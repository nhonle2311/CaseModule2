package view;//src


import model.Admin;
import model.Event;
import storage.DataAccess;
import manager.EventManager;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Event> events = new ArrayList<>();
        Event event1 = new Event("event1", LocalDate.parse("2021-01-01"), "location1", "description1", "creator1");
        EventManager eventManager = new EventManager();
        //login
        Admin admin = new Admin(true);
        System.out.println(eventManager.listEvents());
        System.out.println(eventManager.addEvent(event1, admin));
        System.out.println(eventManager.editEvent(event1,admin));
        System.out.println(eventManager.listEvents());
    }
}