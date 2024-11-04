package org.example.algorithms.homework6;
//1. Напишите  методы для быстрой сортировки массива целых чисел (Quick sort)
//в порядке убывания значений их элементов.
//
//2.* Напишите  методы для быстрой сортировки массива целых чисел (Quick sort),
//используя в качестве опорного элемента средний элемент массива.

import java.util.Arrays;

public class QuickSort {
        public static void main(String[] args) {
            int[] array = {3, 7, 2, 5, 1, 8, 9};

            // Запуск сортировки массива от начала до конца
            quickSort(array, 0, array.length - 1);

            // Вывод отсортированного массива
            System.out.println("Отсортированный массив по убыванию: " + Arrays.toString(array));
        }

        public static void quickSort(int[] array, int low, int high) {
            // Базовый случай завершения рекурсии
            if (low < high) {
                // Разделяем массив на части относительно опорного элемента
                int pivotIndex = partition(array, low, high);

                // Рекурсивная сортировка левой части
                quickSort(array, low, pivotIndex - 1);

                // Рекурсивная сортировка правой части
                quickSort(array, pivotIndex + 1, high);
            }
        }

        private static int partition(int[] array, int low, int high) {
            // Опорный элемент – последний элемент подмассива
            int pivot = array[high];

            int i = low - 1; // Индекс элементов, больше опорного

            // Перебираем элементы подмассива
            for (int j = low; j < high; j++) {
                // Для убывания: если текущий элемент больше опорного
                if (array[j] > pivot) {
                    i++;
                    swap(array, i, j); // Меняем местами элементы
                }
            }

            // Перемещаем опорный элемент на нужную позицию
            swap(array, i + 1, high);
            return i + 1; // Возвращаем индекс опорного элемента
        }

        private static void swap(int[] array, int i, int j) {
            // Обмен значений двух элементов массива
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

