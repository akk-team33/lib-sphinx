package de.team33.sphinx.alpha.activity;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

public enum MouseAct implements Context<Component, MouseEvent> {

    CLICKED(Component::addMouseListener, Listeners::mouseClicked),
    PRESSED(Component::addMouseListener, Listeners::mousePressed),
    RELEASED(Component::addMouseListener, Listeners::mouseReleased),
    ENTERED(Component::addMouseListener, Listeners::mouseEntered),
    EXITED(Component::addMouseListener, Listeners::mouseExited),
    DRAGGED(Component::addMouseMotionListener, Listeners::mouseDragged),
    MOVED(Component::addMouseMotionListener, Listeners::mouseMoved);

    private final Agent agent;

    <L> MouseAct(final BiConsumer<Component, L> addition,
                 final Function<Consumer<MouseEvent>, L> mapping) {
        this.agent = new Agent<>(addition, mapping);
    }

    @Override
    public void add(Component component, Consumer<MouseEvent> reaction) {
        agent.add(component, reaction);
    }
}
