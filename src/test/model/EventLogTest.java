package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Event;
import model.EventLog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the EventLog class
 */
public class EventLogTest {
	private Event e1;
	private Event e2;
	private Event e3;
	
	@BeforeEach
	public void loadEvents() {
		e1 = new Event("Added Ice Capp");
		e2 = new Event("Removed Ice Capp");
		e3 = new Event("Added Bagel");
		EventLog el = EventLog.getInstance();
		el.logEvent(e1);
		el.logEvent(e2);
		el.logEvent(e3);
	}
	
	@Test
	public void testLogEvent() {	
		List<Event> l = new ArrayList<Event>();
		
		EventLog el = EventLog.getInstance();
		for (Event next : el) {
			l.add(next);
		}
		
		assertTrue(l.contains(e1));
		assertTrue(l.contains(e2));
		assertTrue(l.contains(e3));
	}

	@Test
	public void testClear() {
		EventLog el = EventLog.getInstance();
		el.clear();
		Iterator<Event> itr = el.iterator();
		assertTrue(itr.hasNext());   // After log is cleared, the clear log event is added
		assertEquals("Event log cleared.", itr.next().getDescription());
		assertFalse(itr.hasNext());
	}
}
