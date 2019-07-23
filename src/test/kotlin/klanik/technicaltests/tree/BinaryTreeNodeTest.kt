package klanik.technicaltests.tree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BinaryTreeNodeTest {

    object Helper {

        const val VERY_DEEP_TREE_DEPTH = 6000
        const val TOO_MUCH_DEEP_TREE_DEPTH = 100_000

        /**
         * Generates a tree of given height. Tree type is Int, all right nodes are filled, all left nodes are blank.
         * Node value is node height.
         * @param height the tree height
         */
        fun generateTree(height: Int): TreeNode<Int> {
            val root = TreeNode(0)
            var deepestNode = root
            for (i in 1..height) {
                val node = TreeNode(i)
                deepestNode.right = node
                deepestNode = node
            }
            return root
        }
    }

    @Test fun create() {
        val root: TreeNode<Int> = TreeNode(
            1,
            TreeNode(2,
                TreeNode(3),
                null),
            TreeNode(4,
                null,
                TreeNode(5,
                    TreeNode(6),
                    TreeNode(7)))
        )
        assertEquals(1, root.value)

        val left = root.left
        assertNotNull(left)
        assertEquals(2, left?.value)

        val leftLeft = left?.left
        assertNotNull(leftLeft)
        assertEquals(3, leftLeft?.value)

        val leftRight = left?.right
        assertNull(leftRight)

        val right = root.right
        assertNotNull(right)
        assertEquals(4, right?.value)

        val rightLeft = right?.left
        assertNull(rightLeft)

        val rightRight = right?.right
        assertNotNull(rightRight)
        assertEquals(5, rightRight?.value)

        val rightRightLeft = rightRight?.left
        assertNotNull(rightRightLeft)
        assertEquals(6, rightRightLeft?.value)
        assertNull(rightRightLeft?.left)
        assertNull(rightRightLeft?.right)

        val rightRightRight = rightRight?.right
        assertNotNull(rightRightRight)
        assertEquals(7, rightRightRight?.value)
        assertNull(rightRightRight?.left)
        assertNull(rightRightRight?.right)
    }
}
