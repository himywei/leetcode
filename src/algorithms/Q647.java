package algorithms;

/**
 * ����һ���ַ�������������Ǽ�������ַ������ж��ٸ������Ӵ���
 * <p>
 * ���в�ͬ��ʼλ�û����λ�õ��Ӵ�����ʹ������ͬ���ַ���ɣ�Ҳ�ᱻ������ͬ���Ӵ���
 * <p>
 * }
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺"abc"
 * �����3
 * ���ͣ����������Ӵ�: "a", "b", "c"
 * ʾ�� 2��
 * <p>
 * ���룺"aaa"
 * �����6
 * ���ͣ�6�������Ӵ�: "a", "a", "a", "aa", "aa", "aaa"
 */
public class Q647 {

    public int countSubstrings(String s) {
        if (s.equals("")) {
            return 0;
        }
        return dfs(s) + countSubstrings(s.substring(1));
    }

    private int dfs(String s) {
        if (s.equals("")) {
            return 0;
        }
        int ans = 0;
        ans += judge(s);
        return ans + dfs(s.substring(0, s.length() - 1));
    }

    private int judge(String s) {
        char[] charArr = s.toCharArray();
        for (int i = 0, j = charArr.length - 1; i < j; i++, j--) {
            if (charArr[i] != charArr[j]) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s = "hello";
        Q647 q = new Q647();
        int ans = q.countSubstrings(s);
        System.out.println(ans);
    }
}


