package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    private ArrayList<Event> theEvents = new ArrayList<Event>();

    public Agenda() {

    }

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */

    public void addEvent(Event e) {
        theEvents.add(e);
    }


    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> eventThisDay = new ArrayList<Event>();
        for (Event e: theEvents){
            if (e.isInDay(day)) eventThisDay.add(e);
        }
        return eventThisDay;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList<Event> sameTitle = new ArrayList<Event>();
        for (Event e : theEvents) {
            if (e.getTitle().equals(title)) {
                sameTitle.add(e);
            }
        }
        return sameTitle;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        boolean res = true;
        for (Event alreadyE : theEvents){
            if (e.getStart().plus(e.getDuration()).isAfter(alreadyE.getStart()) && e.getStart().isBefore(alreadyE.getStart().plus(alreadyE.getDuration()))){
                res = false;
            }
        }
        return res;
    }

}
