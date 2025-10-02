public class BS_RotatedArrayWithDuplicates {
  /**
   * Given a sorted array that is rotated at some pivot and may contain duplicates, find the index of a target value. If the target is not found, return -1.
   *
   * Example: [2, 5, 6, 0, 0, 1, 2], target = 0 -> returns 3 or 4.
   *
   * @param nums - Rotated sorted integer array (may contain duplicates).
   * @param target - The integer to search for.
   * @returns int - Index of target or -1 if not found.
   */
  public int search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      if (nums[mid] == target) {
        return mid;
      } else if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
        left ++;
        right --;
      }else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && nums[mid] > target) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[right] >= target && nums[mid] <= target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }

  /**
   * Main method for testing the SearchInRotatedSortedArrayWithDuplicates class.
   */
  public static void main(String[] args) {
    BS_RotatedArrayWithDuplicates s = new BS_RotatedArrayWithDuplicates();
    int[] arr1 = {2, 5, 6, 0, 0, 1, 2};
    assert (s.search(arr1, 0) == 3 || s.search(arr1, 0) == 4) : "Test case 1 failed";
    int[] arr2 = {2, 2, 2, 3, 4, 2};
    assert s.search(arr2, 3) == 3 : "Test case 2 failed";
    assert s.search(arr2, 5) == -1 : "Test case 3 failed";
  }
}


