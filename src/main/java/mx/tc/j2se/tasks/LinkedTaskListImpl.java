package mx.tc.j2se.tasks;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * The type Linked task list.
 */
public class LinkedTaskListImpl implements LinkedTaskList, Iterable<Task> {

    private Node head;
    private Node end;
    private int size;


    /**
     * Add.
     *
     * @param task the task
     */
    @Override
    public void add(Task task) {
        if (isEmpty()) {
            head = new Node(task, null);
            end = head;
        } else {
            end.setNext(new Node(task, null));
            end = end.getNext();
        }
        size++;
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * Remove boolean.
     *
     * @param task the task
     * @return the boolean
     */
    @Override
    public boolean remove(Task task) {
        Node current = head;
        Node previous = null;
        for (int i = 0; i < size; i++) {
            if (getTask(i).equals(task)) {
                if (previous != null) {
                    previous.next = current.next;
                    if (current.next == null)
                        end = previous;
                } else {
                    head = head.next;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }


    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return this.size;
    }

    /**
     * Gets task.
     *
     * @param index the index
     * @return the task
     */
    public Task getTask(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index < size() - 1) {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current.getData();
        }
        return end.getData();
    }

    /**
     * Incoming linked task list.
     *
     * @param from the from
     * @param to   the to
     * @return the linked task list
     */
    public LinkedTaskListImpl incoming(int from, int to) {
        LinkedTaskListImpl newsTaskList = new LinkedTaskListImpl();
        Node currentNode = head;

        for (int i = 0; i < newsTaskList.size(); i++) {
            Task task = currentNode.data;
            int time = 0;

            if (task.isActive()) {
                time = task.getStartTime();
            }

            if (time > from && time < to) {
                newsTaskList.add(task);
            }
        }
        return newsTaskList;
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedTaskListImpl) {
            LinkedTaskListImpl listOther = (LinkedTaskListImpl) o;
            if (this.size() == listOther.size()) {
                Iterator<Task> list1 = this.iterator();
                Iterator<Task> list2 = listOther.iterator();

                while (list1.hasNext()) {
                    Object e1 = list1.next();
                    Object e2 = list2.next();

                    if (!(Objects.equals(e1, e2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        int hashCode = 1;
        for (Task task : this) {
            hashCode = 31 * hashCode + (task == null ? 0 : task.hashCode());
        }
        return hashCode;
    }

    /**
     * Clone linked task list.
     *
     * @return the linked task list
     */
    public LinkedTaskListImpl clone() {
        try {
            LinkedTaskListImpl link = (LinkedTaskListImpl) super.clone();
            link.size = 0;
            for (int i = 0; i < size; i++) {
                link.add(getTask(i));
            }
            return link;
        } catch (CloneNotSupportedException ex) {
            System.out.println("CloneNotSupportedException");
            return null;
        }
    }


    /**
     * Get stream stream.
     *
     * @return the stream
     */
    @Override
    public Stream<Task> getStream(){
        LinkedList<Task> list = new LinkedList<>();
        for (Task task : this) {
            list.add(task);
        }
        if (list.isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return list.stream();
    }

    /**
     * iterator.
     *
     * @return the iterator
     */
    @Override
    public Iterator<Task> iterator() {
        Iterator<Task> it = new Iterator<Task>() {
            Node current = head;
            Node prev = null;
            Node prev2 = null;
            boolean removeCall = false;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Task next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                Task tas = current.getData();
                prev2 = prev;
                prev = current;
                current = current.getNext();
                removeCall = false;
                return tas;
            }

            @Override
            public void remove() {
                if (prev == null || removeCall) {
                    throw new IllegalStateException();
                }
                if (prev2 == null) {
                    head = current;
                } else {
                    prev2.setNext(current);
                }
                size--;
                removeCall = true;
            }
        };
        return it;
    }


    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LinkedTaskList{" +
                "head=" + head +
                ", end=" + end +
                ", size=" + size +
                '}';
    }


    /**
     * The type Node.
     */
    public static class Node {
        /**
         * The Data.
         */
        public Task data;
        /**
         * The Next.
         */
        public Node next;

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

        /**
         * Gets data.
         *
         * @return the data
         */
        public Task getData() {
            return this.data;
        }

        /**
         * Gets next.
         *
         * @return the next
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Sets next.
         *
         * @param next the next
         */
        public void setNext(Node next) {
            this.next = next;
        }

        /**
         * Tostring Node Class.
         *
         * @return the string
         */
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}

