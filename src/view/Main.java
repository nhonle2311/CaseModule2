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
        //login
        List<Event> events = new ArrayList<>();
        events.add(new Event("event1", LocalDate.parse("2021-01-01"), "location1", "description1", "creator1"));
    }
}