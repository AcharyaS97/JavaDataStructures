package com.company.DataStructures;

public class Main {

    public static void main(String[] args) {
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
}
