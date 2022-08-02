package mx.tc.j2se.tasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

/**
 * Class-name: ArrayTaskListImpl
 * This class is made for the purpose of implementing the ArrayTaskListImpl
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */
public class ArrayTaskListImpl extends AbstractTaskList implements Cloneable, Iterable<Task> {
    private Task[] tasks = new Task[0];


    /**
     * this method add the specified task to ArrayTaskList.
     *
     * @param task the task
     */
    public void add(Task task) {
        tasks = Arrays.copyOf(tasks, tasks.length + 1);
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                i++;
            }
        }
    }

    /**
     * this method remove a task from the ArrayList and returns true, if such a task was in the list.
     *
     * @param task the task
     */
    public boolean remove(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if (task.hashCode() == tasks[i].hashCode()) {
                System.arraycopy(tasks, i + 1, tasks, i, tasks.length - 1 - i);
                tasks = Arrays.copyOf(tasks, tasks.length - 1);
                return true;
            }
        }
        return false;
    }

    /**
     * Size method returns the number of tasks in te ArrayList
     *
     * @return the int
     */
    public int size() {
        return tasks.length;
    }

    /**
     * GetTask method returns a specified Task in the ArrayList
     *
     * @param index the index of the task
     * @return the task
     */
    public Task getTask(int index) {
        if (index > tasks.length) {
            throw new IndexOutOfBoundsException("the index is greater than the array");
        }
        return tasks[index];
    }

    /**
     * The Equals method is used to compare objects
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayTaskListImpl)) return false;
        ArrayTaskListImpl tasks1 = (ArrayTaskListImpl) o;
        return Arrays.equals(tasks, tasks1.tasks);
    }

    /**
     * HashCode method is used to compare objects.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Arrays.hashCode(tasks);
    }

    /**
     * Clone method, creates an exact copy of an object.
     *
     * @return the array task list
     */
    public ArrayTaskListImpl clone() {
        try {
            ArrayTaskListImpl array = (ArrayTaskListImpl) super.clone();
            array.tasks = Arrays.copyOf(tasks, tasks.length);
            return array;
        } catch (CloneNotSupportedException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Iterator method used to loop through collections, like ArrayList and LinkedList
     *
     * @return the iterator
     */
    @Override
    public Iterator<Task> iterator() {
        Iterator<Task> it = new Iterator<Task>() {
            private int current = 0;

            @Override
            public boolean hasNext() {
                return current < size();
            }

            @Override
            public Task next() {
                return getTask(current++);
            }

            @Override
            public void remove() throws IllegalStateException {
                ArrayTaskListImpl array = new ArrayTaskListImpl();
                if (current == 0) {
                    throw new IllegalStateException();
                } else {
                    array.tasks = tasks;
                    Task tasksRem = getTask(--current);
                    array.remove(tasksRem);
                    tasks = Arrays.copyOf(tasks, tasks.length - 1);
                }
            }
        };
        return it;
    }

    /**
     * getStream method
     * allows to work with collection as  the streams.
     *
     * @return the stream
     */
    @Override
    public Stream<Task> getStream() {
        return Stream.of(this.tasks);
    }

    /**
     * ToString method display should provide the maximum of information available
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "ArrayTaskList{" + "tasks=" + Arrays.toString(tasks) + '}';
    }
}