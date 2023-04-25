package de.team33.sample.sphinx.alpha.visual.filetree;

import javax.swing.tree.TreeNode;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public interface DirTreeNode extends TreeNode {

    List<TreeNode> entries();

    @Override
    default TreeNode getChildAt(final int childIndex) {
        return entries().get(childIndex);
    }

    @Override
    default int getChildCount() {
        return entries().size();
    }

    @Override
    default int getIndex(final TreeNode node) {
        return entries().indexOf(node);
    }

    @Override
    default boolean getAllowsChildren() {
        return true;
    }

    @Override
    default boolean isLeaf() {
        return false;
    }

    @Override
    default Enumeration<TreeNode> children() {
        return Collections.enumeration(entries());
    }
}
