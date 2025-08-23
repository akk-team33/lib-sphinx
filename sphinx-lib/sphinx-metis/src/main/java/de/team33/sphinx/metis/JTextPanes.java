package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyledDocument;
import java.util.function.Supplier;

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
    public static Builder<JTextPane> builder() {
        return new Builder<>(JTextPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextPane}.
     */
    public static <T extends JTextPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextPane}.
     */
    public static <T extends JTextPane> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JTextPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JTextPane}.
     */
    public static final class Builder<T extends JTextPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JTextPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextPane}.
     */
    public static final class Charger<T extends JTextPane>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JTextPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JTextPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
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
