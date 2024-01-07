import java.util.Arrays;

public class MovieTheater {

    private static final int NUM_HALLS = 5;
    private static final int NUM_ROWS = 10;
    private static final int NUM_SEATS = 20;

    private int[][][] seatingArrangement;

    public MovieTheater() {
        seatingArrangement = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS];
    }

    public void bookSeats(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 0) {
                seatingArrangement[hallNumber][row][seat] = 1;
            } else {
                System.out.println("Selected seats are already booked.");
            }
        }
    }

    public void cancelBooking(int hallNumber, int row, int[] seats) {
        for (int seat : seats) {
            if (seatingArrangement[hallNumber][row][seat] == 1) {
                seatingArrangement[hallNumber][row][seat] = 0;
            } else {
                System.out.println("Selected seats are not booked.");
            }
        }
    }

    public boolean checkAvailability(int hallNumber, int numSeats) {
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS - numSeats + 1; seat++) {
                boolean allSeatsAvailable = true;
                for (int i = 0; i < numSeats; i++) {
                    if (seatingArrangement[hallNumber][row][seat + i] != 0) {
                        allSeatsAvailable = false;
                        break;
                    }
                }
                if (allSeatsAvailable) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printSeatingArrangement(int hallNumber) {
        System.out.println("Seating Arrangement for Hall " + hallNumber);
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int seat = 0; seat < NUM_SEATS; seat++) {
                if (seatingArrangement[hallNumber][row][seat] == 0) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MovieTheater movieTheater = new MovieTheater();
        movieTheater.bookSeats(1, 2, new int[]{3, 4, 5});
        movieTheater.printSeatingArrangement(1);
        System.out.println(movieTheater.checkAvailability(1, 4));
        movieTheater.cancelBooking(1, 2, new int[]{3, 4, 5});
        movieTheater.printSeatingArrangement(1);
        System.out.println(movieTheater.checkAvailability(1, 4));
    }
}
