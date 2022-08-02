package mx.tc.j2se.tasks;


import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

/**
 * Class-name: LinkedTaskListImpl
 * This class is made for the purpose of implementing the LinkedTaskListImpl
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */
public class LinkedTaskListImpl extends AbstractTaskList implements Iterable<Task> {
    private Node head;
    private Node end;
    private int size;

    /**
     * this method add the specified task to LinkedTaskList.
     *
     * @param task the task
     */
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

    public boolean isEmpty() {
        return this.size() == 0;
    }

    /**
     * this method remove a task from the LinkedTaskList and returns true, if such a task was in the list.
     *
     * @param task the task
     */
    public boolean remove(Task task) {
        Node current = head;
        Node prev = null;
        for (int i = 0; i < size; i++) {
            if (getTask(i).equals(task)) {
                if (prev != null) {
                    prev.next = current.next;
                    if (current.next == null) end = prev;
                } else {
                    head = head.next;
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false;
    }


    /**
     * Size method returns the number of tasks in te LinkedTaskList
     *
     * @return the int
     */
    public int size() {
        return this.size;
    }

    /**
     * GetTask method returns a specified Task in the LinkedTaskList:
     *
     * @param index the index of the task
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
     * The Equals method is used to compare objects
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof LinkedTaskListImpl) {
            LinkedTaskListImpl LinkedList = (LinkedTaskListImpl) o;
            if (this.size() == LinkedList.size()) {
                Iterator list1 = this.iterator();
                Iterator list2 = LinkedList.iterator();

                while (list1.hasNext()) {
                    Object o1 = list1.next();
                    Object o2 = list2.next();

                    if (!(o1 == null ? o2 == null : o1.equals(o2))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    /**
     * HashCode method is used to compare objects.
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
     * Clone method, creates an exact copy of an object.
     *
     * @return the array task list
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
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Iterator method used to loop through collections, like ArrayList and LinkedList
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
                Task task = current.getData();
                prev2 = prev;
                prev = current;
                current = current.getNext();
                removeCall = false;
                return task;
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
     * getStream method
     * allows to work with collection as  the streams.
     *
     * @return the stream
     */
    @Override
    public Stream<Task> getStream() {
        LinkedTaskListImpl list = new LinkedTaskListImpl();
        for (int i = 0; i < size(); i++) {
            list.add(getTask(i));
        }
        return list.getStream();
    }

    /**
     * ToString method display should provide the maximum of information available
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "LinkedTaskList{" + "head=" + head + ", end=" + end + ", size=" + size + '}';
    }

    public static class Node {
        public Task data;
        public Node next;

        public Node(Task data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Task getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", next=" + next + '}';
        }
    }
}
