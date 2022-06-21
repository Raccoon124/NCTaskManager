package mx.tc.j2se.tasks;

public class TaskImpl implements Task {

    private String title;
    private int time;

    private int start;
    private int end;
    private int interval;

    private boolean active;
    private boolean repeated;
    private int current;

    public TaskImpl() {
    }

    public TaskImpl(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public TaskImpl(String title, int start, int end, int interval) {
        this.title = title;
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

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;

    }

    @Override
    public int getTime() {

        if (isRepeated()) {
            return start;
        } else {
            return time;
        }

    }

    @Override
    public void setTime(int time) {

        if (isRepeated()) {
            this.start = 0;
            this.end = 0;
            this.interval = 0;
        }
        this.time = time;


    }

    @Override
    public int getStartTime() {

        if (isRepeated()) {
            return start;
        } else {
            return time;
        }

    }

    @Override
    public int getEndTime() {
        if (isRepeated()) {
            return end;
        } else {
            return time;
        }
    }

    @Override
    public int getRepeatInterval() {
        if (isRepeated()) {
            return interval;
        } else {
            return 0;
        }
    }

    @Override
    public void setTime(int start, int end, int interval) {

        if (!isRepeated()) {
            this.time = 0;
        }
        this.start = start;
        this.end = end;
        this.interval = interval;


    }

    @Override
    public boolean isRepeated() {

        if (interval > 0) {
            return repeated = true;
        } else {
            return repeated = false;
        }

    }

    @Override
    public int nextTimeAfter(int current) {

        this.current = current;
        int suma = 0;

        if (isRepeated()) {

            if (current > end) {
                System.out.println("la tarea no se ejecutara mas");
                return -1;
            } else {
                if (current < start) {
                    return start;
                } else {
                    int i = 0;
                    for (i = start; i < end; i++) {
                         i +=interval--;
                        int sum = i;
                    }
                    return 0;
                }
            }
        } else if (current > time) {
            System.out.println("la tarea no se ejecutara mas");
            return -1;
        } else {
            System.out.println("la tarea no es repetitiva");
            System.out.println("su hora de inicio es:" + time);
            return time;
        }
    }
}
