package mx.tc.j2se.tasks;

public class Main {
    public static void main(String[] args) {

        TaskImpl task = new TaskImpl();
        task.setTime(10);
        int time = task.getTime();
        System.out.println(time);


    }
}

