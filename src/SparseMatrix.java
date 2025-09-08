/**
 * Implementation of a sparse matrix. This will be used as the data structure
 * for our MovieRater. 
 * 
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.8.2025
 */
public class SparseMatrix 
{
    public class SparseEntry
    {
        private int row;
        private int col;
        private int score;
        
        public sparseEntry(int row, int col, int score)
        {
            this.row = row;
            this.col = col;
            this.score = score;
        }
        
        /**
         * Returns the row number of the entry in the Sparse Matrix.
         * @return row, the number of the row the entry is in.
         */
        public int getRow()
        {
            return row;
        }
        
        /**
         * Returns the column number of the entry in the Sparse Matrix.
         * @return col, the number of the column the entry is in.
         */
        public int getCol()
        {
            return col;
        }
        
        /**
         * Returns the value of the entry in the Sparse Matrix.
         * @return score, the integer value the entry contains.
         */
        public int getScore()
        {
            return score;
        }
    }
    
    public static class Node<SparseEntry>
    {

        // The data element stored in the node.
        private SparseEntry data;

        // The next node in the sequence.
        private Node<SparseEntry> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(SparseEntry d)
        {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<SparseEntry> n)
        {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<SparseEntry> next()
        {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public SparseEntry getData()
        {
            return data;
        }
    }

    private Node<SparseEntry> head;

    // the size of the linked list
    private int size;

    
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return 0;
    }
    
    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    public void add(int index, int obj)
    {
        
    }
    
    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);
    }
    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    
    public void add(int obj)
    {
        
    }
    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean removeObject(int obj)
    {
        return true;
    }
    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean removeIndex(int index)
    {
        return true;
    }
    
    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public int get(int index)
    {
        return 0;
    }
    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(int obj)
    {
        return true;
    }
    
    /**
     * Removes all of the elements from the list
     */
    public void clear()
    {
        
    }
}
