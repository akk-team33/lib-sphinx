package de.team33.sphinx.alpha.model;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.logging.Logger;

@SuppressWarnings({"unused", "FieldHasSetterButNoGetter"})
public class EnumModel<E extends Enum<E>> implements ComboBoxModel<E> {

    private static final Logger LOG = Logger.getLogger(EnumModel.class.getCanonicalName());

    private final Class<E> itemClass;
    private final E[] items;
    private final Supplier<E> selectedItemGetter;
    private final Consumer<E> selectedItemSetter;

    private EnumModel(final Consumer<E> selectedItemSetter,
                      final Supplier<E> selectedItemGetter,
                      final Class<E> itemClass,
                      final E[] items) {
        this.itemClass = itemClass;
        this.items = items;
        this.selectedItemSetter = selectedItemSetter;
        this.selectedItemGetter = selectedItemGetter;
    }

    private EnumModel(final Class<E> itemClass) {
        this(item -> {}, () -> null, itemClass, itemClass.getEnumConstants());
    }

    private EnumModel(final EnumModel<E> origin, final Consumer<E> selectedItemSetter) {
        this(selectedItemSetter, origin.selectedItemGetter, origin.itemClass, origin.items);
    }

    private EnumModel(final EnumModel<E> origin, final Supplier<E> selectedItemGetter) {
        this(origin.selectedItemSetter, selectedItemGetter, origin.itemClass, origin.items);
    }

    public static <E extends Enum<E>> EnumModel<E> of(final Class<E> itemClass) {
        return new EnumModel<>(itemClass);
    }

    public final EnumModel<E> setSelectedItemSetter(final Consumer<E> selectedItemSetter) {
        return new EnumModel<>(this, selectedItemSetter);
    }

    public final EnumModel<E> setSelectedItemGetter(final Supplier<E> selectedItemGetter) {
        return new EnumModel<>(this, selectedItemGetter);
    }

    @Override
    public final void setSelectedItem(final Object anItem) {
        selectedItemSetter.accept(itemClass.cast(anItem));
    }

    @Override
    public final E getSelectedItem() {
        return selectedItemGetter.get();
    }

    @Override
    public final int getSize() {
        return items.length;
    }

    @Override
    public final E getElementAt(final int index) {
        return items[index];
    }

    @Override
    public final void addListDataListener(final ListDataListener l) {
        LOG.info(() -> "EnumModel.addListDataListener - ignored: " + l);
    }

    @Override
    public final void removeListDataListener(final ListDataListener l) {
        LOG.info(() -> "EnumModel.removeListDataListener - ignored: " + l);
    }
}
