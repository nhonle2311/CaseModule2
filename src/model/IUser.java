package model;

import java.util.List;

public interface IUser {
    //login
     boolean login(String username, String password);
    // logout
     boolean logout();
    //create event
     void createEvent(Event event);
    //edit event
     void editEvent(Event event);
    //delete event
    void deleteEvent(Event event);
    //list events
    List<Event> listEvents();
    //search events
    Event searchEvents(String name, String time, String location, String description, String creator);
    //export events
    void exportEvents(String name, String time, String location, String description, String creator);
}
