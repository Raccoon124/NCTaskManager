package mx.tc.j2se.tasks;


/**
 * The type Linked task list.
 */
public class LinkedTaskListImpl implements LinkedTaskList {

    private int size;
    private Node first = null;


    /**
     * Add.
     *
     * @param task the task
     */
    @Override
    public void add(Task task) {
        if (task == null)
            throw new IllegalArgumentException("task = null");

        if (first == null)
            first = new Node(task, null);
        else {
            Node temp = first;
            while (temp.next != null)
                temp = temp.next;
            temp.next = new Node(task, null);
        }
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
        if (task == null) {
            throw new IllegalArgumentException("task = null");
        }

        if (first == null) {
            throw new RuntimeException(".");
        }

        if (task.equals((first.data))) {
            first = first.next;
            size--;
            return true;
        }

        Node current = first;
        Node previous = null;

        while (current != null && !current.data.equals(task)) {
            previous = current;
            current = current.next;
        }
        if (current != null) {
            assert previous != null;
            previous.next = current.next;
            size--;
            return true;
        } else
            return false;

    }

    /**
     * Size int.
     *
     * @return the int
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Gets task.
     *
     * @param index the index
     * @return the task
     */
    @Override
    public Task getTask(int index) {

        int i = 0;

        if (index < 0 && index >= size())
            throw new IndexOutOfBoundsException("cannot delete");
        else {
            if (index == 0)
                return first.data;
            else {
                Node temp = first;
                while (temp.next != null) {
                    temp = temp.next;
                    i++;
                    if (i == index)
                        return temp.data;
                }
                return temp.data;
            }
        }

    }

    /**
     * Incoming linked task list.
     *
     * @param from the from
     * @param to   the to
     * @return the linked task list
     */
    @Override
    public LinkedTaskList incoming(int from, int to) {

        LinkedTaskList listData = new LinkedTaskListImpl();

        if (from < 0 || to < 0) {throw new IllegalArgumentException("the time labels cannot be negative");}
        if (to < from) {throw new IllegalArgumentException("to cannot be < from");}
        else {
            for (int i = 0; i < size(); i++)
            {
                if (getTask(i).nextTimeAfter(from) != -1 && to >= getTask(i).nextTimeAfter(from))
                {
                    listData.add(getTask(i));
                }
            }
            return listData;
        }

    }

    private static class Node {
        private final Task data;
        private Node next;


        /**
         * Instantiates a new Node.
         *
         * @param data the data
         * @param next the next
         */
        public Node(Task data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
