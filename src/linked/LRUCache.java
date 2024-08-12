package linked;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/lru-cache/description/
 *
 * @author mazehong
 * @date 2024/8/8
 */
public class LRUCache {
    int capacity;

    Node head;

    Node tail;

    HashMap<Integer, Node> map = new HashMap<>(capacity);

    public class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        } else {
            removeNode(node);
            addToHead(node);
            return node.value;
        }
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            Node nd = new Node(key, value);
            map.put(key, nd);
            addToHead(nd);
            if (map.size() > capacity) {
                node = removeTail();
                map.remove(node.key);
            }
        } else {
            removeNode(node);
            node.value = value;
            addToHead(node);
            //重要,重新放入map
            map.put(key, node);
        }
    }

    private Node removeTail() {
        Node node = tail.pre;
        /*tail.pre = node.pre;
        node.pre.next =tail;
        node.next = null;
        node.pre = null;*/
        removeNode(node);
        return node;
    }
}
