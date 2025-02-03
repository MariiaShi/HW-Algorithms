package org.example.algorithms.homework9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task {
    private String name;
    private int time; // Время выполнения (дней)
    private int cost; // Стоимость

    public Task(String name, int time, int cost) {
        this.name = name;
        this.time = time;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getCost() {
        return cost;
    }
}

class TaskScheduler {

    public List<Task> selectTasks(List<Task> tasks, int maxTime) {
        // Создаем копию списка, чтобы не изменять исходный
        List<Task> sortedTasks = new ArrayList<>(tasks);
        // Сортируем задачи по времени выполнения по возрастанию
        sortedTasks.sort(Comparator.comparingInt(Task::getTime));

        List<Task> selectedTasks = new ArrayList<>();
        int totalTime = 0;

        for (Task task : sortedTasks) {
            if (totalTime + task.getTime() <= maxTime) {
                selectedTasks.add(task);
                totalTime += task.getTime();
            } else {
                // Последующие задачи больше или равны по времени, нет смысла проверять дальше
                break;
            }
        }
        return selectedTasks;
    }
}

