package manager;
import model.Admin;
import model.Event;
import model.User;
import storage.DataAccess;

import java.time.LocalDate;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class EventManager {
     private final List<Event> events = DataAccess.getInstance().readEvents();
     private final Queue<Event> eventQueue = DataAccess.getInstance().readEventQueue();
     final Scanner scanner = new Scanner(System.in);
     private List<Event> listEvents() {
        return events;
    }
    private Queue<Event> listEventQueue() {
        return eventQueue;
    }
    public void addEvent(Event event, Admin admin) {
            if (admin.isAdmin) {
                events.add(event);
                DataAccess.getInstance().writeEvent(events);
                System.out.println("Add event success");
                System.out.println(listEvents());
            }else {
                System.out.println("Add event failed");
            }
    }

    public void addEventQueue(Event event , User user) {
        if (user.isUser) {
            eventQueue.add(event);
            DataAccess.getInstance().writeEventQueue(eventQueue);
            System.out.println("add queue success");
            event.setPendingApproval(true);
            System.out.println("set pending approval success");
            System.out.println(listEventQueue());
        } else {
            System.out.println("Add event failed");
        }
    }
    public void approveEvent(Admin admin) {
        if (admin.isAdmin) {
            System.out.println(listEventQueue());
            System.out.println("enter name event to approve: ");
            String name = scanner.nextLine();
            if (!listEventQueue().isEmpty()&& listEventQueue().peek().getName().equals(name)) {
                Event event = listEventQueue().poll();
                assert event != null;
                event.setApproved(true);
                events.add(event);
                DataAccess.getInstance().writeEvent(events);
                System.out.println("approve event success");
                System.out.println(listEvents());
                eventQueue.remove(event);
                DataAccess.getInstance().writeEventQueue(eventQueue);
                System.out.println("remove event success" +"\n"+"UpdateFile: " + listEventQueue());
            } else {
                System.out.println("list event queue is empty");
            }
        } else {
            System.out.println("approve event failed");
        }
    }
    public void editEvent(Admin admin) {
        if (admin != null && admin.isAdmin && events != null) {
            System.out.println(listEvents());
            System.out.println("enter name event to edit: ");
            String name = scanner.nextLine();
            boolean found = false;
            for (Event event1 : events) {
                if (event1.getName().equals(name)) {
                    found = true;
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
                    break;
                }
            }

            if (found) {
                DataAccess.getInstance().writeEvent(events);
                System.out.println("Edit event success");
            } else {
                System.out.println("Event not found");
            }
        } else {
            System.out.println("Invalid admin or events");
        }
    }

        public void deleteEvent(Admin admin) {
         System.out.println(listEvents());
         System.out.println("enter name event to delete: ");
         String name = scanner.nextLine();
            for (int i = 0; i < listEvents().size(); i++) {
                if (admin.isAdmin && listEvents().get(i).getName().equals(name)) {
                    events.remove(i);
                    System.out.println("Delete event success");
                    DataAccess.getInstance().writeEvent(events);
                    System.out.println(listEvents());
                    return;
                }
            }
        }


    public void searchEvent(Admin admin) {
         List<Event> events = DataAccess.getInstance().readEvents();
        System.out.println(listEvents());
        System.out.println("enter name event to search: ");
        String nameSearch = scanner.nextLine();
        System.out.println("enter creator event to search: ");
        String creatorSearch = scanner.nextLine();
        if (events != null){
            try{
                for (Event event : events) {
                    if (event.getName().equals(nameSearch) || event.getCreator().equals(creatorSearch))
                    {
                        System.out.println("true");
                        System.out.println(event);
                        return;
                    }
                }
            }catch (Exception e){
                System.out.println("Search event failed");
            }
        }
    }
}
