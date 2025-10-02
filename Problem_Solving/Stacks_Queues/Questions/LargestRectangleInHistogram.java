// Java program to find the largest rectangular area possible 
// in a given histogram 

import java.util.Stack;

public class LargestRectangleInHistogram {

    // Function to find next smaller for every element
    static int[] nextSmaller(int[] arr) {
        int n = arr.length;

        // Initialize with n for the cases when next smaller
        // does not exist
        int[] nextS = new int[n];
        for (int i = 0; i < n; i++) {
            nextS[i] = n;
        }

        Stack<Integer> st = new Stack<>();

        // Traverse all array elements from left to right
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {

                // Setting the index of the next smaller element
                // for the top of the stack
                nextS[st.pop()] = i;
            }
            st.push(i);
        }
        return nextS;
    }

    // Function to find previous smaller for every element
    static int[] prevSmaller(int[] arr) {
        int n = arr.length;

        // Initialize with -1 for the cases when prev smaller
        // does not exist
        int[] prevS = new int[n];
        for (int i = 0; i < n; i++) {
            prevS[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        // Traverse all array elements from left to right
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            if (!st.isEmpty()) {
                prevS[i] = st.peek();
            }
            st.push(i);
        }
        return prevS;
    }

    // Function to calculate the maximum rectangular
    // area in the histogram
    static int getMaxArea(int[] arr) {
        int[] prevS = prevSmaller(arr);
        int[] nextS = nextSmaller(arr);
        int maxArea = 0;

        // Calculate the area for each arrogram bar
        for (int i = 0; i < arr.length; i++) {
            int width = nextS[i] - prevS[i] - 1;
            int area = arr[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] arr = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(getMaxArea(arr));
    }
}
