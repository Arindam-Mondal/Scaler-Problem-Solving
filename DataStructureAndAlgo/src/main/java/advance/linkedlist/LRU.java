package advance.linkedlist;

import java.util.HashMap;

/**
 * LRU Cache Implementation
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 	• get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * 	• set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 * Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
 * 	NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * Example :
 * Input :
 *          capacity = 2
 *          set(1, 10)
 *          set(5, 12)
 *          get(5)        returns 12
 *          get(1)        returns 10
 *          get(10)       returns -1
 *          set(6, 14)    this pushes out key = 5 as LRU is full.
 *          get(5)        returns -1
 */
class DListNode{
    int value;
    int key;
    DListNode next;
    DListNode prev;
    DListNode(int key,int value){
        this.value = value;
        this.key = key;
        this.next = null;
        this.prev = null;
    }
}

public class LRU {
    int capacity;
    int size;
    DListNode head;
    DListNode tail;
    HashMap<Integer,DListNode> LRUMap = new HashMap<>();

    public LRU(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = new DListNode(-1,-1);
        this.tail = new DListNode(-1,-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }

    public int get(int key) {
        DListNode node = LRUMap.get(key);
        //if not miss
        //remove and add
        if(node != null){
            removeNode(node);
            addToNode(node);
            return node.value;
        }else{
            return -1;
        }
    }

    public void set(int key, int value) {
        //first check if the element is already present
        DListNode nodeToRemove = LRUMap.get(key);
        DListNode newNode = new DListNode(key,value);
        if(nodeToRemove == null){
            //if size is full
            //remove and add
            if(size>=capacity){
                DListNode firstNode = head.next;
                removeNode(firstNode);
                addToNode(newNode);
            }else{
                addToNode(newNode);
            }
        }else{
            removeNode(nodeToRemove);
            addToNode(newNode);
        }

    }

    public void addToNode(DListNode x){
        //always add to the last
        x.next = tail;
        x.prev = tail.prev;
        tail.prev = x;
        x.prev.next = x;
        LRUMap.put(x.key,x);
        size++;
    }

    public void removeNode(DListNode x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
        LRUMap.remove(x.key);
        size--;
    }

}
