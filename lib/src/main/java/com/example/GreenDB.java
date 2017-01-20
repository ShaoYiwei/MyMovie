package com.example;

public class GreenDB {


    public static void main(String[] args) {
        int[] arr = {22, 3, 4, 7, 5, 6, 8, 9, 1};

        for (int i = 1; i < arr.length; i++) {

            int j;
            int tempVal = arr[i];
            for (j = i; j > 0; j--) {
                if (tempVal < arr[j - 1]) {
                    arr[j] = arr[j-1];
                }else{
                    break;
                }
            }
            arr[j] = tempVal;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


}
