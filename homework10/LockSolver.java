package org.example.algorithms.homework10;
import java.util.*;

public class LockSolver {
    public static int minRotations(String start, String target) {
        int rotations = 0;
        for (int i = 0; i < start.length(); i++) {
            int digitStart = start.charAt(i) - '0';
            int digitTarget = target.charAt(i) - '0';
            rotations += Math.min(Math.abs(digitStart - digitTarget), 10 - Math.abs(digitStart - digitTarget));
        }
        return rotations;
    }

    public static void main(String[] args) {
        String start = "1234";
        String target = "0000";
        System.out.println("Минимальные вращения: " + minRotations(start, target));
    }
}

