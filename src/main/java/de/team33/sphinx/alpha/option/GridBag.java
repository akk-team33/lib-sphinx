package de.team33.sphinx.alpha.option;

import de.team33.patterns.building.elara.LateBuilder;

import java.awt.*;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class GridBag {

    /**
     * Returns a new instance of {@link GridBagLayout}.
     */
    public static GridBagLayout layout() {
        return new GridBagLayout();
    }

    /**
     * Returns a new instance of {@link Insets} with a uniform value for all directions (top, bottom, left, right).
     */
    public static Insets insets(final int uniValue) {
        return insets(uniValue, uniValue, uniValue, uniValue);
    }

    /**
     * Returns a new instance of {@link Insets} with different values for horizontal (left, right)
     * and vertical (top, bottom) directions.
     */
    public static Insets insets(final int horizontal, final int vertical) {
        return insets(vertical, horizontal, vertical, horizontal);
    }

    /**
     * Returns a new instance of {@link Insets} with individual values for each direction (top, left, bottom, right).
     */
    public static Insets insets(final int top, final int left, final int bottom, final int right) {
        return new Insets(top, left, bottom, right);
    }

    public static Constraints constraints() {
        return new Constraints();
    }

    public static class Constraints {}

    /**
     * Utility class to handle {@link GridBagConstraints}.
     */
    public static class Constraints_ {

        /**
         * Returns a default {@link Template}.
         */
        public static Template template() {
            return new Template(new GridBagConstraints());
        }

        /**
         * Returns a new {@link Template} using given values for the following parameters of
         * {@link GridBagConstraints}: anchor, fill, insets, iPadX and iPadY.
         * This version uses the same value (iPadXY) for both iPadX and IPadY.
         *
         * @see #template(Anchor, Fill, Insets, int, int)
         */
        public static Template template(final Anchor anchor, final Fill fill, final Insets insets, int iPadXY) {
            return template(anchor, fill, insets, iPadXY, iPadXY);
        }

        /**
         * Returns a new {@link Template} using given values for the following parameters of
         * {@link GridBagConstraints}: anchor, fill, insets, iPadX and iPadY.
         * This version uses individual values for iPadX and IPadY.
         *
         * @see #template(Anchor, Fill, Insets, int)
         */
        public static Template template(final Anchor anchor, final Fill fill,
                                        final Insets insets, int iPadX, int iPadY) {
            return builder().setAnchor(anchor)
                            .setFill(fill)
                            .setInsets(insets)
                            .setIPadX(iPadX)
                            .setIPadY(iPadY)
                            .template();
        }

        /**
         * Returns a default {@link Builder}.
         */
        public static Builder builder() {
            return new Builder(GridBagConstraints::new);
        }

        public interface Setup<S extends Setup<S>>
                extends de.team33.patterns.building.elara.Setup<GridBagConstraints, S> {

            /**
             * @see GridBagConstraints#gridx
             */
            default S setGridX(final int gridX) {
                return setup(gbc -> gbc.gridx = gridX);
            }

            /**
             * @see GridBagConstraints#gridy
             */
            default S setGridY(final int gridY) {
                return setup(gbc -> gbc.gridy = gridY);
            }

            /**
             * @see GridBagConstraints#gridwidth
             */
            default S setGridWidth(final int gridWidth) {
                return setup(gbc -> gbc.gridwidth = gridWidth);
            }

            /**
             * @see GridBagConstraints#gridheight
             */
            default S setGridHeight(final int gridHeight) {
                return setup(gbc -> gbc.gridheight = gridHeight);
            }

            /**
             * @see GridBagConstraints#weightx
             */
            default S setWeightX(final double weightX) {
                return setup(gbc -> gbc.weightx = weightX);
            }

            /**
             * @see GridBagConstraints#weighty
             */
            default S setWeightY(final double weightY) {
                return setup(gbc -> gbc.weighty = weightY);
            }

            /**
             * @see GridBagConstraints#anchor
             */
            default S setAnchor(final Anchor anchor) {
                return setup(gbc -> gbc.anchor = anchor.getValue());
            }

            /**
             * @see GridBagConstraints#fill
             */
            default S setFill(final Fill fill) {
                return setup(gbc -> gbc.fill = fill.getValue());
            }

            /**
             * @see GridBagConstraints#insets
             */
            default S setInsets(final Insets insets) {
                return setup(gbc -> gbc.insets = insets);
            }

            /**
             * @see GridBagConstraints#ipadx
             */
            default S setIPadX(final int iPadX) {
                return setup(gbc -> gbc.ipadx = iPadX);
            }

            /**
             * @see GridBagConstraints#ipady
             */
            default S setIPadY(final int iPadY) {
                return setup(gbc -> gbc.ipady = iPadY);
            }

            /**
             * @see GridBagConstraints#ipadx
             * @see GridBagConstraints#ipady
             */
            default S setIPadXY(final int iPadXY) {
                return this.setIPadX(iPadXY)
                           .setIPadY(iPadXY);
            }

            default S setRows(final int gridHeight, final double weightY) {
                return this.setGridHeight(gridHeight)
                           .setWeightY(weightY);
            }

            default S setRows(final int gridHeight, final double weightY, final int iPadY) {
                return this.setRows(gridHeight, weightY)
                           .setIPadY(iPadY);
            }

            default S setColumns(final int gridWidth, final double weightX) {
                return this.setGridWidth(gridWidth)
                           .setWeightX(weightX);
            }

            default S setColumns(final int gridWidth, final double weightX, final int iPadX) {
                return this.setColumns(gridWidth, weightX)
                           .setIPadX(iPadX);
            }

            default S setAreal(final Anchor anchor, final Fill fill, final Insets insets) {
                return this.setAnchor(anchor)
                           .setFill(fill)
                           .setInsets(insets);
            }

            default S setAreal(final Anchor anchor, final Fill fill, final Insets insets, int iPadXY) {
                return this.setAreal(anchor, fill, insets)
                           .setIPadXY(iPadXY);
            }
        }

        /**
         * Represents an immutable template for new {@link GridBagConstraints}.
         * <p>
         * Use {@link #template()}, {@link #template(Anchor, Fill, Insets, int)},
         * {@link #template(Anchor, Fill, Insets, int, int)} or {@link Builder#template()}
         * to get a new instance of this type.
         */
        public static class Template {

            private final GridBagConstraints backing;

            private Template(final GridBagConstraints backing) {
                this.backing = backing;
            }

            private GridBagConstraints get() {
                return (GridBagConstraints) backing.clone();
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}.
             * All parameters that are not explicitly specified are taken from the status of this template.
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
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}.
             * All parameters that are not explicitly specified are taken from the status of this template.
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
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}.
             * All parameters that are not explicitly specified are taken from the status of this template.
             *
             * @see GridBagConstraints#gridx
             * @see GridBagConstraints#gridy
             * @see GridBagConstraints#gridwidth
             * @see GridBagConstraints#gridheight
             * @see GridBagConstraints#weightx
             * @see GridBagConstraints#weighty
             */
            public final GridBagConstraints get(final int gridX, final int gridY,
                                                final int gridWidth, final int gridHeight,
                                                final double weightX, final double weightY) {
                return builder().setGridX(gridX)
                                .setGridY(gridY)
                                .setGridWidth(gridWidth)
                                .setGridHeight(gridHeight)
                                .setWeightX(weightX)
                                .setWeightY(weightY)
                                .build();
            }

            public final GridBagConstraints vertical(final int gridY) {
                return vertical(gridY, 0.0);
            }

            public final GridBagConstraints vertical(final int gridY, final double weightY) {
                return vertical(gridY, 1, weightY);
            }

            public final GridBagConstraints vertical(final int gridY, final int gridHeight, final double weightY) {
                return builder().setGridX(0)
                                .setGridY(gridY)
                                //.setGridWidth(1)
                                .setGridHeight(gridHeight)
                                //.setWeightX(1.0)
                                .setWeightY(weightY)
                                .build();
            }

            /**
             * Returns new {@link GridBagConstraints} for a layout composed of multiple uniform columns.
             * The column width (gridWidth) is set to 1 and its weight (gridWeight) is set to 1.0 across the board.
             * All other parameters that are not explicitly specified are taken from the status of the template.
             */
            public final GridBagConstraints column(final int gridX,
                                                   final int gridY, final int gridHeight, final double weightY) {
                throw new UnsupportedOperationException("not yet implemented");
            }

            public final GridBagConstraints horizontal(final int gridX) {
                return horizontal(gridX, 0.0);
            }

            public final GridBagConstraints horizontal(final int gridX, final double weightX) {
                return horizontal(gridX, 1, weightX);
            }

            public final GridBagConstraints horizontal(final int gridX, final int gridWidth, final double weightX) {
                return builder().setGridX(gridX)
                                .setGridY(0)
                                .setGridWidth(gridWidth)
                                //.setGridHeight(1)
                                .setWeightX(weightX)
                                //.setWeightY(1.0)
                                .build();
            }

            public final Builder builder() {
                return new Builder(this::get);
            }
        }

        /**
         * Represents a builder for new {@link GridBagConstraints}.
         * <p>
         * Use {@link #builder()} or {@link Template#builder()} to get a new instance of this type.
         */
        public static class Builder extends LateBuilder<GridBagConstraints, Builder> implements Setup<Builder> {

            private Builder(final Supplier<GridBagConstraints> newResult) {
                super(newResult, Builder.class);
            }

            /**
             * Returns a new {@link Template} based on the current properties of this builder.
             */
            public final Template template() {
                return new Template(build());
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
            return Stream.of(Anchor.values())
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
            return Stream.of(Fill.values())
                         .filter(fill -> fill.value == value)
                         .findAny()
                         .orElseThrow(() -> new NoSuchElementException("No Fill found for value " + value));
        }
    }
}
