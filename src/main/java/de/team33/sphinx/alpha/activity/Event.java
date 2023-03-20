package de.team33.sphinx.alpha.activity;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Consumer;

/**
 * Abstracts sorts of activities or events.
 *
 * @param <C> The component type in whose context the activity or event takes place.
 * @param <M> The message type being transferred in the context of the activity or event.
 */
@SuppressWarnings("unused")
public interface Event<C, M> {

    Event<Component, ComponentEvent> COMPONENT_HIDDEN =
            new Agent<>(Component::addComponentListener, Listeners::componentHidden).event();

    Event<Component, ComponentEvent> COMPONENT_MOVED =
            new Agent<>(Component::addComponentListener, Listeners::componentMoved).event();

    Event<Component, ComponentEvent> COMPONENT_RESIZED =
            new Agent<>(Component::addComponentListener, Listeners::componentResized).event();

    Event<Component, ComponentEvent> COMPONENT_SHOWN =
            new Agent<>(Component::addComponentListener, Listeners::componentShown).event();

    Event<Component, FocusEvent> FOCUS_GAINED =
            new Agent<>(Component::addFocusListener, Listeners::focusGained).event();

    Event<Component, FocusEvent> FOCUS_LOST =
            new Agent<>(Component::addFocusListener, Listeners::focusLost).event();

    Event<Component, HierarchyEvent> ANCESTOR_MOVED =
            new Agent<>(Component::addHierarchyBoundsListener, Listeners::ancestorMoved).event();

    Event<Component, HierarchyEvent> ANCESTOR_RESIZED =
            new Agent<>(Component::addHierarchyBoundsListener, Listeners::ancestorResized).event();

    Event<Component, HierarchyEvent> HIERARCHIE_CHANGED =
            new Agent<>(Component::addHierarchyListener, Listeners::hierarchyChanged).event();

    Event<Component, InputMethodEvent> CARET_POSITION_CHANGED =
            new Agent<>(Component::addInputMethodListener, Listeners::caretPositionChanged).event();

    Event<Component, InputMethodEvent> INPUT_METHOD_TEXT_CHANGED =
            new Agent<>(Component::addInputMethodListener, Listeners::inputMethodTextChanged).event();

    Event<Component, KeyEvent> KEY_TYPED =
            new Agent<>(Component::addKeyListener, Listeners::keyTyped).event();

    Event<Component, KeyEvent> KEY_PRESSED =
            new Agent<>(Component::addKeyListener, Listeners::keyPressed).event();

    Event<Component, KeyEvent> KEY_RELEASED =
            new Agent<>(Component::addKeyListener, Listeners::keyReleased).event();

    Event<Component, MouseEvent> MOUSE_CLICKED =
            new Agent<>(Component::addMouseListener, Listeners::mouseClicked).event();

    Event<Component, MouseEvent> MOUSE_ENTERED =
            new Agent<>(Component::addMouseListener, Listeners::mouseEntered).event();

    Event<Component, MouseEvent> MOUSE_EXITED =
            new Agent<>(Component::addMouseListener, Listeners::mouseExited).event();

    Event<Component, MouseEvent> MOUSE_PRESSED =
            new Agent<>(Component::addMouseListener, Listeners::mousePressed).event();

    Event<Component, MouseEvent> MOUSE_RELEASED =
            new Agent<>(Component::addMouseListener, Listeners::mouseReleased).event();

    Event<Component, MouseEvent> MOUSE_DRAGGED =
            new Agent<>(Component::addMouseMotionListener, Listeners::mouseDragged).event();

    Event<Component, MouseWheelEvent> MOUSE_WHEEL_MOVED =
            new Agent<>(Component::addMouseWheelListener, Listeners::mouseWheelMoved).event();

    Event<Component, PropertyChangeEvent> PROPERTY_CHANGE =
            new Agent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(l), Listeners::propertyChange).event();

    Event<Window, WindowEvent> WINDOW_GAINED_FOCUS =
            new Agent<>(Window::addWindowFocusListener, Listeners::windowGainedFocus).event();

    Event<Window, WindowEvent> WINDOW_LOST_FOCUS =
            new Agent<>(Window::addWindowFocusListener, Listeners::windowLostFocus).event();

    Event<Window, WindowEvent> WINDOW_ACTIVATED =
            new Agent<>(Window::addWindowListener, Listeners::windowActivated).event();

    Event<Window, WindowEvent> WINDOW_CLOSED =
            new Agent<>(Window::addWindowListener, Listeners::windowClosed).event();

    Event<Window, WindowEvent> WINDOW_CLOSING =
            new Agent<>(Window::addWindowListener, Listeners::windowClosing).event();

    Event<Window, WindowEvent> WINDOW_DEACTIVATED =
            new Agent<>(Window::addWindowListener, Listeners::windowDeactivated).event();

    static Event<Component, PropertyChangeEvent> propertyChange(final String propertyName) {
        return new Agent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(propertyName, l),
                           Listeners::propertyChange).event();
    }

    /**
     * Adds an appropriate {@link Consumer} to a given component of type {@code <C>} to process the associated
     * message of type {@code <M>} when an activity or event as expected in this context occurs.
     */
    void add(C component, Consumer<M> reaction);
}
