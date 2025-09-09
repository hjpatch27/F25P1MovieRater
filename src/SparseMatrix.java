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
    private SparseEntry data;
    private Node curr;
    private Node prev;
    private int listSize; // Number of entries in the Sparse Matrix.
    
    public SparseMatrix()
    {
        this.listSize = 0;
    }
    public class SparseEntry
    {
        private int row;
        private int col;
        private int score;
        
        public SparseEntry(int numRow, int numCol, int score)
        {
            this.row = numRow;
            this.col = numCol;
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
        private SparseEntry data; // value for this node
        private Node next; // Pointer to next node
        private Node prev; // Pointer to previous node

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(SparseEntry e, Node p, Node n)
        {
            e = data;
            p = prev;
            n = next;
        }

        public Node(Node p, Node n)
        {
            p = prev;
            n = next;
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
         * Sets the next node to a new node.
         *
         * @param n is the node after the current one.
         */
        public Node setNext(Node n)
        {
            return next = n;
        }
        
        /**
         * Gets and returns the previous node.
         * @return prev, the previous node.
         */
        public Node prev()
        {
            return prev;
        }
        
        /**
         * Sets the previous node to a new node.
         * @param p is what we'll change the previous node to.
         * @return prev which should now be Node p.
         */
        public Node setPrev(Node p)
        {
            return prev = p;
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
        
        /**
         * Sets the SparseEntry data with a node to have new values.
         * @param e is the SparseEntry to replace the current one.
         * @return data with the new SparseEntry object in it.
         */
        public SparseEntry setData(SparseEntry e)
        {
            return data = e;
        }
    }

    
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return 0;
    }
    
    public boolean insert(SparseEntry e)
    {
        curr = new Node(e, curr.prev(), curr);
        curr.prev().setNext(curr);
        curr.next().setNext(curr);
        listSize++;
        return true;
        
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
        // Check for existing entry and update score if found
        
        // Create new node with new SparseEntry
        Node newNode = new Node(new SparseEntry(row, col, score));
        
        // Insert into Row list
        
        // Insert into Col list
        
        size++;
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
    public boolean removeRow(int row)
    {
        size--;
        return true;
    }
    
    /**
     * Removes the object at the given position
     * This method will find the specific node at (row, col) and 
     * remove it from both the row and column linked lists by updating 
     * the pointers of the nodes before and after it.
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean removeIndex(int row, int col)
    {
        size--;
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
    public SparseEntry get(int row, int col)
    {
  
        while (current != null)
        {
            if (current.getData().getCol() == col)
            {
                // If current data is equal to the wanted than return current
                return current.getData();
            }
            
            current = current.nextRow;
        }

        return null;
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
