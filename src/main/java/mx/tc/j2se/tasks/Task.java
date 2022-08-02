package mx.tc.j2se.tasks;


import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class-name: TaskImpl
 * This class is made for the purpose of implementing the Task Class.
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */

public class Task implements Serializable, Cloneable {
    private String title;
    private boolean active;
    private LocalDateTime time, startTime, endTime;
    private long interval;
    private boolean isActive;
    private boolean isRepeated;


    /**
     * Task constructor without parameters
     */
    public Task() {
    }

    /**
     * This constructor creates an inactive task to run at a specified time without
     * repeating and gives it a title.
     *
     * @param title the title
     * @param time  the time
     */
    public Task(String title, LocalDateTime time) {
        this.title = title;
        this.time = LocalDateTime.of(time.toLocalDate(), time.toLocalTime());
        this.isActive = false;
        this.isRepeated = false;
    }

    /**
     * This constructor creates an inactive task to run at a specified time range (start,end)
     * and a repetition interval and gives it a title.
     *
     * @param title    the title
     * @param start    the start time
     * @param end      the end time
     * @param interval the interval
     */
    public Task(String title, LocalDateTime start, LocalDateTime end, long interval) throws IllegalArgumentException {
        if (start.isAfter(end)) throw new IllegalArgumentException("The start time is greater than the end time");

        this.title = title;
        this.isRepeated = true;
        this.startTime = LocalDateTime.of(start.toLocalDate(), start.toLocalTime());
        this.endTime = LocalDateTime.of(end.toLocalDate(), end.toLocalTime());
        this.interval = interval;
        this.isActive = false;
    }

    /**
     * Gets title.
     *
     * @return the title of a task.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title of a task.
     *
     * @param title the title of a task.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return the status of a task.
     *
     * @return true or false.
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the status of a task, active or inactive.
     *
     * @param active the active is the status of a task true or false.
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * This method gets time of a non-repetitive task, if the task was repetitive one,
     * the method must return the start time of the repetition.
     *
     * @return the time of a task
     */
    public LocalDateTime getTime() {
        return !isRepeated() ? this.time : this.startTime;
    }

    /**
     * This method sets the time of a non-repetitive task, if the task is a repetitive one,
     * it should become non-repetitive.
     *
     * @param time the time of a task
     */
    public void setTime(LocalDateTime time) {
        this.isRepeated = false;
        this.time = LocalDateTime.of(time.toLocalDate(), time.toLocalTime());
    }

    /**
     * this method gets the start time of a task, it is the task is a non-repetitive one,
     * the method mus return the time of the execution.
     *
     * @return the start time of a task
     */
    public LocalDateTime getStartTime() {
        return isRepeated() ? this.startTime : this.time;
    }

    /**
     * This method sets the star time of a repetitive task
     * @param startTime the start time of a repetitive task
     */
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    /**
     * this method gets the end time of a task, it is the task is a non-repetitive one,
     * the method mus return the time of the execution.
     *
     * @return the end time of a task
     */
    public LocalDateTime getEndTime() {
        return isRepeated() ? this.endTime : this.time;
    }


    /**
     * This method sets the end time of a repetitive task
     * @param startTime the end time of a repetitive task
     */
    public void setEndTime(LocalDateTime startTime) {
        this.endTime = endTime;
    }

    /**
     * this method gets repeat interval, if the task is a non-repetitive one,
     * the method must return 0.
     *
     * @return the repeat interval
     */
    public long getRepeatInterval() {
        return isRepeated() ? this.interval : 0;
    }

    public void setRepeatInterval(long repeatInterval) {
        this.interval = repeatInterval;
    }

    /**
     * This method sets the time of a repetitive task,if the task is a non-repetitive one,
     * it should become repetitive.
     *
     * @param start    the start time of a task
     * @param end      the end time of a task
     * @param interval the interval of a task
     */
    public void setTime(LocalDateTime start, LocalDateTime end, long interval) {
        if (start.isAfter(end)) throw new IllegalArgumentException("The start time is greater than the end time");

        this.isRepeated = true; // For change in non-repetitive task
        this.startTime = LocalDateTime.of(start.toLocalDate(), start.toLocalTime());
        this.endTime = LocalDateTime.of(end.toLocalDate(), end.toLocalTime());
        this.interval = interval;
    }

    /**
     * this boolean method check the task for repeatability.
     *
     * @return the boolean
     */
    public boolean isRepeated() {
        return isRepeated;
    }

    /**
     * If the task is not active, it is never executed, if the task is active and executed only once, then the next moment of execution
     * will be either this single moment, or never(if the has already been completed
     * This method returns Next time after a current time give,if after the specified time the task is not executed anymore and return -1,
     * if current time equals endTime for a repetitive task return -1, if the task is inactive return -1,
     * in a repetitive task it must return the next repetition time.
     *
     * @param current the current
     * @return the int
     */
    public LocalDateTime nextTimeAfter(LocalDateTime current) {
        if (isActive()) {
            if (!isRepeated())
                return this.time.isAfter(current) ? this.time : LocalDateTime.MIN;
            LocalDateTime aux = this.startTime;
            while (true) {
                if (aux.isAfter(current))
                    return aux.isBefore(endTime) ? aux : LocalDateTime.MIN;
                aux = aux.plusHours(interval);
            }
        }
        return LocalDateTime.MIN;
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
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return this.isActive() == task.isActive() && Objects.equals(getTitle(), task.getTitle())
                && (this.isRepeated()
                ? task.isRepeated()
                && this.getStartTime().equals(task.getStartTime())
                && this.getEndTime().equals(task.getEndTime())
                && this.interval == task.getRepeatInterval()
                : !task.isRepeated()
                && this.getTime().equals(task.getTime()));
    }

    /**
     * HashCode method is used to compare objects.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getTime().toString(), getStartTime().toString(), getEndTime().toString(),
                getRepeatInterval(), isActive(), isRepeated());
    }

    /**
     * ToString method display should provide the maximum of information available
     *
     * @return the string
     */
    @Override
    public String toString() {
        String task = title;
        if (isRepeated())
            task += "(start=" + this.startTime + ",interval=" + this.interval + ",end=" + this.endTime + ")";
        else
            task += "(time=" + this.time + ")";
        return isActive() ? task + "ACTIVE" : task;
    }

    /**
     * Clone method, creates an exact copy of an object.
     *
     * @return the array task list
     */
    public Task clone() {
        try {
            Task task = (Task) super.clone();
            return task;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
