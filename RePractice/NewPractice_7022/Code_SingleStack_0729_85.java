package RePractice.NewPractice_7022;

import java.util.Stack;

public class Code_SingleStack_0729_85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1 || matrix[0].length < 1){
            return 0;
        }
        int res = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] arr = new int[cols];
        for (int i = 0;i < rows;i++){
            for (int j = 0;j < cols;j++){
                arr[j] = matrix[i][j] == '1' ? arr[j] + 1 : 0;
            }
            res = Math.max(res,largestRectangleArea(arr));
        }
        return res;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0;i < n;i++){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        while (!stack.isEmpty()){
            stack.pop();
        }

        for (int i = n - 1;i >= 0;i--){
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0;i < n;i++){
            res = Math.max(res,heights[i] * (right[i]-left[i] - 1));
        }
        return res;


    }


}
