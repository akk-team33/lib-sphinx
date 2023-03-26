package de.team33.sphinx.alpha.option;

import java.awt.*;

public class GBCTemplate {

    private final GridBagConstraints backing;

    private GBCTemplate(final GridBagConstraints backing) {
        this.backing = backing;
    }

    public GBCTemplate() {
        this(new GridBagConstraints());
    }

    public GBCTemplate(final GridBag.Anchor anchor, final GridBag.Fill fill, final Insets insets) {
        this();
        this.backing.anchor = anchor.getValue();
        this.backing.fill = fill.getValue();
        this.backing.insets = (Insets) insets.clone();
    }

    public GBCTemplate(final GridBag.Anchor anchor, final GridBag.Fill fill, final Insets insets, int iPadXY) {
        this(anchor, fill, insets);
        this.backing.ipadx = iPadXY;
        this.backing.ipady = iPadXY;
    }

    public GBCTemplate setColumns(final double weightX) {
        return setColumns(backing.gridwidth, weightX, backing.ipadx);
    }

    public GBCTemplate setColumns(final int gridWidth, final double weightX) {
        return setColumns(gridWidth, weightX, backing.ipadx);
    }

    public GBCTemplate setColumns(final double weightX, final int iPadX) {
        return setColumns(backing.gridwidth, weightX, iPadX);
    }

    public GBCTemplate setColumns(final int gridWidth, final double weightX, final int iPadX) {
        final GridBagConstraints gbcClone = (GridBagConstraints) backing.clone();
        gbcClone.gridwidth = gridWidth;
        gbcClone.weightx = weightX;
        gbcClone.ipadx = iPadX;
        return new GBCTemplate(gbcClone);
    }

    public final GBCTColumn column(final int gridX) {
        return new GBCTColumn(backing, gridX);
    }

    public final GBCTRow row(final int gridY) {
        return new GBCTRow(backing, gridY);
    }
}