package de.team33.sphinx.alpha.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SuppressWarnings({"unused", "FieldHasSetterButNoGetter"})
public final class ComboListModel<E> implements ComboBoxModel<E> {

    private static final Logger LOG = Logger.getLogger(ComboListModel.class.getCanonicalName());
    @SuppressWarnings({"rawtypes", "unchecked", "ReturnOfNull"})
    private static final Backing NO_BACKING = new Backing(() -> null, item -> {});

    private final E[] items;
    private final Backing<E> backing;

    private ComboListModel(final Backing<E> backing, final E[] items) {
        this.items = items;
        this.backing = backing;
    }

    private ComboListModel(final E[] items) {
        this(noBacking(), items);
    }

    private ComboListModel(final ComboListModel<E> origin, final Backing<E> backing) {
        this(backing, origin.items);
    }

    @SuppressWarnings("unchecked")
    private static <E> Backing<E> noBacking() {
        return NO_BACKING;
    }

    @SuppressWarnings("BoundedWildcard")
    public static <E extends Enum<?>> ComboListModel<E> of(final Class<E> enumClass) {
        return new ComboListModel<E>(enumClass.getEnumConstants());
    }

    @SafeVarargs
    public static <E> ComboListModel<E> ofItems(final E... items) {
        return new ComboListModel<>(items);
    }

    public ComboListModel<E> setBacking(final Supplier<? extends E> getter,
                                        final Consumer<? super E> setter) {
        return new ComboListModel<>(new Backing<>(getter, setter), items);
    }

    @Override
    public E getSelectedItem() {
        return backing.getter.get();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setSelectedItem(final Object anItem) {
        backing.setter.accept((E) anItem);
    }

    @Override
    public int getSize() {
        return items.length;
    }

    @Override
    public E getElementAt(final int index) {
        return items[index];
    }

    @Override
    public void addListDataListener(final ListDataListener l) {
        LOG.info(() -> "EnumModel.addListDataListener - ignored: " + l);
    }

    @Override
    public void removeListDataListener(final ListDataListener l) {
        LOG.info(() -> "EnumModel.removeListDataListener - ignored: " + l);
    }

    private static class Backing<E> {

        final Supplier<? extends E> getter;
        final Consumer<? super E> setter;

        private Backing(final Supplier<? extends E> getter, final Consumer<? super E> setter) {
            this.getter = getter;
            this.setter = setter;
        }
    }
}
