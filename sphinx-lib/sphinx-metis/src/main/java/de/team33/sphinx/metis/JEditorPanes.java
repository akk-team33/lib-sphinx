package de.team33.sphinx.metis;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.patterns.exceptional.dione.Conversion;

import javax.swing.*;
import javax.swing.text.EditorKit;
import java.net.URL;
import java.util.function.Supplier;

/**
 * Utility class to handle {@link JEditorPane}s.
 */
@SuppressWarnings("unused")
public final class JEditorPanes {

    private JEditorPanes() {
    }

    /**
     * Returns a new {@link Builder} for target instances of type {@link JEditorPane}.
     */
    public static Builder<JEditorPane> builder() {
        return new Builder<>(JEditorPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JEditorPane}.
     */
    public static <T extends JEditorPane> Builder<T> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Returns a new {@link Charger} for a given target instance.
     * 
     * @param <T> The final type of the target instance, at least {@link JEditorPane}.
     */
    public static <T extends JEditorPane> Charger<T> charger(final T target) {
        return new Charger<>(target, Charger.class);
    }

    /**
     * Builder implementation to build target instances of {@link JEditorPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JEditorPane}.
     */
    public static final class Builder<T extends JEditorPane>
            extends LateBuilder<T, Builder<T>> implements Setup<T, Builder<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Builder(final Supplier<T> newResult, final Class builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Charger implementation to charge target instances of {@link JEditorPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JEditorPane}.
     */
    public static final class Charger<T extends JEditorPane>
            extends de.team33.patterns.building.elara.Charger<T, Charger<T>>
            implements Setup<T, Charger<T>> {

        @SuppressWarnings({"rawtypes", "unchecked"})
        private Charger(final T target, final Class chargerClass) {
            super(target, chargerClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JEditorPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JEditorPane}.
     * @param <S> The final type of the Setup implementation.
     */
    @SuppressWarnings("ClassNameSameAsAncestorName")
    @FunctionalInterface
    public interface Setup<T extends JEditorPane, S extends Setup<T, S>> extends JTextComponents.Setup<T, S> {

        /**
         * @see JEditorPane#setContentType(String)
         */
        default S setContentType(final String arg0) {
            return setup(result -> result.setContentType(arg0));
        }

        /**
         * @see JEditorPane#setEditorKit(EditorKit)
         */
        default S setEditorKit(final EditorKit arg0) {
            return setup(result -> result.setEditorKit(arg0));
        }

        /**
         * @see JEditorPane#setEditorKitForContentType(String, EditorKit)
         */
        default S setEditorKitForContentType(final String arg0, final EditorKit arg1) {
            return setup(result -> result.setEditorKitForContentType(arg0, arg1));
        }

        /**
         * @see JEditorPane#setPage(String)
         */
        default S setPage(final String arg0) {
            return setup(Conversion.consumer(result -> result.setPage(arg0)));
        }

        /**
         * @see JEditorPane#setPage(URL)
         */
        default S setPage(final URL arg0) {
            return setup(Conversion.consumer(result -> result.setPage(arg0)));
        }
    }
}
