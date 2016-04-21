package com.personal.util;

import java.util.Arrays;

public class ArrayTest {
    
    public static void random(int n ,int k){
        int[] numbers = new int[n];
        
        for(int i=0 ;i< n; i++){
            numbers[i] = i + 1;
        }

        int[] result = new int[k];
        
        for(int i=0;i<k;i++){
            
            int x = (int)(Math.random()*n);
            
            result[i] = numbers[x];
            
            numbers[x] = numbers[n-1];
            
            n--;
        }
        System.out.print(Arrays.toString(result));
    }
    
    public static void change(){
        
        int[] numbers = new int[10];
        
        for(int i=0 ;i< 10; i++){
            numbers[i] = i + 1;
        }
        System.out.print(Arrays.toString(numbers));  
        System.out.println();
        numbers[4] = numbers[9];
        System.out.print(Arrays.toString(numbers));
    }
    
    
    public static void main(String[] args) {
        
        ArrayTest.change();
        
        
    }

}
