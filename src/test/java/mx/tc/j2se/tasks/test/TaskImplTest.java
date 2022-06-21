package mx.tc.j2se.tasks.test;

import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

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

        TaskImpl task = new TaskImpl("correr",10,20,5);
        task.nextTimeAfter(15);






    }
}