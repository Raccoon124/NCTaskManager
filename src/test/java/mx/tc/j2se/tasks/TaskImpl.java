package mx.tc.j2se.tasks;

import java.sql.Time;

public class TaskImpl implements Task {

    private String title;
    private int time ;
    private int start = 0;
    private int end = 0;
    private int interval = 0;
    private boolean active;

    public TaskImpl() {
    }

    public TaskImpl(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public TaskImpl(String title, int time, int start, int end, int interval) {
        this.title = title;
        this.time = time;
        this.start = start;
        this.end = end;
        this.interval = interval;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int getRepeatInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }


    @Override
    public boolean isActive() {
        return this.active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public int getTime() {

        return time;
    }

    @Override
    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int getStartTime() {
        return this.getStart();
    }

    @Override
    public int getEndTime() {
        return this.getEnd();
    }


    @Override
    public void setTime(int start, int end, int interval) {

        this.start = start;
        this.end = end;
        this.interval = interval;

    }

    @Override
    public boolean isRepeated() {
        return false;
    }
}
