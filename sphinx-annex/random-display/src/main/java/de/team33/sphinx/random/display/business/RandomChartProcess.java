package de.team33.sphinx.random.display.business;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class RandomChartProcess {

    private static final int WIDTH = 1009;
    private static final int HEIGHT = 30000;

    private final Randomizer random;
    private final List<Consumer<RandomChartProcess>> updateImageListeners = new LinkedList<>();
    private final BufferedImage image;
    private final Thread processingThread;
    private final AtomicBoolean running;
    private final AtomicLong counter;

    public RandomChartProcess(final Randomizer random) {
        this.random = random;
        this.image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.counter = new AtomicLong(0);
        this.running = new AtomicBoolean(false);
        this.processingThread = new Thread(this::run);

        IntStream.range(0, HEIGHT)
                 .forEach(y -> IntStream.range(0, WIDTH)
                                        .forEach(x -> image.setRGB(x, y, -1)));
    }

    private void run() {
        this.running.set(true);
        long time0 = System.currentTimeMillis();
        while (running.get()) {
            step();
            final long timex = System.currentTimeMillis();
            if (timex - time0 > 50) {
                time0 = timex;
                updateImageListeners.forEach(listener -> listener.accept(this));
            }
        }
    }

    private final Map<Integer, AtomicInteger> counters = new TreeMap<>();

    private void step() {
        final int value = random.nextInt(WIDTH);
        final int count = counters.computeIfAbsent(value, key -> new AtomicInteger(0))
                                  .incrementAndGet();
        if (count < HEIGHT) {
            image.setRGB(value, HEIGHT - count, 0xff000000);
        } else {
            running.set(false);
        }
        counter.incrementAndGet();
    }

    private int next(final int rgb) {
        final int small = (((rgb & 0xf00000) >> 12) | ((rgb & 0xf000) >> 8) | ((rgb & 0xf0) >> 4)) + 1;
        return ((small & 0xf00) << 12) | ((small & 0xf0) << 8) | ((small & 0xf) << 4);
    }

    public final void start() {
        processingThread.start();
    }

    public final void stop() {
        running.set(false);
        try {
            processingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public final RandomChartProcess addUpdateImageListener(final Consumer<RandomChartProcess> listener) {
        updateImageListeners.add(listener);
        return this;
    }

    public final BufferedImage getImage() {
        return image;
    }

    public final long getCount() {
        return counter.get();
    }
}
