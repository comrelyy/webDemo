package com.relyy.algorithm.List;

/**
 * 单向链表
 *
 * @author cairuirui
 * @create 2019/3/27
 */
public class SingleList<E> {

    private int size=0;

    private Node<E> head;

    private Node<E> last;
    public SingleList() {
    }

    public boolean add(E e){
        Node<E> newNode = new Node<>(e);
        if (head == null){
            head = newNode;
        }else {
            last.next = newNode;
        }
        last = newNode;
        size++;
        return true;
    }

    public boolean addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if (head == null){
            head = newNode;
            last = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        size++;
        return true;
    }

    public boolean addByIndex(int index,E e){
        if (index > size) throw new IndexOutOfBoundsException();
        if (index == 0) {
            return addFirst(e);
        }
        Node<E> newNode = new Node<>(e);
        int count = 1;
        Node<E> node = head;
        while (count < index){
            node = node.next;
            count++;
        }
        Node<E> next = node.next;
        node.next = newNode;
        newNode.next = next;
        size++;
        return true;
    }

    public E remove(int index){
        if (size == 0 || size <= index) throw  new IndexOutOfBoundsException();
        if (index == size -1) return removeLast();
        if (index == 0) return removeFirst();
        int count = 1;
        Node<E> newNode = head;
        while (count < index){
            newNode = newNode.next;
            count++;
        }
        Node<E> next = newNode.next;
        newNode.next = next.next;
        next.next = null;
        size--;
        return next.elem;
    }

    public E removeFirst(){
        if (size == 0) return null;
        Node<E> next = head.next;
        Node<E> frist = this.head;
        if (next != null){
            this.head.next = null;
            this.head = next;
        } else{
            this.head = null;
            last = null;
        }
        size--;
        return frist.elem;
    }

    public E removeLast(){
        if (size == 0) return null;
        Node<E> lastNode = last;
        if (size == 1) {
            last = null;
            head = null;
        }
        if (size > 1) {
            Node<E> next = head.next;
            Node<E> pre = head;
            while (next.next != null) {
                pre = next;
                next = next.next;
            }
            pre.next = null;
            last = pre;
        }
        size--;
        return lastNode.elem;
    }

    /**
     * 利用快慢指针定位到单链表的中间节点
     * 链表长度>3
     * @return
     */
    public E getMiddle(){
        if (size < 3) return null;
        Node<E> slow = head.next;
        Node<E> quick = head.next.next;
        while (quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow.elem;
    }

    /**
     * 利用快慢指针判断链表中是否有环
     * @return
     */
    public boolean hasCircle(){
        if (size > 1) {
            Node<E> slow = head.next;
            Node<E> quick = head.next.next;
            if (slow.equals(quick)) return true;
            while (quick.next != null) {
                quick = quick.next.next;
                slow = slow.next;
                if (slow.equals(quick)) return true;
            }

        }
        return false;
    }

    /**
     * 链表反转
     */
    public void revers(){
        if (size == 0) return;
        Node<E> next = head.next;
        Node<E> pre = head;
        while (next.next != null){
            Node<E> cur = next;
            next = cur.next;
            cur.next = pre;
            pre = cur;
        }
        last.next = pre;
        last = head;
        head.next = null;
        head = next;
    }

    @Override
    public String toString() {
        Node<E> node = head;
        if (head == null)return "SingleList{}";
        StringBuffer buffer = new StringBuffer();
        do {
            buffer.append(node.elem).append(",");
            node = node.next;
        }while (node != null);
        String string = buffer.toString();
        return "SingleList{"+string.substring(0,string.length()-1)+"}";
    }

    private static class Node<E>{
        E elem;
        Node<E> next;

        Node(E elem){
            this.elem = elem;
        }
    }

    public static void main(String[] args) {
        SingleList<Integer> singleList = new SingleList<>();
        singleList.add(1);
        singleList.add(2);
        singleList.add(3);
        singleList.add(4);
        singleList.add(5);

        singleList.addFirst(0);
        //System.out.println(singleList.toString());
        singleList.addByIndex(2,6);
        System.out.println(singleList.toString());
        singleList.removeFirst();
        System.out.println(singleList.toString());
        singleList.remove(3);
        System.out.println(singleList.toString());
//        System.out.println(singleList.getMiddle());
//        //singleList.revers();
//        singleList.removeLast();
//        System.out.println(singleList.toString());
//        singleList.removeLast();
//        System.out.println(singleList.toString());
//        singleList.removeLast();
//        System.out.println(singleList.toString());
//        singleList.removeLast();
//        System.out.println(singleList.toString());
//        singleList.removeLast();
//        System.out.println(singleList.toString());

    }
}
