package manager;
import model.Admin;
import model.Event;
import model.User;
import storage.DataAccess;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class EventManager {
     private final List<Event> events = DataAccess.getInstance().readEvents();
     private final Queue<Event> eventQueue = DataAccess.getInstance().readEventQueue();
     final Scanner scanner = new Scanner(System.in);
     public List<Event> listEvents() {
        return events;
    }

    public boolean addEvent(Event event, Admin admin) {
            if (admin.isAdmin) {
                events.add(event);
                DataAccess.getInstance().writeEvent(events);
                return true;
            }else {
                System.out.println("Add event failed");
            }
        return false;
    }
    public boolean addEventQueue(Event event, User user, Admin admin) {
           if (user.isUser) {
               eventQueue.add(event);
               DataAccess.getInstance().writeEventQueue(eventQueue);
               if(admin.isAdmin && eventQueue.contains(event)){
                   if (event.isApproved()){
                       if (!events.contains(event)){
                       events.add(event);
                       DataAccess.getInstance().writeEvent(events);
                       System.out.println("Add event success");
                         return true;
                       }else {
                           System.out.println("Add event failed");
                       }
                   }else {
                       eventQueue.remove(event);
                       System.out.println("event is not approved, remove from queue");
                   }
                   return true;
                   }
           }
        return false;
    }


    public boolean editEvent(Event event, Admin admin) {
        if (admin.isAdmin) {
            System.out.println("enter name event to edit: ");
            String name = scanner.nextLine();
                for (Event event1 : events) {
                    if (event1.getName().equals(name)) {
                        System.out.println("true");
                        System.out.println("enter new name: ");
                        event1.setName(scanner.nextLine());
                        System.out.println("enter new time: ");
                        event1.setTime(LocalDate.parse(scanner.nextLine()));
                        System.out.println("enter new location: ");
                        event1.setLocation(scanner.nextLine());
                        System.out.println("enter new description: ");
                        event1.setDescription(scanner.nextLine());
                        System.out.println("enter new creator: ");
                        event1.setCreator(scanner.nextLine());
                    }
                    DataAccess.getInstance().writeEvent(events);
                    System.out.println("Edit event success");
                    return true;
                }

            }else {
                System.out.println("Edit event failed");
            }
        return false;
    }

    public boolean deleteEvent(Event event, Admin admin) {
        // xoa theo ten
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter name event to delete: ");
        String name = scanner.nextLine();
        try {
            if (admin.isAdmin) {
                Iterator<Event> iterator = events.iterator();
                while (iterator.hasNext()) {
                    Event event1 = iterator.next();
                    if (event1.getName().equals(name)) {
                        iterator.remove();
                    }
                }
                DataAccess.getInstance().writeEvent(events);
                return true;
            }
        } catch (Exception e) {
            System.out.println("Delete event failed");
        }
        return false;
    }
    public List<Event> searchEvent(String name,String creator) {
         List<Event> events = DataAccess.getInstance().readEvents();
        System.out.println("enter name event to search: ");
        String nameSearch = scanner.nextLine();
        if (events != null){
            try{
                for (Event event : events) {
                    if (event.getName().equals(nameSearch) || event.getCreator().equals(nameSearch))
                    {
                        // trùng thì sao?
                        System.out.println("true");
                        events.add(event);
                        return events;
                    }
                }
            }catch (Exception e){
                System.out.println("Search event failed");
            }
        }
        return null;
    }
}
