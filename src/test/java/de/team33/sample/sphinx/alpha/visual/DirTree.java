package de.team33.sample.sphinx.alpha.visual;

import de.team33.sample.sphinx.alpha.service.Adapter;
import de.team33.sample.sphinx.alpha.visual.filetree.FSRootNode;
import de.team33.sample.sphinx.alpha.visual.filetree.PathTreeNode;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.visual.JScrollPanes;
import de.team33.sphinx.alpha.visual.JTrees;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.nio.file.Path;
import java.util.Optional;
import java.util.function.Consumer;

public class DirTree {

    private final JScrollPane jScrollPane;
    private final JTree jTree;
    private final FSRootNode rootNode;

    public DirTree(final Adapter<Path> pathAdapter) {
        this.rootNode = new FSRootNode();
        this.jTree = JTrees.builder()
                           .setModel(new DefaultTreeModel(rootNode))
                           .setRootVisible(false)
                           .setShowsRootHandles(true)
                           .setRequestFocusEnabled(true)
                           .setExpandsSelectedPaths(true)
                           .setAutoscrolls(true)
                           .on(Event.TREE_VALUE_CHANGED, event -> treeValueChanged(event, pathAdapter))
                           .build();
        this.jScrollPane = JScrollPanes.builder()
                                       .setViewportView(jTree)
                                       .build();
        pathAdapter.feed(this::setSelectedPath);
    }

    private void setSelectedPath(final Path path) {
        //jScrollPane.setVisible(false);
        final TreePath treePath = rootNode.treePath(path);
        jTree.setSelectionPath(treePath);
        final Rectangle rect = jTree.getPathBounds(treePath);
        final Point point = jScrollPane.getViewport().getViewPosition();
        rect.setLocation(rect.x - point.x, rect.y - point.y);
        jScrollPane.getViewport().scrollRectToVisible(rect);
        jScrollPane.repaint();
    }

    private void treeValueChanged(final TreeSelectionEvent event, final Consumer<? super Path> setPath) {
        Optional.of(event.getPath().getLastPathComponent())
                .filter(PathTreeNode.class::isInstance)
                .map(PathTreeNode.class::cast)
                .map(PathTreeNode::getPath)
                .ifPresent(setPath);
    }

    public final JScrollPane panel() {
        return jScrollPane;
    }
}
