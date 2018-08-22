/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coursework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author dell
 */
public class MergeSortDemo {
    
    public static void main(String[] args){
        ArrayList<Items> list = new ArrayList<>();
        String[] data1 = {"1","a","category","group","size","quantity","1010"};
        String[] data2 = {"2","b","category","group","size","quantity","200"};
        String[] data3 = {"3","c","category","group","size","quantity","1"};
        String[] data4 = {"4","d","category","group","size","quantity","300"};
        list.add(new Items(data1));
        list.add(new Items(data2));
        list.add(new Items(data3));
        list.add(new Items(data4));
        System.out.println("Arraylist before mergesort:");
        print(list);
        MergeSort.mergeSort(list);
        System.out.println("Arraylist after mergesort:");
        print(list);
//        int[] a = {5,3,2,1,11,0};
//        MergeSorter.sort(a);
//        System.out.print(Arrays.toString(a));
    }
    
    public static void print(ArrayList<Items> theList){
        for(int i = 0; i < theList.size(); i++){
            System.out.println(theList.get(i).getPrice());
        }
    }
}
