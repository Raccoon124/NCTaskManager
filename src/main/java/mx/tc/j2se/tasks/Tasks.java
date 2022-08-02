package mx.tc.j2se.tasks;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;


public class Tasks {



    public Iterator<Task> incoming(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {

        if (start == null) throw new IllegalArgumentException("from = null");
        if (end == null) throw new IllegalArgumentException("to = null");
        if (end.isBefore(start)) throw new IllegalArgumentException("end < start");
        ArrayTaskListImpl aTask = new ArrayTaskListImpl();

        for (Iterator<Task> it = tasks; it.hasNext(); ) {
            Task task = it.next();

            if (!task.isActive()) {
                return null;
            }

            LocalDateTime time = task.nextTimeAfter(start);
            if (time != null && !time.isAfter(end)) {
                aTask.add(task);
            }
        }
        return tasks;
    }

    public SortedMap<LocalDateTime, Set<Task>> calendar(Iterator<Task> tasks, LocalDateTime start, LocalDateTime end) {

        SortedMap<LocalDateTime, Set<Task>> sort = new TreeMap<>();
        for (Iterator<Task> it = tasks; it.hasNext(); ) {
            if (tasks.next().isActive()) {
                LocalDateTime timeNow = it.next().nextTimeAfter(start.minusSeconds(1));
                while (timeNow != null && !timeNow.isAfter(end)) {
                    if (sort.containsKey(timeNow)) {
                        sort.get(timeNow).add(it.next());
                    } else if (!sort.containsKey(timeNow)) {
                        Set<Task> set = new HashSet<>();
                        set.add(it.next());
                        sort.put(timeNow, set);
                    }
                    timeNow = it.next().nextTimeAfter((timeNow));
                }
            }
        }
        return sort;
    }


}






