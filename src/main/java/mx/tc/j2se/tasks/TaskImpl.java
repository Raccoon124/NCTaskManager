package mx.tc.j2se.tasks;

/**
 * Class-name: TaskImpl
 * This class is made for the purpose of implementing the Task interface.
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */

public class TaskImpl implements Task {

    private String title;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeated;

    /**
     * Constructor without parameters
     */
    public TaskImpl() {
    }

    /**
     * This constructor creates an inactive task to run at a specified time without
     * repeating and gives it a title.
     *
     * @param title the title
     * @param time  the time
     */
    public TaskImpl(String title, int time) {
        this.title = title;
        setTime(time);
        this.active = false;
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
    public TaskImpl(String title, int start, int end, int interval) {
        this.title = title;
        setTime(start, end, interval);
        this.active = false;
    }

    /**
     * Gets title.
     *
     * @return the title of a task.
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Sets title of a task.
     *
     * @param title the title of a task.
     */
    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Return the status of a task.
     *
     * @return true or false.
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the status of a task, active or inactive.
     *
     * @param active the active is the status of a task true or false.
     */
    @Override
    public void setActive(boolean active) {
        this.active = active;

    }

    /**
     * This method gets time of a non-repetitive task, if the task was repetitive one,
     * the method must return the start time of the repetition.
     *
     * @return the time of a task
     */
    @Override
    public int getTime() {

        return start;

    }

    /**
     * This method sets the time of a non-repetitive task, if the task is a repetitive one,
     * it should become non-repetitive.
     *
     * @param time the time of a task
     */
    @Override
    public void setTime(int time) {

        this.repeated = false;
        setTime(time, time, 0);

    }

    /**
     * this method gets the start time of a task, it the task is a non-repetitive one,
     * the method mus return the time of the execution.
     *
     * @return the start time of a task
     */
    @Override
    public int getStartTime() {

        return start;

    }

    /**
     * this method gets end time of a task,if the task is a non-repetitive one,
     * the method must return the time of the execution.
     *
     * @return the end-time of a task
     */
    @Override
    public int getEndTime() {

        if (end < 0) {
            return this.end = 0;
        }
        return end;

    }

    /**
     * this method gets repeat interval, if the task is a non-repetitive one,
     * the method must return 0.
     *
     * @return the repeat interval
     */
    @Override
    public int getRepeatInterval() {

        if (((end < 0) && (end < start)) || !repeated || interval <= 0)
        {
            return 0;
        } else {
            return interval;
        }

//        if (repeated) {
//            return interval;
//        } else {
//            return 0;
//        }
    }

    /**
     * This method sets the time of a repetitive task,if the task is a non-repetitive one,
     * it should become repetitive.
     *
     * @param start    the start time of a task
     * @param end      the end time of a task
     * @param interval the interval of a task
     */
    @Override
    public void setTime(int start, int end, int interval) {

        if (start < 0) {
            this.start = 0;
            this.end = 0;
            this.interval = 0;
        } else if (end < 0 || interval < 0) {
            this.start = start;
            this.end = start;
            this.interval = 0;
        } else {
            this.start = start;
            this.end = end;
            this.interval = interval;
            this.repeated = true;
        }

    }

    /**
     * this boolean method check the task for repeatability.
     *
     * @return the boolean
     */
    @Override
    public boolean isRepeated() {

        return interval > 0;

    }

    /**
     * This method returns Next time after a current time give,if after the specified time the task is not executed anymore and return -1,
     * if current time equals endTime for a repetitive task return -1, if the task is inactive return -1,
     * in a repetitive task it must return the next repetition time.
     *
     * @param current the current
     * @return the int
     */
    @Override
    public int nextTimeAfter(int current) {


        if (!isActive() || current >= end || current > end - interval)
        { //if the task is not active it returns -1, or current time > endTime
            return -1;
        }
        else
        {
            if (current < getTime()) {// if current < time return time
                return getTime();
            }
            if ((current < (start + interval) || (current == start)) && isRepeated()) { // if current < (start + interval) or current equals start and is repetitive return start+interval
                return start + interval;
            }
            if (current > (end - interval) && current < end && isRepeated()) { // if current > (end - interval) and current < end and is repeated task return end;
                return end;
            } else {

                int count = (end - start) / interval; //number of repetitions in a task
                int count2 = 1;
                while (count2 < count) {

                    int observer = start + (interval * count2);
                    if (current == observer) {
                        return observer + interval;
                    }
                    count2++;
                }
                for (int i = start; i < end; i += interval) {
                    if ((current >= i) && (current < i + interval) && ((current < end) && ((i + interval) <= end)) || ((current < end - interval) && (current > end - (interval * 2)))) {
                        return i + interval;
                    }
                }
            }
        }
        return -1;
    }
}
