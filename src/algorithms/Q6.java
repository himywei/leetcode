package algorithms;

/**
 * ��һ�������ַ��� s ���ݸ��������� numRows ���Դ������¡������ҽ���'Z �������С�
 *
 * ���������ַ���Ϊ "PAYPALISHIRING"'����Ϊ 3 ʱ���������£�
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"PAHNAPLSIIGYIR"��
 *
 * ����ʵ��������ַ�������ָ�������任�ĺ�����
 *
 * string convert(string s, int numRows);
 * '
 *
 * ʾ�� 1��
 *
 * ���룺s = "PAYPALISHIRING", numRows = 3
 * �����"PAHNAPLSIIGYIR"
 * ʾ�� 2��
 * ���룺s = "PAYPALISHIRING", numRows = 4
 * �����"PINALSIGYAHRPI"
 * ���ͣ�
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * ʾ�� 3��
 *
 * ���룺s = "A", numRows = 1
 * �����"A"
 *
 */
public class Q6 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() < 1 || numRows == 1) {
            return s;
        }
        StringBuilder[] array = new StringBuilder[numRows];
        int dir = 1, index = 0;

        for (int i = 0; i < numRows; i++) {
            array[i] = new StringBuilder();
        }
        for (char c : s.toCharArray()) { //�����ַ���s
            array[index].append(c);
            index = index + dir;
            if (index == numRows - 1 || index == 0) {
                dir = -dir;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(array[i]);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        Q6 q = new Q6();
        String ans = q.convert(s, numRows);
        System.out.println(ans);
    }
}


