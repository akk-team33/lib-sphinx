package de.team33.sphinx.alpha.activity;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Abstracts sorts of activities or events.
 *
 * @param <C> The component type in whose context the activity or event takes place.
 * @param <M> The message type being transferred in the context of the activity or event.
 */
public abstract class Event<C, M> {

    public static final Event<Component, ComponentEvent> COMPONENT_HIDDEN =
            new Agent<>(Component::addComponentListener, Listeners::componentHidden);

    public static final Event<Component, ComponentEvent> COMPONENT_MOVED =
            new Agent<>(Component::addComponentListener, Listeners::componentMoved);

    public static final Event<Component, ComponentEvent> COMPONENT_RESIZED =
            new Agent<>(Component::addComponentListener, Listeners::componentResized);

    public static final Event<Component, ComponentEvent> COMPONENT_SHOWN =
            new Agent<>(Component::addComponentListener, Listeners::componentShown);

    public static final Event<Component, FocusEvent> FOCUS_GAINED =
            new Agent<>(Component::addFocusListener, Listeners::focusGained);

    public static final Event<Component, FocusEvent> FOCUS_LOST =
            new Agent<>(Component::addFocusListener, Listeners::focusLost);

    public static final Event<Component, HierarchyEvent> ANCESTOR_MOVED =
            new Agent<>(Component::addHierarchyBoundsListener, Listeners::ancestorMoved);

    public static final Event<Component, HierarchyEvent> ANCESTOR_RESIZED =
            new Agent<>(Component::addHierarchyBoundsListener, Listeners::ancestorResized);

    public static final Event<Component, HierarchyEvent> HIERARCHIE_CHANGED =
            new Agent<>(Component::addHierarchyListener, Listeners::hierarchyChanged);

    public static final Event<Component, InputMethodEvent> CARET_POSITION_CHANGED =
            new Agent<>(Component::addInputMethodListener, Listeners::caretPositionChanged);

    public static final Event<Component, InputMethodEvent> INPUT_METHOD_TEXT_CHANGED =
            new Agent<>(Component::addInputMethodListener, Listeners::inputMethodTextChanged);

    public static final Event<Component, KeyEvent> KEY_TYPED =
            new Agent<>(Component::addKeyListener, Listeners::keyTyped);

    public static final Event<Component, KeyEvent> KEY_PRESSED =
            new Agent<>(Component::addKeyListener, Listeners::keyPressed);

    public static final Event<Component, KeyEvent> KEY_RELEASED =
            new Agent<>(Component::addKeyListener, Listeners::keyReleased);

    public static final Event<Component, MouseEvent> MOUSE_CLICKED =
            new Agent<>(Component::addMouseListener, Listeners::mouseClicked);

    public static final Event<Component, MouseEvent> MOUSE_ENTERED =
            new Agent<>(Component::addMouseListener, Listeners::mouseEntered);

    public static final Event<Component, MouseEvent> MOUSE_EXITED =
            new Agent<>(Component::addMouseListener, Listeners::mouseExited);

    public static final Event<Component, MouseEvent> MOUSE_PRESSED =
            new Agent<>(Component::addMouseListener, Listeners::mousePressed);

    public static final Event<Component, MouseEvent> MOUSE_RELEASED =
            new Agent<>(Component::addMouseListener, Listeners::mouseReleased);

    public static final Event<Component, MouseEvent> MOUSE_DRAGGED =
            new Agent<>(Component::addMouseMotionListener, Listeners::mouseDragged);

    public static final Event<Component, MouseWheelEvent> MOUSE_WHEEL_MOVED =
            new Agent<>(Component::addMouseWheelListener, Listeners::mouseWheelMoved);

    public static final Event<Component, PropertyChangeEvent> PROPERTY_CHANGE =
            new Agent<>(Component::addPropertyChangeListener, Listeners::propertyChange);

    public static final Event<Component, PropertyChangeEvent> propertyChange(final String propertyName) {
        return new Event<Component, PropertyChangeEvent>() {
            @Override
            public void add(Component component, Consumer<PropertyChangeEvent> reaction) {
                component.addPropertyChangeListener(propertyName, Listeners.propertyChange(reaction));
            }
        };
    }

    /**
     * Adds an appropriate {@link Consumer} to a given component of type {@code <C>} to process the associated
     * message of type {@code <M>} when an activity or event as expected in this context occurs.
     */
    public abstract void add(C component, Consumer<M> reaction);

    private static class Agent<C, L, M> extends Event<C, M> {

        private final BiConsumer<C, L> addition;
        private final Function<Consumer<M>, L> mapping;

        public Agent(BiConsumer<C, L> addition, Function<Consumer<M>, L> mapping) {
            this.addition = addition;
            this.mapping = mapping;
        }

        @Override
        public void add(C component, Consumer<M> reaction) {
            addition.accept(component, mapping.apply(reaction));
        }
    }
}
