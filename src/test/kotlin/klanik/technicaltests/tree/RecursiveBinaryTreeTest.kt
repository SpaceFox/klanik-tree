package klanik.technicaltests.tree

import klanik.technicaltests.tree.BinaryTreeNodeTest.Helper.TOO_MUCH_DEEP_TREE_DEPTH
import klanik.technicaltests.tree.BinaryTreeNodeTest.Helper.VERY_DEEP_TREE_DEPTH
import klanik.technicaltests.tree.BinaryTreeNodeTest.Helper.generateTree
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RecursiveBinaryTreeTest {

    @Test fun depthEmpty() {
        assertEquals(0, RecursiveBinaryTree<Int>(null).height())
    }

    @Test fun depthOneLevel() {
        assertEquals(0, RecursiveBinaryTree(TreeNode("A")).height())
    }

    @Test fun depthOneChild() {
        assertEquals(1, RecursiveBinaryTree(
            TreeNode("A",
                TreeNode("B"),
                TreeNode("C"))
        ).height())
    }

    @Test fun unBalancedTreeLeft() {
        assertEquals(2, RecursiveBinaryTree(
            TreeNode(10,
                TreeNode(20,
                    TreeNode(3)))
        ).height())
    }

    @Test
    fun unBalancedTreeRight() {
        assertEquals(2, RecursiveBinaryTree(
            TreeNode(2,
                null,
                TreeNode(4,
                    null,
                    TreeNode(6)))
        ).height())
    }

    @Test fun veryDeepTree() {
        assertEquals(VERY_DEEP_TREE_DEPTH, RecursiveBinaryTree(generateTree(VERY_DEEP_TREE_DEPTH)).height())
    }

    @Test fun tooMuchDeepTree() {
        assertThrows<StackOverflowError> { RecursiveBinaryTree(generateTree(TOO_MUCH_DEEP_TREE_DEPTH)).height() }
    }
}
