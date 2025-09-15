/**
 * Implementation of a sparse matrix. This will be used as the data structure
 * for our MovieRater.
 * 
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.15.2025
 */
public class SparseMatrix {
    
    /**
     * SparseEntry class represents the object/data entries
     * that are entered into the Sparse Matrix. Each
     * SparseEntry has an assigned row, column and score.
     */
    public class SparseEntry {
        private int row;
        private int col;
        private int score;

        /**
         * Constructor for the SparseEntry object.
         * @param numRow the row of the object in the Sparse Matrix.
         * @param numCol the column of the object in the Sparse Matrix.
         * @param score the score of the object in the Sparse Matrix.
         */
        public SparseEntry(int numRow, int numCol, int score) {
            this.row = numRow;
            this.col = numCol;
            this.score = score;
        }


        /**
         * Returns the row number of the entry in the Sparse Matrix.
         * 
         * @return row, the number of the row the entry is in.
         */
        public int getRow() {
            return row;
        }


        /**
         * Sets the row number to a new row in the Sparse Matrix.
         * 
         * @param newRow is the row number to be changed to.
         */
        public void setRow(int newRow) {
            row = newRow;
        }


        /**
         * Returns the column number of the entry in the Sparse Matrix.
         * 
         * @return col, the number of the column the entry is in.
         */
        public int getCol() {
            return col;
        }


        /**
         * Sets the column number to a new column in the Sparse Matrix.
         * 
         * @param newCol is the column number to be changed to.
         */
        public void setCol(int newCol) {
            col = newCol;
        }


        /**
         * Returns the value of the entry in the Sparse Matrix.
         * 
         * @return score, the integer value the entry contains.
         */
        public int getScore() {
            return score;
        }


        /**
         * Sets the score to a new value in the Sparse Matrix.
         * 
         * @param newScore is the score value to be changed to.
         */
        public void setScore(int newScore) {
            score = newScore;
        }
    }


    private static class Node {
        // The data element stored in the node.
        private SparseEntry data; // value for this node
        private Node next; // Pointer to next node
        private Node prev; // Pointer to previous node

        /**
         * Creates a new node with the given data
         *
         * @param d is the data to put inside the node
         */
        public Node(SparseEntry e, Node p, Node n) {
            this.data = e;
            this.prev = p;
            this.next = n;
        }


        public Node(Node p, Node n) {
            this.prev = p;
            this.next = n;
        }


        /**
         * Gets the next node.
         *
         * @return the next node.
         */
        public Node next() {
            return next;
        }


        /**
         * Sets the next node to a new node.
         *
         * @param n is the node after the current one.
         */
        public Node setNext(Node n) {
            next = n;
            return next;
        }


        /**
         * Gets and returns the previous node.
         * 
         * @return prev, the previous node.
         */
        public Node prev() {
            return prev;
        }


        /**
         * Sets the previous node to a new node.
         * 
         * @param p is what we'll change the previous node to.
         * @return prev which should now be Node p.
         */
        public Node setPrev(Node p) {
            prev = p;
            return prev;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public SparseEntry getData() {
            return data;
        }


        /**
         * Sets the SparseEntry data with a node to have new values.
         * 
         * @param e
         *            is the SparseEntry to replace the current one.
         * @return data with the new SparseEntry object in it.
         */
        public SparseEntry setData(SparseEntry e) {
            data = e;
            return data;
        }
    }

    private SparseEntry data;
    private Node curr;
    private Node prev;
    private Node tail;
    private Node head;
    private int listSize; // Number of entries in the Sparse Matrix.

    /**
     * The SparseMatrix class uses the SparseEntry and Node classes
     * in order to operate a Sparse Matrix data structure. The class
     * has barebones capabilities such as adding, removing, and getting
     * objects within the Sparse Matrix, checking its size, and printing
     * it's contents in a string format.
     */
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
    public int size() {
        return listSize;
    }


