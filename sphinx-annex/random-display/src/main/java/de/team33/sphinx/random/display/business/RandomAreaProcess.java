package de.team33.sphinx.random.display.business;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class RandomAreaProcess {

    private static final int WIDTH = 600;
    private static final int HEIGHT = 400;

    private final Randomizer random;
    private final List<Consumer<RandomAreaProcess>> updateImageListeners = new LinkedList<>();
    private final BufferedImage image;
    private final Thread processingThread;
    private final AtomicBoolean running;
    private final AtomicLong counter;

    public RandomAreaProcess(final Randomizer random) {
        this.random = random;
        this.image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        this.counter = new AtomicLong(0);
        this.running = new AtomicBoolean(false);
        this.processingThread = new Thread(this::run);
    }

    private void run() {
        this.running.set(true);
        long time0 = System.currentTimeMillis();
        while (running.get()) {
            step();
            final long timex = System.currentTimeMillis();
            if (timex - time0 > 100) {
                time0 = timex;
                updateImageListeners.forEach(listener -> listener.accept(this));
            }
        }
    }

    private void step() {
        final int x = random.nextInt(WIDTH);
        final int y = random.nextInt(HEIGHT);
        image.setRGB(x, y, next(image.getRGB(x, y)));
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

    public final RandomAreaProcess addUpdateImageListener(final Consumer<RandomAreaProcess> listener) {
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
