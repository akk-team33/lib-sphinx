package de.team33.test.sphinx.alpha.visual;

import de.team33.patterns.random.tarvos.Generator;

import java.awt.*;
import java.math.BigInteger;
import java.util.Random;

public class Supply extends Random implements Generator {

    @Override
    public final BigInteger nextBits(final int numBits) {
        return new BigInteger(numBits, this);
    }

    public final Point nextPoint() {
        return new Point(nextInt(16, 1024), nextInt(16, 1024));
    }

    public final Dimension nextDimension() {
        return new Dimension(nextInt(16, 1024), nextInt(16, 1024));
    }

    public final Rectangle nextRectangle() {
        return new Rectangle(nextPoint(), nextDimension());
    }
}
