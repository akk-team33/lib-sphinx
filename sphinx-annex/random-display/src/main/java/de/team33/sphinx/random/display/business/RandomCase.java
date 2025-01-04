package de.team33.sphinx.random.display.business;

import de.team33.patterns.arbitrary.mimas.Generator;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public enum RandomCase implements Randomizer {

    RANDOM(Random::new, r -> r::nextInt),
    SECURE_RANDOM(SecureRandom::new, r -> r::nextInt),
    RANDOM_GENERATOR(() -> Generator.of(new Random()), g -> g::anyInt),
    SECURE_RANDOM_GENERATOR(() -> Generator.of(new SecureRandom()), g -> g::anyInt),
    EXPONENTIAL_GENERATOR(() -> Generator.of(new Random()), g -> g::anySmallInt),
    EXPONENTIAL_SECURE_GENERATOR(() -> Generator.of(new SecureRandom()), g -> g::anySmallInt),
    FAULTY_GENERATOR(() -> Generator.of(new Random()), Util::faultyGen),
    FAULTY_SECURE_GENERATOR(() -> Generator.of(new SecureRandom()), Util::faultyGen),
    SMALL_PRIORITY_GENERATOR(() -> Generator.of(new Random()), Util::smallPriorityGen),
    SMALL_PRIORITY_SECURE_GENERATOR(() -> Generator.of(new SecureRandom()), Util::smallPriorityGen),
    VERY_SMALL_PRIORITY_GENERATOR(() -> Generator.of(new Random()), Util::verySmallPriorityGen),
    VERY_SMALL_PRIORITY_SECURE_GENERATOR(() -> Generator.of(new SecureRandom()), Util::verySmallPriorityGen);

    private final Randomizer impl;

    <R> RandomCase(final Supplier<R> newRandom, final Function<R, Randomizer> toImpl) {
        this.impl = toImpl.apply(newRandom.get());
    }

    @Override
    public int nextInt(final int bound) {
        return impl.nextInt(bound);
    }

    private static class Util {

        static Randomizer smallPriorityGen(Generator generator) {
            return bound -> generator.anyInt(1 + generator.anyInt(bound));
        }

        static Randomizer verySmallPriorityGen(Generator generator) {
            return bound -> generator.anyInt(1 + generator.anyInt(1 + generator.anyInt(bound)));
        }

        static Randomizer faultyGen(Generator generator) {
            return bound -> {
                final BigInteger bigBound = BigInteger.valueOf(bound);
                final int numBits = bigBound.bitLength();
                final BigInteger maxBase = BigInteger.ONE.shiftLeft(numBits);
                final BigInteger base = generator.anyBits(numBits);
                return base.multiply(bigBound).divide(maxBase).intValue();
            };
        }
    }
}
