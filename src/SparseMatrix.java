/**
 * Implementation of a sparse matrix. Utilizing a doubly-linked list,
 * this will be used as the data structure for our MovieRater.
 * 
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.18.2025
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
         * @return row, the number of the row the entry is in.
         */
        public int getRow() {
            return row;
        }


        /**
         * Returns the column number of the entry in the Sparse Matrix.
         * @return col, the number of the column the entry is in.
         */
        public int getCol() {
            return col;
        }

        /**
         * Returns the value of the entry in the Sparse Matrix.
         * @return score, the integer value the entry contains.
         */
        public int getScore() {
            return score;
        }

        /**
         * Sets the score to a new value in the Sparse Matrix.
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
         * @return the next node.
         */
        public Node next() {
            return next;
        }

        /**
         * Sets the next node to a new node.
         * @param n is the node after the current one.
         */
        public Node setNext(Node n) {
            next = n;
            return next;
        }

        /**
         * Gets and returns the previous node.
         * @return prev, the previous node.
         */
        public Node prev() {
            return prev;
        }

        /**
         * Sets the previous node to a new node.
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
    }

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
    public SparseMatrix() {
        init();
    }

    /**
     * Initializes the object to have the head and tail nodes
     */
    private void init() {
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
     * Adds an entry to the sparse matrix.
     *
     * @param row is what row the reviewer entry will be added to.
     * @param col is what column the movie entry will be addded to.
     * @param score is what rating the entry will have.
     */
    public void add(int row, int col, int score) {
        Node current = head.next();
        while (current != tail) { // Iterate through the linked list
            SparseEntry entry = current.getData();
            // Find the correct insertion point for the new entry
            if (entry.getRow() > row || (entry.getRow() == row && 
                entry.getCol() > col)) {
                // newEntry should come before the current node
                SparseEntry newEntry = new SparseEntry(row, col, score);
                Node newNode = new Node(newEntry, current.prev(), current);
                // Link the new node into the list
                current.prev().setNext(newNode);
                current.setPrev(newNode);
                listSize++; // Update the size 
                return;
            }
            // If an entry already exists with same row and col, update score
            if (entry.getRow() == row && entry.getCol() == col) {
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
     * @return true if the removal was successful and false otherwise
     */
    public boolean removeIndex(int row, int col) {
        Node current = head.next();
        // Iterate through the list until the tail is reached
        while (current != tail) {
            SparseEntry entry = current.getData();
            // Check if the current entry matches the target to be removed
            if (entry.getRow() == row && entry.getCol() == col) {
                // Disconnect the node from the list
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                listSize--; // Decrement the matrix size
                return true;
            }
            current = current.next(); // Move to the next node
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
    public boolean removeReviewer(int reviewer) {
        boolean found = false; // Track if any entries have been removed yet
        Node current = head.next();
        // Iterate through the list to find and remove the specified entry
        while (current != tail) {
            SparseEntry entry = current.getData();
            // If the current entry matches the target reviewer
            if (entry.getRow() == reviewer) {
                // Unlink the current node from the list
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                listSize--; // Decrement matrix size
                found = true; // Set found to true since node has been removed
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
    public boolean removeMovie(int movie) {
        boolean found = false; // Track if any entries have been removed yet
        Node current = head.next();
     // Iterate through the list to find and remove the specified entry
        while (current != tail) {
            SparseEntry entry = current.getData();
            // If the current entry matches the target movie
            if (entry.getCol() == movie) {
                // Unlink the current node from the list
                current.prev().setNext(current.next());
                current.next().setPrev(current.prev());
                listSize--; // Decrement matrix size
                found = true; // Set found to true since node has been removed
            }
            current = current.next();
        }
        return found;
    }

    /**
     * Gets the entry at the specified row and column
     * 
     * @param row is the row index of the entry to find
     * @param col is the column index of the entry to find
     * @return The object at the given position and null if not found
     */
    public SparseEntry get(int row, int col) {
        Node current = head.next();
        while (current != tail) { 
            SparseEntry entry = current.getData();
            // Check if the current entry's row and col matches the entry to get
            if (entry.getRow() == row && entry.getCol() == col) {
                // If current data is equal to the wanted than return current
                return current.getData();
            }
            current = current.next();
        }
        return null; // Did not find the entry
    }

    /**
     * This methods reformats the Sparse Matrix data
     * structure and it's entries and prints it out 
     * into a string format.
     * @return builder.toString() which is the final
     * format of the Sparse Matrix in string format/
     */
    public String printRating() {
        // Check if empty
        if (isEmpty()) {
            return " ";
        }
        StringBuilder builder = new StringBuilder();
        Node current = head.next();
        int currentReviewer = -1; // Keep track of the current reviewer

        while (current != tail) {
            SparseEntry entry = current.getData();
            // Check if a new reviewer's ratings is starting
            if (entry.getRow() != currentReviewer) {
                // If its not the first reviewer, add a new line for format
                if (currentReviewer != -1) {
                    builder.append("\n");
                }
                // Update the current reviewer and append their index to string
                currentReviewer = entry.getRow();
                builder.append(currentReviewer).append(": ");
            }
            else { // If it is the same reviewer then add a space to separate
                builder.append(" ");
            }
            // Append the movie and score into string with format "( , )"
            builder.append("(").append(entry.getCol()).append(", ").append(entry
                .getScore()).append(")");
            current = current.next();
        }
        return builder.toString(); // Return the string
    }
    
    /**
     * This methods reformats the Sparse Matrix data
     * structure and it's entries and prints it out 
     * into a string format.
     * @param reviewer The reviewer to list ratings for
     * @return builder.toString() which is the final
     * format of the Sparse Matrix in string format
     */
    public String printReviewer(int reviewer) {
        // Return null for invalid input
        if (reviewer < 0) {
            return null;
        }
        
        StringBuilder builder = new StringBuilder();
        
        Node current = head.next();
        // Append the reviewers index
        builder.append(reviewer).append(":");
        int count = 0; // Keep track of ratings found for the reviewer index
        while (current != tail) {
            SparseEntry entry = current.getData();
            // Check if the current entry matches the reviewer
            if (entry.getRow() == reviewer && entry.getCol() > -1) {
                
                builder.append(" ");
                builder.append(entry.getScore());
                count++;     
            }
            current = current.next();
        }
        // If no ratings were found, return null
        if (count == 0) {
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
     * format of the Sparse Matrix in string format.
     */
    public String printMovie(int movie) {
        // Return null for invalid input
        if (movie < 0)
        {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        
        Node current = head.next();
        // Append the movie index
        builder.append(movie).append(":");
        int count = 0;
        while (current != tail) {
            SparseEntry entry = current.getData();
            // Check if the current entry matches the movie index
            if (entry.getCol() == movie && entry.getRow() > -1) {
                builder.append(" ");
                builder.append(entry.getScore());
                count++;
            }
            current = current.next();
        }
        // If no ratings were found, return null
        if (count == 0) {
            return null;
        }
        return builder.toString();
    }  
    
    /**
     * Finds the reviewer most similar to the specified one.
     * 
     * @param reviewer is the row number in the Sparse Matrix, or
     * reviewer to be comparing to
     * @return similarIndex which will be the index of the row,
     * or reviewer which is the most similar to one we're provided.
     */
    public int similarReviewer(int reviewer)
    {
        double bestSimilarityScore = Double.MAX_VALUE;
        int similarReviewer = -1;

        // Iterate through all possible other reviewers
        Node otherReviewerNode = head.next();
        while (otherReviewerNode != tail) {
            SparseEntry otherReviewerEntry = otherReviewerNode.getData();
            int otherReviewer = otherReviewerEntry.getRow();

         // Skip the main reviewer
            if (otherReviewer == reviewer) 
            {
                otherReviewerNode = otherReviewerNode.next();
                continue;
            }

            double scoreDifference = 0.0;
            int numMovie = 0;

            // Find shared movies between reviewer and otherReviewer
            Node reviewerNode = head.next();
            while (reviewerNode != tail) {
                SparseEntry mainReviewerEntry = reviewerNode.getData();
                if (mainReviewerEntry.getRow() == reviewer) {
                    int movie = mainReviewerEntry.getCol();
                    double rating = mainReviewerEntry.getScore();

                    // Find the rating of otherReviewer for the same movie.
                    Node innerOtherReviewerNode = head.next();
                    while (innerOtherReviewerNode != tail) {
                        SparseEntry innerOtherEntry = 
                            innerOtherReviewerNode.getData();
                        if (innerOtherEntry.getRow() == otherReviewer && 
                            innerOtherEntry.getCol() == movie) {
                            double otherRating = innerOtherEntry.getScore();

                            // Compute the difference
                            scoreDifference += Math.abs(rating - otherRating);
                            numMovie++;
                        }
                        innerOtherReviewerNode = innerOtherReviewerNode.next();
                    }
                }
                reviewerNode = reviewerNode.next();
            }

            // Calculate similarityScore for current pair if they share movie
            if (numMovie > 0) {
                double currSimilarityScore = scoreDifference / numMovie;

                // Check if current is best score. A tie goes to lower index.
                if (currSimilarityScore < bestSimilarityScore) { 
                    bestSimilarityScore = currSimilarityScore;
                    similarReviewer = otherReviewer;
                }
            }
            otherReviewerNode = otherReviewerNode.next();
        }
        return similarReviewer;    
    }
    
    /**
     * Finds the movie that is most similar to the specified one.
     * 
     * @param movie is the column number in the Sparse Matrix, or
     * movie to be comparing to.
     * @return similarIndex which will be the index of the row,
     * or reviewer which is the most similar to one we're provided.
     */
    public int similarMovie(int movie)
    {
        double bestSimilarityScore = Double.MAX_VALUE;
        int similarReviewer = -1;

        // Iterate through all possible other reviewers
        Node otherMovieNode = head.next();
        while (otherMovieNode != tail) {
            SparseEntry otherMovieEntry = otherMovieNode.getData();
            int otherMovie = otherMovieEntry.getCol();

            // Skip the main reviewer and any entries that are empty
            if (otherMovie == movie) {
                otherMovieNode = otherMovieNode.next();
                continue;
            }

            double scoreDifference = 0.0;
            int numMovie = 0;

            // Find shared movies between reviewer and otherReviewer
            Node movieNode = head.next();
            while (movieNode != tail) {
                SparseEntry mainMovieEntry = movieNode.getData();
                if (mainMovieEntry.getCol() == movie) {
                    int reviewer = mainMovieEntry.getRow();
                    double rating = mainMovieEntry.getScore();

                    // Find the rating of otherReviewer for the same movie.
                    Node innerOtherMovieNode = head.next();
                    while (innerOtherMovieNode != tail) {
                        SparseEntry innerOtherEntry = 
                            innerOtherMovieNode.getData();
                        if (innerOtherEntry.getCol() == otherMovie && 
                            innerOtherEntry.getRow() == reviewer) {
                            double otherRating = innerOtherEntry.getScore();

                            // Compute the difference
                            scoreDifference += Math.abs(rating - otherRating);
                            numMovie++;
                        }
                        innerOtherMovieNode = innerOtherMovieNode.next();
                    }
                }
                movieNode = movieNode.next();
            }

            // Calculate similarityScore for current pair if they share movie
            if (numMovie > 0) {
                double currSimilarityScore = scoreDifference / numMovie;

                // Check if current is best score. A tie goes to lower index.
                if (currSimilarityScore < bestSimilarityScore) {
                    bestSimilarityScore = currSimilarityScore;
                    similarReviewer = otherMovie;
                }
            }
            otherMovieNode = otherMovieNode.next();
        }
        return similarReviewer; 
    }
}