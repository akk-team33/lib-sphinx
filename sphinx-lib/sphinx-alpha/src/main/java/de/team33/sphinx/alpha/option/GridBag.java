package de.team33.sphinx.alpha.option;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;

@SuppressWarnings({"unused", "WeakerAccess", "InnerClassTooDeeplyNested"})
public final class GridBag {

    private GridBag() {
    }

    /**
     * Convenience method:
     * Returns a new instance of {@link GridBagLayout}.
     */
    public static GridBagLayout layout() {
        return new GridBagLayout();
    }

    /**
     * Returns new {@link Insets} with a uniform value for all directions (top, bottom, left, right).
     */
    public static Insets insets(final int uniValue) {
        return insets(uniValue, uniValue, uniValue, uniValue);
    }

    /**
     * Returns new {@link Insets} with different values for horizontal (left, right)
     * and vertical (top, bottom) directions.
     */
    public static Insets insets(final int horizontal, final int vertical) {
        return insets(vertical, horizontal, vertical, horizontal);
    }

    /**
     * Returns new {@link Insets} with individual values for each direction (top, left, bottom, right).
     */
    public static Insets insets(final int top, final int left, final int bottom, final int right) {
        return new Insets(top, left, bottom, right);
    }

    /**
     * Utility class to handle {@link GridBagConstraints}.
     */
    public static final class Constraints {

        private Constraints() {
        }

        /**
         * Returns a default {@link Template}.
         */
        public static Template template() {
            return new Template(new GridBagConstraints());
        }

        /**
         * Returns a default {@link Builder}.
         */
        public static Builder builder() {
            return new Builder(GridBagConstraints::new);
        }

        /**
         * Represents an immutable template for {@link GridBagConstraints}.
         * <p>
         * Use {@link #template()} or {@link Builder#template()} to retrieve an instance.
         */
        public static final class Template {

            private final GridBagConstraints backing;

            private Template(final GridBagConstraints backing) {
                this.backing = backing;
            }

