public class BS_SearchInsertPosition {
  /**
   * Given a sorted array of distinct integers and a target value, return the index if the target is found. 
   * If not, return the index where it would be if inserted in order.
   *
   * Example: [1, 3, 5, 6], target = 5 -> returns 2; target = 2 -> returns 1.
   *
   * @param nums - Sorted integer array (distinct values).
   * @param target - The integer to search for or insert.
   * @returns int - Index of target or insertion position.
   */
  public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }

  /**
   * Main method for testing the SearchInsertPosition class.
   */
  public static void main(String[] args) {
    BS_SearchInsertPosition s = new BS_SearchInsertPosition();
    int[] arr = {1, 3, 5, 6};
    assert s.searchInsert(arr, 5) == 2 : "Test case 1 failed";
    assert s.searchInsert(arr, 2) == 1 : "Test case 2 failed";
    assert s.searchInsert(arr, 7) == 4 : "Test case 3 failed";
    assert s.searchInsert(arr, 0) == 0 : "Test case 4 failed";
  }
}
