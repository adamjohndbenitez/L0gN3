package citi.karat.Hbinarysearch;

public class ABinarySearch {
    public static int binarySearch(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2; // since a Java int can only hold values up to: 2,147,483,647  - looking at this edge-case: enormous value in array 2_000_000_000, compute only (left + right) (2_000_000_000 + 2_000_000_000) you'll get 4,100,000 so the integer overflow

            if (nums[mid] == target) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {2, 4, 6, 8, 10, 12, 14};

        int index = binarySearch(nums, 10);

        System.out.println(index);
    }
}


class ABinarySearchAJKarat {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        int[] nums = {2, 4, 6, 8, 10, 12, 14};
        int index = binarySearch(nums, 10);
        System.out.println(index);
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // just to prevent integer overflow, java int only holds 2,147,483,647

            // integer division in Java discards the decimal part so No, mid will never be a decimal ex. 5 / 2 = 2.5 Java simply drops the (.5) so 5 / 2 = 2

            // Integer division chooses the left middle. There are 6 elements, so the two middle indices are 2 and 3. So it chooses index 2.
            // interview problem require the right middle instead:
            //int mid = left + (right - left + 1) / 2;


            if (nums[mid] == target) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}