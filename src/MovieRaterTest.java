import java.io.IOException;
import student.TestCase;

/**
 * This class runs a suite of test cases on the MovieRaterDB class as well as
 * the SparseMatrix class. Overall, the tests strive to have complete problem
 * and mutation coverage.
 * 
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.15.2025
 */
public class MovieRaterTest extends TestCase {

    private MovieRaterDB it;
    private SparseMatrix matrix;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        it = new MovieRaterDB();
        matrix = new SparseMatrix();
    }


    /**
     * Test clearing on initial
     * 
     * @throws IOException
     */
    public void testClearInit() throws IOException 
    {
        assertTrue(it.clear());
    }


    /**
     * Test empty print movie or reviewer
     * 
     * @throws IOException
     */
    public void testRefMissing() throws IOException
    {
        assertNull(it.listMovie(2));
        assertNull(it.listReviewer(3));
        assertFalse(it.deleteScore(5, 1));
        assertFalse(it.deleteReviewer(2));
        assertFalse(it.deleteMovie(2));
    }
     

    /**
     * Test insert two items and print
     * 
     * @throws IOException
     */
    public void testRefinsertTwo() throws IOException
    {
        assertTrue(it.addReview(2, 3, 7));
        assertTrue(it.addReview(2, 5, 5));
        assertFuzzyEquals(it.printRatings(), "2: (3, 7) (5, 5)");
        assertFuzzyEquals(it.listMovie(3), "3: 7");
        assertFuzzyEquals(it.listReviewer(2), "2: 7 5");
    }
     

    /**
     * Test bad review values
     * 
     * @throws IOException
     */
    public void testRefBadRatings() throws IOException
    {
        assertFalse(it.addReview(2, 3, -1));
        assertFalse(it.addReview(2, 4, 0));
        assertFalse(it.addReview(2, 5, 20));
        assertFuzzyEquals(it.printRatings(), "");
    }
     

    /**
     * Test insert 5 items and print
     * 
     * @throws IOException
     */
    public void testRefinsertFive() throws IOException
    {
        assertTrue(it.addReview(7, 3, 10));
        assertTrue(it.addReview(2, 3, 7));
        assertTrue(it.addReview(3, 5, 8));
        assertTrue(it.addReview(5, 7, 9));
        assertTrue(it.addReview(7, 7, 1));
        assertFuzzyEquals(
            multiline(
                "2: (3, 7)",
                "3: (5, 8)",
                "5: (7, 9)",
                "7: (3, 10) (7, 1)"),
                it.printRatings());
    }

    /**
     * Test the addReview() method
     */
    public void testAddReview() 
    {
        assertTrue(it.addReview(1, 2, 8));
        assertFalse(it.addReview(-1, 2, 8));
        assertFalse(it.addReview(1, -1, 8));
        assertFalse(it.addReview(1, 2, 0));
        assertFalse(it.addReview(1, 1, 11));
    }

    /**
     * Test the deleteReviewer() method
     */
    public void testDeleteReviewer() 
    {
        it.addReview(7, 3, 10);
        it.addReview(7, 3, 7);
        it.addReview(3, 5, 8);

        assertTrue(it.deleteReviewer(7));
        assertFalse(it.deleteReviewer(7));
        assertTrue(it.deleteReviewer(3));
    }

    /**
     * Test the deleteMovie() method
     */
    public void testDeleteMovie() 
    {
        it.addReview(3, 7, 10);
        it.addReview(2, 7, 7);
        it.addReview(5, 3, 8);

        assertTrue(it.deleteMovie(7));
        assertFalse(it.deleteMovie(7));
        assertTrue(it.deleteMovie(3));
    }

    /**
     * Test the deleteScore() method
     */
    public void testDeleteScore() 
    {
        it.addReview(3, 7, 10);
        it.addReview(3, 3, 6);
        it.addReview(5, 3, 8);

        assertTrue(it.deleteScore(3, 7));
        assertFalse(it.deleteScore(3, 7));
        assertTrue(it.deleteScore(5, 3));
    }
    
    /**
     * Tests the removeReviewer() method. In this test case,
     * we're working on mutation coverage for the line with:
     * listSize--
     * Specifically, replacing the int operation with the first
     * and second member.
     */
    public void testRemoveReviewerListSize()
    {
        // Set initial conditions:
        // Add 3 entries for reviewer 1
        matrix.add(1, 1, 5);
        matrix.add(1, 2, 7);
        matrix.add(1, 3, 9);
        // Add 1 entry for reviewer 2
        matrix.add(2, 1, 6);

        // Total size of the Sparse Matrix should be 4.
        assertEquals(matrix.size(), 4);

        // Call the method:
        // Remove reviewer #1, should return true.
        assertTrue(matrix.removeReviewer(1));
        
        // Only reviewer #2 and it's one entry should remain.
        assertEquals(matrix.size(), 1);

        // Use printRating() to confirm the remaining entry
        // comes from reviewer #2.
        String expected = "2: (1, 6)";
        assertEquals(expected, matrix.printRating());
    }

    /**
     * Tests the removeMovie() method. In this test case,
     * we're working on mutation coverage for the line with:
     * listSize--
     * Specifically, replacing the int operation with the first
     * and second member.
     */
    public void testRemoveMovieListSize()
    {
        // Set up initial conditions:
        // Add 2 entries for movie 1
        matrix.add(1, 1, 8);
        matrix.add(2, 1, 9);
        // Add 1 entry for movie 2
        matrix.add(1, 2, 7);

        // After adding 3 entries, size should be 3.
        assertEquals(matrix.size(), 3);
        
        // Call the method:
        // Remove movie #1, should return true.
        assertTrue(matrix.removeMovie(1));
        
        // Only one entry should now be in the Sparse Matrix.
        assertEquals(matrix.size(), 1);

        // Ensure the remaining entry comes from movie #2.
        SparseMatrix.SparseEntry remaining = matrix.get(1, 2);
        assertNotNull(remaining);
        assertEquals(remaining.getScore(), 7);

    }
    
    /**
     * Test case for the init() method. Ensures that the SparseMatrix
     * object is initalized correctly.
     */
    public void testInit() 
    {
        // SparseObject, matrix, was made in setUp() so init() was used
        // already in matrix.

        // listSize should equal 0.
        assertEquals(matrix.size(), 0);
    }


    /**
     * Tests the add() method. In this test case, this is the first
     * addition to the Sparse Matrix so there are no other entries
     * in the Sparse Matrix.
     */
    public void testAddSingle() 
    {
        // Call the method
        matrix.add(1, 1, 10);

        // listSize should've incremented to 1.
        assertEquals(matrix.size(), 1);

        // There should now be a new Node in the Sparse Matrix
        // where it is in Row 1, Column 1, with a score of 10.
        assertEquals(matrix.get(1, 1).getRow(), 1);
        assertEquals(matrix.get(1, 1).getCol(), 1);
        assertEquals(matrix.get(1, 1).getScore(), 10);
    }


    /**
     * Tests the add method. In this test case, we'll test a scenario
     * where we lower the row and column as we add elements to cover
     * mutation coverage in the situation where the equality/comparison
     * checks of our logical expression are false.
     */
    public void testAddMultiple() 
    {
        // Set up initial conditions, add 3 entries
        // to Sparse Matrix
        matrix.add(2, 5, 1);
        matrix.add(1, 5, 2); // Lower Row
        matrix.add(2, 4, 3); // Lower Column
        
        // Check that entries are in the correct order.
        String expected = "1: (5, 2)\n2: (4, 3) (5, 1)";
        assertEquals(expected, matrix.printRating());
    }

    /**
     * Tests the add() method. In this test case, we are adding a
     * entry to the row and column of an existing entry in
     * the Sparse Matrix.
     */
    public void testAddDuplicate() 
    {
        // Set up initial conditions, add 1 entry to the Sparse Matrix.
        matrix.add(3, 3, 10);

        // Size should be 1 and the score should equal 10
        assertEquals(matrix.size(), 1);
        assertEquals(matrix.get(3, 3).getScore(), 10);

        // Call the method, add to the same row and column
        // with a new score of 5.
        matrix.add(3, 3, 5);

        // Size should still be 1.
        assertEquals(matrix.size(), 1);

        // The score at (3, 3) should now be 5.
        assertEquals(matrix.get(3, 3).getScore(), 5);

        // New Scenario: We add on exact duplicate of the current entry,
        // same row, col, and score. Score should remain 5 and size 1.
        matrix.add(3, 3, 5);

        assertEquals(matrix.size(), 1);
        assertEquals(matrix.get(3, 3).getScore(), 5);
    }
    
    /**
     * Tests the get() method. Test scenarios where
     * you get entry that exists and several entries 
     * that don't exist in the Sparse Matrix.
     */
    public void testGet()
    {
        // Set initial conditions:
        // Add three entries to the Sparse Matrix.
        matrix.add(1, 1, 1);
        matrix.add(2, 2, 2);
        matrix.add(3, 3, 3);

        // Check that get() will not return null for
        // an existing entry.
        SparseMatrix.SparseEntry entry = matrix.get(2, 2);
        assertNotNull(entry);
        assertEquals(2, entry.getScore());

        // Check that get() will return null for
        // an entry with a nonexistent row.
        assertNull(matrix.get(1, 2));

        // Check that get() will return null for
        // an entry with a nonexistent column.
        assertNull(matrix.get(2, 1));

        // Check that get() will return null for
        // an entry with a nonexistent row and column.
        assertNull(matrix.get(4, 4));
    }


    /**
     * Tests the removeIndex() method. In this scenario, the method
     * will successfully remove an entry from the Sparse Matrix and
     * return true.
     */
    public void testRemoveIndexTrue() 
    {
        // Set initial conditions. Add three entries to Sparse Matrix
        matrix.add(1, 1, 10);
        matrix.add(5, 3, 5);
        matrix.add(3, 2, 7);

        // Call the method. Remove from (5, 3). Should return true.
        assertTrue(matrix.removeIndex(5, 3));

        // The entry at (5, 3) should now be gone.
        assertNull(matrix.get(5, 3));

        // The size of the Sparse Matrix should be 2 now.
        assertEquals(matrix.size(), 2);
    }

    /**
     * Test the removeIndex() method when false
     */
    public void testRemoveIndexFalse() 
    {
        // Set initial conditions. Add three entries to Sparse Matrix
        matrix.add(1, 1, 10);
        matrix.add(5, 3, 5);
        matrix.add(3, 2, 7);

        // Call the method. Remove from (6, 6). Should return false.
        assertFalse(matrix.removeIndex(6, 6));
        assertFalse(matrix.removeIndex(5, 5));
        assertFalse(matrix.removeIndex(3, 3));

        // The size of the Sparse Matrix should remain unchanged at 3.
        assertEquals(matrix.size(), 3);
    }

    /**
     * Tests the printRatings() method. Ensures that it works in a
     * scenario where multiple entries need to be formatted and printed.
     */
    public void testPrintRatings() 
    {
        it.addReview(2, 3, 7);
        it.addReview(3, 5, 8);
        it.addReview(7, 3, 10);
        it.addReview(7, 7, 1);
        it.addReview(5, 7, 9);
        String expected = "2: (3, 7)\n" + "3: (5, 8)\n" + "5: (7, 9)\n"
            + "7: (3, 10) (7, 1)";
        String actual = it.printRatings();
        assertEquals(expected, actual);
    }
    
    /**
     * Tests the listReviwer() method. Test case adds reviews,
     * calls the method, and expects that a list of the reviewer
     * with his movie and scores in ascending order are returned.
     */
    public void testListReviewer()
    {
        it.addReview(2, 3, 7);
        it.addReview(2, 5, 8);
        String expected = "2: 7 8";
        assertEquals(expected, it.listReviewer(2));
        assertNull(it.listReviewer(-1));
        assertNull(it.listReviewer(10));
    }
    
    /**
     * Tests the listReviwer() method. Test when entry.getCol() > -1 is false
     */
    public void testListReviewer2()
    {
        matrix.add(1, 1, 5);
        matrix.add(1, -1, 0);
        matrix.add(2, -1, 0);
        matrix.add(2, 1, 3);
        matrix.add(2, 2, 3); // false && true
        String expected = "1: 5";
        assertEquals(expected, matrix.printReviewer(1));
        assertEquals(expected, matrix.printReviewer(1));
    }
    /**
     * Tests the listMovie() method. Test case adds reviews, calls
     * the method, and expects a list of all reviewers of the movie and
     * their score in ascending order is returned.
     */
    public void testListMovie()
    {
        // Scenario 1: Successfully prints all reviews
        it.addReview(10, 3, 8);
        it.addReview(2, 3, 10);
        it.addReview(3, 3, 8);
        
        String expected1 = "3: 10 8 8";
        assertEquals(expected1, it.listMovie(3));
        
        // Scenario 2: Some values in the movie are not valid
        it.addReview(-1, 1, 7);
        it.addReview(3, 1, 6);
        it.addReview(0, 1, -1);
        it.addReview(5, 2, 5);
        
        String expected2 = "1: 6";
        assertEquals(expected2, it.listMovie(1));
        
        it.deleteScore(3, 1);
        assertNull(it.listMovie(1));
       
        // Scenario 3: Movie is less than 0 so returns null
        it.addReview(1, -1, 7);
        assertNull(it.listMovie(-1));
    }
    /**
     * Tests the printMovie() method. Test when entry.getCol() > -1 is false
     */
    public void testListMovie2()
    {
        matrix.add(1, 1, 5);
        matrix.add(-1, 1, 0);
        matrix.add(-1, 2, 0);
        matrix.add(1, 2, 3);
        matrix.add(2, 2, 3); // false && true
        String expected = "1: 5";
        assertEquals(expected, matrix.printMovie(1));
        assertEquals(expected, matrix.printMovie(1));
    }
    /**
     * Tests the similarReviewer() method. In this scenario, reviewer 2 
     * is most similar to reviewer 1. And when the target reviewer 
     * has no movies in common.
     */
    public void testSimilarReviewer()
    {
        it.addReview(1, 1, 5);
        it.addReview(1, 2, 4);
        it.addReview(2, 1, 4);
        it.addReview(2, 2, 3);
        it.addReview(3, 1, 1);
        it.addReview(4, 5, 8);
        
        assertEquals(2, it.similarReviewer(1));
        assertEquals(-1, it.similarReviewer(4));
        assertEquals(-1, it.similarReviewer(5));
    }
    
    /**
     * Tests the similarReviewer() method. In this scenario, there is a 
     * tie for most similar. Should return the reviewer 
     * with the lowest index.
     */
    public void testSimilarReviewer2()
    {
        it.addReview(1, 1, 5);
        it.addReview(2, 1, 6);
        it.addReview(3, 1, 6);
        
        assertEquals(2, it.similarReviewer(1));
    }
    
    
    /**
     * Tests the similarMovie() method. In this scenario, movie 2 
     * is most similar to movie 1.
     */
    public void testSimilarMovie()
    {
        it.addReview(1, 1, 5);
        it.addReview(1, 2, 4);
        it.addReview(2, 1, 4);
        it.addReview(2, 2, 3);
        it.addReview(3, 1, 1);
        it.addReview(4, 5, 8);
        
        assertEquals(2, it.similarMovie(1));
        assertEquals(-1, it.similarMovie(4));
        assertEquals(-1, it.similarMovie(10));
    }
    
    /**
     * Tests the similarMovie() method. In this scenario, there is a 
     * tie for most similar. Should return the movie 
     * with the lowest index.
     */
    public void testSimilarMovie2()
    {
        it.addReview(1, 1, 5);
        it.addReview(1, 2, 6);
        it.addReview(2, 3, 3);
        it.addReview(2, 2, 2);
        it.addReview(3, 3, 1);
        
        assertEquals(2, it.similarMovie(1));
  
    }
    /**
     * Tests the printRatings() method. In this scenario, the Sparse
     * Matrix is empty so an empty string should be printed.
     */
    public void testPrintEmpty()
    {
        // Initial condition. No entries added to the Sparse Matrix.
        
        // Call the method.
        String expected = " ";
        String actual = it.printRatings();
        
        // Since the Sparse Matrix is empty, " " should be returned.
        assertEquals(expected, actual);
    }
}
