package de.team33.sphinx.luna.sample;

import de.team33.sphinx.luna.Channel;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChannelSample {

    private final JButton button;

    public ChannelSample() {
        button = new JButton();
        Channel.ACTION_PERFORMED.subscribe(button, this::onActionPerformed);
    }

    private void onActionPerformed(final ActionEvent event) {
        // do something based on [event] and/or [button] ...
    }
}
