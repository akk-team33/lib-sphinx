package de.team33.sample.sphinx.alpha.visual.filetree;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTree {

    private static final Logger LOG = Logger.getLogger(FileTree.class.getCanonicalName());

    public static TreeNode rootNode() {
        final List<Path> roots = new LinkedList<>();
        FileSystems.getDefault().getRootDirectories().forEach(roots::add);
        return new RootNode(roots);
    }

    public static TreePath path(final TreeNode root, final Path path) {
        if (null == path)
            return new TreePath(root);
        else {
            final TreePath parentPath = path(root, path.getParent());
            final TreeNode parentNode = (TreeNode) parentPath.getLastPathComponent();
            return parentPath.pathByAddingChild(new DirNode(parentNode, path));
        }
    }

    private static class RootNode implements TreeNode {

        private final List<Path> roots;

        private RootNode(final List<Path> roots) {
            this.roots = new ArrayList<>(roots);
        }

        @Override
        public TreeNode getChildAt(final int childIndex) {
            return new DirNode(this, roots.get(childIndex));
        }

        @Override
        public int getChildCount() {
            return roots.size();
        }

        @Override
        public TreeNode getParent() {
            return null;
        }

        @Override
        public int getIndex(final TreeNode node) {
            if (node instanceof DirNode) {
                final DirNode dirNode = (DirNode) node;
                return roots.indexOf(dirNode.path);
            }
            return -1;
        }

        @Override
        public boolean getAllowsChildren() {
            return true;
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public Enumeration children() {
            return Collections.enumeration(roots);
        }

        @Override
        public String toString() {
            return "Filesystem";
        }
    }

    private static class DirNode implements TreeNode {

        private final TreeNode parent;
        private final Path path;
        private final List<Path> entries;

        private DirNode(final TreeNode parent, final Path path) {
            this.parent = parent;
            this.path = path;
            this.entries = entriesOf(path);
        }

        private static List<Path> entriesOf(final Path path) {
            try (final Stream<Path> stream = Files.list(path)) {
                return stream.filter(Files::isDirectory)
                             .collect(Collectors.toList());
            } catch (final IOException e) {
                LOG.log(Level.WARNING, e, () -> "cannot read <" + path + ">");
                return Collections.emptyList();
            }
        }

        @Override
        public TreeNode getChildAt(final int childIndex) {
            return new DirNode(this, entries.get(childIndex));
        }

        @Override
        public int getChildCount() {
            return entries.size();
        }

        @Override
        public TreeNode getParent() {
            return parent;
        }

        @Override
        public int getIndex(final TreeNode node) {
            if (node instanceof DirNode) {
                final DirNode dirNode = (DirNode) node;
                return entries.indexOf(dirNode.path);
            }
            return -1;
        }

        @Override
        public boolean getAllowsChildren() {
            return true;
        }

        @Override
        public boolean isLeaf() {
            return false;
        }

        @Override
        public Enumeration children() {
            return Collections.enumeration(entries);
        }

        @Override
        public String toString() {
            if (path.getParent() == null)
                return path.toString();
            else
                return path.getFileName().toString();
        }
    }
}
