package de.team33.sphinx.alpha.option;

import java.awt.GridBagConstraints;

public class GBCTColumn {

    private final GridBagConstraints template;

    GBCTColumn(final GridBagConstraints template, final int gridX) {
        this.template = (GridBagConstraints) template.clone();
        this.template.gridx = gridX;
    }

    public GridBagConstraints get(final int gridY) {
        final GridBagConstraints result = (GridBagConstraints) template.clone();
        result.gridy = gridY;
        return result;
    }

    public GridBagConstraints get(final int gridY, final double weightY) {
        final GridBagConstraints result = get(gridY);
        result.weighty = weightY;
        return result;
    }

    public GridBagConstraints get(final int gridY, final int gridHeight) {
        final GridBagConstraints result = get(gridY);
        result.gridheight = gridHeight;
        return result;
    }

    public GridBagConstraints get(final int gridY, final int gridHeight, final double weightY) {
        final GridBagConstraints result = get(gridY, gridHeight);
        result.weighty = weightY;
        return result;
    }
}
