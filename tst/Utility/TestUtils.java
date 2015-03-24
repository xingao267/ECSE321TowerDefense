package Utility;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests for Util class
 *
 * @author Xin
 *
 */
public class TestUtils {

    @Before
    public void setup() {

    }

    @Test
    public void testGetDistance() throws Exception {

        long distance1 = (long) Utils.getDistance(0, 0, 0, 0);
        assertEquals(0, distance1);

        long distance2 = (long) Utils.getDistance(0, 5, 0, 0);
        assertEquals(5, distance2);

        long distance3 = (long) Utils.getDistance(5, 5, 0, 0);
        assertEquals((long) (5 * Math.sqrt(2)), distance3);
    }

}
