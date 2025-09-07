import java.io.IOException;
import student.TestCase;

/**
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.7.2025
 */
public class MovieRaterTest extends TestCase {

    private MovieRaterDB it;

    /**
     * Sets up the tests that follow. In general, used for initialization
     */
    public void setUp() {
        it = new MovieRaterDB();
    }

    /**
     * Test clearing on initial
     * @throws IOException
     */   
    /**
     * Commented out for Milestone 1.
     *
    public void testClearInit()
        throws IOException
    {
        assertTrue(it.clear());
    }
    */
    
    /**
     * Test empty print movie or reviewer
     * @throws IOException
     */  
    /**
     * Commented out for Milestone 1.
     * 
    public void testRefMissing()
        throws IOException
    {
        assertNull(it.listMovie(2));
        assertNull(it.listReviewer(3));
        assertFalse(it.deleteScore(5, 1));
        assertFalse(it.deleteReviewer(2));
        assertFalse(it.deleteMovie(2));
    }
    */

    /**
     * Test insert two items and print
     * @throws IOException
     */   
    /**
     * Commented out for Milestone 1.
     * 
    public void testRefinsertTwo()
        throws IOException
    {
        assertTrue(it.addReview(2, 3, 7));
        assertTrue(it.addReview(2, 5, 5));
        assertFuzzyEquals(it.printRatings(), "2: (3, 7) (5, 5)");
        assertFuzzyEquals(it.listMovie(3), "3: 7");
        assertFuzzyEquals(it.listReviewer(2), "2: 7 5");
    }
    */

    /**
     * Test bad review values
     * @throws IOException
     */
    /**
     * Commented out for Milestone 1.
     * 
    public void testRefBadRatings()
        throws IOException
    {
        assertFalse(it.addReview(2, 3, -1));
        assertFalse(it.addReview(2, 4, 0));
        assertFalse(it.addReview(2, 5, 20));
        assertFuzzyEquals(it.printRatings(), "");
    }
    */

    /**
     * Test insert 5 items and print
     * @throws IOException
     */
    /**
     * Commented out for Milestone 1.
     * 
    public void testRefinsertFive()
        throws IOException
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
    */
}
