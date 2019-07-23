package klanik.technicaltests.tree

/**
 * A tree node.
 * @param T the node type
 * @property value the node value
 * @property left the left child node, if exists
 * @property right the right child node, if exists
 */
class TreeNode<T>(
    var value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null
)
