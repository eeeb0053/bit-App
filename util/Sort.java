package util;

import java.util.Random;

public class Sort {
    public int[] randomArr(int begin, int length, int end) {
        int[] arr = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            arr[i] = random.nextInt(end) + begin;
        }
        return arr;
    }
    
    public int[] bubbleSort(int[] arr, boolean direction) {
        // false: ascending, true: descending
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            for(int j = 1; j < size - 1; j++) {
                if(direction) {
                    if(arr[j-1] > arr[j]) {
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }else {
                    if(arr[j-1] < arr[j]) {
                        int temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
                
            }
        }
        return arr;
    }
    
    public int[] selectionSort(int[] arr, boolean direction) {
        int size = arr.length;
        for(int i = 0; i < size - 1; i++) {
            for(int j = i+1; j < size; j++) {
                if(direction) {
                    if(arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }else {
                    if(arr[i] < arr[j]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr; 
    }
    
	public static void main(String[] args) {
	    	    
	}
}