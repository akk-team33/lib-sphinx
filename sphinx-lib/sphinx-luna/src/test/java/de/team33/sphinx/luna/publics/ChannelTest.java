package de.team33.sphinx.luna.publics;

import de.team33.sphinx.luna.Channel;
import de.team33.sphinx.luna.Link;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class ChannelTest {

    @Test
    final void componentAdded() {
        final Given<Container, ContainerEvent> given = new Given<>(new JPanel());
        final JLabel label = new JLabel();

        final Link link = Channel.COMPONENT_ADDED.add(given.component(), given::onMessage);
        given.component().add(label);

        assertEquals(1, given.received().size());
        final ContainerEvent received = given.received().get(0);
        assertSame(given.component(), received.getComponent());
        assertSame(given.component(), received.getContainer());
        assertSame(label, received.getChild());

        link.unlink();
        given.component().add(new JLabel());
        assertEquals(1, given.received().size());

        // what happens when already unlinked? ...
        link.unlink();
    }

    static class Given<C extends Component, M extends ComponentEvent> {

        private final C component;
        private final List<M> received = new LinkedList<>();

        Given(final Supplier<C> newComponent) {
            this(newComponent.get());
        }

        Given(final C component) {
            this.component = component;
        }

        final void onMessage(final M message) {
            received.add(message);
        }

        final C component() {
            return component;
        }

        final List<M> received() {
            return Collections.unmodifiableList(received);
        }
    }
}