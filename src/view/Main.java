package view;//src


import model.Admin;
import model.Event;
import model.User;
import storage.DataAccess;
import manager.EventManager;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Event event1 = new Event("event1", LocalDate.parse("2021-01-01"), "location1", "description1", "creator1");
        Event event4 = new Event("event4", LocalDate.parse("2021-01-02"), "location2", "description2", "creator2");
        EventManager eventManager = new EventManager();
        //login
        Admin admin = new Admin(true);


//        System.out.println(eventManager.listEvents());
//        System.out.println(eventManager.addEvent(event1, admin));
//        System.out.println(eventManager.editEvent(event1,admin));
//        System.out.println(eventManager.listEvents());
//        System.out.println(eventManager.deleteEvent(event1,admin));
//        System.out.println(eventManager.listEvents());
//        System.out.println(eventManager.searchEvent(event1.getName(),event1.getCreator()));
        User user1 = new User("0123456789","Nguy12","Nguyen Van A","nguyenvana@gmail.com",true);
        user1.login("0123456789","Nguy12");
        System.out.println(user1.login("0123456789","Nguy12"));
        eventManager.addEventQueue(event4 ,user1,admin);
}
}