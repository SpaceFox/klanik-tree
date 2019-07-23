package klanik.technicaltests.tree

import kotlin.math.max

/**
 * A simple binary tree with its height computed with a recursive method.
 * This prevents computing tree height if this height is larger than JVM stack.
 */
class RecursiveBinaryTree<T>(root: TreeNode<T>?) : SimpleBinaryTree<T>(root) {

    override fun height(): Int {
        // Function computes height as number of nodes between root and further leaf, we must subtract 1 to get height
        // in edge to match the definition.
        return if (root == null) 0 else heightInNodes(root) - 1
    }

    /**
     * Computes tree node-height to node in parameter.
     * Node-height is number of nodes between root and current node
     */
    private fun heightInNodes(node: TreeNode<T>?): Int {
        return when (node) {
            null -> 0
            else -> max(heightInNodes(node.left), heightInNodes(node.right)) + 1
        }
    }
}
