package com.company.DataStructures;

/*
    Unsorted Singly LinkedList Class Storing Integers
 */
public class CustomDoublyLinkedList {

    public class DoublyListNode{
        int value;
        DoublyListNode prev;
        DoublyListNode next;

        public DoublyListNode (int val){
            value = val;
            prev = null;
            next = null;
        }
    }

    private DoublyListNode sentinel;
    private Integer size;

    /*
        Create
     */
    public CustomDoublyLinkedList(){
        sentinel = new DoublyListNode(-1);
        size = 0;
    }


    /*
        Size
     */
    public int getSize(){
        return size;
    }

    /*
        Access
     */
    public DoublyListNode get(int index){
        if (size == 0 || index >= size) throw new IllegalArgumentException();

        if (index == 0) return sentinel.next;

        int tempIndex = 0;
        DoublyListNode tempHead = sentinel.next; //Don't want to modify the actual list reference.

        //Iterate through the list, increment index. Return element when the counted index matches required
        while (tempHead != null){
            if (tempIndex == index){
                return tempHead;
            }
            tempIndex+=1;
            tempHead = tempHead.next;
        }

        return null;
    }

    /*
        Search
     */
    public boolean contains(int searchedValue){

        DoublyListNode t = sentinel.next;
        while (t != null){
            if (t.value == searchedValue){
                return true;
            }
            t = t.next;
        }

        return false;
    }

    /*
        InsertAtIndex
     */
    public void insertAtIndex(int insertionIndex, int val){
        if (insertionIndex < 0 || insertionIndex >= size) throw new IllegalArgumentException();

        if (insertionIndex == 0) {
            insertHead(val);
            return;
        }

        if (insertionIndex == size - 1) {
            insertTail(val);
            return;
        }

        size+=1;

        DoublyListNode newNode = new DoublyListNode(val);

        DoublyListNode t = sentinel.next;

        int count = 0;
        while (count != insertionIndex - 1){
            t = t.next;
            count+=1;
        }

        //Link new node in between i-1 and old i
        newNode.next = t.next;
        newNode.prev = t;

        t.next.prev = newNode; //Link old i.prev
        t.next = newNode; //Link i-1.next
    }

    /*
        InsertHead
     */
    public void insertHead(int val) {

        size+=1;

        DoublyListNode newNode = new DoublyListNode(val);

        //Connect inserted node to the front of the list
        newNode.next = sentinel.next;
        newNode.prev = sentinel;

        //Connect the back of the existing node to the newly inserted node
        if (sentinel.next != null) sentinel.next.prev = newNode;

        //Set the sentinel to point to the new front node
        sentinel.next = newNode;

        size+=1;
    }

    /*
        InsertTail
     */
    public void insertTail(int val) {

        size+=1;
        DoublyListNode newNode = new DoublyListNode(val);

        DoublyListNode temp = sentinel.next;

        //If the front of the list is null, insert at the front
        if (temp == null){
            insertHead(val);
            return;
        }

        //Get to the end of the list
        while (temp.next != null){
            temp = temp.next;
        }

        //append the new node at the end of the list
        temp.next = newNode;
        newNode.prev = temp;
    }


    /*
        Delete
     */
    public void deleteAtIndex(int index){
        if (index < 0 || index >= size) throw new IllegalArgumentException();

        DoublyListNode t = sentinel.next;
        int count = 0;

        while (count != index - 1){
            t = t.next;
            count +=1;
        }

        DoublyListNode toDelete = t.next;

        t.next = toDelete.next; //Setting the memory reference for current element to point to element after the deleted one
        toDelete.next.prev = t; //Setting the memory reference for the element after the deleted one to point to the current one

        toDelete.next = null; //Deleting the value from the object only (But memory reference still remains)
        toDelete.prev = null;
    }
    /*
        ToString
     */

    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();

        DoublyListNode temp = sentinel.next;

        while (temp != null){
            b.append(temp.value);
            b.append(",");
            temp = temp.next;
        }

        return "CustomDoublyLinkedList{" +
                "sentinel=" + sentinel +
                ", size=" + size +
                ", elements=["+b.toString()+"]"+
                '}';
    }
}
