package de.team33.sample.sphinx.alpha.visual.filetree;

import de.team33.sphinx.alpha.visual.JScrollPanes;
import de.team33.sphinx.alpha.visual.JTrees;

import javax.swing.*;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;

public class FileTreePane {

    private final FileService service;
    private final Component component;

    public FileTreePane(final FileService service) {
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
        final TreeNode root = FileTree.rootNode();
        final DefaultTreeModel model = new DefaultTreeModel(root);
        return JTrees.builder()
                     .setModel(model)
                     .setRootVisible(false)
                     .setShowsRootHandles(true)
                     .setSelectionPath(FileTree.path(root, service.getPath()))
                     .setRequestFocusEnabled(true)
                     .setExpandsSelectedPaths(true)
                     .setAutoscrolls(true)
                     .build();
    }
}
