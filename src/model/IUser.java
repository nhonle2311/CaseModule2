package model;

public interface IUser {
    //login
     boolean login(String username, String password);
    // logout
     boolean logout();
    //create event
     void createEvent(String name, String time, String location, String description, String creator);
    //edit event
     void editEvent(String name, String time, String location, String description, String creator);
    //delete event
    void deleteEvent(String name, String time, String location, String description, String creator);
    //list events
    void listEvents();
    //search events
    void searchEvents(String name, String time, String location, String description, String creator);
    //export events
    void exportEvents(String name, String time, String location, String description, String creator);
}
