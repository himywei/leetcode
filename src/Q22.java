/**
 * ��Ŀ����:
 * ���� n�����������ŵĶ������������һ�������������ܹ��������п��ܵĲ��� ��Ч�� ������ϡ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 3
 * �����["((()))","(()())","(())()","()(())","()()()"]
 * ʾ�� 2��
 * <p>
 * ���룺n = 1
 * �����["()"]
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q22 {


    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        int open = 0, close = 0;
        dfs(n, "", res, open, close);
        return res;
    }

    private void dfs(int n, String path, List<String> res, int open, int close) {
        if (open < close || open > n) {  // ��֦
            return;
        }
        if (path.length() == 2 * n) {
            res.add(path);
            return;//����
        }

        dfs(n, path + "(", res, open + 1, close);

        dfs(n, path + ")", res, open, close + 1);
    }

    public static void main(String[] args) {
        int n = 2;
        Q22 q = new Q22();
        List<String> ans = q.generateParenthesis(n);
        for (String an : ans) {
            System.out.print(an + " ");
        }
    }
}


