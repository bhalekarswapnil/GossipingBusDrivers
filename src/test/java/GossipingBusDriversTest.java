import org.example.GossipingBusDrivers;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GossipingBusDriversTest {


    @Test
    public void testDriverNeverGossips() {
        int[][] driverRoutes = {
                {2, 1, 2},
                {5, 2, 8}
        };
        int expectedOutput = -1; // never
        assertEquals(expectedOutput, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }

    @Test
    public void testTwoDriversSameRoute() {
        int[][] driverRoutes = {
                {1, 2, 3},
                {1, 2, 3}
        };
        int expectedOutput = 3; // Two drivers, all gossips in 3 stops (same route)
        assertEquals(expectedOutput, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }

    @Test
    public void testMultipleDriversDifferentRoutes() {


        int[][] driverRoutes = {
                {3,1,2,3},
                {3,2,3,1},
                {4, 2,3,4,5 },
        };
        int expectedOutput = 5; // All drivers meet at stop 12, so all gossips in 12 stops
        assertEquals(expectedOutput, GossipingBusDrivers.getNumberStopsForSharingAllGosips(driverRoutes));
    }
}