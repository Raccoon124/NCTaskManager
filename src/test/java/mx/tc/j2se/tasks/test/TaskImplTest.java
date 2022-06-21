package mx.tc.j2se.tasks.test;

import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TaskImplTest {

    @Test
    void getTitle() {
    }

    @Test
    void setTitle() {
    }

    @Test
    void isActive() {
    }

    @Test
    void setActive() {
    }

    @Test
    void getTime() {
    }

    @Test
    void setTime() {
        TaskImpl task = new TaskImpl("asdfas",20,50,10);
        task.setTime(5);
        System.out.println(task.isRepeated());
        System.out.println(task.isActive());
        System.out.println(task.getTime());
    }

    @Test
    void getStartTime() {
    }

    @Test
    void getEndTime() {
    }

    @Test
    void getRepeatInterval() {
    }

    @Test
    void testSetTime() {
    }

    @Test
    void isRepeated() {
    }

    @Test
    void nextTimeAfter() {
//
//        TaskImpl task = new TaskImpl("correr",5,50,20);
//        task.setActive(true);
//        System.out.println(task.isActive());
//        System.out.println(task.isRepeated());
//        System.out.println(task.nextTimeAfter(23));

        TaskImpl task = new TaskImpl("correr por la mañana",8,50, 2 );
        task.setActive(true);
        System.out.println(task.getTime());
        System.out.println(task.getStartTime());
        System.out.println(task.getEndTime());
        System.out.println(task.isActive());
        System.out.println(task.isRepeated());

        System.out.println(task.nextTimeAfter(15));

    }

    @Test
    void setTime2() {

        TaskImpl task = new TaskImpl("correr",40);
        task.setTime(10,30,5);
        System.out.println(task.getTime());
        System.out.println(task.getStartTime());
        System.out.println(task.getEndTime());
        assertEquals(10,task.getTime());



    }



}