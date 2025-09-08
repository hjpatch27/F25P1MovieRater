import java.util.*;
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
        
        public SparseEntry(int row, int col, int score)
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
         * Sets the row number to a new row in the Sparse Matrix.
         * @param newRow is the row number to be changed to.
         */
        public void setRow(int newRow)
        {
            row = newRow;
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
         * Sets the column number to a new column in the Sparse Matrix.
         * @param newCol is the column number to be changed to.
         */
        public void setCol(int newCol)
        {
            col = newCol;
        }
        
        /**
         * Returns the value of the entry in the Sparse Matrix.
         * @return score, the integer value the entry contains.
         */
        public int getScore()
        {
            return score;
        }
        
        /**
         * Sets the score to a new value in the Sparse Matrix.
         * @param newScore is the score value to be changed to.
         */
        public void setScore(int newScore)
        {
            score = newScore;
        }
    }
    
    private static class Node
    {

        // The data element stored in the node.
        private SparseEntry data;
        Node next;

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
         * Sets the node column after this node.
         *
         * @param n is the node after the current one.
         */
        public void setNext(Node n)
        {
            next = n;
        }

        /**
         * Gets the next node.
         *
         * @return the next node.
         */
        public Node next()
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

    // The size of the Linked List
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
    public void add(int row, int col, int score)
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
    public boolean removeIndex(int row, int col)
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
    public int get(int row, int col)
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
