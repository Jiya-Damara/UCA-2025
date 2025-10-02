public class BS_SearchInBitonicArray {
  /**
   * A bitonic array is first strictly increasing then strictly decreasing. 
   * Given such a bitonic array and a target value, return the index of the target if it exists, otherwise return -1.
   *
   * Example: [1, 3, 8, 12, 4, 2], target = 4 -> returns 4.
   *
   * @param nums - Bitonic array of integers (length >= 3).
   * @param target - The integer to search for.
   * @returns int - Index of target or -1 if not found.
   */
  public int searchBitonic(int[] nums, int target) {
    int n = nums.length;
    int peekEle = findPeek(nums, n);

    int left = binarySearch(nums, 0, peekEle, target, true);
    if (left != -1) return left;

    return binarySearch(nums, peekEle + 1, n - 1, target, false);
  }

  private int findPeek(int[] nums, int n) {
    int left = 0, right = n - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < nums[mid + 1]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  private int binarySearch(int[] nums, int left, int right, int target, boolean asc) {
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) return mid;
      if (asc) {
        if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
      } else {
        if (nums[mid] < target) right = mid - 1;
        else left = mid + 1;
      }
    }
    return -1;
  }

  /**
   * Main method for testing the SearchInBitonicArray class.
   */
  public static void main(String[] args) {
    BS_SearchInBitonicArray s = new BS_SearchInBitonicArray();
    int[] arr = {1, 3, 8, 12, 4, 2};
    assert s.searchBitonic(arr, 4) == 4 : "Test case 1 failed";
    assert s.searchBitonic(arr, 12) == 3 : "Test case 2 failed";
    assert s.searchBitonic(arr, 5) == -1 : "Test case 3 failed";
    assert s.searchBitonic(arr, 1) == 0 : "Test case 4 failed";
  }
}
