package agenda;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    private ChronoUnit frequency;
    private ArrayList<LocalDate> exceptions= new ArrayList<LocalDate>();

    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency=frequency;

    }

    @Override
    public boolean isInDay(LocalDate aDay) {
        if (exceptions.contains(aDay))
                return false;
        return super.isInDay(aDay);
    }

    public void addException(LocalDate date) {
        exceptions.add(date);
    }


    public ChronoUnit getFrequency() {
        return frequency;
    }

}
