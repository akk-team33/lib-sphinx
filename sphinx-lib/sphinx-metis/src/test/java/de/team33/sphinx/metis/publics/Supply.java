package de.team33.sphinx.metis.publics;

import de.team33.patterns.random.tarvos.Generator;

import java.awt.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Supply implements Generator {

    private final Random random = new SecureRandom();

    @Override
    public final BigInteger nextBits(final int i) {
        return new BigInteger(i, random);
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
