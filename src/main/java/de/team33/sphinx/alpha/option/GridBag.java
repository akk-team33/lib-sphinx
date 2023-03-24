package de.team33.sphinx.alpha.option;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.patterns.building.elara.ProtoBuilder;
import de.team33.patterns.reflect.luna.Fields;

import java.awt.*;
import java.util.function.Supplier;

public class GridBag {

    /**
     * Returns a new instance of {@link GridBagLayout}.
     */
    public static GridBagLayout layout() {
        return new GridBagLayout();
    }

    /**
     * Utility class to handle {@link GridBagConstraints}.
     */
    public static class Constraints {

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
            default S setAnchor(final int anchor) {
                return setup(gbc -> gbc.anchor = anchor);
            }

            /**
             * @see GridBagConstraints#fill
             */
            default S setFill(final int fill) {
                return setup(gbc -> gbc.fill = fill);
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
        }

        public static class Template {

            private final GridBagConstraints backing;

            private Template(final GridBagConstraints backing) {
                this.backing = backing;
            }

            /**
             * Returns a new instance of {@link GridBagConstraints} based on this {@link Template}.
             */
            public final GridBagConstraints get() {
                return (GridBagConstraints) backing.clone();
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
                                .setGridWidth(1)
                                .setGridHeight(gridHeight)
                                .setWeightX(1.0)
                                .setWeightY(weightY)
                                .build();
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
                                .setGridHeight(1)
                                .setWeightX(weightX)
                                .setWeightY(1.0)
                                .build();
            }

            public final Builder builder() {
                return new Builder(this::get);
            }
        }

        public static class Builder extends LateBuilder<GridBagConstraints, Builder> implements Setup<Builder> {

            private Builder(final Supplier<GridBagConstraints> newResult) {
                super(newResult, Builder.class);
            }

            public final Template template() {
                return new Template(build());
            }
        }
    }
}
