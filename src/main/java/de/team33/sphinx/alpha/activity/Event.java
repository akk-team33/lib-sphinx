package de.team33.sphinx.alpha.activity;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.function.Consumer;

/**
 * Abstracts sorts of activities or events.
 *
 * @param <C> The component type in whose context the activity or event takes place.
 * @param <M> The message type being transferred in the context of the activity or event.
 */
@FunctionalInterface
@SuppressWarnings("unused")
public interface Event<C, M> {

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see PropertyChangeListener#propertyChange(PropertyChangeEvent)
     * @see Component#addPropertyChangeListener(PropertyChangeListener)
     */
    Event<Component, PropertyChangeEvent> PROPERTY_CHANGE =
            new EventAgent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(l),
                             Listeners::propertyChange)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentResized(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Event<Component, ComponentEvent> COMPONENT_RESIZED =
            new EventAgent<>(Component::addComponentListener, Listeners::componentResized)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentMoved(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Event<Component, ComponentEvent> COMPONENT_MOVED =
            new EventAgent<>(Component::addComponentListener, Listeners::componentMoved)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentShown(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Event<Component, ComponentEvent> COMPONENT_SHOWN =
            new EventAgent<>(Component::addComponentListener, Listeners::componentShown)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see ComponentListener#componentHidden(ComponentEvent)
     * @see Component#addComponentListener(ComponentListener)
     */
    Event<Component, ComponentEvent> COMPONENT_HIDDEN =
            new EventAgent<>(Component::addComponentListener, Listeners::componentHidden)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see FocusListener#focusGained(FocusEvent)
     * @see Component#addFocusListener(FocusListener)
     */
    Event<Component, FocusEvent> FOCUS_GAINED =
            new EventAgent<>(Component::addFocusListener, Listeners::focusGained)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see FocusListener#focusLost(FocusEvent)
     * @see Component#addFocusListener(FocusListener)
     */
    Event<Component, FocusEvent> FOCUS_LOST =
            new EventAgent<>(Component::addFocusListener, Listeners::focusLost)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see HierarchyListener#hierarchyChanged(HierarchyEvent)
     * @see Component#addHierarchyListener(HierarchyListener)
     */
    Event<Component, HierarchyEvent> HIERARCHY_CHANGED =
            new EventAgent<>(Component::addHierarchyListener, Listeners::hierarchyChanged)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see HierarchyBoundsListener#ancestorMoved(HierarchyEvent)
     * @see Component#addHierarchyBoundsListener(HierarchyBoundsListener)
     */
    Event<Component, HierarchyEvent> ANCESTOR_BOUNDS_MOVED =
            new EventAgent<>(Component::addHierarchyBoundsListener, Listeners::ancestorBoundsMoved)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see HierarchyBoundsListener#ancestorResized(HierarchyEvent)
     * @see Component#addHierarchyBoundsListener(HierarchyBoundsListener)
     */
    Event<Component, HierarchyEvent> ANCESTOR_BOUNDS_RESIZED =
            new EventAgent<>(Component::addHierarchyBoundsListener, Listeners::ancestorBoundsResized)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see KeyListener#keyTyped(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     */
    Event<Component, KeyEvent> KEY_TYPED =
            new EventAgent<>(Component::addKeyListener, Listeners::keyTyped)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see KeyListener#keyPressed(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     */
    Event<Component, KeyEvent> KEY_PRESSED =
            new EventAgent<>(Component::addKeyListener, Listeners::keyPressed)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see KeyListener#keyReleased(KeyEvent)
     * @see Component#addKeyListener(KeyListener)
     */
    Event<Component, KeyEvent> KEY_RELEASED =
            new EventAgent<>(Component::addKeyListener, Listeners::keyReleased)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseListener#mousePressed(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Event<Component, MouseEvent> MOUSE_PRESSED =
            new EventAgent<>(Component::addMouseListener, Listeners::mousePressed)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseReleased(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Event<Component, MouseEvent> MOUSE_RELEASED =
            new EventAgent<>(Component::addMouseListener, Listeners::mouseReleased)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseClicked(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Event<Component, MouseEvent> MOUSE_CLICKED =
            new EventAgent<>(Component::addMouseListener, Listeners::mouseClicked)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseExited(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Event<Component, MouseEvent> MOUSE_EXITED =
            new EventAgent<>(Component::addMouseListener, Listeners::mouseExited)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseListener#mouseEntered(MouseEvent)
     * @see Component#addMouseListener(MouseListener)
     */
    Event<Component, MouseEvent> MOUSE_ENTERED =
            new EventAgent<>(Component::addMouseListener, Listeners::mouseEntered)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseMotionListener#mouseMoved(MouseEvent)
     * @see Component#addMouseMotionListener(MouseMotionListener)
     */
    Event<Component, MouseEvent> MOUSE_MOVED =
            new EventAgent<>(Component::addMouseMotionListener, Listeners::mouseMoved)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseMotionListener#mouseDragged(MouseEvent)
     * @see Component#addMouseMotionListener(MouseMotionListener)
     */
    Event<Component, MouseEvent> MOUSE_DRAGGED =
            new EventAgent<>(Component::addMouseMotionListener, Listeners::mouseDragged)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see MouseWheelListener#mouseWheelMoved(MouseWheelEvent)
     * @see Component#addMouseWheelListener(MouseWheelListener)
     */
    Event<Component, MouseWheelEvent> MOUSE_WHEEL_MOVED =
            new EventAgent<>(Component::addMouseWheelListener, Listeners::mouseWheelMoved)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see InputMethodListener#inputMethodTextChanged(InputMethodEvent)
     * @see Component#addInputMethodListener(InputMethodListener)
     */
    Event<Component, InputMethodEvent> INPUT_METHOD_TEXT_CHANGED =
            new EventAgent<>(Component::addInputMethodListener, Listeners::inputMethodTextChanged)::add;

    /**
     * Represents an event that can occur on {@link Component}s.
     *
     * @see InputMethodListener#caretPositionChanged(InputMethodEvent)
     * @see Component#addInputMethodListener(InputMethodListener)
     */
    Event<Component, InputMethodEvent> CARET_POSITION_CHANGED =
            new EventAgent<>(Component::addInputMethodListener, Listeners::caretPositionChanged)::add;

    /**
     * Represents an event that can occur on {@link Container}s.
     *
     * @see ContainerListener#componentAdded(ContainerEvent)
     * @see Container#addContainerListener(ContainerListener)
     */
    Event<Container, ContainerEvent> COMPONENT_ADDED =
            new EventAgent<>(Container::addContainerListener, Listeners::componentAdded)::add;

    /**
     * Represents an event that can occur on {@link Container}s.
     *
     * @see ContainerListener#componentRemoved(ContainerEvent)
     * @see Container#addContainerListener(ContainerListener)
     */
    Event<Container, ContainerEvent> COMPONENT_REMOVED =
            new EventAgent<>(Container::addContainerListener, Listeners::componentRemoved)::add;

    /**
     * Represents an event that can occur on {@link JComponent}s.
     *
     * @see VetoableChangeListener#vetoableChange(PropertyChangeEvent)
     * @see JComponent#addVetoableChangeListener(VetoableChangeListener)
     */
    Event<JComponent, PropertyChangeEvent> VETOABLE_CHANGE =
            new EventAgent<>(JComponent::addVetoableChangeListener, Listeners::vetoableChange)::add;

    /**
     * Represents an event that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorAdded(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     */
    Event<JComponent, AncestorEvent> ANCESTOR_ADDED =
            new EventAgent<>(JComponent::addAncestorListener, Listeners::ancestorAdded)::add;

    /**
     * Represents an event that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorRemoved(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     */
    Event<JComponent, AncestorEvent> ANCESTOR_REMOVED =
            new EventAgent<>(JComponent::addAncestorListener, Listeners::ancestorRemoved)::add;

    /**
     * Represents an event that can occur on {@link JComponent}s.
     *
     * @see AncestorListener#ancestorMoved(AncestorEvent)
     * @see JComponent#addAncestorListener(AncestorListener)
     */
    Event<JComponent, AncestorEvent> ANCESTOR_MOVED =
            new EventAgent<>(JComponent::addAncestorListener, Listeners::ancestorMoved)::add;

    /**
     * Represents an event that can occur on {@link JTextComponent}s.
     *
     * @see CaretListener#caretUpdate(CaretEvent)
     * @see JTextComponent#addCaretListener(CaretListener)
     */
    Event<JTextComponent, CaretEvent> CARET_UPDATE =
            new EventAgent<>(JTextComponent::addCaretListener, Listeners::caretUpdate)::add;

    /**
     * Represents an event that can occur on {@link JProgressBar}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JProgressBar#addChangeListener(ChangeListener)
     */
    Event<JProgressBar, ChangeEvent> JPB_STATE_CHANGED =
            new EventAgent<>(JProgressBar::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents an event that can occur on {@link JTabbedPane}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JTabbedPane#addChangeListener(ChangeListener)
     */
    Event<JTabbedPane, ChangeEvent> JTP_STATE_CHANGED =
            new EventAgent<>(JTabbedPane::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents an event that can occur on {@link JTextField}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JTextField#addActionListener(ActionListener)
     */
    Event<JTextField, ActionEvent> JTF_ACTION_PERFORMED =
            new EventAgent<>(JTextField::addActionListener, Listeners::actionPerformed)::add;

    /**
     * Represents an event that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     */
    Event<JPopupMenu, PopupMenuEvent> POPUP_MENU_WILL_BECOME_VISIBLE =
            new EventAgent<>(JPopupMenu::addPopupMenuListener, Listeners::popupMenuWillBecomeVisible)::add;

    /**
     * Represents an event that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     */
    Event<JPopupMenu, PopupMenuEvent> POPUP_MENU_WILL_BECOME_INVISIBLE =
            new EventAgent<>(JPopupMenu::addPopupMenuListener, Listeners::popupMenuWillBecomeInvisible)::add;

    /**
     * Represents an event that can occur on {@link JPopupMenu}s.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     * @see JPopupMenu#addPopupMenuListener(PopupMenuListener)
     */
    Event<JPopupMenu, PopupMenuEvent> POPUP_MENU_CANCELED =
            new EventAgent<>(JPopupMenu::addPopupMenuListener, Listeners::popupMenuCanceled)::add;

    /**
     * Represents an event that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     */
    Event<JPopupMenu, MenuKeyEvent> MENU_KEY_PRESSED =
            new EventAgent<>(JPopupMenu::addMenuKeyListener, Listeners::menuKeyPressed)::add;

    /**
     * Represents an event that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     */
    Event<JPopupMenu, MenuKeyEvent> MENU_KEY_RELEASED =
            new EventAgent<>(JPopupMenu::addMenuKeyListener, Listeners::menuKeyReleased)::add;

    /**
     * Represents an event that can occur on {@link JPopupMenu}s.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     * @see JPopupMenu#addMenuKeyListener(MenuKeyListener)
     */
    Event<JPopupMenu, MenuKeyEvent> MENU_KEY_TYPED =
            new EventAgent<>(JPopupMenu::addMenuKeyListener, Listeners::menuKeyTyped)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowStateListener#windowStateChanged(WindowEvent)
     * @see Window#addWindowStateListener(WindowStateListener)
     */
    Event<Window, WindowEvent> WINDOW_STATE_CHANGED =
            new EventAgent<>(Window::addWindowStateListener, Listeners::windowStateChanged)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowOpened(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_OPENED =
            new EventAgent<>(Window::addWindowListener, Listeners::windowOpened)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowClosing(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_CLOSING =
            new EventAgent<>(Window::addWindowListener, Listeners::windowClosing)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowClosed(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_CLOSED =
            new EventAgent<>(Window::addWindowListener, Listeners::windowClosed)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowIconified(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_ICONIFIED =
            new EventAgent<>(Window::addWindowListener, Listeners::windowIconified)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowDeiconified(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_DEICONIFIED =
            new EventAgent<>(Window::addWindowListener, Listeners::windowDeiconified)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowActivated(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_ACTIVATED =
            new EventAgent<>(Window::addWindowListener, Listeners::windowActivated)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowListener#windowDeactivated(WindowEvent)
     * @see Window#addWindowListener(WindowListener)
     */
    Event<Window, WindowEvent> WINDOW_DEACTIVATED =
            new EventAgent<>(Window::addWindowListener, Listeners::windowDeactivated)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowFocusListener#windowGainedFocus(WindowEvent)
     * @see Window#addWindowFocusListener(WindowFocusListener)
     */
    Event<Window, WindowEvent> WINDOW_GAINED_FOCUS =
            new EventAgent<>(Window::addWindowFocusListener, Listeners::windowGainedFocus)::add;

    /**
     * Represents an event that can occur on {@link Window}s.
     *
     * @see WindowFocusListener#windowLostFocus(WindowEvent)
     * @see Window#addWindowFocusListener(WindowFocusListener)
     */
    Event<Window, WindowEvent> WINDOW_LOST_FOCUS =
            new EventAgent<>(Window::addWindowFocusListener, Listeners::windowLostFocus)::add;

    /**
     * Represents an event that can occur on {@link AbstractButton}s.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     * @see AbstractButton#addItemListener(ItemListener)
     */
    Event<AbstractButton, ItemEvent> ITEM_STATE_CHANGED =
            new EventAgent<>(AbstractButton::addItemListener, Listeners::itemStateChanged)::add;

    /**
     * Represents an event that can occur on {@link AbstractButton}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see AbstractButton#addActionListener(ActionListener)
     */
    Event<AbstractButton, ActionEvent> ACTION_PERFORMED =
            new EventAgent<>(AbstractButton::addActionListener, Listeners::actionPerformed)::add;

    /**
     * Represents an event that can occur on {@link AbstractButton}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see AbstractButton#addChangeListener(ChangeListener)
     */
    Event<AbstractButton, ChangeEvent> STATE_CHANGED =
            new EventAgent<>(AbstractButton::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseEntered(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Event<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_ENTERED =
            new EventAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseEntered)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseExited(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Event<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_EXITED =
            new EventAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseExited)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseDragged(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Event<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_DRAGGED =
            new EventAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseDragged)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuDragMouseListener#menuDragMouseReleased(MenuDragMouseEvent)
     * @see JMenuItem#addMenuDragMouseListener(MenuDragMouseListener)
     */
    Event<JMenuItem, MenuDragMouseEvent> MENU_DRAG_MOUSE_RELEASED =
            new EventAgent<>(JMenuItem::addMenuDragMouseListener, Listeners::menuDragMouseReleased)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     */
    Event<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_PRESSED =
            new EventAgent<>(JMenuItem::addMenuKeyListener, Listeners::menuKeyPressed)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     */
    Event<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_RELEASED =
            new EventAgent<>(JMenuItem::addMenuKeyListener, Listeners::menuKeyReleased)::add;

    /**
     * Represents an event that can occur on {@link JMenuItem}s.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     * @see JMenuItem#addMenuKeyListener(MenuKeyListener)
     */
    Event<JMenuItem, MenuKeyEvent> MENU_ITEM_KEY_TYPED =
            new EventAgent<>(JMenuItem::addMenuKeyListener, Listeners::menuKeyTyped)::add;

    /**
     * Represents an event that can occur on {@link JSlider}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JSlider#addChangeListener(ChangeListener)
     */
    Event<JSlider, ChangeEvent> JSL_STATE_CHANGED =
            new EventAgent<>(JSlider::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents an event that can occur on {@link JComboBox}s.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     * @see JComboBox#addItemListener(ItemListener)
     */
    Event<JComboBox<?>, ItemEvent> JCB_ITEM_STATE_CHANGED =
            new EventAgent<>((JComboBox<?> c, ItemListener l) -> c.addItemListener(l),
                             Listeners::itemStateChanged)::add;

    /**
     * Represents an event that can occur on {@link JComboBox}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JComboBox#addActionListener(ActionListener)
     */
    Event<JComboBox<?>, ActionEvent> JCB_ACTION_PERFORMED =
            new EventAgent<>((JComboBox<?> c, ActionListener l) -> c.addActionListener(l),
                             Listeners::actionPerformed)::add;

    /**
     * Represents an event that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     */
    Event<JComboBox<?>, PopupMenuEvent> JCB_POPUP_WILL_BECOME_VISIBLE =
            new EventAgent<>((JComboBox<?> c, PopupMenuListener l) -> c.addPopupMenuListener(l),
                             Listeners::popupMenuWillBecomeVisible)::add;

    /**
     * Represents an event that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     */
    Event<JComboBox<?>, PopupMenuEvent> JCB_POPUP_WILL_BECOME_INVISIBLE =
            new EventAgent<>((JComboBox<?> c, PopupMenuListener l) -> c.addPopupMenuListener(l),
                             Listeners::popupMenuWillBecomeInvisible)::add;

    /**
     * Represents an event that can occur on {@link JComboBox}s.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     * @see JComboBox#addPopupMenuListener(PopupMenuListener)
     */
    Event<JComboBox<?>, PopupMenuEvent> JCB_POPUP_CANCELED =
            new EventAgent<>((JComboBox<?> c, PopupMenuListener l) -> c.addPopupMenuListener(l),
                             Listeners::popupMenuCanceled)::add;

    /**
     * Represents an event that can occur on {@link JTree}s.
     *
     * @see TreeExpansionListener#treeExpanded(TreeExpansionEvent)
     * @see JTree#addTreeExpansionListener(TreeExpansionListener)
     */
    Event<JTree, TreeExpansionEvent> TREE_EXPANDED =
            new EventAgent<>(JTree::addTreeExpansionListener, Listeners::treeExpanded)::add;

    /**
     * Represents an event that can occur on {@link JTree}s.
     *
     * @see TreeExpansionListener#treeCollapsed(TreeExpansionEvent)
     * @see JTree#addTreeExpansionListener(TreeExpansionListener)
     */
    Event<JTree, TreeExpansionEvent> TREE_COLLAPSED =
            new EventAgent<>(JTree::addTreeExpansionListener, Listeners::treeCollapsed)::add;

    /**
     * Represents an event that can occur on {@link JTree}s.
     *
     * @see TreeWillExpandListener#treeWillExpand(TreeExpansionEvent)
     * @see JTree#addTreeWillExpandListener(TreeWillExpandListener)
     */
    Event<JTree, TreeExpansionEvent> TREE_WILL_EXPAND =
            new EventAgent<>(JTree::addTreeWillExpandListener, Listeners::treeWillExpand)::add;

    /**
     * Represents an event that can occur on {@link JTree}s.
     *
     * @see TreeWillExpandListener#treeWillCollapse(TreeExpansionEvent)
     * @see JTree#addTreeWillExpandListener(TreeWillExpandListener)
     */
    Event<JTree, TreeExpansionEvent> TREE_WILL_COLLAPSE =
            new EventAgent<>(JTree::addTreeWillExpandListener, Listeners::treeWillCollapse)::add;

    /**
     * Represents an event that can occur on {@link JTree}s.
     *
     * @see TreeSelectionListener#valueChanged(TreeSelectionEvent)
     * @see JTree#addTreeSelectionListener(TreeSelectionListener)
     */
    Event<JTree, TreeSelectionEvent> TREE_VALUE_CHANGED =
            new EventAgent<>(JTree::addTreeSelectionListener, Listeners::treeValueChanged)::add;

    /**
     * Represents an event that can occur on {@link JSpinner}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JSpinner#addChangeListener(ChangeListener)
     */
    Event<JSpinner, ChangeEvent> JSP_STATE_CHANGED =
            new EventAgent<>(JSpinner::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents an event that can occur on {@link JScrollBar}s.
     *
     * @see AdjustmentListener#adjustmentValueChanged(AdjustmentEvent)
     * @see JScrollBar#addAdjustmentListener(AdjustmentListener)
     */
    Event<JScrollBar, AdjustmentEvent> ADJUSTMENT_VALUE_CHANGED =
            new EventAgent<>(JScrollBar::addAdjustmentListener, Listeners::adjustmentValueChanged)::add;

    /**
     * Represents an event that can occur on {@link JList}s.
     *
     * @see ListSelectionListener#valueChanged(ListSelectionEvent)
     * @see JList#addListSelectionListener(ListSelectionListener)
     */
    Event<JList<?>, ListSelectionEvent> LIST_VALUE_CHANGED =
            new EventAgent<>((JList<?> c, ListSelectionListener l) -> c.addListSelectionListener(l),
                             Listeners::listValueChanged)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameOpened(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_OPENED =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameOpened)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameClosing(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_CLOSING =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameClosing)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameClosed(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_CLOSED =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameClosed)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameIconified(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_ICONIFIED =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameIconified)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameDeiconified(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_DEICONIFIED =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameDeiconified)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameActivated(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_ACTIVATED =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameActivated)::add;

    /**
     * Represents an event that can occur on {@link JInternalFrame}s.
     *
     * @see InternalFrameListener#internalFrameDeactivated(InternalFrameEvent)
     * @see JInternalFrame#addInternalFrameListener(InternalFrameListener)
     */
    Event<JInternalFrame, InternalFrameEvent> INTERNAL_FRAME_DEACTIVATED =
            new EventAgent<>(JInternalFrame::addInternalFrameListener, Listeners::internalFrameDeactivated)::add;

    /**
     * Represents an event that can occur on {@link JEditorPane}s.
     *
     * @see HyperlinkListener#hyperlinkUpdate(HyperlinkEvent)
     * @see JEditorPane#addHyperlinkListener(HyperlinkListener)
     */
    Event<JEditorPane, HyperlinkEvent> HYPERLINK_UPDATE =
            new EventAgent<>(JEditorPane::addHyperlinkListener, Listeners::hyperlinkUpdate)::add;

    /**
     * Represents an event that can occur on {@link JViewport}s.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     * @see JViewport#addChangeListener(ChangeListener)
     */
    Event<JViewport, ChangeEvent> JVP_STATE_CHANGED =
            new EventAgent<>(JViewport::addChangeListener, Listeners::stateChanged)::add;

    /**
     * Represents an event that can occur on {@link JFileChooser}s.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     * @see JFileChooser#addActionListener(ActionListener)
     */
    Event<JFileChooser, ActionEvent> JFC_ACTION_PERFORMED =
            new EventAgent<>(JFileChooser::addActionListener, Listeners::actionPerformed)::add;

    /**
     * Represents an event that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuSelected(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     */
    Event<JMenu, MenuEvent> MENU_SELECTED =
            new EventAgent<>(JMenu::addMenuListener, Listeners::menuSelected)::add;

    /**
     * Represents an event that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuDeselected(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     */
    Event<JMenu, MenuEvent> MENU_DESELECTED =
            new EventAgent<>(JMenu::addMenuListener, Listeners::menuDeselected)::add;

    /**
     * Represents an event that can occur on {@link JMenu}s.
     *
     * @see MenuListener#menuCanceled(MenuEvent)
     * @see JMenu#addMenuListener(MenuListener)
     */
    Event<JMenu, MenuEvent> MENU_CANCELED =
            new EventAgent<>(JMenu::addMenuListener, Listeners::menuCanceled)::add;

    static Event<Component, PropertyChangeEvent> propertyChange(final String propertyName) {
        return new EventAgent<>((Component c, PropertyChangeListener l) -> c.addPropertyChangeListener(propertyName, l),
                                Listeners::propertyChange)::add;
    }

    /**
     * Adds an appropriate {@link Consumer} to a given component of type {@code <C>} to process the associated
     * message of type {@code <M>} when an activity or event as expected in this context occurs.
     */
    void add(C component, Consumer<M> reaction);
}
