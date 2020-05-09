

	
	import static org.junit.Assert.*;

	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;

	public class MoviePassTest {
		MoviePass m1,m2,m3,m4,m5,m6;
		

		@Before
		public void setUp() throws Exception {
			
			m1 = new MoviePass("HUMTUM", "NR", 3,20,"NONE","MoviePass",788788);
		
			m2 = new MoviePass("English Medium", "G", 2,13,"IMAX","MoviePass",588588);
			
			m3 = new MoviePass("Life of Pi", "PG13", 3,12,"NONE","MoviePass",388388);
			
			m4 = new MoviePass("Book Club", "PG13", 1,13,"IMAX",45678,3);
		
			m5 = new MoviePass("Life of pi", "PG13", 3,21,"3D",47578,0);
		
			m6 = new MoviePass("HUMTUM", "PG13", 2,14,"3D",87500,3);
		}

		@After
		public void tearDown() throws Exception {
			m1=m2=m3=m4=m5=m6=null;
		}

		@Test
		public void test() {
			
			assertEquals(14.796,m2.calculateTicketPrice(),.01);
			assertEquals(14.796,m4.calculateTicketPrice(),.01);
			assertEquals(17.536,m5.calculateTicketPrice(),.01);
			
		}

	}



