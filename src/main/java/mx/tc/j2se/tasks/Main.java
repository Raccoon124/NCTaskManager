package mx.tc.j2se.tasks;

public class Main {
    public static void main(String[] args) {

        //probando constructor sin parametros
        TaskImpl task = new TaskImpl();
        task.setTime(10);
        // probando constructor con 2 parametros tittle y time
        TaskImpl task1 = new TaskImpl("tarea 1",12);

        // probando contructor con 4 parametros
        TaskImpl task2 = new TaskImpl("tarea2",1,10,1);
        System.out.println("the task is repetitive?: "+task2.isRepeated());
        System.out.println("the start time of the next task is?: "+task2.getStartTime());
        System.out.println("the end time of the task is?: "+task2.getEndTime());
        System.out.println("the time of the interval repetition is?: "+task2.getRepeatInterval());
        task2.setTime(20);
        System.out.println("the task is repetitive?: "+task2.isRepeated());
        System.out.println("the time of the execution is?: "+task2.getStartTime());
        System.out.println("the time of the execution is?: "+task2.getEndTime());
        System.out.println("the time of the repetition is?: "+task2.getRepeatInterval());
        task2.setTime(10,20,4);
        System.out.println("the task is repetitive?: "+task2.isRepeated());
        System.out.println("the start time of the next task is?: "+task2.getStartTime());
        System.out.println("the end time of the task is?: "+task2.getEndTime());
        System.out.println("the time of the interval repetition is?: "+task2.getRepeatInterval());



    }
}

