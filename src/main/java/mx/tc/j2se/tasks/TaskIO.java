package mx.tc.j2se.tasks;

import com.google.gson.Gson;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Class-name: TaskIO
 * This class is made for the purpose of implementing the TaskIO
 * <p>
 * Author: Alberto Sanchez
 * Version info 1.0
 * <p>
 * Copyright Netracker
 */
public class TaskIO {


    /**
     * writebinary method. Writes the tasks from the list to the stream in a binary format
     *
     * @param tasks the tasks
     * @param out   the out
     */
    public static void writeBinary(AbstractTaskList tasks, OutputStream out) {
        DataOutput dataOutput = new DataOutputStream(out);
        try {
            dataOutput.writeInt(tasks.size());
            for (int i = 0; i < tasks.size(); i++) {
                dataOutput.writeInt(tasks.size());
                dataOutput.writeUTF(tasks.getTask(i).getTitle());
                dataOutput.writeBoolean(tasks.getTask(i).isActive());
                dataOutput.writeLong(tasks.getTask(i).getRepeatInterval());
                if (tasks.getTask(i).isRepeated()) {
                    dataOutput.writeLong(tasks.getTask(i).getStartTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                    dataOutput.writeLong(tasks.getTask(i).getEndTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                } else {
                    dataOutput.writeLong(tasks.getTask(i).getTime().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * readBinary method. Read tasks from the binary stream to the current task list
     *
     * @param tasks the tasks
     * @param in    the in
     */
    public static void readBinary(AbstractTaskList tasks, InputStream in) throws IllegalArgumentException {
        DataInputStream ins = new DataInputStream(in);
        try {
            int size = ins.readInt();
            for (int i = 0; i < size; i++) {
                Task task = new Task();
                int count = ins.readInt();
                task.setTitle(ins.readUTF());
                task.setActive(ins.readBoolean());
                long interval = ins.readLong();
                if (interval != 0) {
                    task.setTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(ins.readLong()), ZoneId.systemDefault()), LocalDateTime.ofInstant(Instant.ofEpochMilli(ins.readLong()), ZoneId.systemDefault()), interval);
                    tasks.add(task);

                } else {
                    task.setTime(LocalDateTime.ofInstant(Instant.ofEpochMilli(ins.readLong()), ZoneId.systemDefault()));
                    tasks.add(task);
                }
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * write method. Write tasks from the list to the stream in the JSON format
     *
     * @param tasks the tasks
     * @param out   the out
     */
    public static void write(AbstractTaskList tasks, Writer out) {
        try {
            Gson write = new Gson();
            write.toJson(tasks, out);
            out.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * write method. Write tasks from the list to the stream in the JSON format
     *
     * @param tasks the tasks
     * @param in    the out
     */
    public static void read(AbstractTaskList tasks, Reader in) {
        Gson read = new Gson();
        AbstractTaskList task;
        task = read.fromJson(in, tasks.getClass());
        for (Task t : task) {
            tasks.add(t);
        }
    }


    /**
     * writeText method. Write tasks to the file in JSON format
     *
     * @param tasks the tasks
     * @param file  file
     */
    public static void writeText(AbstractTaskList tasks, File file) {
        try (FileWriter fileWriter = new FileWriter(file)) {
            Gson gson = new Gson();
            LinkedTaskListImpl taskList = new LinkedTaskListImpl();
            tasks.getStream().forEach(taskList::add);
            gson.toJson(taskList, fileWriter);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * readText method. Read the tasks in JSON file.
     *
     * @param tasks the tasks
     * @param file  file
     */
    public static void readText(AbstractTaskList tasks, File file) {
        try (FileReader fileReader = new FileReader(file)) {
            Gson gson = new Gson();
            LinkedTaskListImpl taskList = gson.fromJson(fileReader, LinkedTaskListImpl.class);
            for (Task task : taskList) {
                tasks.add(task);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * write method. Write tasks from the list to the binary file.
     *
     * @param tasks the tasks
     * @param file  the file
     */
    public void write(AbstractTaskList tasks, File file) {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(file));
            writeBinary(tasks, dos);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * read. Read tasks from the binary file to the task list.
     *
     * @param tasks the tasks
     * @param file  the file
     */
    public void read(AbstractTaskList tasks, File file) {

        try {
            DataInputStream dos = new DataInputStream(new FileInputStream(file));
            readBinary(tasks, dos);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
