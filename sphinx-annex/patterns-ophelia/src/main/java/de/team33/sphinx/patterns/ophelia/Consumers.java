package de.team33.sphinx.patterns.ophelia;

import de.team33.patterns.collection.ceres.Collecting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.function.Consumer;

/**
 * An agent for {@link Consumer}s of arguments of type &lt;T&gt;.
 * Itself represents a {@link Consumer} that forwards passed arguments to all associated {@link Consumer}s.
 */
public class Consumers<T> implements Consumer<T> {

    private final Executor executor;
    private volatile List<Consumer<? super T>> clients = Collections.emptyList();

    /**
     * Initializes a new instance that uses a given {@link Executor} to pass arguments to its associated
     * {@link Consumer}s.
     */
    public Consumers(final Executor executor) {
        this.executor = executor;
    }

    /**
     * Initializes a new instance that immediately passes arguments to its associated {@link Consumer}s.
     */
    public Consumers() {
        this(Runnable::run);
    }

    private synchronized List<Consumer<? super T>> currentClients() {
        return clients;
    }

    private synchronized void addNonNull(final Consumer<? super T> client) {
        clients = Collecting.builder(() -> new ArrayList<Consumer<? super T>>(clients.size() + 1))
                            .addAll(clients)
                            .add(client)
                            .build();
    }

    private synchronized void removeNonNull(final Consumer<? super T> client) {
        clients = Collecting.builder(() -> new ArrayList<Consumer<? super T>>(clients.size()))
                            .addAll(clients)
                            .remove(client)
                            .build();
    }

    @Override
    public final void accept(final T t) {
        executor.execute(() -> {
            for (Consumer<? super T> client : currentClients()) {
                client.accept(t);
            }
        });
    }

    public final Consumers<T> add(final Consumer<? super T> client) {
        if (null != client) {
            addNonNull(client);
        }
        return this;
    }

    public final Consumers<T> remove(final Consumer<? super T> client) {
        if (null != client) {
            removeNonNull(client);
        }
        return this;
    }
}