            /**
             * Returns a new {@link GridBagConstraints} based on this {@link Template}.
             */
            public final GridBagConstraints get() {
                //noinspection UseOfClone
                return (GridBagConstraints) backing.clone();
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameters.
             *
             * @see GridBagConstraints#gridx
             * @see GridBagConstraints#gridy
             */
            public final GridBagConstraints get(final int gridX, final int gridY) {
                return builder().setGridX(gridX)
                                .setGridY(gridY)
                                .build();
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameters.
             *
             * @see GridBagConstraints#gridx
             * @see GridBagConstraints#gridy
             * @see GridBagConstraints#weightx
             * @see GridBagConstraints#weighty
             */
            public final GridBagConstraints get(final int gridX, final int gridY, final double weightXY) {
                return builder().setGridX(gridX)
                                .setGridY(gridY)
                                .setWeightXY(weightXY)
                                .build();
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameters.
             *
             * @see GridBagConstraints#gridx
             * @see GridBagConstraints#gridy
             * @see GridBagConstraints#weightx
             * @see GridBagConstraints#weighty
             */
            public final GridBagConstraints get(final int gridX, final int gridY,
                                                final double weightX, final double weightY) {
                return builder().setGridX(gridX)
                                .setGridY(gridY)
                                .setWeightX(weightX)
                                .setWeightY(weightY)
                                .build();
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameter.
             *
             * @see GridBagConstraints#gridy
             */
            public final GridBagConstraints getY(final int gridY) {
                return getY(gridY, backing.weighty);
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameters.
             *
             * @see GridBagConstraints#gridy
             * @see GridBagConstraints#weighty
             */
            public final GridBagConstraints getY(final int gridY, final double weightY) {
                return builder().setGridY(gridY)
                                .setWeightY(weightY)
                                .build();
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameter.
             *
             * @see GridBagConstraints#gridx
             */
            public final GridBagConstraints getX(final int gridX) {
                return getX(gridX, backing.weightx);
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}
             * and considering the given parameters.
             *
             * @see GridBagConstraints#gridx
             * @see GridBagConstraints#weightx
             */
            public final GridBagConstraints getX(final int gridX, final double weightX) {
                return builder().setGridX(gridX)
                                .setWeightX(weightX)
                                .build();
            }

            /**
             * Returns a new {@link Builder} based on this {@link Template}.
             */
            public final Builder builder() {
                return new Builder(this::get);
            }
        }

        /**
         * Represents a builder for {@link GridBagConstraints}.
         * <p>
         * Use {@link #builder()} or {@link Template#builder()} to retrieve an instance.
         */
        public static final class Builder extends LateBuilder<GridBagConstraints, Builder>  {

            private Builder(final Supplier<GridBagConstraints> newResult) {
                super(newResult, Builder.class);
            }

            /**
             * Returns a new {@link Template} based on this builder.
             */
            public final Template template() {
                return new Template(build());
            }

            /**
             * @see GridBagConstraints#gridx
             */
            public final Builder setGridX(final int gridX) {
                return setup(gbc -> gbc.gridx = gridX);
            }

            /**
             * @see GridBagConstraints#gridy
             */
            public final Builder setGridY(final int gridY) {
                return setup(gbc -> gbc.gridy = gridY);
            }

            /**
             * @see GridBagConstraints#gridwidth
             */
            public final Builder setGridWidth(final int gridWidth) {
                return setup(gbc -> gbc.gridwidth = gridWidth);
            }

            /**
             * @see GridBagConstraints#gridheight
             */
            public final Builder setGridHeight(final int gridHeight) {
                return setup(gbc -> gbc.gridheight = gridHeight);
            }

            /**
             * @see GridBagConstraints#weightx
             */
            public final Builder setWeightX(final double weightX) {
                return setup(gbc -> gbc.weightx = weightX);
            }

            /**
             * @see GridBagConstraints#weighty
             */
            public final Builder setWeightY(final double weightY) {
                return setup(gbc -> gbc.weighty = weightY);
            }

            /**
             * @see GridBagConstraints#weightx
             * @see GridBagConstraints#weighty
             */
            public final Builder setWeightXY(final double weightXY) {
                return this.setWeightX(weightXY)
                           .setWeightY(weightXY);
            }

            /**
             * @see GridBagConstraints#anchor
             */
            public final Builder setAnchor(final Anchor anchor) {
                return setup(gbc -> gbc.anchor = anchor.getValue());
            }

            /**
             * @see GridBagConstraints#fill
             */
            public final Builder setFill(final Fill fill) {
                return setup(gbc -> gbc.fill = fill.getValue());
            }

            /**
             * @see GridBagConstraints#insets
             */
            public final Builder setInsets(final Insets insets) {
                return setup(gbc -> gbc.insets = insets);
            }

            /**
             * @see GridBagConstraints#ipadx
             */
            public final Builder setIPadX(final int iPadX) {
                return setup(gbc -> gbc.ipadx = iPadX);
            }

            /**
             * @see GridBagConstraints#ipady
             */
            public final Builder setIPadY(final int iPadY) {
                return setup(gbc -> gbc.ipady = iPadY);
            }

            /**
             * @see GridBagConstraints#ipadx
             * @see GridBagConstraints#ipady
             */
            public final Builder setIPadXY(final int iPadXY) {
                return this.setIPadX(iPadXY)
                           .setIPadY(iPadXY);
            }
        }
    }

    public enum Anchor {

        /**
         * @see GridBagConstraints#CENTER
         */
        CENTER(GridBagConstraints.CENTER),

        /**
         * @see GridBagConstraints#NORTH
         */
        NORTH(GridBagConstraints.NORTH),

        /**
         * @see GridBagConstraints#NORTHEAST
         */
        NORTHEAST(GridBagConstraints.NORTHEAST),

        /**
         * @see GridBagConstraints#EAST
         */
        EAST(GridBagConstraints.EAST),

        /**
         * @see GridBagConstraints#SOUTHEAST
         */
        SOUTHEAST(GridBagConstraints.SOUTHEAST),

        /**
         * @see GridBagConstraints#SOUTH
         */
        SOUTH(GridBagConstraints.SOUTH),

        /**
         * @see GridBagConstraints#SOUTHWEST
         */
        SOUTHWEST(GridBagConstraints.SOUTHWEST),

        /**
         * @see GridBagConstraints#WEST
         */
        WEST(GridBagConstraints.WEST),

        /**
         * @see GridBagConstraints#NORTHWEST
         */
        NORTHWEST(GridBagConstraints.NORTHWEST),

        /**
         * @see GridBagConstraints#PAGE_START
         */
        PAGE_START(GridBagConstraints.PAGE_START),

        /**
         * @see GridBagConstraints#PAGE_END
         */
        PAGE_END(GridBagConstraints.PAGE_END),

        /**
         * @see GridBagConstraints#LINE_START
         */
        LINE_START(GridBagConstraints.LINE_START),

        /**
         * @see GridBagConstraints#LINE_END
         */
        LINE_END(GridBagConstraints.LINE_END),

        /**
         * @see GridBagConstraints#FIRST_LINE_START
         */
        FIRST_LINE_START(GridBagConstraints.FIRST_LINE_START),

        /**
         * @see GridBagConstraints#FIRST_LINE_END
         */
        FIRST_LINE_END(GridBagConstraints.FIRST_LINE_END),

        /**
         * @see GridBagConstraints#LAST_LINE_START
         */
        LAST_LINE_START(GridBagConstraints.LAST_LINE_START),

        /**
         * @see GridBagConstraints#LAST_LINE_END
         */
        LAST_LINE_END(GridBagConstraints.LAST_LINE_END),

        /**
         * @see GridBagConstraints#BASELINE
         */
        BASELINE(GridBagConstraints.BASELINE),

        /**
         * @see GridBagConstraints#BASELINE_LEADING
         */
        BASELINE_LEADING(GridBagConstraints.BASELINE_LEADING),

        /**
         * @see GridBagConstraints#BASELINE_TRAILING
         */
        BASELINE_TRAILING(GridBagConstraints.BASELINE_TRAILING),

        /**
         * @see GridBagConstraints#ABOVE_BASELINE
         */
        ABOVE_BASELINE(GridBagConstraints.ABOVE_BASELINE),

        /**
         * @see GridBagConstraints#ABOVE_BASELINE_LEADING
         */
        ABOVE_BASELINE_LEADING(GridBagConstraints.ABOVE_BASELINE_LEADING),

        /**
         * @see GridBagConstraints#ABOVE_BASELINE_TRAILING
         */
        ABOVE_BASELINE_TRAILING(GridBagConstraints.ABOVE_BASELINE_TRAILING),

        /**
         * @see GridBagConstraints#BELOW_BASELINE
         */
        BELOW_BASELINE(GridBagConstraints.BELOW_BASELINE),

        /**
         * @see GridBagConstraints#BELOW_BASELINE_LEADING
         */
        BELOW_BASELINE_LEADING(GridBagConstraints.BELOW_BASELINE_LEADING),

        /**
         * @see GridBagConstraints#BELOW_BASELINE_TRAILING
         */
        BELOW_BASELINE_TRAILING(GridBagConstraints.BELOW_BASELINE_TRAILING);

        private final int value;

        Anchor(final int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static Anchor of(final int value) {
            return Stream.of(values())
                         .filter(anchor -> anchor.value == value)
                         .findAny()
                         .orElseThrow(() -> new NoSuchElementException("No Anchor found for value " + value));
        }
    }

    public enum Fill {

        /**
         * @see GridBagConstraints#NONE
         */
        NONE(GridBagConstraints.NONE),

        /**
         * @see GridBagConstraints#BOTH
         */
        BOTH(GridBagConstraints.BOTH),

        /**
         * @see GridBagConstraints#HORIZONTAL
         */
        HORIZONTAL(GridBagConstraints.HORIZONTAL),

        /**
         * @see GridBagConstraints#VERTICAL
         */
        VERTICAL(GridBagConstraints.VERTICAL);

        private final int value;

        Fill(final int value) {
            this.value = value;
        }

        public final int getValue() {
            return value;
        }

        public static Fill of(final int value) {
            return Stream.of(values())
                         .filter(fill -> fill.value == value)
                         .findAny()
                         .orElseThrow(() -> new NoSuchElementException("No Fill found for value " + value));
        }
    }
}
