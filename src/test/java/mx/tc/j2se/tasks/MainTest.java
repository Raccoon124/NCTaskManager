package mx.tc.j2se.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
	@Test
	public void mainTest() {

		TaskImpl task = new TaskImpl("correr por la mañana",10,20,0);

		task.isRepeated();
		System.out.println(task.isRepeated());

	}
}
