package mx.tc.j2se.tasks;

public class TaskImpl implements Task {

    private String title;
    private int time;

    private int start;
    private int end;
    private int interval;

    private boolean active;
    private boolean repeated;

    public TaskImpl() {
    }

    public TaskImpl(String title, int time) {
        this.title = title;
        this.time = time;
        this.active = false;
    }

    public TaskImpl(String title, int start, int end, int interval) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.active = false;
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

        this.repeated = false;
        this.time = time;
        this.start = 0;
        this.end = 0;
        this.interval = 0;


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
            return start;
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

        this.time = 0;

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

    @Override
    public boolean isRepeated() {

        return interval > 0;

    }

    @Override
    public int nextTimeAfter(int current) {


        if (!isActive()) { //if the task is not active it returns -1
            return -1;

        } else {
            if (current < time) {// if current < time return time
                return time;
            }

            if (current < start) { // if current < start return start
                return start;
            }

            if ((current < (start + interval) || (current == start)) && isRepeated()) { // if current < (start + interval) or current equals start and is repetitive return start+interval
                return start + interval;
            }

            if (current > (end - interval) && current < end && isRepeated()) { // if current > (end - interval) and current < end and is repeated task return end;
                return end;

            } else {

                int count = (end - start) / interval; //number of repetitions in a task

                int count2 = 1;
                                    //50 100 /20
                System.out.println("numero de repeticiones en una tarea: "+count);
                while (count2 < count) {
                    System.out.println("valor count2: "+count2);
                    int observer = start + (interval * count2);
                    System.out.println(current);
                    System.out.println(observer);
                    if (current == observer) {
                        System.out.println("estas dentro del while");
                        return observer + interval;
                    }
                    count2++;
                }
                for (int i = start; i < end; i += interval)
                {
                    if ((current >= i) &&
                       (current < i + interval) &&
                       ((current < end) &&
                       ((i + interval) <= end)) ||
                       ((current < end - interval) &&
                       (current > end - (interval * 2))))
                    {
                        System.out.print("estas dentro el for: ");
                        return i + interval;
                    }
                }
            }
        }
        return -1;
    }
}
