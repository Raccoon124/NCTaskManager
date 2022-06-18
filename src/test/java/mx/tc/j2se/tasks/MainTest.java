package mx.tc.j2se.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {
	@Test
	public void mainTest() {

		TaskImpl task = new TaskImpl("salir a correr por las mañanas a las 7 am 17 junio 2022",13,25,0);

		assertTrue(true);
	}
}
