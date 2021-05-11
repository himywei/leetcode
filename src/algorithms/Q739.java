
package algorithms;

/**
 * �����ÿ�� ���� �б���������һ���б���Ӧλ�õ����Ϊ��Ҫ��۲⵽���ߵ����£�������Ҫ�ȴ��������������������֮�󶼲������ߣ����ڸ�λ����0 �����档
 * <p>
 * ���磬����һ���б�temperatures = [73, 74, 75, 71, 69, 72, 76, 73]��������Ӧ����[1, 1, 4, 2, 1, 1, 0, 0]��
 * <p>
 * ��ʾ������ �б��ȵķ�Χ��[1, 30000]��ÿ�����µ�ֵ�ľ�Ϊ���϶ȣ�������[30, 100]��Χ�ڵ�������
 */
public class Q739 {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            if (T[i + 1] > T[i]) {
                ans[i] = 1;
            } else {
                int num = 1;
                int j = i + 1;
                while (T[j] <= T[i]) {
                    num += 1;
                    j++;
                    if (j == T.length) {
                        num = 0;
                        break;
                    }
                }
                ans[i] = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = {89, 62, 70, 58, 47, 47, 46, 76, 100, 70};

        Q739 q = new Q739();
        int[] ans = q.dailyTemperatures(T);
        for (int an : ans) {
            System.out.print(an + " ");
        }

    }
}


