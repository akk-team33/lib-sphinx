package de.team33.sphinx.random.display.business;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class RandomProcess {

    private static final int WIDTH = 640;
    private static final int HEIGHT = 480;

    private final Random random = new Random();
    private final List<Consumer<RandomProcess>> updateImageListeners = new LinkedList<>();
    private final BufferedImage image;
    private final Thread processingThread;
    private boolean running;

    public RandomProcess() {
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        processingThread = new Thread(() -> run());
    }

    private void run() {
        this.running = true;
        long time0 = System.currentTimeMillis();
        while (running) {
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
        image.setRGB(x, y, image.getRGB(x, y) + 0x0f);
    }

    public final void start() {
        processingThread.start();
    }

    public final void stop() {
        this.running = false;
        try {
            processingThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public final RandomProcess addUpdateImageListener(final Consumer<RandomProcess> listener) {
        updateImageListeners.add(listener);
        return this;
    }

    public final BufferedImage getImage() {
        return image;
    }
}
