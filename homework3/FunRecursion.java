package org.example.Algorithms.homework3;
//2*. Есть метод, реализованный рекурсивно,
//Java:
// private static int funRecursion(int x, int y) {
//   if (x == 0) {
//       return y;
//   } else {
//       int res = funRecursion(x - 1, x + y);
//       System.out.println("res = " + res + "; x = " + x + "; y = " + y);
//       return res;
//   }
//}
//Реализовать метод funIteration(x, y) cо
// схожей логикой, реализуя итерационный подход.

public class FunRecursion {
     private static int funRecursion(int x, int y) {
         // x = 3   y = 1
         // 2  4
         // 1  6
         // 0 7
   if (x == 0) {
       return y;
   } else {
       int res = funRecursion(x - 1, x + y);
       System.out.println("res = " + res + "; x = " + x + "; y = " + y);
       return res;
   }
}
    private static int funRecursionIter(int x, int y){
         int res = 1;
        for (int i = x; i < y; i++) {
            res = i + y;
            System.out.println("res = " + res + "; x = " + x + "; y = " + y);
        }
        return res;
    }
}
