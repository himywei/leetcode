import java.util.HashMap;

/**
 * Q146 ��Ŀ����
 * <p>
 * <p>
 * �����������յ����ݽṹ����ƺ�ʵ��һ��' LRU (�������ʹ��) ������� ��
 * ʵ�� LRUCache �ࣺ
 * <p>
 * LRUCache(int capacity) ����������Ϊ����'capacity ��ʼ�� LRU ����
 * int get(int key) ����ؼ��� key �����ڻ����У��򷵻عؼ��ֵ�ֵ�����򷵻� -1 ��
 * void put(int key, int value)'����ؼ����Ѿ����ڣ�����������ֵ������ؼ��ֲ����ڣ��������顸�ؼ���-ֵ���������������ﵽ����ʱ����Ӧ����д��������֮ǰɾ�����δʹ�õ�����ֵ���Ӷ�Ϊ�µ�����ֵ�����ռ䡣
 * '
 * <p>
 * ���ף����Ƿ������'O(1) ʱ�临�Ӷ�����������ֲ�����
 * <p>
 * '
 * <p>
 * ʾ����
 * <p>
 * ����
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * ���
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * ����
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // ������ {1=1}
 * lRUCache.put(2, 2); // ������ {1=1, 2=2}
 * lRUCache.get(1);    // ���� 1
 * lRUCache.put(3, 3); // �ò�����ʹ�ùؼ��� 2 ���ϣ������� {1=1, 3=3}
 * lRUCache.get(2);    // ���� -1 (δ�ҵ�)
 * lRUCache.put(4, 4); // �ò�����ʹ�ùؼ��� 1 ���ϣ������� {4=4, 3=3}
 * lRUCache.get(1);    // ���� -1 (δ�ҵ�)
 * lRUCache.get(3);    // ���� 3
 * lRUCache.get(4);    // ���� 4
 */

public class LRUCache {
    HashMap<Integer, Node> map;
    DoubleLinkedList cache;
    int cap;
    public LRUCache(int capacity){
        map   = new HashMap<>();
        cache = new DoubleLinkedList();
        cap   = capacity;
    }

    public void put(int key, int val){
        Node newNode = new Node(key, val);

        if(map.containsKey(key)){
            cache.delete(map.get(key));
            cache.addFirst(newNode);
            map.put(key, newNode);
        }else{
            if(map.size() == cap){
                int k = cache.deleteLast();
                map.remove(k);
            }
            cache.addFirst(newNode);
            map.put(key, newNode);

        }
    }

    public int get(int key){
        if(!map.containsKey(key))   return -1;

        int val = map.get(key).val;
        put(key, val);

        return val;
    }
}

/**
 *  head: recently used
 *  tail: LRU
 */
class DoubleLinkedList{
    Node head;
    Node tail;

    public DoubleLinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node){

        node.next   = head.next;
        node.prev   = head;

        head.next.prev = node;
        head.next      = node;
    }

    public int delete(Node n){
        int key = n.key;
        n.next.prev = n.prev;
        n.prev.next = n.next;

        return key;
    }

    public int deleteLast(){
        if(head.next == tail)   return -1;

        return delete(tail.prev);
    }
}

class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