    /**
     * Adds an entry in the matrix.
     *
     * @param row
     *            is what row the entry will be added to.
     * @param col
     *            is what column the entry will be addded to.
     * @param score
     *            is what rating the entry will have.
     */
    public void add(int row, int col, int score) 
    {
        Node current = head.next();
        while (current != tail) 
        {
            SparseEntry entry = current.getData();
            if (entry.getRow() > row || (entry.getRow() == row && 
                entry.getCol() > col)) 
            {
                // Insert before current
                SparseEntry newEntry = new SparseEntry(row, col, score);
                Node newNode = new Node(newEntry, current.prev(), current);
                current.prev().setNext(newNode);
                current.setPrev(newNode);
                listSize++;
                return;
            }
            // If an entry already exists with same row and col, update socre
            if (entry.getRow() == row && entry.getCol() == col) 
            {
                entry.setScore(score);
                return;
            }

            current = current.next();
        }

        // If entry is not found insert at the end
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
    public boolean isEmpty() {
        return (listSize == 0);
    }


    /**
     * Removes the object at the given position.
     * This method will find the specific node at (row, col) and
     * remove it from both the row and column linked lists by updating
     * the pointers of the nodes before and after it.
     *
     * @param row is the number of the row to look to remove from.
     * @param col is the number of the column to look to remove from.
     * @return true if the removal was successful.
     * @throws IndexOutOfBoundsException if there is not an element 
     * at the index.
     */
    public boolean removeIndex(int row, int col) 
    {
        Node current = head.next();

        while (current != tail) 
        {
            SparseEntry entry = current.getData();
            if (entry.getRow() == row && entry.getCol() == col) 
            {
                // Disconnect the node from the list
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                listSize--;
                return true;
            }
            current = current.next();
        }
        // No entry found in that position
        return false;
    }


    /**
     * This method with locate a reviewer in the Sparse
     * Matrix that is set to be removed, remove it, and 
     * then report true or false based on its success.
     * 
     * @param reviewer is what's to be removed
     * @return found, or true, if the reviewer to be
     * removed is found and successfully removed.
     */
    public boolean removeReviewer(int reviewer) 
    {
        boolean found = false;
        Node current = head.next();

        while (current != tail) 
        {
            SparseEntry entry = current.getData();

            if (entry.getRow() == reviewer) 
            {
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                listSize--;
                found = true;
            }
            current = current.next();

        }
        return found;
    }


    /**
     * This method with locate a movie in the Sparse
     * Matrix that is set to be removed, remove it, and 
     * then report true or false based on its success.
     * 
     * @param movie is what's to be removed
     * @return found, or true, if the reviewer to be
     * removed is found and successfully removed.
     */
    public boolean removeMovie(int movie) 
    {
        boolean found = false;
        Node current = head.next();

        while (current != tail) 
        {
            SparseEntry entry = current.getData();

            if (entry.getCol() == movie) 
            {
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                listSize--;
                found = true;
            }
            current = current.next();

        }
        return found;
    }


    /**
     * Gets the object at the given position
     * 
     * @param row is the number of row to look at.
     * @param col is the number of column to look at.
     * @return The object at the given position
     * @throws IndexOutOfBoundsException if no node is 
     * at the given index.
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
     * Removes all of the elements from the list
     */
    public void clear() 
    {
        tail = new Node(null, null); // Create trailer
        curr = tail;
        head = new Node(null, tail); // Create header
        listSize = 0;
    }

    /**
     * This methods reformats the Sparse Matrix data
     * structure and it's entries and prints it out 
     * into a string format.
     * @return builder.toString() which is the final
     * format of the Sparse Matrix in string format/
     */
    public String printRating() 
    {
        // Check if empty
        if (isEmpty()) 
        {
            return " ";
        }
        StringBuilder builder = new StringBuilder();
        Node current = head.next();
        int currentReviewer = -1;

        while (current != tail) 
        {
            SparseEntry entry = current.getData();

            // new reviewer
            if (entry.getRow() != currentReviewer) 
            {
                if (currentReviewer != -1) 
                {
                    builder.append("\n"); // newline before next reviewer
                }
                currentReviewer = entry.getRow();
                builder.append(currentReviewer).append(": ");
            }
            else
            {
                builder.append(" ");
            }
            builder.append("(").append(entry.getCol()).append(", ").append(entry
                .getScore()).append(")");
            current = current.next();
        }
        return builder.toString();
    }
    
    /**
     * This methods reformats the Sparse Matrix data
     * structure and it's entries and prints it out 
     * into a string format.
     * @param reviewer The reviewer to list ratings for
     * @return builder.toString() which is the final
     * format of the Sparse Matrix in string format/
     */
    public String printReviewer(int reviewer) 
    {
        
        StringBuilder builder = new StringBuilder();
        
        Node current = head.next();
        builder.append(reviewer).append(":");
        int count = 0;
        while (current != tail) 
        {
            SparseEntry entry = current.getData();
            
            if (entry.getRow() == reviewer && entry.getCol() > -1) 
            {
                
                builder.append(" ");
                builder.append(entry.getScore());
                count++;
                
            }
            current = current.next();
        }
        if (count == 0)
        {
            return null;
        }
        
        return builder.toString();
    }
    
    /**
     * This methods reformats the Sparse Matrix data
     * structure and it's entries and prints it out 
     * into a string format.
     * @param movie The reviewer to list ratings for
     * @return builder.toString() which is the final
     * format of the Sparse Matrix in string format/
     */
    public String printMovie(int movie) 
    {
        StringBuilder builder = new StringBuilder();
        
        Node current = head.next();
        builder.append(movie).append(":");
        int count = 0;
        while (current != tail) 
        {
            SparseEntry entry = current.getData();
            
            if (entry.getCol() == movie && entry.getRow() > -1) 
            {
                builder.append(" ");
                builder.append(entry.getScore());
                count++;
                
            }
            current = current.next();
        }
        if (count == 0)
        {
            return null;
        }
        return builder.toString();
    }  
    
    /**
     * 1)For each reviewer Y, look at each movie.
     * 2)If reviewers X and Y both rated a given movie, then
     *      add the absolute value of the difference to a sum.
     * 3)Once you sum up the difference for all movies
     *      that are rated by both reviewers, divide by the total number of movies sharing a review.
     * 4)This is the similarity score for the two reviewers. The “most similar” reviewer
     *      is the one with the lowest similarity score.
     * 5)If there are no movies that both rated, then define the similarity score to be -1.
     */
    public int similarReviewer(int reviewer)
    {
        Node current = head.next();
        int numMovie = 0;
        double currSimilarityScore = 0.0;
        double bestSimilarityScore = -1.0;
        int similarIndex = -1;
        while (current != tail)
        {
            SparseEntry reviewerEntry = current.getData();
            if (reviewerEntry.getRow() == reviewer && reviewerEntry.getCol() > -1)
            {
                // Get the movie that was reviewed
                int movie = reviewerEntry.getCol();
                double rating = reviewerEntry.getScore();
            
                // Find another reviewer for the movie that was rated
                Node innerCur = head.next();
                while (innerCur != tail)
                {
                    SparseEntry otherEntry = innerCur.getData();
                    if (otherEntry.getCol() == movie && otherEntry.getRow() != reviewer) 
                    {
                        // Save the other reviewer and their score
                        int otherReviewer = otherEntry.getRow();
                        double otherRating = otherEntry.getScore();
                    
                        // Calculate absolute difference
                        double scoreDifference = Math.abs(rating - otherRating);
                        numMovie++;
                        
                        // Calculate similarity score
                        currSimilarityScore = scoreDifference/numMovie;
                    }
                    innerCur = innerCur.next();
                }
                // Check is similarity score was the best.
                if (currSimilarityScore < bestSimilarityScore)
                {
                    // Replace best score with the current score.
                    bestSimilarityScore = currSimilarityScore;
                    // Set int to be returned as index of similar reviewer
                    similarIndex = reviewerEntry.getRow();
                }
                // Reset numMovie and currSimilarityScore
                
            }
            current = current.next(); 
        }
        return similarIndex;
    }
}
