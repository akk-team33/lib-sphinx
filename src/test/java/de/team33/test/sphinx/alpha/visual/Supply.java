package de.team33.test.sphinx.alpha.visual;

import de.team33.patterns.random.tarvos.Generator;

import java.awt.*;
import java.math.BigInteger;
import java.util.Random;

public class Supply extends Random implements Generator {

    @Override
    public BigInteger nextBits(final int numBits) {
        return new BigInteger(numBits, this);
    }

    public Point nextPoint() {
        return new Point(nextInt(16, 1024), nextInt(16, 1024));
    }

    public Dimension nextDimension() {
        return new Dimension(nextInt(16, 1024), nextInt(16, 1024));
    }

    public Rectangle nextRectangle() {
        return new Rectangle(nextPoint(), nextDimension());
    }
}
