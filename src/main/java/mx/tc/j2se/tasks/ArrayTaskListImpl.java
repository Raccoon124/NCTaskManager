package mx.tc.j2se.tasks;

/**
 * The type Array task list.
 */
public class ArrayTaskListImpl implements ArrayTaskList {

    private Task[] arr = new Task[10];
    private int size = 0; // number of task in the list


    /**
     * constructor without parameters
     */
    public ArrayTaskListImpl() {

    }

    /**
     * Method to add new task to ArrayList
     *
     * @param task task that need add
     */
    @Override
    public void add(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("the task can't be null");
        }
        if (size == this.arr.length) {
            Task[] arrTemp = new Task[(size() + 10)];
            for (int i = 0; i < size(); i++) {
                arrTemp[i] = this.getTask(i);
            }
            this.arr = arrTemp;
        }
        this.arr[size()] = task;
        size++;
    }

    /**
     * This method removes a task from the ArrayList and returns true, if such a task was in the list.
     *
     * @param task task that need add
     * @return the boolean, true or false
     */
    @Override
    public boolean remove(Task task) {

        if (task == null) {
            return false;
        }
        int sizeTasks = size();
        if (sizeTasks == 0) {
            return false;
        }
        boolean taskDeleted = false;
        int newIndex = 0;
        Task[] supArray = new Task[sizeTasks - 1];
        for (int i = 0; i < sizeTasks; i++) {
            System.out.println(taskDeleted);
            if (!taskDeleted && (task.equals(this.getTask(i)))) {
                taskDeleted = true;
                size--;
            } else {
                if (newIndex < (sizeTasks - 1)) {
                    supArray[newIndex] = this.getTask(i);
                    newIndex++;
                }
            }
        }
        if (!taskDeleted) {
            return false;
        }
        this.arr = supArray;
        return true;
    }

    /**
     * This method returns the number of task in the ArrayList
     *
     * @return the int, size of ArrayList
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * getTask this method return a task which takes the specified place in the list;
     *
     * @param index the index of the task
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
        return arr[index];
    }

    /**
     * Sets task on ArrayList.
     *
     * @param task  the task
     * @param index the index of the task in the ArrayList
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
        arr[index] = task;
    }


    /**
     * Incoming array task list. This method return a subset of task that are scheduled for execution at least once after the "from" time,
     * and not later than the "to" time.
     *
     * @param from the from
     * @param to   the to
     * @return the array task list
     */
    @Override
    public ArrayTaskList incoming(int from, int to) {

        //int count = 0;

        ArrayTaskList list;
        list = new ArrayTaskListImpl();

        if (from < 0 || to < 0) {
            System.err.print("You entered a wrong number, they cant be negative!!");
        }

        else {
            for (int i = 0; i < size(); i++) {
                if (getTask(i).nextTimeAfter(from) != -1 && to >= getTask(i).nextTimeAfter(from)) {
                    list.add(getTask(i));
                }
            }
        }
        return list;
    }




}
