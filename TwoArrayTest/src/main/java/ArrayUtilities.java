import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Soren on 08/09/15.
 */
public class ArrayUtilities {


    /**
     * Finds the starting position of the sub array inside the array
     *
     * @param array
     * @param subArray
     * @return index of sub array
     */
    public static int findArray(Integer[] array, Integer[] subArray)
    {

        if (array.length == 0 || subArray.length == 0) {
            return -1;
        }

        return Collections.indexOfSubList(Arrays.asList(array), Arrays.asList(subArray));
    }
}
