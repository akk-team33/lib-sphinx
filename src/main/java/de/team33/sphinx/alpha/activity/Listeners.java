package de.team33.sphinx.alpha.activity;

import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Consumer;

@SuppressWarnings("AnonymousInnerClass")
public final class Listeners {

    private Listeners() {
    }

    public static ComponentListener componentResized(final Consumer<ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentResized(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static ComponentListener componentMoved(final Consumer<ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentMoved(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static ComponentListener componentShown(final Consumer<ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentShown(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static ComponentListener componentHidden(final Consumer<ComponentEvent> reaction) {
        return new ComponentAdapter() {
            @Override
            public void componentHidden(final ComponentEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static FocusListener focusGained(final Consumer<FocusEvent> reaction) {
        return new FocusAdapter() {
            @Override
            public void focusGained(final FocusEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static FocusListener focusLost(final Consumer<FocusEvent> reaction) {
        return new FocusAdapter() {
            @Override
            public void focusLost(final FocusEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static HierarchyListener hierarchyChanged(final Consumer<HierarchyEvent> reaction) {
        return reaction::accept;
    }

    public static HierarchyBoundsListener ancestorMoved(final Consumer<HierarchyEvent> reaction) {
        return new HierarchyBoundsAdapter() {
            @Override
            public void ancestorMoved(final HierarchyEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static HierarchyBoundsListener ancestorResized(final Consumer<HierarchyEvent> reaction) {
        return new HierarchyBoundsAdapter() {
            @Override
            public void ancestorResized(final HierarchyEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static KeyListener keyTyped(final Consumer<KeyEvent> reaction) {
        return new KeyAdapter() {
            @Override
            public void keyTyped(final KeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static KeyListener keyPressed(final Consumer<KeyEvent> reaction) {
        return new KeyAdapter() {
            @Override
            public void keyPressed(final KeyEvent e) {
                super.keyPressed(e);
            }
        };
    }

    public static KeyListener keyReleased(final Consumer<KeyEvent> reaction) {
        return new KeyAdapter() {
            @Override
            public void keyReleased(final KeyEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseListener mouseClicked(final Consumer<MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseListener mousePressed(final Consumer<MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mousePressed(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseListener mouseReleased(final Consumer<MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseReleased(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseListener mouseEntered(final Consumer<MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseEntered(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseListener mouseExited(final Consumer<MouseEvent> reaction) {
        return new MouseAdapter() {
            @Override
            public void mouseExited(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseMotionListener mouseDragged(final Consumer<MouseEvent> reaction) {
        return new MouseMotionAdapter() {
            @Override
            public void mouseDragged(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static <L> MouseMotionListener mouseMoved(final Consumer<MouseEvent> reaction) {
        return new MouseMotionAdapter() {
            @Override
            public void mouseMoved(final MouseEvent e) {
                reaction.accept(e);
            }
        };
    }

    public static MouseWheelListener mouseWheelMoved(final Consumer<MouseWheelEvent> reaction) {
        return reaction::accept;
    }

    public static InputMethodListener inputMethodTextChanged(final Consumer<InputMethodEvent> reaction) {
        return new InputMethodAdapter() {
            @Override
            public void inputMethodTextChanged(final InputMethodEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static InputMethodListener caretPositionChanged(final Consumer<InputMethodEvent> reaction) {
        return new InputMethodAdapter() {
            @Override
            public void caretPositionChanged(final InputMethodEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static PropertyChangeListener propertyChange(final Consumer<PropertyChangeEvent> reaction) {
        return reaction::accept;
    }

    public static WindowFocusListener windowGainedFocus(final Consumer<WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowGainedFocus(final WindowEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static WindowFocusListener windowLostFocus(final Consumer<WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowLostFocus(final WindowEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static WindowListener windowActivated(final Consumer<WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowActivated(final WindowEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static WindowListener windowClosed(final Consumer<WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowClosed(final WindowEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static WindowListener windowClosing(final Consumer<WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowClosing(final WindowEvent event) {
                reaction.accept(event);
            }
        };
    }

    public static WindowListener windowDeactivated(final Consumer<WindowEvent> reaction) {
        return new WindowAdapter() {
            @Override
            public void windowDeactivated(final WindowEvent event) {
                reaction.accept(event);
            }
        };
    }

    @SuppressWarnings({"NoopMethodInAbstractClass", "AbstractClassWithoutAbstractMethods"})
    private abstract static class InputMethodAdapter implements InputMethodListener {

        @Override
        public void inputMethodTextChanged(final InputMethodEvent event) {
        }

        @Override
        public void caretPositionChanged(final InputMethodEvent event) {
        }
    }
}
