package model;

import model.Event;
import model.EventLog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for the Event class
 */
public class EventTest {
	private Event e;
	private Date d;
	
	//NOTE: these tests might fail if time at which line (2) below is executed
	//is different from time that line (1) is executed.  Lines (1) and (2) must
	//run in same millisecond for this test to make sense and pass.
	
	@BeforeEach
	public void runBefore() {
		e = new Event("Added Ice Capp");   // (1)
		d = Calendar.getInstance().getTime();   // (2)
	}
	
	@Test
	public void testEvent() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertEquals("Added Ice Capp", e.getDescription());
		assertEquals(sdf.format(d), sdf.format(e.getDate()));
	}

	@Test
	public void testToString() {
		assertEquals(d.toString() + "\n" + "Added Ice Capp", e.toString());
	}
}
