import student.TestCase;
import java.util.*;
import SparseMatrix.SparseEntry;
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
        
        // The head and tail nodes should both be null
        //assertNull(matrix.getPrev());
        //assertNull(matrix.get());
        
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
     * Tests the add() method. In this test case, there are several
     * additions to the Sparse Matrix so there are multiple entries
     * in the Sparse Matrix.
     */
    public void testAddMultiple()
    {
        // Call the method, add 3 entries to the Sparse Matrix.
        matrix.add(1, 1, 10);
        matrix.add(5, 3, 5);
        matrix.add(3, 2, 7);
        
        // Check if Entry 1 (1, 1, 10) is accurate.
        assertEquals(matrix.get(1, 1).getRow(), 1);
        assertEquals(matrix.get(1, 1).getCol(), 1);
        assertEquals(matrix.get(1, 1).getScore(), 10);
        
        // Check if Entry 2 (5, 3, 5) is accurate.
        assertEquals(matrix.get(5, 3).getRow(), 5);
        assertEquals(matrix.get(5, 3).getCol(), 3);
        assertEquals(matrix.get(5, 3).getScore(), 5);
        
        // Check if Entry 3 (3, 2, 7) is accurate.
        assertEquals(matrix.get(3, 2).getRow(), 3);
        assertEquals(matrix.get(3, 2).getCol(), 2);
        assertEquals(matrix.get(3, 2).getScore(), 7);
    }
    
}
