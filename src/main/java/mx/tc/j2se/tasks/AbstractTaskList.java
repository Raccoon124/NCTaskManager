package mx.tc.j2se.tasks;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.Stream;


/**
 * Class-name: AbstractTaskList
 * This class is made for the purpose of implementing the AbstractTaskList
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */
public abstract class AbstractTaskList implements Iterable<Task>, Cloneable, Serializable {

    /**
     * this method add the specified task to ArrayTaskList or LinkedList .
     *
     * @param task the task
     */
    public abstract void add(Task task);

    /**
     * this method remove a task from the ArrayList or LinkedList
     *
     * @param task the task
     */
    public abstract boolean remove(Task task);

    /**
     * Size method returns the number of tasks in the ArrayList or LinkedList
     *
     * @return the int
     */
    public abstract int size();

    /**
     * GetTask method returns a specified Task in the List
     *
     * @param index the index of the task
     * @return the task
     */
    public abstract Task getTask(int index);

    /**
     * Incoming method It is used to reduce code duplication. .
     *
     * @param from the from
     * @param to   the to
     * @return the abstract task list
     */
    public final AbstractTaskList incoming(LocalDateTime from, LocalDateTime to) {
        if (this.getClass().equals(LinkedTaskListImpl.class)) {
            LinkedTaskListImpl linked = new LinkedTaskListImpl();
            this.getStream().filter(task -> task != null &&
                    task.nextTimeAfter(from) != null && task.nextTimeAfter(from).isBefore(to)).forEach(linked::add);
            return linked;
        } else if (this.getClass().equals(ArrayTaskListImpl.class)) {
            ArrayTaskListImpl arr = new ArrayTaskListImpl();
            this.getStream().filter(task -> task != null &&
                    task.nextTimeAfter(from) != null && task.nextTimeAfter(from).isBefore(to)).forEach(arr::add);
            return arr;
        }
        return null;
    }

    /**
     * getStream method
     * allows to work with collection as  the streams.
     *
     * @return the stream
     */
    public abstract Stream<Task> getStream();
}
