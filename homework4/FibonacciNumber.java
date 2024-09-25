package org.example.Algorithms.homework4;

//Выведите на экран первые 11 членов последовательности Фибоначчи.
//первый и второй члены последовательности равны единицам
//а каждый следующий — сумме двух предыдущих
//Пример последовательности Фибоначчи - это 1  1  2  3  5  8  13  21  34  55  89  и т.д.
//
//
//Реализация рекурсивно
//
//* Улучшить используя техники РиВ

public class FibonacciNumber {

    // Рекурсивный метод для вычисления n-го члена последовательности Фибоначчи
    public static int fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("Первые 11 членов последовательности Фибоначчи:");
        for (int i = 0; i < 11; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }
}
