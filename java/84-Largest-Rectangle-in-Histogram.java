class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int[]> stack = new ArrayDeque<>();
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++)
        {
            int index = i;
            while(stack.size() > 0 && stack.peek()[0] > heights[i]){
                maxArea = Math.max(maxArea, (i - stack.peek()[1]) * stack.peek()[0]);
                // Extend the index back
                index = stack.pop()[1];
            }
            // int[0] = height, int[1] = index
            stack.push(new int[]{heights[i], index});
        }
        // calculate the area of any rectangle left in stack
        while(stack.size() > 0){
            maxArea = Math.max(maxArea, (heights.length - stack.peek()[1]) * stack.pop()[0]);
        }
        
        return maxArea;
    }
}
