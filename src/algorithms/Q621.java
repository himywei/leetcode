package algorithms;

import java.util.*;

/**
 * ����һ�����ַ�����tasks ��ʾ�� CPU ��Ҫִ�е������б�����ÿ����ĸ��ʾһ�ֲ�ͬ����������������������˳��ִ�У�����ÿ�����񶼿����� 1 ����λʱ����ִ���ꡣ���κ�һ����λʱ�䣬CPU �������һ�����񣬻��ߴ��ڴ���״̬��
 * <p>
 * Ȼ�������� ��ͬ���� ������֮������г���Ϊ���� n ����ȴʱ�䣬������������� n ����λʱ���� CPU ��ִ�в�ͬ�����񣬻����ڴ���״̬��
 * <p>
 * ����Ҫ�������������������Ҫ�� ���ʱ�� ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺tasks = ['A','A','A','B','B','B'], n = 2
 * �����8
 * ���ͣ�A -> B -> (����) -> A -> B -> (����) -> A -> B
 * �ڱ�ʾ���У�������ͬ��������֮�����������Ϊ n = 2 ����ȴʱ�䣬��ִ��һ������ֻ��Ҫһ����λʱ�䣬�����м�����ˣ�������״̬��
 * ʾ�� 2��
 * <p>
 * ���룺tasks = ['A','A','A','B','B','B'], n = 0
 * �����6
 * ���ͣ�����������£��κδ�СΪ 6 �����ж���������Ҫ����Ϊ n = 0
 * ['A','A','A','B','B','B']
 * ['A','B','A','B','A','B']
 * ['B','B','B','A','A','A']
 * ...
 * �������
 * ʾ�� 3��
 * <p>
 * ���룺tasks = ['A','A','A','A','A','A','B','C','D','E','F','G'], n = 2
 * �����16
 * ���ͣ�һ�ֿ��ܵĽ�������ǣ�
 * A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (����) -> (����) -> A -> (����) -> (����) -> A
 */
public class Q621 {

    /**
     * ÿ��ѡ��ʣ������������Ҵ��ڷ���ȴ�ڵ�����ִ��
     */
    public int leastInterval(char[] tasks, int n) {

        int ans = 0;
        // <����,ʣ��������>
        HashMap<Character, Integer> numMap = new HashMap<>();
        //<����,��ȴʱ��>
        HashMap<Character, Integer> timeMap = new HashMap<>();
        for (char task : tasks) {
            int num = numMap.getOrDefault(task, 0);
            numMap.put(task, num + 1);
            timeMap.put(task, 0);
        }
        while (!numMap.isEmpty()) {
            ans += 1;
            // ÿ��ѡ��ʣ����������ಢ�Ҵ��ڷ���ȴ�ڵ�����ִ��
            List<Map.Entry<Character, Integer>> list = new ArrayList(numMap.entrySet());
            list.sort((o1, o2) -> (o2.getValue() - o1.getValue())); //����������������
            //ѡ����������ಢ�Ҵ��ڷ���ȴ�ڵ�����
            char taskID = '*';
            for (Map.Entry<Character, Integer> characterIntegerEntry : list) {
                if (timeMap.get(characterIntegerEntry.getKey()) == 0) {
                    taskID = characterIntegerEntry.getKey();
                    break;
                }
            }
            //�������񶼴�����ȴ��,������������ȴ��-1��������һ��ѭ��
            if (taskID == '*') {
                for (Character character : timeMap.keySet()) {
                    if (timeMap.get(character) > 0) {
                        timeMap.put(character, timeMap.get(character) - 1);
                    }
                }
                continue;
            }
            //ִ�������������Ϊ0����ɾ������,����������-1��ͬʱ���������ȴ
            if (numMap.get(taskID) - 1 == 0) {
                numMap.remove(taskID);
                timeMap.remove(taskID);
            } else {
                numMap.put(taskID, numMap.get(taskID) - 1);
                timeMap.put(taskID, n);
            }
            //�������������ȴʱ�����0���򲻱䣬������ȴʱ��-1
            for (Character character : timeMap.keySet()) {
                if (character != taskID && timeMap.get(character) > 0) {
                    timeMap.put(character, timeMap.get(character) - 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
/*        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int n = 2;*/
        char[] tasks = {'A', 'A', 'A', 'B', 'B'};
        int n = 2;
        Q621 q = new Q621();
        int ans = q.leastInterval(tasks, n);
        System.out.println(ans);
    }
}


