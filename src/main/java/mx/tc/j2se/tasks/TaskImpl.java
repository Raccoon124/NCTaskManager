package mx.tc.j2se.tasks;

import java.security.spec.RSAOtherPrimeInfo;

public class TaskImpl implements Task {

    private String title;
    private int time = 0;
    private int start = 0;
    private int end = 0;
    private int interval = 0;
    private boolean active;

    private int current;

    public TaskImpl() {
    }

    public TaskImpl(String title, int time) {
        this.active = false;
        this.title = title;
        this.time = time;
    }

    public TaskImpl(String title, int start, int end, int interval) {
        this.active = false;
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

        if (isRepeated()) {
            return interval;
        }
        return 0;

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

        if (isRepeated()) {
            this.start = 0;
            this.end = 0;
            this.interval = 0;
            this.time = time;
        } else {
            this.start = 0;
            this.end = 0;
            this.time = time;
        }

    }


    @Override
    public int getStartTime() {

        if (!isRepeated()) {
            return this.getTime();
        } else {
            return this.getStart();
        }

    }

    @Override
    public int getEndTime() {

        if (!isRepeated()) {
            return this.getTime();
        } else {
            return this.getEnd();
        }

    }

    @Override
    public void setTime(int start, int end, int interval) {

        if (isRepeated()) {
            this.start = start;
            this.end = end;
            this.interval = interval;
        } else {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }


    }

    @Override
    public boolean isRepeated() {
        int interval = this.interval;
        return interval > 0;
    }

    @Override
    public int nextTimeAfter(int current) {

        current = this.getTime();
        interval = this.getRepeatInterval();
        start = this.getStartTime();
        end = this.getEndTime();

        if (isActive()) {
            if (isRepeated()){
                for (int i = start; i <= end; i++ ){

                    if(i == end){
                        System.out.println("the task is not execute anymore: ");
                        return -1;
                    }else{
                        int nextTask = current+interval;
                        System.out.println("the current time is: "+current);
                        System.out.println("the next task start in: "+nextTask);
                        current = nextTask;
                        i = current;
                    }
                }
            }else{
                System.out.println("The task is not repetitive");
                System.out.println("The task will not be executed anymore");
                return -1;
            }
        } else {
            System.out.println("the task is not active");
            return -1;
        }

        return 0;

    }
}
