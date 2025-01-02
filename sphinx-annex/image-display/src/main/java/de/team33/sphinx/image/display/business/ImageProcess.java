package de.team33.sphinx.image.display.business;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class ImageProcess {

    private final List<Consumer<ImageProcess>> setImageListeners = new LinkedList<>();
    private BufferedImage image;
    private String imagePath;

    public final ImageProcess addSetImageListener(final Consumer<ImageProcess> listener) {
        setImageListeners.add(Objects.requireNonNull(listener));
        return this;
    }

    public final BufferedImage getImage() {
        return image;
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
    }
}
