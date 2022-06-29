package mx.tc.j2se.tasks;


import java.io.Serializable;

public class LinkedTaskListImpl implements LinkedTaskList {

    private Node first = null;
    private Node last = null;
    private int size = 0; // number of task in the list

    public LinkedTaskListImpl() {
    }

    /**
     * Add.
     *
     * @param task the task
     */
    @Override
    public void add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("the task can't be null");
        }
        Node newList = new Node(task);
        if (size == 0) {
            first = newList;
        }
        if (last != null) {
            last.next = newList;
        }
        newList.previous = last;
        last = newList;
        size++;
    }

    /**
     * Remove boolean.
     *
     * @param task the task
     * @return the boolean
     */
    @Override
    public boolean remove(Task task) {

//        if (task == null) {
//            return false;
//        }
//        int sizeTasks = size();
//        if (sizeTasks == 0) {
//            return false;
//        }
//        boolean taskDeleted = false;
//        int newIndex = 0;
//        //Task[] supArray = new Task[sizeTasks - 1];
//        for (int i = 0; i < sizeTasks; i++) {
//            System.out.println(taskDeleted);
//            if (!taskDeleted && (task.equals(this.getTask(i)))) {
//                taskDeleted = true;
//                size--;
//            } else {
//                if (newIndex < (sizeTasks - 1)) {
//                    //supArray[newIndex] = this.getTask(i);
//                    newIndex++;
//                }
//            }
//        }
//        if (!taskDeleted) {
//            return false;
//        }
//        //this.arr = supArray;
//        return true;
        return true;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Gets task.
     *
     * @param index the index
     * @return the task
     */
    @Override
    public Task getTask(int index) {

        String s = "";
        if (index < 0) {
            s = s + "The index can not be negative. ";
        }
        if (index > size()) {
            s = s + "Index out of bounds. ";
        }
        if (!s.equals("")) {
            throw new IllegalArgumentException(s);
        }
       // return arr[index];
        return null;
    }

    /**
     * Sets task.
     *
     * @param task  the task
     * @param index the index
     */
    public void setTask(Task task, int index) {
        String s = "";
        if (index < 0) {
            s = s + "The index can not be negative. ";
        }
        if (index > size()) {
            s = s + "Index out of bounds. ";
        }
        if (!s.equals("")) {
            throw new IllegalArgumentException(s);
        }
       // arr[index] = task;
    }

    @Override
    public LinkedTaskList incoming(int from, int to) {

        if ((from < 0) || (to < 0)) {
            throw new IllegalArgumentException("time can not be negative!");
        }
        LinkedTaskList newLTL = new LinkedTaskListImpl() {
        };
        int tmpTime;
        int tmpNumberTasks = size();
        for (int i = 0; i < tmpNumberTasks; i++) {
            tmpTime = this.getTask(i).nextTimeAfter(from);
            if ((tmpTime != -1) && (tmpTime <= to)) {
                newLTL.add(this.getTask(i));
            }
        }
        return newLTL;
    }

    /**
     * Class for work with Nodes of LinkedTaskList
     */
    private class Node implements Serializable {
        Node next = null;
        Node previous = null;
        Task taskNode;

        private Node(Task task) {
            if (task == null) {
                throw new NullPointerException();
            }
            this.taskNode = task;
        }

        void setNext(Node next) {
            this.next = next;
        }

        void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

}
