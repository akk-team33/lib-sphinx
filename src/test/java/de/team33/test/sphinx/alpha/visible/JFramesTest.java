package de.team33.test.sphinx.alpha.visible;

import de.team33.sphinx.alpha.visible.JFrames;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class JFramesTest {

    private static final Supply SUPPLY = new Supply();

    @Test
    void setLocationSize() {
        final Point location = SUPPLY.nextPoint();
        final Dimension size = SUPPLY.nextDimension();
        final JFrame frame = JFrames.builder()
                                    .setLocation(location)
                                    .setSize(size)
                                    .build();
        assertEquals(location, frame.getLocation());
        assertEquals(size, frame.getSize());
        final Rectangle bounds = new Rectangle(location, size);
        assertEquals(bounds, frame.getBounds());
    }
}