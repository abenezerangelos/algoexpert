package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
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

        String [][] competitions = {{"HTML", "C#"},{"C#", "Python"},{"Python", "HTML"}};

        int []results= {0, 0, 1};
        ArrayList<ArrayList<String>> competition = new ArrayList<>();
        for (String[] a: competitions){
            ArrayList<String> temp= new ArrayList<>(Arrays.asList(a));
            competition.add(temp);
        }
        ArrayList<Integer> resulting= new ArrayList<Integer>();
        for (int item: results){
            resulting.add(item);
        }
        String output=tournamentWinner(competition,resulting);
        System.out.printf("This is supposed to be the result if it is correctly working: %s",output);


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
            Arrays.fill(order1,Integer.MIN_VALUE);
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

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        // Write your code here.
        int counter=0;
        String[] store = new String[competitions.size()];
        for (var item: competitions){
            if (results.get(counter)==0){
                store[counter]=item.get(1);}
            else{
                store[counter]=item.get(0);
            }
            counter++;
        }
        if (store.length==1)return store[0];
        System.out.println(Arrays.toString(store));
        int count=1;
        int iter=0;
        int j;
        String[][] winner = new String[counter][2];
        for (int i =0;i<store.length-1;i++){
            count=1;
            for ( j = i+1;j<store.length; j++){
                System.out.println(store[i]==store[j]);
                if (store[i].equals(store[j])){
                    ++count;
                    winner[i][0]=store[j];
                    winner[i][1]=Integer.toString(count);
                }
            }
        }
        String to_return="";
        int max = Integer.MIN_VALUE;
        for (var arr: winner){
            if (arr[1]!=null){
                System.out.println(Arrays.toString(arr));

                int comparer = Integer.parseInt(arr[1]);

                if (comparer>max){
                    max = comparer;
                    to_return= arr[0];
                }
            }
        }
        return to_return;
    }
}


