package com.company.DataStructures;

import java.util.List;

/*
    Unsorted Singly LinkedList Class Storing Integers
 */
public class CustomSinglyLinkedList {
    public class ListNode{
        int value;
        ListNode next;
        public ListNode(int v){
            value = v;
            next = null;
        }
    }

    private ListNode head;

    private Integer size = null;

    /*
        Create
     */
    public CustomSinglyLinkedList(){
        head = null;
        size = 0;
    }

    /*
        Size - Get Number of Elements in the List
     */
    public int getSize() {
        return size;
    }

    /*
        Access - Get element at index
     */
    public ListNode get(int index){

        //If list is empty or if the index is larger then the size of the array
        if (size == 0 || index > size) throw new IndexOutOfBoundsException();

        if (index == 0) return head;

        int tempIndex = 0;
        ListNode tempHead = head; //Don't want to modify the actual list reference.

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
        Search - Check if list contains element
     */
    public boolean contains(int searchedValue){

        if (size == 0) return false;

        ListNode temp = head;
        while (temp != null){
            if (temp.value == searchedValue) return true;
            temp = temp.next;
        }
        return false;
    }

    /*
        Insert - Insert element into linkedlist

        InsertHead - Insert element to the top of the list
        inserted.next = null -> Only inserting a single element

     */
    public ListNode insertHead(int inserted){

        ListNode newNode = new ListNode(inserted);

        //If list is empty, just reassign the pointer
        if (head == null){
            head = newNode;
            size+=1;
            return head;
        }

        //If list is populated, set the next pointer of inserted element to point to the current list
        newNode.next = head;
        head = newNode; //Reset the head pointer
        size+=1;
        return head;
    }

    /*
        Delete - Delete element from linkedlist
               - Return the head;
     */
    public ListNode deleteElement(int elementToDelete){

        //If the list is empty or the node to delete is null
        if (size == 0) throw new IllegalArgumentException("Cannot delete from an empty list!");

        ListNode nodeToDelete = new ListNode(elementToDelete);
        ListNode tempHead = head;

        //If deleting from the head of the list, just reset the head pointer to be the next sequential node

        //Checking object equality is checking for both objects point to the same location in memory.
        //Therefore doesn't matter that tempHead may have a non null next pointer and elementToDelete does not
        if (nodeToDelete.value == tempHead.value) {
            head = head.next;
            size = size - 1;
            return head;
        }

        //Iterate until you reach the second last element
        while (tempHead.next.next != null){
            if (tempHead.next.value == nodeToDelete.value){
                tempHead.next = tempHead.next.next; //Reset the element
                size = size - 1;
                return head;
            }
            tempHead = tempHead.next;
        }

        //Check the final element. If matches, delete it otherwise
        if (tempHead.next.value == nodeToDelete.value){
            tempHead.next = null;
            size = size - 1;
            return head;
        }

        //If it's not the final element, throw an exception saying you can't find the element
        throw new IllegalArgumentException("Cannot find the requested element in the list");
    }

    @Override
    public String toString() {

        StringBuilder b = new StringBuilder();

        ListNode temp = head;

        while (temp != null){
            b.append(temp.value);
            b.append(",");
            temp = temp.next;
        }

        return "CustomSinglyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                ", elements=["+b.toString()+"]"+
                '}';
    }
}
