package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Insets;
import java.util.function.Supplier;
import javax.swing.DropMode;
import javax.swing.plaf.TextUI;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;
import javax.swing.text.NavigationFilter;

/**
 * Utility class to handle {@link JTextComponent}s.
 */
@SuppressWarnings("unused")
public final class JTextComponents {

    private JTextComponents() {
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextComponent}.
     */
    public static <T extends JTextComponent> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTextComponent}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextComponent}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTextComponent, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTextComponent}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextComponent}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JTextComponent, S extends Setup<T, S>> extends JComponents.Setup<T, S> {

        /**
         * @see JTextComponent#setCaret(Caret)
         */
        default S setCaret(final Caret c) {
            return setup(result -> result.setCaret(c));
        }

        /**
         * @see JTextComponent#setCaretColor(Color)
         */
        default S setCaretColor(final Color c) {
            return setup(result -> result.setCaretColor(c));
        }

        /**
         * @see JTextComponent#setCaretPosition(int)
         */
        default S setCaretPosition(final int position) {
            return setup(result -> result.setCaretPosition(position));
        }

        /**
         * @see JTextComponent#setComponentOrientation(ComponentOrientation)
         */
        default S setComponentOrientation(final ComponentOrientation o) {
            return setup(result -> result.setComponentOrientation(o));
        }

        /**
         * @see JTextComponent#setDisabledTextColor(Color)
         */
        default S setDisabledTextColor(final Color c) {
            return setup(result -> result.setDisabledTextColor(c));
        }

        /**
         * @see JTextComponent#setDocument(Document)
         */
        default S setDocument(final Document doc) {
            return setup(result -> result.setDocument(doc));
        }

        /**
         * @see JTextComponent#setDragEnabled(boolean)
         */
        default S setDragEnabled(final boolean b) {
            return setup(result -> result.setDragEnabled(b));
        }

        /**
         * @see JTextComponent#setDropMode(DropMode)
         */
        default S setDropMode(final DropMode dropMode) {
            return setup(result -> result.setDropMode(dropMode));
        }

        /**
         * @see JTextComponent#setEditable(boolean)
         */
        default S setEditable(final boolean b) {
            return setup(result -> result.setEditable(b));
        }

        /**
         * @see JTextComponent#setFocusAccelerator(char)
         */
        default S setFocusAccelerator(final char aKey) {
            return setup(result -> result.setFocusAccelerator(aKey));
        }

        /**
         * @see JTextComponent#setHighlighter(Highlighter)
         */
        default S setHighlighter(final Highlighter h) {
            return setup(result -> result.setHighlighter(h));
        }

        /**
         * @see JTextComponent#setKeymap(Keymap)
         */
        default S setKeymap(final Keymap map) {
            return setup(result -> result.setKeymap(map));
        }

        /**
         * @see JTextComponent#setMargin(Insets)
         */
        default S setMargin(final Insets m) {
            return setup(result -> result.setMargin(m));
        }

        /**
         * @see JTextComponent#setNavigationFilter(NavigationFilter)
         */
        default S setNavigationFilter(final NavigationFilter filter) {
            return setup(result -> result.setNavigationFilter(filter));
        }

        /**
         * @see JTextComponent#setSelectedTextColor(Color)
         */
        default S setSelectedTextColor(final Color c) {
            return setup(result -> result.setSelectedTextColor(c));
        }

        /**
         * @see JTextComponent#setSelectionColor(Color)
         */
        default S setSelectionColor(final Color c) {
            return setup(result -> result.setSelectionColor(c));
        }

        /**
         * @see JTextComponent#setSelectionEnd(int)
         */
        default S setSelectionEnd(final int selectionEnd) {
            return setup(result -> result.setSelectionEnd(selectionEnd));
        }

        /**
         * @see JTextComponent#setSelectionStart(int)
         */
        default S setSelectionStart(final int selectionStart) {
            return setup(result -> result.setSelectionStart(selectionStart));
        }

        /**
         * @see JTextComponent#setText(String)
         */
        default S setText(final String t) {
            return setup(result -> result.setText(t));
        }

        /**
         * @see JTextComponent#setUI(TextUI)
         */
        default S setUI(final TextUI ui) {
            return setup(result -> result.setUI(ui));
        }
    }
}
