package application;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner in = new Scanner(System.in);
    long num = in.nextLong();
        long start = 3;
        long val = start;
        for(long i=1;i<=num;i++){
        	//if(i==num) {
        	System.out.println(val);
        	//}
            if(val == 1){
                val = start*2;
                start = val;
            }else {
            val--;
            }
        }
       // System.out.println(val);
    }
}