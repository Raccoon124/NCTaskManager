package mx.tc.j2se.tasks;

import java.io.Serializable;

/**
 * Class-name: TaskListFactory
 * This class is made for the purpose of implementing the TaskListFactory
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */
public class TaskListFactory implements Serializable {

    /**
     * Create a list according to the type parameter
     *
     * @param type the type
     * @return return the object ArrayTaskListImpl or LinkedListImpl
     */
    public static AbstractTaskList createTaskList(ListTypes.types type){
        if (type.equals(ListTypes.types.ARRAY)){
            return new ArrayTaskListImpl();
        }
        if (type.equals(ListTypes.types.LINKED)){
            return new LinkedTaskListImpl();
        }
        return null;
    }
}
