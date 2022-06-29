package mx.tc.j2se.tasks.test;

import mx.tc.j2se.tasks.ArrayTaskList;
import mx.tc.j2se.tasks.ArrayTaskListImpl;
import mx.tc.j2se.tasks.Task;
import mx.tc.j2se.tasks.TaskImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTaskListImplTest {


    @Test
    void add() {

        ArrayTaskListImpl  tasks = new ArrayTaskListImpl();
        assertEquals(0, tasks.size());
        TaskImpl[] task1 = {new TaskImpl("correr",10),new TaskImpl("nadar",15),new TaskImpl("saltar la cuerda",18)};
        for (TaskImpl t : task1){
            //tasks.setTask(t,1);
        }

        assertEquals(task1.length, tasks.size());


    }

    @Test
    void remove() {

        ArrayTaskListImpl  tasks = new ArrayTaskListImpl();
        TaskImpl[] task1 = {new TaskImpl("a",0), new TaskImpl("b",1), new TaskImpl("c",2)};
        tasks.add(task1[0]);
        Task t = new TaskImpl("some",0);
        tasks.add(t);
        tasks.add(task1[1]);
        tasks.add(task1[2]);
        tasks.remove(t);
        assertEquals(task1.length, tasks.size());



    }

    @Test
    void size() {
    }

    @Test
    void getTask() {
    }

    @Test
    void incoming() {

        ArrayTaskListImpl  tasks = new ArrayTaskListImpl();
       // TaskImpl[] task1 = {new TaskImpl("a",10)};
        tasks.incoming(10,100);
        //assertEquals(0, task1.length);



    }
}