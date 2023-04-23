package de.team33.sample.sphinx.alpha.visual.filetree;

import de.team33.sample.sphinx.alpha.service.DirectoryService;
import de.team33.sphinx.alpha.activity.Event;
import de.team33.sphinx.alpha.visual.JScrollPanes;
import de.team33.sphinx.alpha.visual.JTrees;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.Optional;

public class FileTreePane {

    private final DirectoryService service;
    private final Component component;

    public FileTreePane(final DirectoryService service) {
        this.service = service;
        this.component = jScrollPane();
    }

    public final Component component() {
        return component;
    }

    private JScrollPane jScrollPane() {
        final JTree jTree = jTree();
        return JScrollPanes.builder()
                           .setViewportView(jTree)
                           //.setup(sp -> sp.getViewport().scrollRectToVisible())
                           .build();
    }

    private JTree jTree() {
        final FSRootNode root = new FSRootNode();
        final DefaultTreeModel model = new DefaultTreeModel(root);
        return JTrees.builder()
                     .setModel(model)
                     .setRootVisible(false)
                     .setShowsRootHandles(true)
                     .setSelectionPath(root.treePath(service.getPath()))
                     .setRequestFocusEnabled(true)
                     .setExpandsSelectedPaths(true)
                     .setAutoscrolls(true)
                     .on(Event.TREE_VALUE_CHANGED, this::treeValueChanged)
                     .build();
    }

    private void treeValueChanged(final TreeSelectionEvent event) {
        Optional.of(event.getPath().getLastPathComponent())
                .filter(PathTreeNode.class::isInstance)
                .map(PathTreeNode.class::cast)
                .map(PathTreeNode::getPath)
                .ifPresent(service::setPath);
    }
}
