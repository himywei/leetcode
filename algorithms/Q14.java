import java.util.Arrays;
import java.util.Collections;

public class Q14 {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        String s = strs[0];
        if (s.equals("")) {
            return "";
        }

        Integer[] lenArray = new Integer[strs.length]; // �ַ�������
        for (int i = 0; i < lenArray.length; i++) {
            lenArray[i] = strs[i].length();
        }

        int minLen = Collections.min(Arrays.asList(lenArray)); // �ַ���������Сֵ

        StringBuilder sb = new StringBuilder(""); // �����ǰ׺

        boolean flag = true;
        for (int i = 0; i < minLen; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (s.charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
        String[] strs = {"asfd", "asf"};

        Q14 q = new Q14();
        String ans = q.longestCommonPrefix(strs);
        System.out.println(ans);
    }
}


