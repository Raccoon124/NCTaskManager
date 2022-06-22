package mx.tc.j2se.tasks.test;

import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskImplTest {

    @Test
    void getTitle() {
        TaskImpl task = new TaskImpl();
        task.setTitle("run 8 AM");
        assertEquals("run 8 AM", task.getTitle());
    }

    @Test
    void setTitle() {
        TaskImpl task = new TaskImpl();
        task.setTitle("run 8 AM");
        assertEquals("run 8 AM", task.getTitle());
    }

    @Test
    void isActive() {
        TaskImpl task = new TaskImpl();
        task.setActive(true);
        assertTrue(task.isActive());
    }

    @Test
    void setActive() {
        TaskImpl task = new TaskImpl();
        task.setActive(true);
        assertTrue(task.isActive());
    }

    @Test
    void getTime() {

        TaskImpl task = new TaskImpl();
        task.setTitle("run 8am");
        task.setTime(10);
        System.out.println(task.getTime());

    }

    @Test
    void setTime() {

        TaskImpl task = new TaskImpl("run", 1, 10, 2);
        assertTrue(task.isRepeated());
        task.setTime(15);
        assertFalse(task.isRepeated());
        assertEquals(15, task.getTime());


//        TaskImpl task = new TaskImpl("correr",8,20,4);
//        System.out.println(task.getEndTime());
//        System.out.println(task.getStartTime());
//        task.setTime(539);
//        System.out.println(task.getEndTime());
//        System.out.println(task.getStartTime());
//        task.setTitle("correr2");
//        System.out.println(task.getEndTime());
//        assertEquals(539,task.getTime());
    }

    @Test
    void getStartTime() {
        TaskImpl task = new TaskImpl();
        task.setTime(10);
        assertEquals(10,task.getTime());
        assertEquals(10,task.getStartTime());
        task.setTime(10,50,4);
        assertEquals(10,task.getTime());
        assertEquals(10,task.getStartTime());

    }

    @Test
    void getEndTime() {
        TaskImpl task = new TaskImpl();
        task.setTime(10);
        assertEquals(10,task.getTime());
        assertEquals(10,task.getEndTime());
        task.setTime(10,50,4);
        assertEquals(10,task.getTime());
        assertEquals(50,task.getEndTime());
    }

    @Test
    void getRepeatInterval() {

        //non-repetitive test
        TaskImpl task = new TaskImpl();
        task.setTitle("run at night");
        task.setTime(20);
        assertEquals(0, task.getRepeatInterval());

        //repetitive test
        task.setTitle("correr por la mañaña");
        task.setTime(10, 20, 5);
        assertEquals(5, task.getRepeatInterval());

    }

    @Test
    void isRepeated() {

        TaskImpl task = new TaskImpl();
        task.setTitle("run at night");
        task.setTime(20);
        assertFalse(task.isRepeated());
        task.setTime(10,50,10);
        assertTrue(task.isRepeated());
    }

    @Test
    void nextTimeAfter() {

        TaskImpl task = new TaskImpl("run 9pm",5,45,5);
        task.setActive(false);
        System.out.println(task.isActive());
        System.out.println(task.isRepeated());
        assertEquals(-1,task.nextTimeAfter(33));




    }

    @Test
    void setTime2() {

        TaskImpl task = new TaskImpl(); // creo un objeto tarea sin parametros
        task.setTitle("correr por la mañana");  //seteo su nombre
        task.setTime(10); //seteo el tiempo
        System.out.println(task.isActive());// pregunta si la tarea esta activa , debe dar falso
        System.out.println(task.isRepeated());//pregunto si es repetitiva, debe dar falso
        task.setTime(10, 40, 5);// seteo tarea repetitiva
        System.out.println(task.getStartTime());
        System.out.println(task.getEndTime());
        System.out.println(task.isActive());
        System.out.println(task.isRepeated());
        task.setTime(10);
        System.out.println(task.getStartTime());
        System.out.println(task.getEndTime());
        System.out.println(task.isRepeated());
        task.setTime(40, 40, 2);
        System.out.println(task.isRepeated());


        task.setTime(-1, 20, 5);
        System.out.println(task.getTime());


    }


}