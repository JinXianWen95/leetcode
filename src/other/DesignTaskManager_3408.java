package other;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

public class DesignTaskManager_3408 {

    public static void main(String[] args) {
        DesignTaskManager_3408 taskManager = new DesignTaskManager_3408(List.of(List.of(1, 101, 10), List.of(2, 102, 20), List.of(3, 103, 15)));
        taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
        taskManager.edit(102, 8); // Updates priority of task 102 to 8.
        taskManager.execTop(); // return 3. Executes task 103 for User 3.
        taskManager.rmv(101); // Removes task 101 from the system.
        taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
        taskManager.execTop(); // return 5. Executes task 105 for User 5.
    }

    Map<Integer, Task> taskMap = new HashMap<>();
    TreeSet<Task> orderedTask = new TreeSet<>(Comparator.reverseOrder());

    public DesignTaskManager_3408(List<List<Integer>> tasks) {
        for (List<Integer> task : tasks) {
            Task t = new Task(task.get(0), task.get(1), task.get(2));
            taskMap.put(task.get(1), t);
            orderedTask.add(t);
        }
    }

    public void add(int userId, int taskId, int priority) {
        Task task = new Task(userId, taskId, priority);
        taskMap.put(taskId, task);
        orderedTask.add(task);
    }

    public void edit(int taskId, int newPriority) {
        Task task = taskMap.get(taskId);
        orderedTask.remove(task);
        task.priority = newPriority;
        orderedTask.add(task);
    }

    public void rmv(int taskId) {
        Task task = taskMap.remove(taskId);
        orderedTask.remove(task);
    }

    public int execTop() {
        Task task = orderedTask.pollFirst();
        if (Objects.isNull(task)) {
            return -1;
        }
        taskMap.remove(task.taskId);
        return task.userId;
    }

    private class Task implements Comparable<Task> {
        private final int userId;
        private final int taskId;
        private int priority;

        public Task(int userId, int taskId, int priority) {
            this.userId = userId;
            this.taskId = taskId;
            this.priority = priority;
        }

        @Override
        public boolean equals(Object o) {
            if (o==null || getClass()!=o.getClass()) return false;
            Task task = (Task) o;
            return userId==task.userId && taskId==task.taskId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, taskId);
        }

        @Override
        public int compareTo(Task o) {
            if (this.priority == o.priority) {
                return this.taskId - o.taskId;
            }
            return this.priority - o.priority;
        }
    }
}
