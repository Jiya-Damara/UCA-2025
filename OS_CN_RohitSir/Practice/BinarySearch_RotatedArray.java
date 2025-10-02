public class BinarySearch_RotatedArray {
  /**
   * Given a sorted array that is rotated at some pivot (with no duplicate values), find the index of a target value. If the target is not found, return -1.
   *
   * Example: [4, 5, 6, 7, 0, 1, 2], target = 0 -> returns 4.
   *
   * @param nums - Rotated sorted integer array (no duplicates).
   * @param target - The integer to search for.
   * @returns int - Index of target or -1 if not found.
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[left] < nums[mid]) {
        if (nums[left] <= target && nums[mid] > target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && nums[right] >= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return (nums[left] == target) ? left : -1;
  }

  /**
   * Main method for testing the SearchInRotatedSortedArray class.
   */
  public static void main(String[] args) {
    BinarySearch_RotatedArray s = new BinarySearch_RotatedArray();
    int[] arr1 = {4, 5, 6, 7, 0, 1, 2};
    assert s.search(arr1, 0) == 4 : "Test case 1 failed";
    assert s.search(arr1, 3) == -1 : "Test case 2 failed";
    int[] arr2 = {3, 1};
    assert s.search(arr2, 3) == 0 : "Test case 3 failed";
  }
}
