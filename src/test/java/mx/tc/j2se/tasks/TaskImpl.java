package mx.tc.j2se.tasks;

public class TaskImpl implements Task {

    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;

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

    public int getInterval() {
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
        return 0;
    }

    @Override
    public int getEndTime() {
        return 0;
    }

    @Override
    public int getRepeatInterval() {
        return 0;
    }

    @Override
    public void setTime(int start, int end, int interval) {

    }

    @Override
    public boolean isRepeated() {
        return false;
    }
}
