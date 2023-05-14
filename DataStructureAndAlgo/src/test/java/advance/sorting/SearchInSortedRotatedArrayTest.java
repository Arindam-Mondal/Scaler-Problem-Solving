package advance.sorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SearchInSortedRotatedArrayTest {

    @DisplayName("Searching in Rotated array when the element is present in the array")
    @Test
    void searchTestPositive(){

        int[] inputArray = {4,5,6,7,0,1,2};
        int target = 4;

        SearchInSortedRotatedArray searchInSortedRotatedArray = new SearchInSortedRotatedArray();

        int result = searchInSortedRotatedArray.search(inputArray,target);

        Assertions.assertTrue(result==0);
    }

    @DisplayName("Searching in Rotated array when the element is not present in the array")
    @Test
    void searchTestNegative(){

        int[] inputArray = {4,5,6,7,0,1,2};
        int target = 15;

        SearchInSortedRotatedArray searchInSortedRotatedArray = new SearchInSortedRotatedArray();

        int result = searchInSortedRotatedArray.search(inputArray,target);

        Assertions.assertTrue(result==-1);
    }
}
