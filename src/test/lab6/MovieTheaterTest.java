import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTheaterTest {

    @Test
    public void testBookSeats() {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.bookSeats(1, 2, new int[]{3, 4, 5});
        assertEquals(true, movieTheater.checkAvailability(1, 4));
    }

    @Test
    public void testCancelBooking() {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.bookSeats(1, 2, new int[]{3, 4, 5});
        movieTheater.cancelBooking(1, 2, new int[]{3, 4, 5});
        assertEquals(false, movieTheater.checkAvailability(1, 4));
    }

    @Test
    public void testCheckAvailability() {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.bookSeats(1, 2, new int[]{3, 4, 5});
        assertEquals(true, movieTheater.checkAvailability(1, 4));
        movieTheater.cancelBooking(1, 2, new int[]{3, 4, 5});
        assertEquals(false, movieTheater.checkAvailability(1, 4));
    }
}
