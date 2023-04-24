package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int [] arr= {10,5,2,3,5,4,3,7,8,9,1,0};
        int [] arrayer={5, 1, 22, 25, 6, -1, 8, 10};
        int [] sequencer={1, 6, -1, 10};
        swap(arr,0,1);
        List<Integer>array = new ArrayList<>();
        List <Integer> sequence = new ArrayList<>();
        for(int i=0; i<arrayer.length;i++){
            array.add(arrayer[i]);
        }
        for (int i = 0; i< sequencer.length; i++){
            sequence.add(sequencer[i]);
        }


        boolean result= isValidSubsequence(array,sequence);
        System.out.println(result);

    }
    public static void swap (int[]array,int i, int j){

        int replacer;
        int temp1=i;
        int temp2=j;
        for (int x=0;x<array.length;x++){
            i=temp1;
            j=temp2;
            while (i<array.length-1 && j<array.length) {
               if (array[i] >= array[j]) {
                   replacer = array[j];
                   array[j] = array[i];
                   array[i] = replacer;


               }
                System.out.println(Arrays.toString(array));
                System.out.println(String.format("{%d , %d}", i, j));
                i++;
                j++;
            }

            System.out.println(Arrays.toString(array));
            System.out.println(i);
            }
        }
    //this is not a perfectly working code but is essentially good enough implementation for the isvalidsubsequence problem for algoexpert
    //easy
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

            int[] order1=new int[sequence.size()];
            int[] order2 =new int [sequence.size()];
            int indexer=0;
            boolean still= true;
            for (int i=0;i< sequence.size();i++){
                for (int j = 0; j< array.size();j++){
                    if (sequence.get(i) == array.get(j)){
                        order1[indexer]=i;
                        order2[indexer]=j;
                        indexer++;
                    }
                }
            }
            System.out.printf("String:%s",Arrays.toString(order1));
            System.out.printf("Array:%s\n",Arrays.toString(order2));
            if (indexer!=sequence.size())return false;
            else{
                for (int i=0;i< order1.length-1&& i<order2.length-1;i++){
                    if (order2[i]>order2[i+1]){
                        still=false;
                    }
                }
                if (!still)return false;
                else return true;
            }
    }






    }


