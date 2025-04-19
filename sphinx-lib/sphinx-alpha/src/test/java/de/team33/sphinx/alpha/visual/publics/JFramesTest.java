package de.team33.sphinx.alpha.visual.publics;

import de.team33.sphinx.alpha.visual.JFrames;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JFramesTest {

    private static final Supply SUPPLY = new Supply();

    @Test
    final void setLocationSize() {
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
