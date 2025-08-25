package de.team33.sphinx.metis.testing;

import de.team33.sphinx.metis.JLabels;
import de.team33.sphinx.metis.JPanels;

import javax.swing.*;
import java.awt.*;
import java.security.SecureRandom;
import java.util.Random;

class SwingTrialTrial extends SwingTrial {

    private static final Random RANDOM = new SecureRandom();

    public static void main(final String[] args) {
        run(new SwingTrialTrial());
    }

    private static JLabel newLabel(final String text) {
        return JLabels.builder()
                      .setText(text)
                      .setHorizontalAlignment(SwingConstants.CENTER)
                      .setOpaque(true)
                      .setBackground(new Color(RANDOM.nextInt(), false))
                      .build();
    }

    @Override
    protected final Container contentPane() {
        return JPanels.builder()
                      .setLayout(new BorderLayout())
                      .add(newLabel(BorderLayout.PAGE_START), BorderLayout.PAGE_START)
                      .add(newLabel(BorderLayout.CENTER), BorderLayout.CENTER)
                      .add(newLabel(BorderLayout.PAGE_END), BorderLayout.PAGE_END)
                      .add(newLabel(BorderLayout.LINE_END), BorderLayout.LINE_END)
                      .add(newLabel(BorderLayout.LINE_START), BorderLayout.LINE_START)
                      .build();
    }

    @Override
    protected final void setupFrame(final JFrame jFrame) {
        jFrame.setTitle(getClass().getCanonicalName());
    }
}
