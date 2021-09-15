package com.relyy.algorithm.List;

/**
 * 跳表：给有序链表添加索引，以空间换时间
 *
 * @author cairuirui
 * @create 2018/12/12
 */
public class SkipList {

    private int indexLevel = 1;
    private Node[] indexTable; //采用hashMap的结构，数组用来记录索引层级,主链表层级为1

    private Node first ;
    private Node last;

    private int size = 0;
    private int modCount = 0;
    private int threshold = 3;

    public SkipList() {
        this.indexTable = new Node[1];
    }

    public boolean add(Integer e){
        Node l = last;
        Node newNode = new Node(e,null,null);
        last = newNode;
        if (l == null){
            first = newNode;
            indexTable[0]=first;
        }else {
            l.next = newNode;
        }
        this.size++;
        this.modCount++;
        this.generateIndex(e);
        return true;
    }

    public void generateIndex(Integer e){
        if (0 != size % threshold) return;
        Node[] newIndexTable = new Node[indexLevel + 1];
        Node newLevelNode = new Node((Integer)indexTable[0].element,null,null);
        newLevelNode.down = indexTable[indexLevel -1];
        Node newLevelNodeNext = new Node(e,null,null);
        newLevelNodeNext.down = last;
        newLevelNode.next = newLevelNodeNext;
        newIndexTable[indexLevel] = newLevelNode;
        for (int i = 0; i < indexLevel; i++) {
            newIndexTable[i] =  indexTable[i];
        }
        indexTable = newIndexTable;
        indexLevel++;
    }

    public boolean find(Integer e){
        Node node = indexTable[indexLevel - 1];
        if (node.element.compareTo(e) > 0){
                return false;
        }
        if (node.element.equals(e)) {
            return true;
        }
        if (node.element.compareTo(e) < 0){
            Node next = node.next;
            next.element.compareTo(e);
        }
        return false;
    }

//    private Integer compare(Node node,Integer value){
//
//    }



    private class Node {
        Integer element;
       Node next;
       Node down;

       public Node(Integer element, Node next, Node down) {
           this.element = element;
           this.next = next;
           this.down = down;
       }
   }

    public static void main(String[] args) {
        SkipList skipList = new SkipList();
        skipList.add(1);
        skipList.add(2);
        skipList.add(3);
        skipList.add(4);
        System.out.println("========");
    }
}
