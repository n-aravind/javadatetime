import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");

        LocalDateTime leaving = LocalDateTime.of(Year.now().getValue(), Month.FEBRUARY, 14, 12, 0);
        ZoneId leavingTimeZone = ZoneId.of("America/New_York");
        ZonedDateTime departure = ZonedDateTime.of(leaving, leavingTimeZone);

        try {
            System.out.printf("LEAVING:  %s (%s)%n", departure.format(format), leavingTimeZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }


        ZoneId arrivingTimeZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime arrival = departure.withZoneSameInstant(arrivingTimeZone).plusMinutes(323);

        try {
            System.out.printf("ARRIVING: %s (%s)%n", arrival.format(format), arrivingTimeZone);
        } catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", arrival);
            throw exc;
        }
    }
}
