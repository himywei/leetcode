/**
 * ��Ŀ����:
 * ��дһ����Ч���㷨������mxn���� matrix �е�һ��Ŀ��ֵ target ���þ�������������ԣ�
 * <p>
 * ÿ�е�Ԫ�ش������������С�
 * ÿ�е�Ԫ�ش��ϵ����������С�
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * �����true
 * ʾ�� 2��
 * <p>
 * <p>
 * ���룺matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * �����false
 */

public class Q240 {

    /**
     * ����
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        for (int[] ints : matrix) {
//            for (int anInt : ints) {
//                if (anInt == target) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    /**
     * ������������
     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        int row = 0;
//        int col = matrix[0].length - 1;
//        while (row <= matrix.length - 1 && col >= 0) {
//            if (matrix[row][col] == target) {
//                return true;
//            } else if (matrix[row][col] > target) {
//                col--;
//            } else {
//                row++;
//            }
//        }
//        return false;
//    }

    /**
     * ���ж��ַ�
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int left = 0, right = ints.length - 1;
            if (ints[left] > target || ints[right] < target) {
                continue;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ints[mid] == target) {
                    return true;
                } else if (ints[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        Q240 q = new Q240();
        boolean ans = q.searchMatrix(matrix, target);
        System.out.print(ans);
    }
}


