package klanik.technicaltests.tree

import java.util.*

/**
 * A simple binary tree with its height computed with an iterative method.
 * This is more complex than recursive method but allows tree heights larger than JVM stack
 */
class IterativeBinaryTree<T>(root: TreeNode<T>?) : SimpleBinaryTree<T>(root) {

    override fun height(): Int {
        if (root == null) {
            return 0
        }

        // Let's compute height of current binary tree by doing level order traversal
        val nodesToVisit: Queue<TreeNode<T>> = ArrayDeque()
        nodesToVisit.add(root)

        var currentNode: TreeNode<T>?
        var height = 0

        while (!nodesToVisit.isEmpty()) {
            var nodesInCurrentLevel = nodesToVisit.size

            // Add next level nodes to nodes to visit queue if they exist
            while (nodesInCurrentLevel-- > 0) {
                currentNode = nodesToVisit.poll()

                if (currentNode.left != null) {
                    nodesToVisit.add(currentNode.left)
                }
                if (currentNode.right != null) {
                    nodesToVisit.add(currentNode.right)
                }
            }

            height++
        }

        // Previous algorithm computes height as number of nodes between root and further leaf, we must subtract 1 to
        // get height in edge to match the definition.
        return height - 1
    }
}
