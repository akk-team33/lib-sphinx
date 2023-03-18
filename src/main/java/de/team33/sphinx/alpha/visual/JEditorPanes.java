package de.team33.sphinx.alpha.visual;

import de.team33.patterns.building.elara.LateBuilder;
import de.team33.patterns.exceptional.e1.Conversion;

import java.util.function.Supplier;

import java.net.URL;
import javax.swing.JEditorPane;
import javax.swing.text.EditorKit;

/**
 * Utility class to handle {@link JEditorPane}s.
 */
@SuppressWarnings("unused")
public final class JEditorPanes {

    /**
     * Returns a new {@link Builder} for target instances of type {@link JEditorPane}.
     */
    public static Builder<JEditorPane, ?> builder() {
        return new Builder<>(JEditorPane::new, Builder.class);
    }

    /**
     * Returns a new {@link Builder} for target instances as supplied by the given {@link Supplier}.
     * 
     * @param <T> The final type of the target instances, at least {@link JEditorPane}.
     */
    public static <T extends JEditorPane> Builder<T, ?> builder(final Supplier<T> newTarget) {
        return new Builder<>(newTarget, Builder.class);
    }

    /**
     * Builder implementation to build target instances of {@link JEditorPane}.
     * 
     * @param <T> The final type of the target instances, at least {@link JEditorPane}.
     * @param <B> The final type of the Builder implementation.
     */
    public static class Builder<T extends JEditorPane, B extends Builder<T, B>>
            extends LateBuilder<T, B> implements Setup<T, B> {

        protected Builder(final Supplier<T> newResult, final Class<B> builderClass) {
            super(newResult, builderClass);
        }
    }

    /**
     * Utility interface to set up a target instance of {@link JEditorPane}.
     * 
     * @param <T> The final type of the target instance, at least {@link JEditorPane}.
     * @param <S> The final type of the Setup implementation.
     */
    public interface Setup<T extends JEditorPane, S extends Setup<T, S>> extends JTextComponents.Setup<T, S> {

        /**
         * @see JEditorPane#setText(String)
         */
        default S setText(final String arg0) {
            return setup(result -> result.setText(arg0));
        }

        /**
         * @see JEditorPane#setContentType(String)
         */
        default S setContentType(final String arg0) {
            return setup(result -> result.setContentType(arg0));
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
    }
}
