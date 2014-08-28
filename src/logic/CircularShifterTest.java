package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import storage.Title;

public class CircularShifterTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
		CircularShifter cs = new CircularShifter();
		HashMap<String, Integer> sw = new HashMap<String, Integer>(); 
		sw.put("the", 1);
		sw.put("a", 1);
		sw.put("I", 1);
		sw.put("you", 1);
		sw.put("he", 1);
		sw.put("she", 1);
		sw.put("is", 1);
		sw.put("am", 1);
		sw.put("are", 1);
		ArrayList<Title> titles = cs.computeCircularShifts
				(sw, "This is a test you know", 1);
		for (Title title: titles){
			System.out.println(title.getLine() + "\t\t" + title.getIndex());
		}
	}
	

}
