package mx.tc.j2se.tasks;

import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskImplTest {

    @Test
    void getTitleTest() {
        TaskImpl task = new TaskImpl("titulo",100);
        Assertions.assertEquals("titulo",task.getTitle());
    }

    @Test
    void setTitle() {
        TaskImpl task = new TaskImpl();
        task.setTitle("titulo");
        Assertions.assertEquals("titulo",task.getTitle());
    }

    @Test
    void getStart() {
        TaskImpl task = new TaskImpl();
        task.setStart(100);
        Assertions.assertEquals(100,task.getStart());
    }

    @Test
    void setStart() {
        TaskImpl task = new TaskImpl();
        task.setStart(100);
        Assertions.assertEquals(100,task.getStart());
    }

    @Test
    void getEnd() {
        TaskImpl task = new TaskImpl();
        task.setEnd(100);
        Assertions.assertEquals(100,task.getEnd());
    }

    @Test
    void setEnd() {
        TaskImpl task = new TaskImpl();
        task.setEnd(100);
        Assertions.assertEquals(100,task.getEnd());
    }

    @Test
    void getRepeatInterval() {
        TaskImpl task = new TaskImpl();
        task.setInterval(10);
        Assertions.assertEquals(100,task.getRepeatInterval());
    }

    @Test
    void setInterval() {
        TaskImpl task = new TaskImpl();
        task.setInterval(100);
        Assertions.assertEquals(100,task.getRepeatInterval());
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
        int time;
        TaskImpl task = new TaskImpl();
        task.setTime(1);
        time = task.getTime();
        Assertions.assertEquals(1,time);
    }

    @Test
    void setTime() {
        TaskImpl task = new TaskImpl();
        task.setTime(1);
        Assertions.assertEquals(1,task.getTime());
    }

    @Test
    void getStartTime() {
        TaskImpl task = new TaskImpl();
        task.setStart(1);
        Assertions.assertEquals(1,task.getStart());
    }

    @Test
    void getEndTime() {
        TaskImpl task = new TaskImpl();
        task.setEnd(1);
        Assertions.assertEquals(1,task.getEnd());
    }

    @Test
    void testSetTime() {
        int time;
        TaskImpl task = new TaskImpl();
        task.setTime(1,23,5);
        Assertions.assertEquals(1,task.getStart());
        Assertions.assertEquals(23,task.getEnd());
        Assertions.assertEquals(5,task.getRepeatInterval());
    }

    @Test
    void isRepeated() {
    }
}