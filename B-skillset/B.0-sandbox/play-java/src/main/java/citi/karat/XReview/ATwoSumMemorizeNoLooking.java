package citi.karat.XReview;

import java.util.Arrays;

public class ATwoSumMemorizeNoLooking {
    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        // 1st inputs
        int[][] inputs = {
                {1, 2, 3, 4},
                {-1, -2, -3, -4},
                {10, 20, 30, 40},
                {99, 99}
        };
        int[] target = {
                7,
                -7,
                70,
                0
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i+1) + "\tInput:" + Arrays.toString(inputs[i]) + "\tTarget: " + target[i]);
            int[] result = twoSumUsingBinarySearch2(inputs[i], target[i]);
            System.out.println("\tResult: " + Arrays.toString(result));
            System.out.println("-----------------------------------");
        }
    }

    private static int[] twoSumBruteForce(int[] input, int k) {
        int[] result = new int[2];
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] + input[j] == k) {
                    result[0] = input[i];
                    result[1] = input[j];
                    return result;
                }
            }
        }
        return result;
    }
    private static int[] twoSumBruteForce0(int[] input, int target) {
        int[] result = new int[2]; //[0,0]
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    result[0] = input[i]; //1st addend
                    result[1] = input[j]; //2nd addend
                    return result;
                }
            }
        }
        return result;
    }
    private static int[] twoSumBruteForce1(int[] input, int target) {
        int[] result = new int[2];
        if (input.length < 2) {
            return result;
        }
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length; j++) {
                if (input[i] + input[j] == target) {
                    return new int[]{i, j}; //only index of the addends
                }
            }
        }
        return result;
    }
    private static int[] twoSumUsingTwoPointers(int[] nums, int k) {
        int[] result = new int[2];
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sumVal = nums[left] + nums[right];
            if (sumVal < k) {
                left++;
            }
            else if (sumVal > k) {
                right--;
            }
            else {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            }
        }

        return result;
    }
    private static int[] twoSumUsingTwoPointers0(int[] input, int target) {
        int[] result = new int[2];
        Arrays.sort(input); //Sorting an array typically takes O(n log n) linearithmic time
        int left = 0;
        int right = input.length - 1;
        while (left < right) {
            int sum = input[left] + input[right];
            if (sum < target) {
                left = left + 1; //left++
            } else if (sum > target) {
                right = right - 1; //right--
            } else {
                result[0] = input[left];
                result[1] = input[right];
                break;
            }
        }
        return result;
    }
    private static int[] twoSumUsingTwoPointers1(int[] input, int target) {
        int[] result = new int[2]; //[0,0]
        int left = 0;
        int right = input.length-1;
        Arrays.sort(input);
        while (left < right) {
            int sum = input[left] + input[right];
            if (sum < target) {
                left = left + 1;
            } else if (sum > target) {
                right = right - 1;
            } else {
                result[0] = input[left];
                result[1] = input[right];
                break;
            }
        }
        return result;
    }
    private static int[] twoSumUsingTwoPointers2(int[] input, int target) {
        int[] result = new int[2]; //[0,0]
        int left = 0;
        int right = input.length-1;
        Arrays.sort(input); // O(n log n) linearithmic time complexity, since it divides into smaller halves then process all elements
        while (left < right) { //why? left < right? we need 2 elements: input[left] & input[right]
            int sum = input[left] + input[right];
            if (sum < target) {
                left = left+1;
            } else if (sum > target) {
                right = right-1;
            } else {
                //why? while(left < right)? we need 2 elements: input[left] & input[right]
                result[0] = input[left];
                result[1] = input[right];
                break;
            }
        }
        return result;
    }
    public static int[] twoSumUsingBinarySearch(int[] nums, int k) {
        int[] result = new int[2];
        Arrays.sort(nums);
        for (int j = 0; j < nums.length; j++) {
            int complement = k - nums[j];
            int first = 0;
            int last = nums.length - 1;

            while (first <= last) {
                int mid = (first + last) / 2;
                if (nums[mid] == complement) {
                    return new int[]{nums[j], complement};
                } else if (complement < nums[mid]) {
                    last = mid - 1;
                } else {
                    first = mid + 1;
                }
            }
        }
        return result;
    }
    private static int[] twoSumUsingBinarySearch0(int[] input, int target) {
        int[] result = new int[2];
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            int first = 0;
            int last = input.length-1;
            while (first <= last) {
                int mid = (first + last) / 2;
                if (complement < input[mid]) {
                    last = mid - 1;
                } else if (complement > input[mid]) {
                    first = mid + 1;
                } else { // complement == input[mid]
                    result[0] = input[i];
                    result[1] = complement;
                    break;
                }
            }
        }
        return result;
    }
    private static int[] twoSumUsingBinarySearch1(int[] input, int target) {
        int[] result = new int[2];
        Arrays.sort(input); //O(n log n) linearithmic
        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            int first = 0;
            int last = input.length - 1;
            while (first <= last) { //why? first <= last? we need 1 element: complement
                int mid = (first + last) / 2; // middle index
                if (complement < input[mid]) {
                    last = mid - 1;
                } else if (complement > input[mid]) {
                    first = mid + 1;
                } else {
                    //why? while(first <= last)? we need 1 element: complement
                    result[0] = input[i];
                    result[1] = complement;
                    break;
                }
            }
        }
        return result;
    }

    private static int[] twoSumUsingBinarySearch2(int[] input, int target) {
        int[] result = new int[2];
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            int complement = target - input[i];
            int first = 0; //left
            int last = input.length - 1; //right
            while (first <= last) {
                int mid = (first + last) / 2;
                if (complement < input[mid]) {
                    last = mid - 1;
                } else if (complement > input[mid]) {
                    first = mid + 1;
                } else {
                    result[0] = input[i];
                    result[1] = complement;
                    break;
                }
            }
        }
        return result;
    }
}
