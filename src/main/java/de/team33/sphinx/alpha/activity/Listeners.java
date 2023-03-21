package de.team33.sphinx.alpha.activity;

import javax.swing.event.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.VetoableChangeListener;
import java.util.function.Consumer;

@SuppressWarnings({"AnonymousInnerClass", "unused", "WeakerAccess", "ClassWithTooManyMethods"})
public final class Listeners {

    private Listeners() {
    }

    /**
     * Converts a given {@link Consumer} into a {@link PropertyChangeListener}
     * that reacts on a specific {@link PropertyChangeEvent}.
     *
     * @see PropertyChangeListener#propertyChange(PropertyChangeEvent)
     */
    public static PropertyChangeListener propertyChange(final Consumer<? super PropertyChangeEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link ComponentListener}
     * that reacts on a specific {@link ComponentEvent}.
     *
     * @see ComponentListener#componentResized(ComponentEvent)
     */
    public static ComponentListener componentResized(final Consumer<? super ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentResized(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link ComponentListener}
     * that reacts on a specific {@link ComponentEvent}.
     *
     * @see ComponentListener#componentMoved(ComponentEvent)
     */
    public static ComponentListener componentMoved(final Consumer<? super ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentMoved(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link ComponentListener}
     * that reacts on a specific {@link ComponentEvent}.
     *
     * @see ComponentListener#componentShown(ComponentEvent)
     */
    public static ComponentListener componentShown(final Consumer<? super ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentShown(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link ComponentListener}
     * that reacts on a specific {@link ComponentEvent}.
     *
     * @see ComponentListener#componentHidden(ComponentEvent)
     */
    public static ComponentListener componentHidden(final Consumer<? super ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentHidden(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link FocusListener}
     * that reacts on a specific {@link FocusEvent}.
     *
     * @see FocusListener#focusGained(FocusEvent)
     */
    public static FocusListener focusGained(final Consumer<? super FocusEvent> reaction) {
        return new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link FocusListener}
     * that reacts on a specific {@link FocusEvent}.
     *
     * @see FocusListener#focusLost(FocusEvent)
     */
    public static FocusListener focusLost(final Consumer<? super FocusEvent> reaction) {
        return new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link HierarchyListener}
     * that reacts on a specific {@link HierarchyEvent}.
     *
     * @see HierarchyListener#hierarchyChanged(HierarchyEvent)
     */
    public static HierarchyListener hierarchyChanged(final Consumer<? super HierarchyEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link HierarchyBoundsListener}
     * that reacts on a specific {@link HierarchyEvent}.
     *
     * @see HierarchyBoundsListener#ancestorMoved(HierarchyEvent)
     */
    public static HierarchyBoundsListener ancestorBoundsMoved(final Consumer<? super HierarchyEvent> reaction) {
        return new HierarchyBoundsAdapter() {
            @Override
            public void ancestorMoved(final HierarchyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link HierarchyBoundsListener}
     * that reacts on a specific {@link HierarchyEvent}.
     *
     * @see HierarchyBoundsListener#ancestorResized(HierarchyEvent)
     */
    public static HierarchyBoundsListener ancestorBoundsResized(final Consumer<? super HierarchyEvent> reaction) {
        return new HierarchyBoundsAdapter() {
            @Override
            public void ancestorResized(final HierarchyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link KeyListener}
     * that reacts on a specific {@link KeyEvent}.
     *
     * @see KeyListener#keyTyped(KeyEvent)
     */
    public static KeyListener keyTyped(final Consumer<? super KeyEvent> reaction) {
        return new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link KeyListener}
     * that reacts on a specific {@link KeyEvent}.
     *
     * @see KeyListener#keyPressed(KeyEvent)
     */
    public static KeyListener keyPressed(final Consumer<? super KeyEvent> reaction) {
        return new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link KeyListener}
     * that reacts on a specific {@link KeyEvent}.
     *
     * @see KeyListener#keyReleased(KeyEvent)
     */
    public static KeyListener keyReleased(final Consumer<? super KeyEvent> reaction) {
        return new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseListener#mousePressed(MouseEvent)
     */
    public static MouseListener mousePressed(final Consumer<? super MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseListener#mouseReleased(MouseEvent)
     */
    public static MouseListener mouseReleased(final Consumer<? super MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseReleased(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseListener#mouseClicked(MouseEvent)
     */
    public static MouseListener mouseClicked(final Consumer<? super MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseListener#mouseExited(MouseEvent)
     */
    public static MouseListener mouseExited(final Consumer<? super MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseExited(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseListener#mouseEntered(MouseEvent)
     */
    public static MouseListener mouseEntered(final Consumer<? super MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseMotionListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseMotionListener#mouseMoved(MouseEvent)
     */
    public static MouseMotionListener mouseMoved(final Consumer<? super MouseEvent> reaction) {
        return new MouseMotionAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseMotionListener}
     * that reacts on a specific {@link MouseEvent}.
     *
     * @see MouseMotionListener#mouseDragged(MouseEvent)
     */
    public static MouseMotionListener mouseDragged(final Consumer<? super MouseEvent> reaction) {
        return new MouseMotionAdapter() {
            @Override
            public void mouseDragged(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MouseWheelListener}
     * that reacts on a specific {@link MouseWheelEvent}.
     *
     * @see MouseWheelListener#mouseWheelMoved(MouseWheelEvent)
     */
    public static MouseWheelListener mouseWheelMoved(final Consumer<? super MouseWheelEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link InputMethodListener}
     * that reacts on a specific {@link InputMethodEvent}.
     *
     * @see InputMethodListener#inputMethodTextChanged(InputMethodEvent)
     */
    public static InputMethodListener inputMethodTextChanged(final Consumer<? super InputMethodEvent> reaction) {
        return new InputMethodAdapter() {
            @Override
            public void inputMethodTextChanged(final InputMethodEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InputMethodListener}
     * that reacts on a specific {@link InputMethodEvent}.
     *
     * @see InputMethodListener#caretPositionChanged(InputMethodEvent)
     */
    public static InputMethodListener caretPositionChanged(final Consumer<? super InputMethodEvent> reaction) {
        return new InputMethodAdapter() {
            @Override
            public void caretPositionChanged(final InputMethodEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link ContainerListener}
     * that reacts on a specific {@link ContainerEvent}.
     *
     * @see ContainerListener#componentAdded(ContainerEvent)
     */
    public static ContainerListener componentAdded(final Consumer<? super ContainerEvent> reaction) {
        return new ContainerAdapter() {
            @Override
            public void componentAdded(final ContainerEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link ContainerListener}
     * that reacts on a specific {@link ContainerEvent}.
     *
     * @see ContainerListener#componentRemoved(ContainerEvent)
     */
    public static ContainerListener componentRemoved(final Consumer<? super ContainerEvent> reaction) {
        return new ContainerAdapter() {
            @Override
            public void componentRemoved(final ContainerEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link VetoableChangeListener}
     * that reacts on a specific {@link PropertyChangeEvent}.
     *
     * @see VetoableChangeListener#vetoableChange(PropertyChangeEvent)
     */
    public static VetoableChangeListener vetoableChange(final Consumer<? super PropertyChangeEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link AncestorListener}
     * that reacts on a specific {@link AncestorEvent}.
     *
     * @see AncestorListener#ancestorMoved(AncestorEvent)
     */
    public static AncestorListener ancestorMoved(final Consumer<? super AncestorEvent> reaction) {
        return new AncestorAdapter() {
            @Override
            public void ancestorMoved(final AncestorEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link AncestorListener}
     * that reacts on a specific {@link AncestorEvent}.
     *
     * @see AncestorListener#ancestorAdded(AncestorEvent)
     */
    public static AncestorListener ancestorAdded(final Consumer<? super AncestorEvent> reaction) {
        return new AncestorAdapter() {
            @Override
            public void ancestorAdded(final AncestorEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link AncestorListener}
     * that reacts on a specific {@link AncestorEvent}.
     *
     * @see AncestorListener#ancestorRemoved(AncestorEvent)
     */
    public static AncestorListener ancestorRemoved(final Consumer<? super AncestorEvent> reaction) {
        return new AncestorAdapter() {
            @Override
            public void ancestorRemoved(final AncestorEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link CaretListener}
     * that reacts on a specific {@link CaretEvent}.
     *
     * @see CaretListener#caretUpdate(CaretEvent)
     */
    public static CaretListener caretUpdate(final Consumer<? super CaretEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link ChangeListener}
     * that reacts on a specific {@link ChangeEvent}.
     *
     * @see ChangeListener#stateChanged(ChangeEvent)
     */
    public static ChangeListener stateChanged(final Consumer<? super ChangeEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link ActionListener}
     * that reacts on a specific {@link ActionEvent}.
     *
     * @see ActionListener#actionPerformed(ActionEvent)
     */
    public static ActionListener actionPerformed(final Consumer<? super ActionEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link PopupMenuListener}
     * that reacts on a specific {@link PopupMenuEvent}.
     *
     * @see PopupMenuListener#popupMenuWillBecomeVisible(PopupMenuEvent)
     */
    public static PopupMenuListener popupMenuWillBecomeVisible(final Consumer<? super PopupMenuEvent> reaction) {
        return new PopupMenuAdapter() {
            @Override
            public void popupMenuWillBecomeVisible(final PopupMenuEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link PopupMenuListener}
     * that reacts on a specific {@link PopupMenuEvent}.
     *
     * @see PopupMenuListener#popupMenuWillBecomeInvisible(PopupMenuEvent)
     */
    public static PopupMenuListener popupMenuWillBecomeInvisible(final Consumer<? super PopupMenuEvent> reaction) {
        return new PopupMenuAdapter() {
            @Override
            public void popupMenuWillBecomeInvisible(final PopupMenuEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link PopupMenuListener}
     * that reacts on a specific {@link PopupMenuEvent}.
     *
     * @see PopupMenuListener#popupMenuCanceled(PopupMenuEvent)
     */
    public static PopupMenuListener popupMenuCanceled(final Consumer<? super PopupMenuEvent> reaction) {
        return new PopupMenuAdapter() {
            @Override
            public void popupMenuCanceled(final PopupMenuEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuKeyListener}
     * that reacts on a specific {@link MenuKeyEvent}.
     *
     * @see MenuKeyListener#menuKeyPressed(MenuKeyEvent)
     */
    public static MenuKeyListener menuKeyPressed(final Consumer<? super MenuKeyEvent> reaction) {
        return new MenuKeyAdapter() {
            @Override
            public void menuKeyPressed(final MenuKeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuKeyListener}
     * that reacts on a specific {@link MenuKeyEvent}.
     *
     * @see MenuKeyListener#menuKeyReleased(MenuKeyEvent)
     */
    public static MenuKeyListener menuKeyReleased(final Consumer<? super MenuKeyEvent> reaction) {
        return new MenuKeyAdapter() {
            @Override
            public void menuKeyReleased(final MenuKeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuKeyListener}
     * that reacts on a specific {@link MenuKeyEvent}.
     *
     * @see MenuKeyListener#menuKeyTyped(MenuKeyEvent)
     */
    public static MenuKeyListener menuKeyTyped(final Consumer<? super MenuKeyEvent> reaction) {
        return new MenuKeyAdapter() {
            @Override
            public void menuKeyTyped(final MenuKeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowOpened(WindowEvent)
     */
    public static WindowListener windowOpened(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowOpened(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowClosing(WindowEvent)
     */
    public static WindowListener windowClosing(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowClosed(WindowEvent)
     */
    public static WindowListener windowClosed(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowClosed(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowIconified(WindowEvent)
     */
    public static WindowListener windowIconified(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowIconified(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowDeiconified(WindowEvent)
     */
    public static WindowListener windowDeiconified(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowDeiconified(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowActivated(WindowEvent)
     */
    public static WindowListener windowActivated(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowActivated(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowListener#windowDeactivated(WindowEvent)
     */
    public static WindowListener windowDeactivated(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowDeactivated(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowFocusListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowFocusListener#windowGainedFocus(WindowEvent)
     */
    public static WindowFocusListener windowGainedFocus(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowGainedFocus(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowFocusListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowFocusListener#windowLostFocus(WindowEvent)
     */
    public static WindowFocusListener windowLostFocus(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowLostFocus(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link WindowStateListener}
     * that reacts on a specific {@link WindowEvent}.
     *
     * @see WindowStateListener#windowStateChanged(WindowEvent)
     */
    public static WindowStateListener windowStateChanged(final Consumer<? super WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowStateChanged(final WindowEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link ItemListener}
     * that reacts on a specific {@link ItemEvent}.
     *
     * @see ItemListener#itemStateChanged(ItemEvent)
     */
    public static ItemListener itemStateChanged(final Consumer<? super ItemEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuDragMouseListener}
     * that reacts on a specific {@link MenuDragMouseEvent}.
     *
     * @see MenuDragMouseListener#menuDragMouseEntered(MenuDragMouseEvent)
     */
    public static MenuDragMouseListener menuDragMouseEntered(final Consumer<? super MenuDragMouseEvent> reaction) {
        return new MenuDragMouseAdapter() {
            @Override
            public void menuDragMouseEntered(final MenuDragMouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuDragMouseListener}
     * that reacts on a specific {@link MenuDragMouseEvent}.
     *
     * @see MenuDragMouseListener#menuDragMouseExited(MenuDragMouseEvent)
     */
    public static MenuDragMouseListener menuDragMouseExited(final Consumer<? super MenuDragMouseEvent> reaction) {
        return new MenuDragMouseAdapter() {
            @Override
            public void menuDragMouseExited(final MenuDragMouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuDragMouseListener}
     * that reacts on a specific {@link MenuDragMouseEvent}.
     *
     * @see MenuDragMouseListener#menuDragMouseDragged(MenuDragMouseEvent)
     */
    public static MenuDragMouseListener menuDragMouseDragged(final Consumer<? super MenuDragMouseEvent> reaction) {
        return new MenuDragMouseAdapter() {
            @Override
            public void menuDragMouseDragged(final MenuDragMouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuDragMouseListener}
     * that reacts on a specific {@link MenuDragMouseEvent}.
     *
     * @see MenuDragMouseListener#menuDragMouseReleased(MenuDragMouseEvent)
     */
    public static MenuDragMouseListener menuDragMouseReleased(final Consumer<? super MenuDragMouseEvent> reaction) {
        return new MenuDragMouseAdapter() {
            @Override
            public void menuDragMouseReleased(final MenuDragMouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link TreeExpansionListener}
     * that reacts on a specific {@link TreeExpansionEvent}.
     *
     * @see TreeExpansionListener#treeExpanded(TreeExpansionEvent)
     */
    public static TreeExpansionListener treeExpanded(final Consumer<? super TreeExpansionEvent> reaction) {
        return new TreeExpansionAdapter() {
            @Override
            public void treeExpanded(final TreeExpansionEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link TreeExpansionListener}
     * that reacts on a specific {@link TreeExpansionEvent}.
     *
     * @see TreeExpansionListener#treeCollapsed(TreeExpansionEvent)
     */
    public static TreeExpansionListener treeCollapsed(final Consumer<? super TreeExpansionEvent> reaction) {
        return new TreeExpansionAdapter() {
            @Override
            public void treeCollapsed(final TreeExpansionEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link TreeWillExpandListener}
     * that reacts on a specific {@link TreeExpansionEvent}.
     *
     * @see TreeWillExpandListener#treeWillExpand(TreeExpansionEvent)
     */
    public static TreeWillExpandListener treeWillExpand(final Consumer<? super TreeExpansionEvent> reaction) {
        return new TreeWillExpandAdapter() {
            @Override
            public void treeWillExpand(final TreeExpansionEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link TreeWillExpandListener}
     * that reacts on a specific {@link TreeExpansionEvent}.
     *
     * @see TreeWillExpandListener#treeWillCollapse(TreeExpansionEvent)
     */
    public static TreeWillExpandListener treeWillCollapse(final Consumer<? super TreeExpansionEvent> reaction) {
        return new TreeWillExpandAdapter() {
            @Override
            public void treeWillCollapse(final TreeExpansionEvent event) {
                reaction.accept(event);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link TreeSelectionListener}
     * that reacts on a specific {@link TreeSelectionEvent}.
     *
     * @see TreeSelectionListener#valueChanged(TreeSelectionEvent)
     */
    public static TreeSelectionListener treeValueChanged(final Consumer<? super TreeSelectionEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link AdjustmentListener}
     * that reacts on a specific {@link AdjustmentEvent}.
     *
     * @see AdjustmentListener#adjustmentValueChanged(AdjustmentEvent)
     */
    public static AdjustmentListener adjustmentValueChanged(final Consumer<? super AdjustmentEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link ListSelectionListener}
     * that reacts on a specific {@link ListSelectionEvent}.
     *
     * @see ListSelectionListener#valueChanged(ListSelectionEvent)
     */
    public static ListSelectionListener listValueChanged(final Consumer<? super ListSelectionEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameOpened(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameOpened(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameOpened(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameClosing(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameClosing(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameClosed(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameClosed(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameClosed(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameIconified(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameIconified(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameIconified(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameDeiconified(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameDeiconified(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameDeiconified(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameActivated(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameActivated(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameActivated(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link InternalFrameListener}
     * that reacts on a specific {@link InternalFrameEvent}.
     *
     * @see InternalFrameListener#internalFrameDeactivated(InternalFrameEvent)
     */
    public static InternalFrameListener internalFrameDeactivated(final Consumer<? super InternalFrameEvent> reaction) {
        return new InternalFrameAdapter() {
            @Override
            public void internalFrameDeactivated(final InternalFrameEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link HyperlinkListener}
     * that reacts on a specific {@link HyperlinkEvent}.
     *
     * @see HyperlinkListener#hyperlinkUpdate(HyperlinkEvent)
     */
    public static HyperlinkListener hyperlinkUpdate(final Consumer<? super HyperlinkEvent> reaction) {
        return reaction::accept;
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuListener}
     * that reacts on a specific {@link MenuEvent}.
     *
     * @see MenuListener#menuSelected(MenuEvent)
     */
    public static MenuListener menuSelected(final Consumer<? super MenuEvent> reaction) {
        return new MenuAdapter() {
            @Override
            public void menuSelected(final MenuEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuListener}
     * that reacts on a specific {@link MenuEvent}.
     *
     * @see MenuListener#menuDeselected(MenuEvent)
     */
    public static MenuListener menuDeselected(final Consumer<? super MenuEvent> reaction) {
        return new MenuAdapter() {
            @Override
            public void menuDeselected(final MenuEvent e) {
                reaction.accept(e);
            }
        };
    }

    /**
     * Converts a given {@link Consumer} into a {@link MenuListener}
     * that reacts on a specific {@link MenuEvent}.
     *
     * @see MenuListener#menuCanceled(MenuEvent)
     */
    public static MenuListener menuCanceled(final Consumer<? super MenuEvent> reaction) {
        return new MenuAdapter() {
            @Override
            public void menuCanceled(final MenuEvent e) {
                reaction.accept(e);
            }
        };
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class AncestorAdapter implements AncestorListener {

        @Override
        public void ancestorAdded(final AncestorEvent event) {
        }

        @Override
        public void ancestorRemoved(final AncestorEvent event) {
        }

        @Override
        public void ancestorMoved(final AncestorEvent event) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class InputMethodAdapter implements InputMethodListener {

        @Override
        public void inputMethodTextChanged(final InputMethodEvent event) {
        }

        @Override
        public void caretPositionChanged(final InputMethodEvent event) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class PopupMenuAdapter implements PopupMenuListener {

        @Override
        public void popupMenuWillBecomeVisible(final PopupMenuEvent e) {
        }

        @Override
        public void popupMenuWillBecomeInvisible(final PopupMenuEvent e) {
        }

        @Override
        public void popupMenuCanceled(final PopupMenuEvent e) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class MenuKeyAdapter implements MenuKeyListener {

        @Override
        public void menuKeyTyped(final MenuKeyEvent e) {
        }

        @Override
        public void menuKeyPressed(final MenuKeyEvent e) {
        }

        @Override
        public void menuKeyReleased(final MenuKeyEvent e) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class MenuDragMouseAdapter implements MenuDragMouseListener {

        @Override
        public void menuDragMouseEntered(final MenuDragMouseEvent e) {
        }

        @Override
        public void menuDragMouseExited(final MenuDragMouseEvent e) {
        }

        @Override
        public void menuDragMouseDragged(final MenuDragMouseEvent e) {
        }

        @Override
        public void menuDragMouseReleased(final MenuDragMouseEvent e) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class TreeExpansionAdapter implements TreeExpansionListener {

        @Override
        public void treeExpanded(final TreeExpansionEvent event) {
        }

        @Override
        public void treeCollapsed(final TreeExpansionEvent event) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class TreeWillExpandAdapter implements TreeWillExpandListener {

        @Override
        public void treeWillExpand(final TreeExpansionEvent event) {
        }

        @Override
        public void treeWillCollapse(final TreeExpansionEvent event) {
        }
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    abstract static class MenuAdapter implements MenuListener {
        @Override

        public void menuSelected(final MenuEvent e) {
        }

        @Override
        public void menuDeselected(final MenuEvent e) {
        }

        @Override
        public void menuCanceled(final MenuEvent e) {
        }
    }
}
