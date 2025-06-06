package de.team33.sphinx.luna;

import de.team33.patterns.exceptional.dione.Conversion;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.function.Consumer;

/**
 * Identifies predefined notification channels and associates specific
 * Swing component types, events, and message types with each other.
 * <p>
 * Each instance is also capable of adding appropriate listeners to a component
 * that can process the corresponding message when a particular event occurs.
 * <p>
 * Example:
 * <pre>
 * public class ChannelSample {
 *
 *     private final JButton button;
 *
 *     public ChannelSample() {
 *         button = new JButton();
 *         <b>Channel.ACTION_PERFORMED.add(button, this::onActionPerformed);</b>
 *     }
 *
 *     private void onActionPerformed(final ActionEvent message) {
 *         // do something based on [message] and/or [button] ...
 *     }
 * }
 * </pre>
 *
 * @param <C> The component type in whose context the activity or event takes place.
 * @param <M> The message type being transferred in the context of the activity or event.
 */
@FunctionalInterface
@SuppressWarnings({"unused", "ClassWithTooManyFields", "InterfaceWithOnlyOneDirectInheritor"})
public interface Channel<C, M> {

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see PropertyChangeListener#propertyChange(PropertyChangeEvent)
     * @see Component#addPropertyChangeListener(PropertyChangeListener)
     * @see Component#removePropertyChangeListener(PropertyChangeListener)
     */
    Channel<Component, PropertyChangeEvent> PROPERTY_CHANGE =
            new ChannelAgent<>(Component::addPropertyChangeListener, Component::removePropertyChangeListener, Listeners::propertyChange);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentResized(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     * @see Component#removeComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_RESIZED =
            new ChannelAgent<>(Component::addComponentListener, Component::removeComponentListener, Listeners::componentResized);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentMoved(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     * @see Component#removeComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_MOVED =
            new ChannelAgent<>(Component::addComponentListener, Component::removeComponentListener, Listeners::componentMoved);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentShown(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     * @see Component#removeComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_SHOWN =
            new ChannelAgent<>(Component::addComponentListener, Component::removeComponentListener, Listeners::componentShown);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentHidden(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     * @see Component#removeComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_HIDDEN =
            new ChannelAgent<>(Component::addComponentListener, Component::removeComponentListener, Listeners::componentHidden);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see FocusListener#focusGained(FocusEvent)
     * @see Component#addFocusListener(FocusListener)
     * @see Component#removeFocusListener(FocusListener)
     */
    Channel<Component, FocusEvent> FOCUS_GAINED =
            new ChannelAgent<>(Component::addFocusListener, Component::removeFocusListener, Listeners::focusGained);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see FocusListener#focusLost(FocusEvent)
     * @see Component#addFocusListener(FocusListener)
     * @see Component#removeFocusListener(FocusListener)
     */
    Channel<Component, FocusEvent> FOCUS_LOST =
            new ChannelAgent<>(Component::addFocusListener, Component::removeFocusListener, Listeners::focusLost);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see HierarchyListener#hierarchyChanged(HierarchyEvent)
     * @see Component#addHierarchyListener(HierarchyListener)
     * @see Component#removeHierarchyListener(HierarchyListener)
     */
    Channel<Component, HierarchyEvent> HIERARCHY_CHANGED =
            new ChannelAgent<>(Component::addHierarchyListener, Component::removeHierarchyListener, Listeners::hierarchyChanged);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see HierarchyBoundsListener#ancestorMoved(HierarchyEvent)
     * @see Component#addHierarchyBoundsListener(HierarchyBoundsListener)
     * @see Component#removeHierarchyBoundsListener(HierarchyBoundsListener)
     */
    Channel<Component, HierarchyEvent> ANCESTOR_BOUNDS_MOVED =
            new ChannelAgent<>(Component::addHierarchyBoundsListener, Component::removeHierarchyBoundsListener, Listeners::ancestorBoundsMoved);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see HierarchyBoundsListener#ancestorResized(HierarchyEvent)
     * @see Component#addHierarchyBoundsListener(HierarchyBoundsListener)
     * @see Component#removeHierarchyBoundsListener(HierarchyBoundsListener)
     */
    Channel<Component, HierarchyEvent> ANCESTOR_BOUNDS_RESIZED =
            new ChannelAgent<>(Component::addHierarchyBoundsListener, Component::removeHierarchyBoundsListener, Listeners::ancestorBoundsResized);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see KeyListener#keyTyped(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     * @see Component#removeKeyListener(KeyListener)
     */
    Channel<Component, KeyEvent> KEY_TYPED =
            new ChannelAgent<>(Component::addKeyListener, Component::removeKeyListener, Listeners::keyTyped);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see KeyListener#keyPressed(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     * @see Component#removeKeyListener(KeyListener)
     */
    Channel<Component, KeyEvent> KEY_PRESSED =
            new ChannelAgent<>(Component::addKeyListener, Component::removeKeyListener, Listeners::keyPressed);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see KeyListener#keyReleased(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     * @see Component#removeKeyListener(KeyListener)
     */
    Channel<Component, KeyEvent> KEY_RELEASED =
            new ChannelAgent<>(Component::addKeyListener, Component::removeKeyListener, Listeners::keyReleased);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mousePressed(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     * @see Component#removeMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_PRESSED =
            new ChannelAgent<>(Component::addMouseListener, Component::removeMouseListener, Listeners::mousePressed);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseReleased(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     * @see Component#removeMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_RELEASED =
            new ChannelAgent<>(Component::addMouseListener, Component::removeMouseListener, Listeners::mouseReleased);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseClicked(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     * @see Component#removeMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_CLICKED =
            new ChannelAgent<>(Component::addMouseListener, Component::removeMouseListener, Listeners::mouseClicked);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseExited(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     * @see Component#removeMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_EXITED =
            new ChannelAgent<>(Component::addMouseListener, Component::removeMouseListener, Listeners::mouseExited);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseEntered(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     * @see Component#removeMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_ENTERED =
            new ChannelAgent<>(Component::addMouseListener, Component::removeMouseListener, Listeners::mouseEntered);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseMotionListener#mouseMoved(MouseEvent)
     * @see Component#addMouseMotionListener(MouseMotionListener)
     * @see Component#removeMouseMotionListener(MouseMotionListener)
     */
    Channel<Component, MouseEvent> MOUSE_MOVED =
            new ChannelAgent<>(Component::addMouseMotionListener, Component::removeMouseMotionListener, Listeners::mouseMoved);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseMotionListener#mouseDragged(MouseEvent)
     * @see Component#addMouseMotionListener(MouseMotionListener)
     * @see Component#removeMouseMotionListener(MouseMotionListener)
     */
    Channel<Component, MouseEvent> MOUSE_DRAGGED =
            new ChannelAgent<>(Component::addMouseMotionListener, Component::removeMouseMotionListener, Listeners::mouseDragged);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseWheelListener#mouseWheelMoved(MouseWheelEvent)
     * @see Component#addMouseWheelListener(MouseWheelListener)
     * @see Component#removeMouseWheelListener(MouseWheelListener)
     */
    Channel<Component, MouseWheelEvent> MOUSE_WHEEL_MOVED =
            new ChannelAgent<>(Component::addMouseWheelListener, Component::removeMouseWheelListener, Listeners::mouseWheelMoved);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see InputMethodListener#inputMethodTextChanged(InputMethodEvent)
     * @see Component#addInputMethodListener(InputMethodListener)
     * @see Component#removeInputMethodListener(InputMethodListener)
     */
    Channel<Component, InputMethodEvent> INPUT_METHOD_TEXT_CHANGED =
            new ChannelAgent<>(Component::addInputMethodListener, Component::removeInputMethodListener, Listeners::inputMethodTextChanged);

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see InputMethodListener#caretPositionChanged(InputMethodEvent)
     * @see Component#addInputMethodListener(InputMethodListener)
     * @see Component#removeInputMethodListener(InputMethodListener)
     */
    Channel<Component, InputMethodEvent> CARET_POSITION_CHANGED =
            new ChannelAgent<>(Component::addInputMethodListener, Component::removeInputMethodListener, Listeners::caretPositionChanged);

    /**
     * Represents a channel that handles events that can occur on a {@link Component}'s {@link DropTarget}.
     *
     * @see DropTargetListener#dragEnter(DropTargetDragEvent)
     * @see DropTarget#addDropTargetListener(DropTargetListener)
     * @see Component#getDropTarget()
     */
    Channel<Component, DropTargetDragEvent> DROP_TARGET_DRAG_ENTER =
            new ChannelAgent<>(Conversion.biConsumer((Component component,
                                                      DropTargetListener l) -> component.getDropTarget()
                                                                                        .addDropTargetListener(l)),
                               (Component component, DropTargetListener l) -> component.getDropTarget()
                                                                                       .removeDropTargetListener(l),
                               Listeners::dropTargetDragEnter);

    /**
     * Represents a channel that handles events that can occur on a {@link Component}'s {@link DropTarget}.
     *
     * @see DropTargetListener#dragOver(DropTargetDragEvent)
     * @see DropTarget#addDropTargetListener(DropTargetListener)
     * @see Component#getDropTarget()
     */
    Channel<Component, DropTargetDragEvent> DROP_TARGET_DRAG_OVER =
            new ChannelAgent<>(Conversion.biConsumer((Component component,
                                                      DropTargetListener l) -> component.getDropTarget()
                                                                                        .addDropTargetListener(l)),
                               (Component component, DropTargetListener l) -> component.getDropTarget()
                                                                                       .removeDropTargetListener(l),
                               Listeners::dropTargetDragOver);

    /**
     * Represents a channel that handles events that can occur on a {@link Component}'s {@link DropTarget}.
     *
     * @see DropTargetListener#dropActionChanged(DropTargetDragEvent)
     * @see DropTarget#addDropTargetListener(DropTargetListener)
     * @see Component#getDropTarget()
     */
    Channel<Component, DropTargetDragEvent> DROP_TARGET_DRAG_ACTION_CHANGED =
            new ChannelAgent<>(Conversion.biConsumer((Component component,
                                                      DropTargetListener l) -> component.getDropTarget()
                                                                                        .addDropTargetListener(l)),
                               (Component component, DropTargetListener l) -> component.getDropTarget()
                                                                                       .removeDropTargetListener(l),
                               Listeners::dropTargetDragActionChanged);

    /**
     * Represents a channel that handles events that can occur on a {@link Component}'s {@link DropTarget}.
     *
     * @see DropTargetListener#dragExit(DropTargetEvent)
     * @see DropTarget#addDropTargetListener(DropTargetListener)
     * @see Component#getDropTarget()
     */
    Channel<Component, DropTargetEvent> DROP_TARGET_DRAG_EXIT =
            new ChannelAgent<>(Conversion.biConsumer((Component component,
                                                      DropTargetListener l) -> component.getDropTarget()
                                                                                        .addDropTargetListener(l)),
                               (Component component, DropTargetListener l) -> component.getDropTarget()
                                                                                       .removeDropTargetListener(l),
                               Listeners::dropTargetDragExit);

    /**
     * Represents a channel that handles events that can occur on a {@link Component}'s {@link DropTarget}.
     *
     * @see DropTargetListener#drop(DropTargetDropEvent)
     * @see DropTarget#addDropTargetListener(DropTargetListener)
     * @see Component#getDropTarget()
     */
    Channel<Component, DropTargetDropEvent> DROP_TARGET_DROP =
            new ChannelAgent<>(Conversion.biConsumer((Component component,
                                                      DropTargetListener l) -> component.getDropTarget()
                                                                                        .addDropTargetListener(l)),
                               (Component component, DropTargetListener l) -> component.getDropTarget()
                                                                                       .removeDropTargetListener(l),
                               Listeners::dropTargetDrop);

    /**
     * Represents a channel that handles events that can occur on {@link Container}s.
     *
     * @see ContainerListener#componentAdded(ContainerEvent)
     * @see Container#addContainerListener(ContainerListener)
     * @see Container#removeContainerListener(ContainerListener)
     */
    Channel<Container, ContainerEvent> COMPONENT_ADDED =
            new ChannelAgent<>(Container::addContainerListener, Container::removeContainerListener, Listeners::componentAdded);

    /**
     * Represents a channel that handles events that can occur on {@link Container}s.
     *
     * @see ContainerListener#componentRemoved(ContainerEvent)
     * @see Container#addContainerListener(ContainerListener)
     * @see Container#removeContainerListener(ContainerListener)
     */
    Channel<Container, ContainerEvent> COMPONENT_REMOVED =
            new ChannelAgent<>(Container::addContainerListener, Container::removeContainerListener, Listeners::componentRemoved);

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see VetoableChangeListener#vetoableChange(PropertyChangeEvent)
     * @see JComponent#addVetoableChangeListener(VetoableChangeListener)
     * @see JComponent#removeVetoableChangeListener(VetoableChangeListener)
     */
    Channel<JComponent, PropertyChangeEvent> VETOABLE_CHANGE =
            new ChannelAgent<>(JComponent::addVetoableChangeListener, JComponent::removeVetoableChangeListener, Listeners::vetoableChange);

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorAdded(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     * @see JComponent#removeAncestorListener(AncestorListener)
     */
    Channel<JComponent, AncestorEvent> ANCESTOR_ADDED =
            new ChannelAgent<>(JComponent::addAncestorListener, JComponent::removeAncestorListener, Listeners::ancestorAdded);

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorRemoved(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     * @see JComponent#removeAncestorListener(AncestorListener)
     */
    Channel<JComponent, AncestorEvent> ANCESTOR_REMOVED =
            new ChannelAgent<>(JComponent::addAncestorListener, JComponent::removeAncestorListener, Listeners::ancestorRemoved);

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorMoved(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     * @see JComponent#removeAncestorListener(AncestorListener)
     */
    Channel<JComponent, AncestorEvent> ANCESTOR_MOVED =
            new ChannelAgent<>(JComponent::addAncestorListener, JComponent::removeAncestorListener, Listeners::ancestorMoved);

    /**
     * Represents a channel that handles events that can occur on {@link JTextComponent}s.
     *
     * @see CaretListener#caretUpdate(CaretEvent)
     * @see JTextComponent#addCaretListener(CaretListener)
     * @see JTextComponent#removeCaretListener(CaretListener)
     */
    Channel<JTextComponent, CaretEvent> CARET_UPDATE =
            new ChannelAgent<>(JTextComponent::addCaretListener, JTextComponent::removeCaretListener, Listeners::caretUpdate);

    /**
     * Represents a channel that handles events that can occur on {@link JProgressBar}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JProgressBar#addChangeListener(ChangeListener)
     * @see JProgressBar#removeChangeListener(ChangeListener)
     */
    Channel<JProgressBar, ChangeEvent> JPB_STATE_CHANGED =
            new ChannelAgent<>(JProgressBar::addChangeListener, JProgressBar::removeChangeListener, Listeners::stateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JTabbedPane}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JTabbedPane#addChangeListener(ChangeListener)
     * @see JTabbedPane#removeChangeListener(ChangeListener)
     */
    Channel<JTabbedPane, ChangeEvent> JTP_STATE_CHANGED =
            new ChannelAgent<>(JTabbedPane::addChangeListener, JTabbedPane::removeChangeListener, Listeners::stateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JTextField}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JTextField#addActionListener(ActionListener)
     * @see JTextField#removeActionListener(ActionListener)
     */
    Channel<JTextField, ActionEvent> JTF_ACTION_PERFORMED =
            new ChannelAgent<>(JTextField::addActionListener, JTextField::removeActionListener, Listeners::actionPerformed);

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     * @see JPopupMenu#removePopupMenuListener(PopupMenuListener)
     */
    Channel<JPopupMenu, PopupMenuEvent> POPUP_MENU_WILL_BECOME_VISIBLE =
            new ChannelAgent<>(JPopupMenu::addPopupMenuListener, JPopupMenu::removePopupMenuListener, Listeners::popupMenuWillBecomeVisible);

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     * @see JPopupMenu#removePopupMenuListener(PopupMenuListener)
     */
    Channel<JPopupMenu, PopupMenuEvent> POPUP_MENU_WILL_BECOME_INVISIBLE =
            new ChannelAgent<>(JPopupMenu::addPopupMenuListener, JPopupMenu::removePopupMenuListener, Listeners::popupMenuWillBecomeInvisible);

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     * @see JPopupMenu#removePopupMenuListener(PopupMenuListener)
     */
    Channel<JPopupMenu, PopupMenuEvent> POPUP_MENU_CANCELED =
            new ChannelAgent<>(JPopupMenu::addPopupMenuListener, JPopupMenu::removePopupMenuListener, Listeners::popupMenuCanceled);

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     * @see JPopupMenu#removeMenuKeyListener(MenuKeyListener)
     */
    Channel<JPopupMenu, MenuKeyEvent> MENU_KEY_PRESSED =
            new ChannelAgent<>(JPopupMenu::addMenuKeyListener, JPopupMenu::removeMenuKeyListener, Listeners::menuKeyPressed);

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     * @see JPopupMenu#removeMenuKeyListener(MenuKeyListener)
     */
    Channel<JPopupMenu, MenuKeyEvent> MENU_KEY_RELEASED =
            new ChannelAgent<>(JPopupMenu::addMenuKeyListener, JPopupMenu::removeMenuKeyListener, Listeners::menuKeyReleased);

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     * @see JPopupMenu#removeMenuKeyListener(MenuKeyListener)
     */
    Channel<JPopupMenu, MenuKeyEvent> MENU_KEY_TYPED =
            new ChannelAgent<>(JPopupMenu::addMenuKeyListener, JPopupMenu::removeMenuKeyListener, Listeners::menuKeyTyped);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowStateListener#windowStateChanged(WindowEvent)
     * @see Window#addWindowStateListener(WindowStateListener)
     * @see Window#removeWindowStateListener(WindowStateListener)
     */
    Channel<Window, WindowEvent> WINDOW_STATE_CHANGED =
            new ChannelAgent<>(Window::addWindowStateListener, Window::removeWindowStateListener, Listeners::windowStateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowOpened(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_OPENED =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowOpened);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowClosing(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_CLOSING =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowClosing);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowClosed(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_CLOSED =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowClosed);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowIconified(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_ICONIFIED =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowIconified);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowDeiconified(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_DEICONIFIED =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowDeiconified);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowActivated(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_ACTIVATED =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowActivated);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowDeactivated(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     * @see Window#removeWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_DEACTIVATED =
            new ChannelAgent<>(Window::addWindowListener, Window::removeWindowListener, Listeners::windowDeactivated);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowFocusListener#windowGainedFocus(WindowEvent)
     * @see Window#addWindowFocusListener(WindowFocusListener)
     * @see Window#removeWindowFocusListener(WindowFocusListener)
     */
    Channel<Window, WindowEvent> WINDOW_GAINED_FOCUS =
            new ChannelAgent<>(Window::addWindowFocusListener, Window::removeWindowFocusListener, Listeners::windowGainedFocus);

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowFocusListener#windowLostFocus(WindowEvent)
     * @see Window#addWindowFocusListener(WindowFocusListener)
     * @see Window#removeWindowFocusListener(WindowFocusListener)
     */
    Channel<Window, WindowEvent> WINDOW_LOST_FOCUS =
            new ChannelAgent<>(Window::addWindowFocusListener, Window::removeWindowFocusListener, Listeners::windowLostFocus);

    /**
     * Represents a channel that handles events that can occur on {@link AbstractButton}s.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     * @see AbstractButton#addItemListener(ItemListener)
     * @see AbstractButton#removeItemListener(ItemListener)
     */
    Channel<AbstractButton, ItemEvent> ITEM_STATE_CHANGED =
            new ChannelAgent<>(AbstractButton::addItemListener, AbstractButton::removeItemListener, Listeners::itemStateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link AbstractButton}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see AbstractButton#addActionListener(ActionListener)
     * @see AbstractButton#removeActionListener(ActionListener)
     */
    Channel<AbstractButton, ActionEvent> ACTION_PERFORMED =
            new ChannelAgent<>(AbstractButton::addActionListener, AbstractButton::removeActionListener, Listeners::actionPerformed);

    /**
     * Represents a channel that handles events that can occur on {@link AbstractButton}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see AbstractButton#addChangeListener(ChangeListener)
     * @see AbstractButton#removeChangeListener(ChangeListener)
     */
    Channel<AbstractButton, ChangeEvent> STATE_CHANGED =
            new ChannelAgent<>(AbstractButton::addChangeListener, AbstractButton::removeChangeListener, Listeners::stateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseEntered(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     * @see JMenuItem#removeMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_ENTERED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, JMenuItem::removeMenuDragMouseListener, Listeners::menuDragMouseEntered);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseExited(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     * @see JMenuItem#removeMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_EXITED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, JMenuItem::removeMenuDragMouseListener, Listeners::menuDragMouseExited);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseDragged(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     * @see JMenuItem#removeMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_DRAGGED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, JMenuItem::removeMenuDragMouseListener, Listeners::menuDragMouseDragged);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseReleased(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     * @see JMenuItem#removeMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_RELEASED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, JMenuItem::removeMenuDragMouseListener, Listeners::menuDragMouseReleased);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     * @see JMenuItem#removeMenuKeyListener(MenuKeyListener)
     */
    Channel<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_PRESSED =
            new ChannelAgent<>(JMenuItem::addMenuKeyListener, JMenuItem::removeMenuKeyListener, Listeners::menuKeyPressed);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     * @see JMenuItem#removeMenuKeyListener(MenuKeyListener)
     */
    Channel<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_RELEASED =
            new ChannelAgent<>(JMenuItem::addMenuKeyListener, JMenuItem::removeMenuKeyListener, Listeners::menuKeyReleased);

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     * @see JMenuItem#removeMenuKeyListener(MenuKeyListener)
     */
    Channel<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_TYPED =
            new ChannelAgent<>(JMenuItem::addMenuKeyListener, JMenuItem::removeMenuKeyListener, Listeners::menuKeyTyped);

    /**
     * Represents a channel that handles events that can occur on {@link JSlider}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JSlider#addChangeListener(ChangeListener)
     * @see JSlider#removeChangeListener(ChangeListener)
     */
    Channel<JSlider, ChangeEvent> JSL_STATE_CHANGED =
            new ChannelAgent<>(JSlider::addChangeListener, JSlider::removeChangeListener, Listeners::stateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     * @see JComboBox#addItemListener(ItemListener)
     * @see JComboBox#removeItemListener(ItemListener)
     */
    Channel<JComboBox<?>, ItemEvent> JCB_ITEM_STATE_CHANGED =
            new ChannelAgent<>(JComboBox::addItemListener, JComboBox::removeItemListener, Listeners::itemStateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JComboBox#addActionListener(ActionListener)
     * @see JComboBox#removeActionListener(ActionListener)
     */
    Channel<JComboBox<?>, ActionEvent> JCB_ACTION_PERFORMED =
            new ChannelAgent<>(JComboBox::addActionListener, JComboBox::removeActionListener, Listeners::actionPerformed);

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     * @see JComboBox#removePopupMenuListener(PopupMenuListener)
     */
    Channel<JComboBox<?>, PopupMenuEvent> JCB_POPUP_WILL_BECOME_VISIBLE =
            new ChannelAgent<>(JComboBox::addPopupMenuListener, JComboBox::removePopupMenuListener, Listeners::popupMenuWillBecomeVisible);

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     * @see JComboBox#removePopupMenuListener(PopupMenuListener)
     */
    Channel<JComboBox<?>, PopupMenuEvent> JCB_POPUP_WILL_BECOME_INVISIBLE =
            new ChannelAgent<>(JComboBox::addPopupMenuListener, JComboBox::removePopupMenuListener, Listeners::popupMenuWillBecomeInvisible);

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     * @see JComboBox#removePopupMenuListener(PopupMenuListener)
     */
    Channel<JComboBox<?>, PopupMenuEvent> JCB_POPUP_CANCELED =
            new ChannelAgent<>(JComboBox::addPopupMenuListener, JComboBox::removePopupMenuListener, Listeners::popupMenuCanceled);

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeExpansionListener#treeExpanded(TreeExpansionEvent)
     * @see JTree#addTreeExpansionListener(TreeExpansionListener)
     * @see JTree#removeTreeExpansionListener(TreeExpansionListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_EXPANDED =
            new ChannelAgent<>(JTree::addTreeExpansionListener, JTree::removeTreeExpansionListener, Listeners::treeExpanded);

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeExpansionListener#treeCollapsed(TreeExpansionEvent)
     * @see JTree#addTreeExpansionListener(TreeExpansionListener)
     * @see JTree#removeTreeExpansionListener(TreeExpansionListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_COLLAPSED =
            new ChannelAgent<>(JTree::addTreeExpansionListener, JTree::removeTreeExpansionListener, Listeners::treeCollapsed);

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeWillExpandListener#treeWillExpand(TreeExpansionEvent)
     * @see JTree#addTreeWillExpandListener(TreeWillExpandListener)
     * @see JTree#removeTreeWillExpandListener(TreeWillExpandListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_WILL_EXPAND =
            new ChannelAgent<>(JTree::addTreeWillExpandListener, JTree::removeTreeWillExpandListener, Listeners::treeWillExpand);

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeWillExpandListener#treeWillCollapse(TreeExpansionEvent)
     * @see JTree#addTreeWillExpandListener(TreeWillExpandListener)
     * @see JTree#removeTreeWillExpandListener(TreeWillExpandListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_WILL_COLLAPSE =
            new ChannelAgent<>(JTree::addTreeWillExpandListener, JTree::removeTreeWillExpandListener, Listeners::treeWillCollapse);

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeSelectionListener#valueChanged(TreeSelectionEvent)
     * @see JTree#addTreeSelectionListener(TreeSelectionListener)
     * @see JTree#removeTreeSelectionListener(TreeSelectionListener)
     */
    Channel<JTree, TreeSelectionEvent> TREE_VALUE_CHANGED =
            new ChannelAgent<>(JTree::addTreeSelectionListener, JTree::removeTreeSelectionListener, Listeners::treeValueChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JSpinner}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JSpinner#addChangeListener(ChangeListener)
     * @see JSpinner#removeChangeListener(ChangeListener)
     */
    Channel<JSpinner, ChangeEvent> JSP_STATE_CHANGED =
            new ChannelAgent<>(JSpinner::addChangeListener, JSpinner::removeChangeListener, Listeners::stateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JScrollBar}s.
     *
     * @see AdjustmentListener#adjustmentValueChanged(AdjustmentEvent)
     * @see JScrollBar#addAdjustmentListener(AdjustmentListener)
     * @see JScrollBar#removeAdjustmentListener(AdjustmentListener)
     */
    Channel<JScrollBar, AdjustmentEvent> ADJUSTMENT_VALUE_CHANGED =
            new ChannelAgent<>(JScrollBar::addAdjustmentListener, JScrollBar::removeAdjustmentListener, Listeners::adjustmentValueChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JList}s.
     *
     * @see ListSelectionListener#valueChanged(ListSelectionEvent)
     * @see JList#addListSelectionListener(ListSelectionListener)
     * @see JList#removeListSelectionListener(ListSelectionListener)
     */
    Channel<JList<?>, ListSelectionEvent> LIST_VALUE_CHANGED =
            new ChannelAgent<>(JList::addListSelectionListener, JList::removeListSelectionListener, Listeners::listValueChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameOpened(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_OPENED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameOpened);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameClosing(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_CLOSING =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameClosing);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameClosed(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_CLOSED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameClosed);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameIconified(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_ICONIFIED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameIconified);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameDeiconified(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_DEICONIFIED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameDeiconified);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameActivated(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_ACTIVATED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameActivated);

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameDeactivated(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     * @see JInternalFrame#removeInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_DEACTIVATED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, JInternalFrame::removeInternalFrameListener, Listeners::internalFrameDeactivated);

    /**
     * Represents a channel that handles events that can occur on {@link JEditorPane}s.
     *
     * @see HyperlinkListener#hyperlinkUpdate(HyperlinkEvent)
     * @see JEditorPane#addHyperlinkListener(HyperlinkListener)
     * @see JEditorPane#removeHyperlinkListener(HyperlinkListener)
     */
    Channel<JEditorPane, HyperlinkEvent> HYPERLINK_UPDATE =
            new ChannelAgent<>(JEditorPane::addHyperlinkListener, JEditorPane::removeHyperlinkListener, Listeners::hyperlinkUpdate);

    /**
     * Represents a channel that handles events that can occur on {@link JViewport}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JViewport#addChangeListener(ChangeListener)
     * @see JViewport#removeChangeListener(ChangeListener)
     */
    Channel<JViewport, ChangeEvent> JVP_STATE_CHANGED =
            new ChannelAgent<>(JViewport::addChangeListener, JViewport::removeChangeListener, Listeners::stateChanged);

    /**
     * Represents a channel that handles events that can occur on {@link JFileChooser}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JFileChooser#addActionListener(ActionListener)
     * @see JFileChooser#removeActionListener(ActionListener)
     */
    Channel<JFileChooser, ActionEvent> JFC_ACTION_PERFORMED =
            new ChannelAgent<>(JFileChooser::addActionListener, JFileChooser::removeActionListener, Listeners::actionPerformed);

    /**
     * Represents a channel that handles events that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuSelected(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     * @see JMenu#removeMenuListener(MenuListener)
     */
    Channel<JMenu, MenuEvent> MENU_SELECTED =
            new ChannelAgent<>(JMenu::addMenuListener, JMenu::removeMenuListener, Listeners::menuSelected);

    /**
     * Represents a channel that handles events that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuDeselected(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     * @see JMenu#removeMenuListener(MenuListener)
     */
    Channel<JMenu, MenuEvent> MENU_DESELECTED =
            new ChannelAgent<>(JMenu::addMenuListener, JMenu::removeMenuListener, Listeners::menuDeselected);

    /**
     * Represents a channel that handles events that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuCanceled(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     * @see JMenu#removeMenuListener(MenuListener)
     */
    Channel<JMenu, MenuEvent> MENU_CANCELED =
            new ChannelAgent<>(JMenu::addMenuListener, JMenu::removeMenuListener, Listeners::menuCanceled);

    /**
     * Retrieves a channel that handles events that can occur on {@link Component}s
     *
     * @param propertyName The name of the property in question.
     * @see PropertyChangeListener#propertyChange(PropertyChangeEvent)
     * @see Component#addPropertyChangeListener(String, PropertyChangeListener)
     */
    static Channel<Component, PropertyChangeEvent> propertyChange(final String propertyName) {
        return new ChannelAgent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(propertyName, l),
                                  (Component c, PropertyChangeListener l) -> c.removePropertyChangeListener(propertyName, l),
                                  Listeners::propertyChange);
    }

    /**
     * Adds a suitable {@link Consumer} to a given component of type {@code <C>} to process messages of type
     * {@code <M>} when a corresponding activity or event occurs in that component.
     *
     * @return A {@link Link} that can be {@link Link#unlink() unlinked} to stop processing associated messages.
     * Can be ignored if processing should not be stopped within the component's lifecycle.
     */
    Link add(C component, Consumer<M> reaction);
}
