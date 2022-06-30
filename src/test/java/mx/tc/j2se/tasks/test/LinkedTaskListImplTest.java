package mx.tc.j2se.tasks.test;


import mx.tc.j2se.tasks.ArrayTaskListImpl;
import mx.tc.j2se.tasks.LinkedTaskListImpl;
import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Test;



import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedTaskListImplTest {

    @Test
    void add() {

        LinkedTaskListImpl tss = new LinkedTaskListImpl();
        assertEquals(0,tss.size());
        TaskImpl[] task1 = {new TaskImpl("a",0), new TaskImpl("b",1), new TaskImpl("c",2)};
        for (TaskImpl t : task1)
            tss.add(t);
        assertEquals(task1.length,tss.size());


    }

    @Test
    void remove() {
    }

    @Test
    void size() {
    }

    @Test
    void getTask() {
    }

    @Test
    void setTask() {
    }

    @Test
    void incoming() {

        LinkedTaskListImpl tss = new LinkedTaskListImpl();
        TaskImpl[] task1 = {new TaskImpl("a",0), new TaskImpl("b",1), new TaskImpl("c",2)};
        for (TaskImpl t : task1) {
            t.setActive(false);
            tss.add(t);
        }
        tss.incoming(100,250);

    }
}