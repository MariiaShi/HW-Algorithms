package org.example.Algorithms.homework3;
//1. Реализовать метод вычисления факториала
// (n!) рекурсивным и итеративным способами.
public class Factorial {
    public static int fact_rec(int n){
        if (n == 1) {
            return 1;
        }
         return n * fact_rec(n - 1);
    }
    public static int fact_iter(int n) {
        int result = 1;
        for (int i = 1; i < n; i++) {
            result = result * i;
        }
        return result;
    }
}
