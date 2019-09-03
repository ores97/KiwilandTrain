package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import TrainSystem.KiwiLandTrain;

public class KiwiLandTrainTest {
	//Big Test for test input
	@Test
	public void calculateDistanceTestInput() {
		System.out.println("\nTEST INPUT:\n");
		//we put the expected output
	    final String expected = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7\n" + "Expected Output:\nOutput #1: 9\n" + "Output #2: 5\n" + "Output #3: 13\n" + "Output #4: 22\n" + "Output #5: NO SUCH ROUTE\n";
	    KiwiLandTrain testSystem = new KiwiLandTrain();
	    //we put the routes given
	    String[] a1 = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
	    testSystem.addRoutesGiven(a1);
	    //we put the routes that the system has to make (MANUAL VERSION FOR THE TEST
	    ArrayList <ArrayList<String>> routesToCalculate = new ArrayList <ArrayList<String>>();
	    ArrayList<String> s1 = new ArrayList<String>();
	    s1.add("A");
	    s1.add("B");
	    s1.add("C");
	    routesToCalculate.add(s1);
	    s1 = new ArrayList<String>();
	    s1.add("A");
	    s1.add("D");
	    routesToCalculate.add(s1);
	    s1 = new ArrayList<String>();
	    s1.add("A");
	    s1.add("D");
	    s1.add("C");
	    routesToCalculate.add(s1);
	    s1 = new ArrayList<String>();
	    s1.add("A");
		s1.add("E");
		s1.add("B");
		s1.add("C");
		s1.add("D");
	    routesToCalculate.add(s1);
	    s1 = new ArrayList<String>();
	    s1.add("A");
		s1.add("E");
		s1.add("D");
		routesToCalculate.add(s1);
	    testSystem.setRoutesToCalculate(routesToCalculate);
	    //we calculate the distances
	    testSystem.calculateDistances();
	    //we print the results of the output and save it in the system
	    testSystem.printResults();
	    final String actual = testSystem.getOutputResult();
	    //we test the result of it
	    Assert.assertEquals(expected, actual);
	}
	//Tests for given routes to calculate
	@Test
	public void calculateDistanceABC() {
		System.out.println("\nTEST ABC:\n");
		//we put the expected output for the test
		final String expected = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7\n" + "Expected Output:\nOutput #1: 9\n";
	    KiwiLandTrain testSystem = new KiwiLandTrain();
	    //we put the routes given
	    String[] a1 = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
	    testSystem.addRoutesGiven(a1);
	    //we put the routes that the system has to make
	    ArrayList <ArrayList<String>> routesToCalculate = new ArrayList <ArrayList<String>>();
	    ArrayList<String> s1 = new ArrayList<String>();
	    s1.add("A");
	    s1.add("B");
	    s1.add("C");
	    routesToCalculate.add(s1);
	    testSystem.setRoutesToCalculate(routesToCalculate);
	    //we calculate the distances
	    testSystem.calculateDistances();
	    testSystem.printResults();
	    final String actual = testSystem.getOutputResult();
	    //we test the result of it
	    Assert.assertEquals(expected, actual);
	    
	}
	@Test
	public void calculateDistanceAD() {
		System.out.println("\nTEST AD:\n");
		//we put the expected output for the test
		final String expected = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7\n" + "Expected Output:\nOutput #1: 5\n";
	    KiwiLandTrain testSystem = new KiwiLandTrain();
	    //we put the routes given
	    String[] a1 = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
	    testSystem.addRoutesGiven(a1);
	    //we put the routes that the system has to make
	    ArrayList <ArrayList<String>> routesToCalculate = new ArrayList <ArrayList<String>>();
	    ArrayList<String> s1 = new ArrayList<String>();
	    s1.add("A");
	    s1.add("D");
	    routesToCalculate.add(s1);
	    testSystem.setRoutesToCalculate(routesToCalculate);
	    //we calculate the distances
	    testSystem.calculateDistances();
	    testSystem.printResults();
	    final String actual = testSystem.getOutputResult();
	    //we test the result of it
	    Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceADC() {
		System.out.println("\nTEST ADC:\n");
		//we put the expected output for the test
		final String expected = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7\n" + "Expected Output:\nOutput #1: 13\n";
	    KiwiLandTrain testSystem = new KiwiLandTrain();
	    //we put the routes given
	    String[] a1 = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
	    testSystem.addRoutesGiven(a1);
	    //we put the routes that the system has to make
	    ArrayList <ArrayList<String>> routesToCalculate = new ArrayList <ArrayList<String>>();
	    ArrayList<String> s1 = new ArrayList<String>();
	    s1.add("A");
	    s1.add("D");
	    s1.add("C");
	    routesToCalculate.add(s1);
	    testSystem.setRoutesToCalculate(routesToCalculate);
	    //we calculate the distances
	    testSystem.calculateDistances();
	    testSystem.printResults();
	    final String actual = testSystem.getOutputResult();
	    //we test the result of it
	    Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceAEBCD() {
		System.out.println("\nTEST AEBCD:\n");
		//we put the expected output for the test
		final String expected = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7\n" + "Expected Output:\nOutput #1: 22\n";
		KiwiLandTrain testSystem = new KiwiLandTrain();
		//we put the routes given
		String[] a1 = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
		testSystem.addRoutesGiven(a1);
		//we put the routes that the system has to make
		ArrayList <ArrayList<String>> routesToCalculate = new ArrayList <ArrayList<String>>();
		ArrayList<String> s1 = new ArrayList<String>();
		s1.add("A");
		s1.add("E");
		s1.add("B");
		s1.add("C");
		s1.add("D");
		routesToCalculate.add(s1);
		testSystem.setRoutesToCalculate(routesToCalculate);
		//we calculate the distances
		testSystem.calculateDistances();
		testSystem.printResults();
		final String actual = testSystem.getOutputResult();
		//we test the result of it
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void calculateDistanceAED() {
		System.out.println("\nTEST AED:\n");
		//we put the expected output for the test
		final String expected = "Graph: AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7\n" + "Expected Output:\nOutput #1: NO SUCH ROUTE\n";
		KiwiLandTrain testSystem = new KiwiLandTrain();
		//we put the routes given
		String[] a1 = {"AB5", "BC4", "CD8", "DC8", "DE6", "AD5", "CE2", "EB3", "AE7"};
		testSystem.addRoutesGiven(a1);
		//we put the routes that the system has to make
		ArrayList <ArrayList<String>> routesToCalculate = new ArrayList <ArrayList<String>>();
		ArrayList<String> s1 = new ArrayList<String>();
		s1.add("A");
		s1.add("E");
		s1.add("D");
		routesToCalculate.add(s1);
		testSystem.setRoutesToCalculate(routesToCalculate);
		//we calculate the distances
		testSystem.calculateDistances();
		testSystem.printResults();
		final String actual = testSystem.getOutputResult();
		//we test the result of it
		Assert.assertEquals(expected, actual);
	}
}
