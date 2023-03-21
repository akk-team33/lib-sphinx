package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;

/**
 * Utility class to handle {@link JTextPane}s.
 */
@SuppressWarnings("unused")
public final class JTextPanes {

    private JTextPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JTextPane}.
     */
    public static Builder<JTextPane, ?> builder() {
        return new Builder<>(JTextPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextPane}.
     */
    public static <T extends JTextPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTextPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JTextPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTextPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextPane}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JTextPane, S extends Setup<T, S>> extends JEditorPanes.Setup<T, S> {

        /**
         * @see JTextPane#addStyle(String, Style)
         */
        default S addStyle(final String nm, final Style parent) {
            return setup(result -> result.addStyle(nm, parent));
        }

        /**
         * @see JTextPane#removeStyle(String)
         */
        default S removeStyle(final String nm) {
            return setup(result -> result.removeStyle(nm));
        }

        /**
         * @see JTextPane#setCharacterAttributes(AttributeSet, boolean)
         */
        default S setCharacterAttributes(final AttributeSet attr, final boolean replace) {
            return setup(result -> result.setCharacterAttributes(attr, replace));
        }

        /**
         * @see JTextPane#setDocument(Document)
         */
        default S setDocument(final Document doc) {
            return setup(result -> result.setDocument(doc));
        }

        /**
         * @see JTextPane#setEditorKit(EditorKit)
         */
        default S setEditorKit(final EditorKit kit) {
            return setup(result -> result.setEditorKit(kit));
        }

        /**
         * @see JTextPane#setLogicalStyle(Style)
         */
        default S setLogicalStyle(final Style s) {
            return setup(result -> result.setLogicalStyle(s));
        }

        /**
         * @see JTextPane#setParagraphAttributes(AttributeSet, boolean)
         */
        default S setParagraphAttributes(final AttributeSet attr, final boolean replace) {
            return setup(result -> result.setParagraphAttributes(attr, replace));
        }

        /**
         * @see JTextPane#setStyledDocument(StyledDocument)
         */
        default S setStyledDocument(final StyledDocument doc) {
            return setup(result -> result.setStyledDocument(doc));
        }
    }
}
