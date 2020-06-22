package com.company.DataStructures;

//We will define this to hold integers and then make generic later if time/interest permits
public class CustomList {

    private Integer[] list;
    private int size = 0;

    /*
        Initialize
    */
    public CustomList(){
        list = new Integer[2];
        size = 0;
    }

    /*
        Determine whether empty
     */
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    /*
        Find length of list
    */
    public int size(){
        return size;
    }

    /*
        Get element at index
    */
    public int get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        return list[index];

    }

    /*
        Replace element at index, return the element previously at the specified position
    */
    public int replace(int index, int newValue){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        int previous = list[index];
        list[index] = newValue;
        return previous;
    }

    /*
        Delete element at index. Return the element that was previously at that index
    */
    public int remove(int index){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        int elementAtIndex = list[index];
        list[index] = null;
        size = size - 1;

        //Keep swapping adjacent pairs of elements until reaching the second last index
        for (int i = index ; i <= list.length - 2 ; i++){
            list[i] = list[i+1];
        }

        return elementAtIndex;

    }

    /*
        Insert element at the end
        BEST: O(1) append to end
        WORST: O(n)
    */
    public boolean add(int element, int index){

        if (index < 0 || (index > size) && !isEmpty()) throw new IndexOutOfBoundsException();

        //If reached max capacity, double capacity
        if (size == list.length - 1){
            reallocAndCopy();
        }

        //If appending to the end of the list
        if (index == list.length - 1){
            size+=1;
            list[index] = element;
            return true;
        }
        
        size+=1;

        //Keep swapping forward from list[index] -> index.length - 1
        Integer insertedElement = element;
        for (int i = index ; i <= list.length - 1; i++ ){
            Integer temp = list[i];
            list[i] = insertedElement;
            insertedElement = temp;
        }

        return true;
    }

    private void reallocAndCopy(){
        Integer[] newList = new Integer[list.length * 2];

        for (int i = 0 ; i < list.length ; i++){
            newList[i] = list[i];
        }
        list = newList;
    }

    public String toString(){
        StringBuilder b = new StringBuilder();
        for (Integer integer : list) {
            b.append(integer);
            b.append(",");
        }
        return b.toString();
    }
}

