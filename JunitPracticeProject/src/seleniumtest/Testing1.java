package seleniumtest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testing1 {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("print brfore class");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("print after class");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("print before evry test");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("print after evry test");
	}

	@Test
	public void test1() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		System.out.println("test 1");
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
	}
	
	@Test
	public void test2() {
		System.out.println("######################");
		System.out.println("test 2");
		System.out.println("######################");
	}
	
	@Test
	public void test3() {
		System.out.println("*********************");
		System.out.println("test 3");
		System.out.println("*********************");
	}

}
