package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import java.util.function.Supplier;
import javax.swing.JEditorPane;
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
        default S addStyle(final String arg0, final Style arg1) {
            return setup(result -> result.addStyle(arg0, arg1));
        }

        /**
         * @see JTextPane#removeStyle(String)
         */
        default S removeStyle(final String arg0) {
            return setup(result -> result.removeStyle(arg0));
        }

        /**
         * @see JTextPane#setCharacterAttributes(AttributeSet, boolean)
         */
        default S setCharacterAttributes(final AttributeSet arg0, final boolean arg1) {
            return setup(result -> result.setCharacterAttributes(arg0, arg1));
        }

        /**
         * @see JTextPane#setDocument(Document)
         */
        default S setDocument(final Document arg0) {
            return setup(result -> result.setDocument(arg0));
        }

        /**
         * @see JTextPane#setEditorKit(EditorKit)
         */
        default S setEditorKit(final EditorKit arg0) {
            return setup(result -> result.setEditorKit(arg0));
        }

        /**
         * @see JTextPane#setLogicalStyle(Style)
         */
        default S setLogicalStyle(final Style arg0) {
            return setup(result -> result.setLogicalStyle(arg0));
        }

        /**
         * @see JTextPane#setParagraphAttributes(AttributeSet, boolean)
         */
        default S setParagraphAttributes(final AttributeSet arg0, final boolean arg1) {
            return setup(result -> result.setParagraphAttributes(arg0, arg1));
        }

        /**
         * @see JTextPane#setStyledDocument(StyledDocument)
         */
        default S setStyledDocument(final StyledDocument arg0) {
            return setup(result -> result.setStyledDocument(arg0));
        }
    }
}
