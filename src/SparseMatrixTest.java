import student.TestCase;

/**
 * This class runs a suite of test cases for the SparseMatrix class,
 * including the Node and SparseEntry classes as well.
 * Overall, the tests strive to have complete code and mutation coverage.
 * 
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.8.2025
 */
public class SparseMatrixTest extends TestCase {

    private SparseMatrix matrix; 
    
    /**
     * Sets up the tests that follow. Used to initialize a SparseMatrix
     * object for the upcoming test cases.
     */
    public void setUp()
    {
        matrix = new SparseMatrix(); // Initialize SparseMatrix object.
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
     * Tests the clear() method. We will test this by adding
     * entries to the Sparse Matrix, using the clear() method,
     * and then ensuring the expected results happen.
     */
    public void testClear()
    {
        // Set up initial conditions, add 3 entries to the Sparse Matrix.
        matrix.add(1, 1, 10);
        matrix.add(5, 3, 5);
        matrix.add(3, 2, 7);
        
        // size should be 3 at the moment.
        assertEquals(matrix.size(), 3);
        
        // Call the method
        matrix.clear();
        
        // size should now be zero
        assertEquals(matrix.size(), 0);
        assertTrue(matrix.isEmpty());
        
        // If we used the get() method on a entry previously added,
        // then nothing should come up so get() should return null.
        assertNull(matrix.get(1, 1));
        assertNull(matrix.get(5, 3));
        assertNull(matrix.get(3, 2));
    }
    
}
