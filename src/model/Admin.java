package model;

import java.util.List;

public class Admin extends Account implements IUser{
    public boolean isAdmin;
    public Admin() {
    }
    public Admin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Admin(String username, String password, String name, String email, boolean isAdmin) {
        super(username, password, name, email);
        this.isAdmin = isAdmin;
    }

    @Override
    public boolean login(String username, String password) {
        if ("admin".equals(username) && "admin".equals(password)){
            return true;
        }
        return false;
    }

    @Override
    public boolean logout() {
        isAdmin = false;
        return true;
    }

    @Override
    public void createEvent(Event event) {

    }

    @Override
    public void editEvent(Event event) {

    }

    @Override
    public void deleteEvent(Event event) {

    }

    @Override
    public List<Event> listEvents() {
        return null;
    }

    @Override
    public Event searchEvents(String name, String time, String location, String description, String creator) {
        return null;
    }

    @Override
    public void exportEvents(String name, String time, String location, String description, String creator) {

    }
}
