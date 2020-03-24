package com.java.cmsc_203_Lab6;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

	class GradeBookTest {
	private GradeBook gB, gB1, gB2, gB3;
	@BeforeEach
	void setUp() throws Exception {				
	gB=new GradeBook(5);
	gB1=new GradeBook(6);
	gB2=new GradeBook(7);
	gB.addScore(50);
	gB.addScore(40);
	gB.addScore(30);
	gB.addScore(20);
	gB.addScore(10);
	
	//gB1.addScore(30);
	//gB1.addScore(20);
	//gB2.addScore(78.6);
	//gB2.addScore(0.78);
	//gB2.addScore(1.9);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	gB=gB1=null;
	}

	@Test
	void testAddScore() {
		//assertTrue(gB.toString().equals(“50.0 75.0 ”);
		assertEquals("[50.0, 40.0, 30.0, 20.0, 10.0]", gB.toString());
	}

	@Test
	void testSum() {
		
		assertEquals(150, gB.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(10, gB.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(140, gB.finalScore());
	}

	@Test
	void testGetScoreSize() {
		assertEquals(5, gB.getScoreSize());
	}

	@Test
	void testToStringDoubleArray() {
		assertEquals("[50.0, 40.0, 30.0, 20.0, 10.0]", gB.toString());
		
	}
	

}
