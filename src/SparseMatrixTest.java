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
    public void testRow()
    {
        // SparseObject, matrix, was made in setUp() so init() was used
        // already in matrix.
        
        // listSize should equal 0.
        assertEquals(matrix.size(), 0);
        
        // The
        
    }
    
}
