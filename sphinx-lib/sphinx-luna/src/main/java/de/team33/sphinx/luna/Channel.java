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
@SuppressWarnings({"unused", "ClassWithTooManyFields"})
public interface Channel<C, M> {

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see PropertyChangeListener#propertyChange(PropertyChangeEvent)
     * @see Component#addPropertyChangeListener(PropertyChangeListener)
     */
    Channel<Component, PropertyChangeEvent> PROPERTY_CHANGE =
            new ChannelAgent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(l),
                               Listeners::propertyChange)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentResized(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_RESIZED =
            new ChannelAgent<>(Component::addComponentListener, Listeners::componentResized)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentMoved(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_MOVED =
            new ChannelAgent<>(Component::addComponentListener, Listeners::componentMoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentShown(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_SHOWN =
            new ChannelAgent<>(Component::addComponentListener, Listeners::componentShown)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentHidden(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Channel<Component, ComponentEvent> COMPONENT_HIDDEN =
            new ChannelAgent<>(Component::addComponentListener, Listeners::componentHidden)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see FocusListener#focusGained(FocusEvent)
     * @see Component#addFocusListener(FocusListener)
     */
    Channel<Component, FocusEvent> FOCUS_GAINED =
            new ChannelAgent<>(Component::addFocusListener, Listeners::focusGained)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see FocusListener#focusLost(FocusEvent)
     * @see Component#addFocusListener(FocusListener)
     */
    Channel<Component, FocusEvent> FOCUS_LOST =
            new ChannelAgent<>(Component::addFocusListener, Listeners::focusLost)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see HierarchyListener#hierarchyChanged(HierarchyEvent)
     * @see Component#addHierarchyListener(HierarchyListener)
     */
    Channel<Component, HierarchyEvent> HIERARCHY_CHANGED =
            new ChannelAgent<>(Component::addHierarchyListener, Listeners::hierarchyChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see HierarchyBoundsListener#ancestorMoved(HierarchyEvent)
     * @see Component#addHierarchyBoundsListener(HierarchyBoundsListener)
     */
    Channel<Component, HierarchyEvent> ANCESTOR_BOUNDS_MOVED =
            new ChannelAgent<>(Component::addHierarchyBoundsListener, Listeners::ancestorBoundsMoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see HierarchyBoundsListener#ancestorResized(HierarchyEvent)
     * @see Component#addHierarchyBoundsListener(HierarchyBoundsListener)
     */
    Channel<Component, HierarchyEvent> ANCESTOR_BOUNDS_RESIZED =
            new ChannelAgent<>(Component::addHierarchyBoundsListener, Listeners::ancestorBoundsResized)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see KeyListener#keyTyped(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     */
    Channel<Component, KeyEvent> KEY_TYPED =
            new ChannelAgent<>(Component::addKeyListener, Listeners::keyTyped)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see KeyListener#keyPressed(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     */
    Channel<Component, KeyEvent> KEY_PRESSED =
            new ChannelAgent<>(Component::addKeyListener, Listeners::keyPressed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see KeyListener#keyReleased(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     */
    Channel<Component, KeyEvent> KEY_RELEASED =
            new ChannelAgent<>(Component::addKeyListener, Listeners::keyReleased)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mousePressed(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_PRESSED =
            new ChannelAgent<>(Component::addMouseListener, Listeners::mousePressed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseReleased(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_RELEASED =
            new ChannelAgent<>(Component::addMouseListener, Listeners::mouseReleased)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseClicked(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_CLICKED =
            new ChannelAgent<>(Component::addMouseListener, Listeners::mouseClicked)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseExited(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_EXITED =
            new ChannelAgent<>(Component::addMouseListener, Listeners::mouseExited)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseEntered(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Channel<Component, MouseEvent> MOUSE_ENTERED =
            new ChannelAgent<>(Component::addMouseListener, Listeners::mouseEntered)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseMotionListener#mouseMoved(MouseEvent)
     * @see Component#addMouseMotionListener(MouseMotionListener)
     */
    Channel<Component, MouseEvent> MOUSE_MOVED =
            new ChannelAgent<>(Component::addMouseMotionListener, Listeners::mouseMoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseMotionListener#mouseDragged(MouseEvent)
     * @see Component#addMouseMotionListener(MouseMotionListener)
     */
    Channel<Component, MouseEvent> MOUSE_DRAGGED =
            new ChannelAgent<>(Component::addMouseMotionListener, Listeners::mouseDragged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see MouseWheelListener#mouseWheelMoved(MouseWheelEvent)
     * @see Component#addMouseWheelListener(MouseWheelListener)
     */
    Channel<Component, MouseWheelEvent> MOUSE_WHEEL_MOVED =
            new ChannelAgent<>(Component::addMouseWheelListener, Listeners::mouseWheelMoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see InputMethodListener#inputMethodTextChanged(InputMethodEvent)
     * @see Component#addInputMethodListener(InputMethodListener)
     */
    Channel<Component, InputMethodEvent> INPUT_METHOD_TEXT_CHANGED =
            new ChannelAgent<>(Component::addInputMethodListener, Listeners::inputMethodTextChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Component}s.
     *
     * @see InputMethodListener#caretPositionChanged(InputMethodEvent)
     * @see Component#addInputMethodListener(InputMethodListener)
     */
    Channel<Component, InputMethodEvent> CARET_POSITION_CHANGED =
            new ChannelAgent<>(Component::addInputMethodListener, Listeners::caretPositionChanged)::add;

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
                               Listeners::dropTargetDragEnter)::add;

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
                               Listeners::dropTargetDragOver)::add;

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
                               Listeners::dropTargetDragActionChanged)::add;

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
                               Listeners::dropTargetDragExit)::add;

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
                               Listeners::dropTargetDrop)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Container}s.
     *
     * @see ContainerListener#componentAdded(ContainerEvent)
     * @see Container#addContainerListener(ContainerListener)
     */
    Channel<Container, ContainerEvent> COMPONENT_ADDED =
            new ChannelAgent<>(Container::addContainerListener, Listeners::componentAdded)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Container}s.
     *
     * @see ContainerListener#componentRemoved(ContainerEvent)
     * @see Container#addContainerListener(ContainerListener)
     */
    Channel<Container, ContainerEvent> COMPONENT_REMOVED =
            new ChannelAgent<>(Container::addContainerListener, Listeners::componentRemoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see VetoableChangeListener#vetoableChange(PropertyChangeEvent)
     * @see JComponent#addVetoableChangeListener(VetoableChangeListener)
     */
    Channel<JComponent, PropertyChangeEvent> VETOABLE_CHANGE =
            new ChannelAgent<>(JComponent::addVetoableChangeListener, Listeners::vetoableChange)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorAdded(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     */
    Channel<JComponent, AncestorEvent> ANCESTOR_ADDED =
            new ChannelAgent<>(JComponent::addAncestorListener, Listeners::ancestorAdded)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorRemoved(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     */
    Channel<JComponent, AncestorEvent> ANCESTOR_REMOVED =
            new ChannelAgent<>(JComponent::addAncestorListener, Listeners::ancestorRemoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorMoved(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     */
    Channel<JComponent, AncestorEvent> ANCESTOR_MOVED =
            new ChannelAgent<>(JComponent::addAncestorListener, Listeners::ancestorMoved)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTextComponent}s.
     *
     * @see CaretListener#caretUpdate(CaretEvent)
     * @see JTextComponent#addCaretListener(CaretListener)
     */
    Channel<JTextComponent, CaretEvent> CARET_UPDATE =
            new ChannelAgent<>(JTextComponent::addCaretListener, Listeners::caretUpdate)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JProgressBar}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JProgressBar#addChangeListener(ChangeListener)
     */
    Channel<JProgressBar, ChangeEvent> JPB_STATE_CHANGED =
            new ChannelAgent<>(JProgressBar::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTabbedPane}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JTabbedPane#addChangeListener(ChangeListener)
     */
    Channel<JTabbedPane, ChangeEvent> JTP_STATE_CHANGED =
            new ChannelAgent<>(JTabbedPane::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTextField}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JTextField#addActionListener(ActionListener)
     */
    Channel<JTextField, ActionEvent> JTF_ACTION_PERFORMED =
            new ChannelAgent<>(JTextField::addActionListener, Listeners::actionPerformed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     */
    Channel<JPopupMenu, PopupMenuEvent> POPUP_MENU_WILL_BECOME_VISIBLE =
            new ChannelAgent<>(JPopupMenu::addPopupMenuListener, Listeners::popupMenuWillBecomeVisible)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     */
    Channel<JPopupMenu, PopupMenuEvent> POPUP_MENU_WILL_BECOME_INVISIBLE =
            new ChannelAgent<>(JPopupMenu::addPopupMenuListener, Listeners::popupMenuWillBecomeInvisible)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     */
    Channel<JPopupMenu, PopupMenuEvent> POPUP_MENU_CANCELED =
            new ChannelAgent<>(JPopupMenu::addPopupMenuListener, Listeners::popupMenuCanceled)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     */
    Channel<JPopupMenu, MenuKeyEvent> MENU_KEY_PRESSED =
            new ChannelAgent<>(JPopupMenu::addMenuKeyListener, Listeners::menuKeyPressed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     */
    Channel<JPopupMenu, MenuKeyEvent> MENU_KEY_RELEASED =
            new ChannelAgent<>(JPopupMenu::addMenuKeyListener, Listeners::menuKeyReleased)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     */
    Channel<JPopupMenu, MenuKeyEvent> MENU_KEY_TYPED =
            new ChannelAgent<>(JPopupMenu::addMenuKeyListener, Listeners::menuKeyTyped)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowStateListener#windowStateChanged(WindowEvent)
     * @see Window#addWindowStateListener(WindowStateListener)
     */
    Channel<Window, WindowEvent> WINDOW_STATE_CHANGED =
            new ChannelAgent<>(Window::addWindowStateListener, Listeners::windowStateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowOpened(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_OPENED =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowOpened)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowClosing(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_CLOSING =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowClosing)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowClosed(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_CLOSED =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowClosed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowIconified(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_ICONIFIED =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowIconified)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowDeiconified(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_DEICONIFIED =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowDeiconified)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowActivated(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_ACTIVATED =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowActivated)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowListener#windowDeactivated(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Channel<Window, WindowEvent> WINDOW_DEACTIVATED =
            new ChannelAgent<>(Window::addWindowListener, Listeners::windowDeactivated)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowFocusListener#windowGainedFocus(WindowEvent)
     * @see Window#addWindowFocusListener(WindowFocusListener)
     */
    Channel<Window, WindowEvent> WINDOW_GAINED_FOCUS =
            new ChannelAgent<>(Window::addWindowFocusListener, Listeners::windowGainedFocus)::add;

    /**
     * Represents a channel that handles events that can occur on {@link Window}s.
     *
     * @see WindowFocusListener#windowLostFocus(WindowEvent)
     * @see Window#addWindowFocusListener(WindowFocusListener)
     */
    Channel<Window, WindowEvent> WINDOW_LOST_FOCUS =
            new ChannelAgent<>(Window::addWindowFocusListener, Listeners::windowLostFocus)::add;

    /**
     * Represents a channel that handles events that can occur on {@link AbstractButton}s.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     * @see AbstractButton#addItemListener(ItemListener)
     */
    Channel<AbstractButton, ItemEvent> ITEM_STATE_CHANGED =
            new ChannelAgent<>(AbstractButton::addItemListener, Listeners::itemStateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link AbstractButton}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see AbstractButton#addActionListener(ActionListener)
     */
    Channel<AbstractButton, ActionEvent> ACTION_PERFORMED =
            new ChannelAgent<>(AbstractButton::addActionListener, Listeners::actionPerformed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link AbstractButton}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see AbstractButton#addChangeListener(ChangeListener)
     */
    Channel<AbstractButton, ChangeEvent> STATE_CHANGED =
            new ChannelAgent<>(AbstractButton::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseEntered(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_ENTERED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseEntered)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseExited(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_EXITED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseExited)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseDragged(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_DRAGGED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseDragged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseReleased(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Channel<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_RELEASED =
            new ChannelAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseReleased)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     */
    Channel<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_PRESSED =
            new ChannelAgent<>(JMenuItem::addMenuKeyListener, Listeners::menuKeyPressed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     */
    Channel<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_RELEASED =
            new ChannelAgent<>(JMenuItem::addMenuKeyListener, Listeners::menuKeyReleased)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     */
    Channel<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_TYPED =
            new ChannelAgent<>(JMenuItem::addMenuKeyListener, Listeners::menuKeyTyped)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JSlider}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JSlider#addChangeListener(ChangeListener)
     */
    Channel<JSlider, ChangeEvent> JSL_STATE_CHANGED =
            new ChannelAgent<>(JSlider::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     * @see JComboBox#addItemListener(ItemListener)
     */
    Channel<JComboBox<?>, ItemEvent> JCB_ITEM_STATE_CHANGED =
            new ChannelAgent<>((JComboBox<?> c, ItemListener l) -> c.addItemListener(l),
                               Listeners::itemStateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JComboBox#addActionListener(ActionListener)
     */
    Channel<JComboBox<?>, ActionEvent> JCB_ACTION_PERFORMED =
            new ChannelAgent<>((JComboBox<?> c, ActionListener l) -> c.addActionListener(l),
                               Listeners::actionPerformed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     */
    Channel<JComboBox<?>, PopupMenuEvent> JCB_POPUP_WILL_BECOME_VISIBLE =
            new ChannelAgent<>((JComboBox<?> c, PopupMenuListener l) -> c.addPopupMenuListener(l),
                               Listeners::popupMenuWillBecomeVisible)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     */
    Channel<JComboBox<?>, PopupMenuEvent> JCB_POPUP_WILL_BECOME_INVISIBLE =
            new ChannelAgent<>((JComboBox<?> c, PopupMenuListener l) -> c.addPopupMenuListener(l),
                               Listeners::popupMenuWillBecomeInvisible)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     */
    Channel<JComboBox<?>, PopupMenuEvent> JCB_POPUP_CANCELED =
            new ChannelAgent<>((JComboBox<?> c, PopupMenuListener l) -> c.addPopupMenuListener(l),
                               Listeners::popupMenuCanceled)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeExpansionListener#treeExpanded(TreeExpansionEvent)
     * @see JTree#addTreeExpansionListener(TreeExpansionListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_EXPANDED =
            new ChannelAgent<>(JTree::addTreeExpansionListener, Listeners::treeExpanded)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeExpansionListener#treeCollapsed(TreeExpansionEvent)
     * @see JTree#addTreeExpansionListener(TreeExpansionListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_COLLAPSED =
            new ChannelAgent<>(JTree::addTreeExpansionListener, Listeners::treeCollapsed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeWillExpandListener#treeWillExpand(TreeExpansionEvent)
     * @see JTree#addTreeWillExpandListener(TreeWillExpandListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_WILL_EXPAND =
            new ChannelAgent<>(JTree::addTreeWillExpandListener, Listeners::treeWillExpand)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeWillExpandListener#treeWillCollapse(TreeExpansionEvent)
     * @see JTree#addTreeWillExpandListener(TreeWillExpandListener)
     */
    Channel<JTree, TreeExpansionEvent> TREE_WILL_COLLAPSE =
            new ChannelAgent<>(JTree::addTreeWillExpandListener, Listeners::treeWillCollapse)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JTree}s.
     *
     * @see TreeSelectionListener#valueChanged(TreeSelectionEvent)
     * @see JTree#addTreeSelectionListener(TreeSelectionListener)
     */
    Channel<JTree, TreeSelectionEvent> TREE_VALUE_CHANGED =
            new ChannelAgent<>(JTree::addTreeSelectionListener, Listeners::treeValueChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JSpinner}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JSpinner#addChangeListener(ChangeListener)
     */
    Channel<JSpinner, ChangeEvent> JSP_STATE_CHANGED =
            new ChannelAgent<>(JSpinner::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JScrollBar}s.
     *
     * @see AdjustmentListener#adjustmentValueChanged(AdjustmentEvent)
     * @see JScrollBar#addAdjustmentListener(AdjustmentListener)
     */
    Channel<JScrollBar, AdjustmentEvent> ADJUSTMENT_VALUE_CHANGED =
            new ChannelAgent<>(JScrollBar::addAdjustmentListener, Listeners::adjustmentValueChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JList}s.
     *
     * @see ListSelectionListener#valueChanged(ListSelectionEvent)
     * @see JList#addListSelectionListener(ListSelectionListener)
     */
    Channel<JList<?>, ListSelectionEvent> LIST_VALUE_CHANGED =
            new ChannelAgent<>((JList<?> c, ListSelectionListener l) -> c.addListSelectionListener(l),
                               Listeners::listValueChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameOpened(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_OPENED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameOpened)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameClosing(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_CLOSING =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameClosing)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameClosed(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_CLOSED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameClosed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameIconified(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_ICONIFIED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameIconified)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameDeiconified(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_DEICONIFIED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameDeiconified)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameActivated(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_ACTIVATED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameActivated)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameDeactivated(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Channel<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_DEACTIVATED =
            new ChannelAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameDeactivated)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JEditorPane}s.
     *
     * @see HyperlinkListener#hyperlinkUpdate(HyperlinkEvent)
     * @see JEditorPane#addHyperlinkListener(HyperlinkListener)
     */
    Channel<JEditorPane, HyperlinkEvent> HYPERLINK_UPDATE =
            new ChannelAgent<>(JEditorPane::addHyperlinkListener, Listeners::hyperlinkUpdate)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JViewport}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JViewport#addChangeListener(ChangeListener)
     */
    Channel<JViewport, ChangeEvent> JVP_STATE_CHANGED =
            new ChannelAgent<>(JViewport::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JFileChooser}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JFileChooser#addActionListener(ActionListener)
     */
    Channel<JFileChooser, ActionEvent> JFC_ACTION_PERFORMED =
            new ChannelAgent<>(JFileChooser::addActionListener, Listeners::actionPerformed)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuSelected(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     */
    Channel<JMenu, MenuEvent> MENU_SELECTED =
            new ChannelAgent<>(JMenu::addMenuListener, Listeners::menuSelected)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuDeselected(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     */
    Channel<JMenu, MenuEvent> MENU_DESELECTED =
            new ChannelAgent<>(JMenu::addMenuListener, Listeners::menuDeselected)::add;

    /**
     * Represents a channel that handles events that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuCanceled(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     */
    Channel<JMenu, MenuEvent> MENU_CANCELED =
            new ChannelAgent<>(JMenu::addMenuListener, Listeners::menuCanceled)::add;

    /**
     * Retrieves a channel that handles events that can occur on {@link Component}s
     *
     * @param propertyName The name of the property in question.
     * @see PropertyChangeListener#propertyChange(PropertyChangeEvent)
     * @see Component#addPropertyChangeListener(String, PropertyChangeListener)
     */
    static Channel<Component, PropertyChangeEvent> propertyChange(final String propertyName) {
        return new ChannelAgent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(propertyName, l),
                                  Listeners::propertyChange)::add;
    }

    /**
     * Adds an appropriate {@link Consumer} to a given component of type {@code <C>} to process the associated
     * message of type {@code <M>} when an activity or event as expected in this context occurs.
     */
    void add(C component, Consumer<M> reaction);
}
