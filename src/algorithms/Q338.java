/**
 * ��Ŀ����:
 * ����һ���Ǹ�����num������0 �� i �� num ��Χ�е�ÿ������i����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: 2
 * ���: [0,1,1]
 * ʾ��2:
 * <p>
 * ����: 5
 * ���: [0,1,1,2,1,2]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q338 {
   /*
    =========  ����   =========
   public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            res[i] = get_one(i);
        }
        return res;
    }

    private int get_one(int target) {
        int res = 0;
        while (target != 0) {
            res += target % 2;
            target /= 2;
        }
        return res;

    }*/

    /**
     * ��̬�滮
     */
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            if (i % 2 == 1) {
                res[i] = res[i - 1] + 1; //�����Ķ�����1�ĸ�������ǰһ��ż���Ķ�����1�ĸ���+1��ż��+1��
            } else {
                res[i] = res[i / 2]; //ż���Ķ�����1�ĸ�������ż��һ��Ķ�����1�ĸ�����ֻ��1���ƣ�
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int num = 5;
        Q338 q = new Q338();
        int[] ans = q.countBits(num);
        System.out.print(Arrays.toString(ans));
    }
}


