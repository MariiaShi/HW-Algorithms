package org.example.algorithms.homework13;

import java.util.HashMap;
import java.util.Map;

public class FirstElementKTimes {
    public static int findFirstElementKTimes(int[] arr, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (freqMap.get(num) == k) {
                return num;
            }
        }

        return -1;
    }
}
