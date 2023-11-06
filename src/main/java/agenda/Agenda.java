package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private ArrayList<Event> lesEvenements = new ArrayList<Event>();

    public Agenda() {
        this.lesEvenements = null;
    }

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */

    public void addEvent(Event e) {
        lesEvenements.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return a list of events that occur on that day
     */

    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> eventThisDay = new ArrayList<Event>();
        for (Event e: lesEvenements){
            if (e.isInDay(day)) eventThisDay.add(e);
        }
        return eventThisDay;
    }
}
