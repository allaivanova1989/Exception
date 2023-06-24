import org.awaitility.Awaitility;

import org.awaitility.Duration;
import org.example.CreateBooking;


public class CreateBookingTest {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            if (CreateBooking.createBooking() == 200)
//                break;
//        }
        Awaitility
                .await()
                .atMost(Duration.TEN_SECONDS)
                .pollInterval(Duration.TWO_SECONDS)
                .until(() -> CreateBooking.createBooking() == 200);
    }

}

