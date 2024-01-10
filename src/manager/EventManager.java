package manager;
import model.Admin;
import model.Event;
import storage.DataAccess;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class EventManager {
     private final List<Event> events = DataAccess.getInstance().readEvents();
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

    public boolean editEvent(Event event, Admin admin) {
        Scanner scanner = new Scanner(System.in);
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

    public void deleteEvent(Event event, Admin admin) {
        // xoa theo ten
        try {
            if (admin.isAdmin) {

                for (Event event1 : events) {
                    if (event1.getName().equals(event.getName())) {
                        events.remove(event1);
                    }
                }
                DataAccess.getInstance().writeEvent(events);
            }
        } catch (Exception e) {
            System.out.println("Delete event failed");
        }
    }
    public Event searchEvent(String name, String time, String location, String description, String creator) {
        if (events != null){
            try{
                for (Event event : events) {
                    if (event.getName().equals(name)
                            && event.getTime().equals(time)
                            && event.getLocation().equals(location)
                            && event.getDescription().equals(description)
                            && event.getCreator().equals(creator)) {
                        return event;
                    }
                }
            }catch (Exception e){
                System.out.println("Search event failed");
            }
        }
        return null;
    }
}
