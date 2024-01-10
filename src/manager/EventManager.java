package manager;
import model.Admin;
import model.Event;
import storage.DataAccess;

import java.util.List;

public class EventManager {
    List<Event> events = DataAccess.getInstance().readEvents();

    public EventManager() {
    }

    public List<Event> listEvents() {
        return events;
    }

    public void addEvent(Event event, Admin admin) {
        try {
            if (admin.isAdmin) {
                events.add(event);
                DataAccess.getInstance().writeEvent(events);
            }
        } catch (Exception e) {
            System.out.println("Create event failed");
        }
    }

    public void editEvent(Event event, Admin admin) {
        try {
            if (admin.isAdmin) {
                for (Event event1 : events) {
                    if (event1.getName().equals(event.getName())) {
                        event1.setName(event.getName());
                        event1.setTime(event.getTime());
                        event1.setLocation(event.getLocation());
                        event1.setDescription(event.getDescription());
                        event1.setCreator(event.getCreator());
                    }
                }
                DataAccess.getInstance().writeEvent(events);
            }
        } catch (Exception e) {
            System.out.println("Edit event failed");
        }
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
        for (Event event : events) {
            if (event.getName().equals(name)
                    && event.getTime().equals(time)
                    && event.getLocation().equals(location)
                    && event.getDescription().equals(description)
                    && event.getCreator().equals(creator)) {
                return event;
            }
        }
        return null;
    }
}
