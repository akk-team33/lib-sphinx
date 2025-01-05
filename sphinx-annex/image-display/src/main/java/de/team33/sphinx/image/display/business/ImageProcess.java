package de.team33.sphinx.image.display.business;

import de.team33.sphinx.patterns.ophelia.Consumers;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ImageProcess {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private final Consumers<ImageProcess> setImageListeners = new Consumers<>(executor);
    private BufferedImage image;
    private String imagePath;

    public final ImageProcess addSetImageListener(final Consumer<ImageProcess> listener) {
        setImageListeners.add(listener);
        return this;
    }

    public final Optional<BufferedImage> getImage() {
        return Optional.ofNullable(image);
    }

    public final String getImagePath() {
        return imagePath;
    }

    public final void setImage(final Path path) throws IOException {
        final File file = path.toFile();
        if (!file.isFile()) {
            throw new IOException("not a regular file: " + path);
        }
        this.image = ImageIO.read(file);
        this.imagePath = path.toAbsolutePath().normalize().toString();
        setImageListeners.accept(this);
    }

    public final void shutdown() {
        executor.shutdown();
    }
}
