import com.sun.tools.javac.util.ArrayUtils;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by Soren on 08/09/15.
 */
public class ArrayUtilitiesTest {

    private ArrayUtilities arrayUtilities = new ArrayUtilities();

    @Test
    public void veryfyPostitionOfSubArray() {
        //Given
        Integer[] array = {2,3,4,5};
        Integer[] subArray = {4,5};
        //When
        int actual = arrayUtilities.findArray(array, subArray);
        //Then
        assertThat(actual, is(2));
    }
}