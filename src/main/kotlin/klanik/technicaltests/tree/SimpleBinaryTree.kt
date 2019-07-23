package klanik.technicaltests.tree

/**
 * A simple binary tree without any constraint on nodes
 * @property root the root node
 */
abstract class SimpleBinaryTree<T>(var root: TreeNode<T>?) : BinaryTree<T>
