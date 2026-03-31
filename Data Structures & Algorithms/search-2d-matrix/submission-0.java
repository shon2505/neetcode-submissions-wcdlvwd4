

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int len = matrix[i].length;

            if (target >= matrix[i][0] && target <= matrix[i][len - 1]) {
                int index = Arrays.binarySearch(matrix[i], target);
                return index >= 0;
            }
        }
        return false;
    }
}