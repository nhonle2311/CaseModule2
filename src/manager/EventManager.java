package manager;
import model.Admin;
import model.Event;
import model.User;
import storage.DataAccess;

import java.io.IOException;
import java.util.List;

public class EventManager {
    List<Event> events = DataAccess.getInstance().readEvents();

    public EventManager() throws IOException {
    }

    public void createEvent(Event event, Admin admin) {
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
}
