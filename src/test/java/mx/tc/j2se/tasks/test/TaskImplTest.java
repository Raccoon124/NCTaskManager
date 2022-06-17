package mx.tc.j2se.tasks.test;

import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskImplTest {

    @Test
    void getTitleTest() {
        TaskImpl task = new TaskImpl("titulo",100);
        assertEquals("titulo",task.getTitle());
    }

    @Test
    void setTitle() {
        TaskImpl task = new TaskImpl();
        task.setTitle("titulo");
        assertEquals("titulo",task.getTitle());
    }

    @Test
    void getStart() {
        TaskImpl task = new TaskImpl();
        task.setStart(100);
        assertEquals(100,task.getStart());
    }

    @Test
    void setStart() {
        TaskImpl task = new TaskImpl();
        task.setStart(100);
        assertEquals(100,task.getStart());
    }

    @Test
    void getEnd() {
        TaskImpl task = new TaskImpl();
        task.setEnd(100);
        assertEquals(100,task.getEnd());
    }

    @Test
    void setEnd() {
        TaskImpl task = new TaskImpl();
        task.setEnd(100);
        assertEquals(100,task.getEnd());
    }

    @Test
    void getRepeatInterval() {
        TaskImpl task = new TaskImpl();
        task.setInterval(10);
        assertEquals(100,task.getRepeatInterval());
    }

    @Test
    void setInterval() {
        TaskImpl task = new TaskImpl();
        task.setInterval(100);
        assertEquals(100,task.getRepeatInterval());
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
        int time;
        TaskImpl task = new TaskImpl();
        task.setTime(1,23,5);
        time = task.getTime();
        assertEquals(0,time);
    }

    @Test
    void setTime() {
    }

    @Test
    void getStartTime() {
    }

    @Test
    void getEndTime() {
    }

    @Test
    void testSetTime() {
    }

    @Test
    void isRepeated() {
    }
}