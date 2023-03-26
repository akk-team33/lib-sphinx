package de.team33.sphinx.alpha.option;

import java.awt.*;

public class GBCTRow {
    
    private final GridBagConstraints template;

    GBCTRow(final GridBagConstraints template, final int gridY) {
        this.template = (GridBagConstraints) template.clone();
        this.template.gridy = gridY;
    }

    public GridBagConstraints get(final int gridX) {
        final GridBagConstraints result = (GridBagConstraints) template.clone();
        result.gridx = gridX;
        return result;
    }

    public GridBagConstraints get(final int gridX, final double weightX) {
        final GridBagConstraints result = get(gridX);
        result.weightx = weightX;
        return result;
    }

    public GridBagConstraints get(final int gridX, final int gridWidth) {
        final GridBagConstraints result = get(gridX);
        result.gridwidth = gridWidth;
        return result;
    }

    public GridBagConstraints get(final int gridX, final int gridWidth, final double weightX) {
        final GridBagConstraints result = get(gridX, gridWidth);
        result.weightx = weightX;
        return result;
    }
}
