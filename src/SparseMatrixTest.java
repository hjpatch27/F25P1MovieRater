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
    private SparseEntry entry;
    
    /**
     * Sets up the tests that follow. Used to initialize a SparseMatrix
     * object for the upcoming test cases.
     */
    public void setUp()
    {
        matrix = new SparseMatrix(); // Initialize SparseMatrix object.
        entry = new SparseEntry(1, 1, 10); // Initialize SparseEntry object.
    }
    
    /**
     * Test case for the getter and setter method of the row variable
     * in the SparseEntry object.
     */
    public void testRow()
    {
        // SparseEntry object, entry, has row set to 1 in constructor
        assertEquals(entry.getRow(), 1);
    }
    
}
