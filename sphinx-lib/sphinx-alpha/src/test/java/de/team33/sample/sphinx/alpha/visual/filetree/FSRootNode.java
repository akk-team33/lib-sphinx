package de.team33.sample.sphinx.alpha.visual.filetree;

import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FSRootNode implements DirTreeNode {

    private static final Logger LOG = Logger.getLogger(FSRootNode.class.getCanonicalName());

    @Override
    public List<TreeNode> entries() {
        return StreamSupport.stream(FileSystems.getDefault().getRootDirectories().spliterator(), false)
                            .map(path -> new DirNode(this, path))
                            .collect(Collectors.toList());
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int hashCode() {
        return FSRootNode.class.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof FSRootNode;
    }

    @Override
    public String toString() {
        return "Filesystem";
    }

    public TreePath treePath(final Path path) {
        if (null == path)
            return new TreePath(this);
        else {
            final TreePath parentPath = treePath(path.getParent());
            final TreeNode parentNode = (TreeNode) parentPath.getLastPathComponent();
            return parentPath.pathByAddingChild(new DirNode(parentNode, path));
        }
    }

    private static class PathNode implements PathTreeNode {

        private final TreeNode parent;
        private final Path path;

        PathNode(final TreeNode parent, final Path path) {
            this.parent = parent;
            this.path = path.toAbsolutePath().normalize();
        }

        @Override
        public final Path getPath() {
            return path;
        }

        public final TreeNode getParent() {
            return parent;
        }

        @Override
        public final int hashCode() {
            return path.hashCode();
        }

        @Override
        public final boolean equals(final Object obj) {
            return (this == obj) || ((obj instanceof PathNode) && path.equals(((PathNode) obj).path));
        }

        @Override
        public final String toString() {
            return (null == path.getParent()) ? path.toString() : path.getFileName().toString();
        }
    }

    private static class DirNode extends PathNode implements DirTreeNode {

        DirNode(final TreeNode parent, final Path path) {
            super(parent, path);
        }

        @Override
        public List<TreeNode> entries() {
            try (final Stream<Path> stream = Files.list(getPath())) {
                return stream.filter(Files::isDirectory)
                             .map(entry -> new DirNode(this, entry))
                             .sorted(Comparator.comparing(Object::toString))
                             .collect(Collectors.toList());
            } catch (IOException e) {
                LOG.log(Level.WARNING, e, () -> String.format("could not read directory <%s>", getPath()));
                return Collections.emptyList();
            }
        }
    }
}
