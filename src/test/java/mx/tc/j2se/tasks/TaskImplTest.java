package mx.tc.j2se.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class TaskImplTest {

    @Test
    void getTitleTest() {
        TaskImpl task = new TaskImpl("titulo", 100);
        Assertions.assertEquals("titulo", task.getTitle());
    }

    @Test
    void setTitle() {
        TaskImpl task = new TaskImpl();
        task.setTitle("titulo");
        Assertions.assertEquals("titulo", task.getTitle());
    }

    @Test
    void getStart() {
        TaskImpl task = new TaskImpl();
        task.setStart(100);
        Assertions.assertEquals(100, task.getStart());
    }

    @Test
    void setStart() {
        TaskImpl task = new TaskImpl();
        task.setStart(100);
        Assertions.assertEquals(100, task.getStart());
    }

    @Test
    void getEnd() {
        TaskImpl task = new TaskImpl();
        task.setEnd(100);
        Assertions.assertEquals(100, task.getEnd());
    }

    @Test
    void setEnd() {
        TaskImpl task = new TaskImpl();
        task.setEnd(100);
        Assertions.assertEquals(100, task.getEnd());
    }

    @Test
    void getRepeatInterval() {

//        TaskImpl task = new TaskImpl();
//        task.setInterval(0);
//        if (task.isRepeated()) {
//            System.out.println("is repetitive one");
//            assertEquals(1,task.getRepeatInterval());
//        } else {
//            assertEquals(false,task.isRepeated());
//        }
        TaskImpl task = new TaskImpl("tarea loca",1,15,0);
        task.getRepeatInterval();
        assertEquals(0,task.getRepeatInterval());

    }

    @Test
    void setInterval() {
        TaskImpl task = new TaskImpl();
        task.setInterval(100);
        Assertions.assertEquals(100, task.getRepeatInterval());
    }

    @Test
    void isActive() {
        TaskImpl task = new TaskImpl();
        task.setActive(true);
        Assertions.assertTrue(task.isActive());
    }

    @Test
    void setActive() {
        TaskImpl task = new TaskImpl();
        task.setActive(true);
        Assertions.assertTrue(task.isActive());
    }

    @Test
    void getTime() {

        TaskImpl task = new TaskImpl("tarea1", 1, 40, 0);
        if (task.isRepeated()) {
            task.getStartTime();
            System.out.println("the task was a repetitive one ");
            System.out.println("the start time of the repetition : " + task.getStartTime());
        } else {
            System.out.println("the task is not a repetitive ");
            System.out.println("the time of the task start is: " + task.getTime());
        }


    }

    @Test
    void setTime() {
        TaskImpl task = new TaskImpl("tarea1", 1, 40, 1);


        if (task.isRepeated()) {
            System.out.println("the task is repetitive, become a non-repetitive task");
            task.setTime(12);
            System.out.println("time " + task.getTime());
            System.out.println("start " + task.getStart());
            System.out.println("end " + task.getEnd());
            System.out.println("interval " + task.getRepeatInterval());
            System.out.println("its repetitive? " + task.isRepeated());
            assertEquals(task.getTime(), task.getTime());
            assertFalse(task.isRepeated());
        } else {
            System.out.println("the task is not repetitive");
            task.setTime(12);
            System.out.println("time " + task.getTime());
            System.out.println("start " + task.getStart());
            System.out.println("end " + task.getEnd());
            System.out.println("interval " + task.getRepeatInterval());
            System.out.println("its repetitive? " + task.isRepeated());
            assertEquals(task.getTime(), task.getTime());
            assertFalse(task.isRepeated());
        }
    }

    @Test
    void setTime2() {

        TaskImpl task = new TaskImpl("repetitive tasK",4,40,8);
        task.setTime(10);
        task.getRepeatInterval();
        task.isRepeated();
        System.out.println("start: "+task.getStart());
        System.out.println("end: "+task.getEnd());
        System.out.println("interval: "+task.getRepeatInterval());
        System.out.println("the time is: "+task.getTime());
        System.out.println("its a repetitive task: "+task.isRepeated());
        assertFalse(task.isRepeated());
        task.setTime(4,45,4);
        task.getRepeatInterval();
        task.isRepeated();
        System.out.println("start: "+task.getStart());
        System.out.println("end: "+task.getEnd());
        System.out.println("interval: "+task.getRepeatInterval());
        System.out.println("its a repetitive task: :"+task.isRepeated());
        assertTrue(true);


    }


    @Test
    void getStartTime() {
        TaskImpl task = new TaskImpl("tarea1", 1, 40, 1);
        if (task.isRepeated()) {
            System.out.println("is repetitive task");
            System.out.println("the next task start at :" + task.getStart() + " Hours");
            assertEquals(1, task.getStart());
        } else {
            System.out.println("is not repetitive task");
            System.out.println("the time of the execution is :" + task.getTime() + " Hours");
            assertEquals(12, task.getTime());
        }

    }

    @Test
    void getEndTime() {
        TaskImpl task = new TaskImpl("tarea1", 1, 40, 1);
        if (task.isRepeated()) {
            System.out.println("is repetitive task");
            System.out.println("the task end at :" + task.getEndTime() + " Hour");
            assertEquals(40, task.getEndTime());
        } else {
            System.out.println("is not repetitive task");
            System.out.println("the time of the task execution is :" + task.getTime() + " Hours");

            assertEquals(12, task.getTime());
        }
    }


    @Test
    void testSetTime() {

        TaskImpl task = new TaskImpl();
        task.setTime(1, 23, 5);
        Assertions.assertEquals(1, task.getStart());
        Assertions.assertEquals(23, task.getEnd());
        Assertions.assertEquals(5, task.getRepeatInterval());
    }

    @Test
    void isRepeated() {

//        TaskImpl task = new TaskImpl("correr por la mañana a las 5AM", 5);
//        task.setTime(1, 10, 0);
//        if (task.getRepeatInterval() > 0) {
//            task.setActive(true);
//            System.out.println(task.isActive());
//        } else {
//            System.out.println(task.isActive());
//        }
        TaskImpl task = new TaskImpl("run at 10 AM 17/6/2022", 10, 25, 0);
        int interval = task.getRepeatInterval();
        System.out.println("the interval is: " + interval);
        boolean state = task.isRepeated();
        if (state) {
            System.out.println("is repetitive");
            assertTrue(true);
        } else {
            System.out.println("not repetitive");
            assertFalse(false);
        }

    }

    @Test
    void nextTimeAfter() {

//        TaskImpl task = new TaskImpl("run at 10 AM 17/6/2022", 10, 10, 15, 1);
//        int current = task.getTime();
//        int i;
//        int interval = task.getRepeatInterval();
//        int suma;
//        for (i = task.getStartTime(); i <= task.getEndTime(); i++) {
//            if (i == task.getEndTime()) {
//                break;
//            }else{
//                suma = current+interval;
//                System.out.println("la hora es :"+current+" Horas");
//                System.out.println("la hora de la siguiente tarea es: "+suma+" Horas");
//                current++;
//            }
//        }

        TaskImpl task = new TaskImpl();
        task.setActive(true);
        task.setTime(3);
        task.setTime(8,20,4);
        assertEquals(-1, task.nextTimeAfter(task.getTime()));

    }

}