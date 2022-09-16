package Prac18;

import java.util.Arrays;

//variant 4
public class ArrGenerator {
    public static void generate(){ //main
        int n = 10;
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = -100 + (int)(Math.random() * 200);
        }
        for(int i =0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
