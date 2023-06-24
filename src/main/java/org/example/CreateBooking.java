package org.example;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


public class CreateBooking {
    public static int createBooking() {
        int randomNumber = (int) (Math.random() * (50 - 1) + 1);
        System.out.println(randomNumber);
        if (randomNumber % 2 == 0) {
            System.out.println("Booking creating");
            return RestAssured
                    .given()
                    .body("{\n" +
                            "    \"firstname\" : \"Jim\",\n" +
                            "    \"lastname\" : \"Brown\",\n" +
                            "    \"totalprice\" : 111,\n" +
                            "    \"depositpaid\" : true,\n" +
                            "    \"bookingdates\" : {\n" +
                            "        \"checkin\" : \"2018-01-01\",\n" +
                            "        \"checkout\" : \"2019-01-01\"\n" +
                            "    },\n" +
                            "    \"additionalneeds\" : \"Breakfast\"\n" +
                            "}")
                    .contentType(ContentType.JSON)
                    .post("https://restful-booker.herokuapp.com/booking")
                    .statusCode();
        } else {
            System.out.println("Booking creation failed");
            return 0;
        }
    }


}
