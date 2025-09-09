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
    
    public void testAdd()
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
    
}
