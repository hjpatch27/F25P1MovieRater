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
            this.data = e;
            this.prev = p;
            this.next = n;
        }

        public Node(Node p, Node n)
        {
            this.prev = p;
            this.next = n;
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

    private SparseEntry data;
    private Node curr;
    private Node prev;
    private Node tail;
    private Node head;
    private int listSize; // Number of entries in the Sparse Matrix.
    
    public SparseMatrix()
    {
        init();
    }
    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init()
    {
        head = new SparseMatrix.Node(null, null);
        tail = new SparseMatrix.Node(null, null);
        head.setNext(tail);
        tail.setPrev(head);
        listSize = 0;
    }
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return listSize;
    }
    
    /**
     * Adds an existing SparseEntry to the list
     */
    public boolean insert(SparseEntry e)
    {
        curr = new Node(e, curr.prev(), curr);
        curr.prev().setNext(curr);
        curr.next().setNext(curr);
        listSize++;
        return true;
        
    }
    /**
     * Adds an entry in the matrix
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
        Node current = head.next();
        while (current != tail)
        {
            SparseEntry entry = current.getData();
            if (entry.getRow() == row && entry.getCol() == col)
            {
                entry.setScore(score);
                return;
            }
               current = current.next();
        }
        
        // If entry is not found
        SparseEntry newEntry = new SparseEntry(row, col, score);
        Node newNode = new Node(newEntry, tail.prev(), tail);
        tail.prev().setNext(newNode);
        tail.setPrev(newNode);
        // Increment the size by 1
        listSize++;
       
    }
    
    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return (listSize == 0);
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
    public SparseEntry remove()
    {
        if (curr == tail) // Nothing to remove
        {
            return null;
        }
        SparseEntry it = curr.getData(); // Remember Value
        // Remove from list
        curr.prev().setNext(curr.next()); 
        curr.next().setPrev(curr.prev());
        curr = curr.next();
        listSize--; // Decrement node count
        return it; // Return the value removed
      
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
        listSize--;
        return true;
    }
    
    /**
     * Gets the object at the given position
     * @param row 
     * @param col 
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public SparseEntry get(int row, int col)
    {
        Node current = head.next();
        while (current != tail)
        {
           
        SparseEntry entry = current.getData();
        if (entry.getRow() == row && entry.getCol() == col)
        {
            // If current data is equal to the wanted than return current
            return current.getData();
        }
            current = current.next();
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
    public boolean contains(int row, int col)
    {
        Node current = head.next();
        while (current != tail)
        {
            SparseEntry entry = current.getData();
            if (entry.getRow() == row && entry.getCol() == col)
            {
                return true;
            }
            current = current.next();
        }
        return false;
    }
    
    /**
     * Removes all of the elements from the list
     */
    public void clear()
    {
        curr = tail = new Node(null , null); // Create trailer
        head = new Node(null, tail); // Create header
        listSize = 0;
    }
}
