package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestCard {
    
    import org.junit.experimental.categories.Category;

    /**
     *
     * @author yw433
     * This test class (together with LargestTest3) is 
     * written to facilitate your 
     * understanding of Categories in suites (SlowTestSuite)
     */

    @Category({SlowTests.class, FastTests.class})
    public class LargestTest4 {
        
        public LargestTest4() {
        }
        
        @Test
        public void testOrder () {
        assertEquals (9, Largest.largest (new int[] {8 ,9 ,7}));
            assertEquals (9, Largest.largest (new int [] {8 ,9 ,7}));
            assertEquals (9, Largest.largest (new int [] {7 ,8 ,9}));

        }
        
        @Test
        public void testEmpty () {
            try {
                Largest.largest(new int [] {});
                fail (" Should have thrown an exception ");
            } catch (RuntimeException e) {
                assertTrue ( true );
            }
        }
        
    }
}
