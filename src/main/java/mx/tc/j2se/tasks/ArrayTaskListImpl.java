package mx.tc.j2se.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * The type Array task list.
 */
public class ArrayTaskListImpl implements Cloneable, Iterable<Task>, ArrayTaskList {

    private Task[] taskList = new Task[0];


    /**
     * Method to add new task to ArrayList
     *
     * @param task task that need add
     */
    public void add(Task task) {

        Task[] newList = new Task[taskList.length + 1];
        newList[0] = task;
        for (int i = 0; i < taskList.length; i++) {
            newList[i + 1] = taskList[i];
        }
        taskList = newList;

    }

    /**
     * This method removes a task from the ArrayList and returns true, if such a task was in the list.
     *
     * @param task task that need add
     * @return the boolean, true or false
     */
    public boolean remove(Task task) {

        int delTask = -1;

        for (int i = 0; i < taskList.length; i++) {
            if (taskList[i].equals(task)) {
                delTask = i;
                break;
            }
        }

        if (delTask != -1) {
            Task[] newTaskList = new Task[taskList.length - 1];

            for (int i = 0; i < delTask; i++) newTaskList[i] = taskList[i];

            for (int i = delTask + 1; i < taskList.length; i++) newTaskList[i - 1] = taskList[i];

            taskList = newTaskList;
            return true;

        } else
            return false;

    }

    /**
     * This method returns the number of task in the ArrayList
     *
     * @return the int, size of ArrayList
     */
    public int size() {

        int size = 0;
        for (Task task : taskList) {
            if (task != null) {
                size++;
            }
        }
        return size;

    }

    /**
     * getTask this method return a task which takes the specified place in the list;
     *
     * @param index the index of the task
     * @return the task
     */
    public Task getTask(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException();
        }

        return taskList[index];
    }


    /**
     * Incoming array task list. This method return a subset of task that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     *
     * @param from the from
     * @param to   the to
     * @return the array task list
     */
    public ArrayTaskListImpl incoming(int from, int to) {
        ArrayTaskListImpl newTaskList = new ArrayTaskListImpl();

        for (int i = 0; i < newTaskList.size(); i++) {
            Task task = taskList[i];
            int time = 0;

            if (task.isActive()) {
                time = task.getStartTime();
            }

            if (time > from && time < to) {
                newTaskList.add(task);
            }

        }

        return newTaskList;

    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayTaskListImpl)) return false;
        ArrayTaskListImpl tasks1 = (ArrayTaskListImpl) o;
        return Arrays.equals(taskList, tasks1.taskList);
    }


    /**
     * Hash code int.
     *
     * @return the int
     */
    public int hashCode() {
        return Arrays.hashCode(taskList);
    }


    /**
     * Iterator iterator.
     *
     * @return the iterator
     */
    public Iterator<Task> iterator() {
        Iterator<Task> iterator1 = new Iterator<Task>() {
            private int current = 0;
            private int last = -1;

            @Override
            public boolean hasNext() {

                return current < size();
            }

            @Override
            public Task next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("No next element");
                } else {
                    last = current;
                    current++;
                    return getTask(last);
                }
            }

            @Override
            public void remove() throws IllegalStateException {
                ArrayTaskListImpl arrayRemove = new ArrayTaskListImpl();
                if (current == 0) {
                    throw new IllegalStateException();
                } else {
                    arrayRemove.taskList = taskList;
                    Task tasksVoid = getTask(--current);
                    arrayRemove.remove(tasksVoid);
                    taskList = Arrays.copyOf(taskList, taskList.length - 1);
                }
            }
        };
        return iterator1;
    }

    /**
     * Clone array task list.
     *
     * @return the array task list
     */
    public ArrayTaskListImpl clone() {
        try {
            ArrayTaskListImpl arrayTaskList = (ArrayTaskListImpl) super.clone();
            arrayTaskList.taskList = Arrays.copyOf(taskList, taskList.length);
            return arrayTaskList;
        } catch (CloneNotSupportedException ex) {
            System.err.println("CloneNotSupportedException");
            return null;
        }
    }

    /**
     * Gets stream.
     *
     * @return the stream
     */
    @Override
    public Stream<Task> getStream() {
        LinkedList<Task> list = new LinkedList<>();
        for (Task task : this) {
            list.add(task);
        }
        if (list.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return list.stream();
    }

    /**
     * To string string.
     *
     * @return the string
     */
    public String toString() {
        return "ArrayTaskList{" + "tasks=" + Arrays.toString(taskList) + '}';
    }


}
