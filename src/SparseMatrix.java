import java.util.HashMap;

/**
 * Implementation of a sparse matrix. This will be used as the data structure
 * for our MovieRater. 
 * 
 * @author Henry Patch (hjpatch27), Nyssa Loeu (nyssal23)
 * @version 9.7.2025
 */
public class SparseMatrix 
{
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size()
    {
        return 0;
    }
    
    /**
     * Adds the object to the position in the list
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
    public void add(int index, int obj)
    {
        
    }
    
    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty()
    {
        return (size == 0);
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
    public boolean removeObject(int obj)
    {
        return true;
    }
    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public boolean removeIndex(int index)
    {
        return true;
    }
    
    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    public int get(int index)
    {
        return 0;
    }
    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    public boolean contains(int obj)
    {
        return true;
    }
    
    /**
     * Removes all of the elements from the list
     */
    public void clear()
    {
        
    }
}
