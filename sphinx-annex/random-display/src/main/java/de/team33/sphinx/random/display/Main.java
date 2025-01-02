package de.team33.sphinx.random.display;

import de.team33.patterns.arbitrary.mimas.Generator;
import de.team33.sphinx.random.display.business.RandomGen;
import de.team33.sphinx.random.display.business.RandomProcess;
import de.team33.sphinx.random.display.visual.RandomFrame;

import javax.swing.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Main implements Runnable {

    private final Random random = new Random();
    // private final Generator generator = Generator.of(random);
    // private final Generator generator = Generator.of(new SecureRandom());
    private final RandomProcess process = new RandomProcess(random::nextInt);
    // private final RandomProcess process = new RandomProcess(generator::anyInt);
    // private final RandomProcess process = new RandomProcess(faultyGen(generator));
    // private final RandomProcess process = new RandomProcess(bound -> generator.anyInt(1 + generator.anyInt(bound)));
    // private final RandomProcess process = new RandomProcess(bound -> generator.anyInt(1 + generator.anyInt(1 + generator.anyInt(bound))));
    // private final RandomProcess process = new RandomProcess(bound -> generator.anySmallInt(bound));
    private final RandomFrame frame = new RandomFrame(process);

    private static RandomGen faultyGen(Generator generator) {
        return bound -> {
            final BigInteger bigBound = BigInteger.valueOf(bound);
            final int numBits = bigBound.bitLength();
            final BigInteger maxBase = BigInteger.ONE.shiftLeft(numBits);
            final BigInteger base = generator.anyBits(numBits);
            return base.multiply(bigBound).divide(maxBase).intValue();
        };
    }

    public static void main(final String[] args) {
        SwingUtilities.invokeLater(new Main());
    }

    @Override
    public void run() {
        frame.setVisible(true);
        process.start();
    }
}
