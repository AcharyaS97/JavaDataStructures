package com.company.DataStructures;

public class Main {
    public static void TestList(){
        CustomList list = new CustomList();

        list.add(0,0);
        list.add(1,1);
        list.add(2,2);
        list.add(3,3);
        list.add(4,4);
        list.add(5,5);

        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.remove(0);
        System.out.println(list.toString());
        list.remove(0);
    }

    public static void TestLinkedList(){
        CustomSinglyLinkedList linkedList = new CustomSinglyLinkedList();


        var inserted = 0;

        linkedList.insertHead(inserted);
        inserted = 1;
        linkedList.insertHead(0);
        linkedList.insertHead(1);
        linkedList.insertHead(2);
        linkedList.insertHead(3);
        System.out.println(linkedList.toString());

        for (int i = 0 ; i <= 6 ; i++){
            System.out.println("Searching for:"+i+", Found In LinkedList:"+linkedList.contains(i));
        }

        linkedList.deleteElement(0);
        System.out.println(linkedList.toString());
        linkedList.deleteElement(1);
        System.out.println(linkedList.toString());
        linkedList.deleteElement(2);
        System.out.println(linkedList.toString());
        linkedList.deleteElement(3);
        System.out.println(linkedList.toString());
    }

    public static void main(String[] args) {
        TestLinkedList();
    }
}
