package klanik.technicaltests.tree

import klanik.technicaltests.tree.BinaryTreeNodeTest.Helper.TOO_MUCH_DEEP_TREE_DEPTH
import klanik.technicaltests.tree.BinaryTreeNodeTest.Helper.VERY_DEEP_TREE_DEPTH
import klanik.technicaltests.tree.BinaryTreeNodeTest.Helper.generateTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IterativeBinaryTreeTest {

    @Test fun depthEmpty() {
        assertEquals(0, IterativeBinaryTree<Int>(null).height())
    }

    @Test fun depthOneLevel() {
        assertEquals(0, IterativeBinaryTree(TreeNode("A")).height())
    }

    @Test fun depthOneChild() {
        assertEquals(1, IterativeBinaryTree(
            TreeNode("A",
                TreeNode("B"),
                TreeNode("C"))
        ).height())
    }

    @Test fun unBalancedTreeLeft() {
        assertEquals(2, IterativeBinaryTree(
            TreeNode(10,
                TreeNode(20,
                    TreeNode(3)))
        ).height())
    }

    @Test fun unBalancedTreeRight() {
        assertEquals(2, IterativeBinaryTree(
            TreeNode(2,
                null,
                TreeNode(4,
                    null,
                    TreeNode(6)))
        ).height())
    }

    @Test fun veryDeepTree() {
        assertEquals(VERY_DEEP_TREE_DEPTH, IterativeBinaryTree(generateTree(VERY_DEEP_TREE_DEPTH)).height())
    }

    @Test fun tooMuchDeepTree() {
        assertEquals(TOO_MUCH_DEEP_TREE_DEPTH, IterativeBinaryTree(generateTree(TOO_MUCH_DEEP_TREE_DEPTH)).height())
    }
}
