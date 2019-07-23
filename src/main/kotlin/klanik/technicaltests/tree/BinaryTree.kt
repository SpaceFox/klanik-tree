package klanik.technicaltests.tree

/**
 * A binary tree without any additional constraint
 * @param T the type of all node values
 */
interface BinaryTree<T> {

    /**
     * Tree height, as the number of edges between the tree's root and its further leaf.
     * Known as "tree depth" in the test text.
     * Height of an empty or single-node tree is 0.
     */
    fun height(): Int
}
