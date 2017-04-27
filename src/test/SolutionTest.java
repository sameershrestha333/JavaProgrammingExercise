package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.java.Solution;

public class SolutionTest {
	private Solution objSolution;

	@Before
	public void setUp() throws Exception {
		objSolution = new Solution();
	}

	@Test
	public void testMain() {

		Map<String, List<String>> realData = objSolution.mainTask();

		List<String> sampleData = new ArrayList<>();
		sampleData.add("bood");
		sampleData.add("good");
		sampleData.add("programmer.");
	//	System.out.println("From test");
		realData.get("words").forEach(System.out::println);
		//System.out.println("Sample Data");

		//sampleData.forEach(System.out::println);

		assertArrayEquals(sampleData.toArray(), realData.get("words").toArray());
	}

}
