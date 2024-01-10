package model;

import manager.EventManager;
import storage.DataAccess;

import java.util.List;
public class User extends Account implements IUser {
    private boolean isUser;

    public User(boolean isUser) {
        this.isUser = isUser;
    }

    public User(String username, String password, String name, String email, boolean isUser) {
        super(username, password, name, email);
        this.isUser = isUser;
    }

    @Override
    public boolean login(String username, String password) {
        //username = sdt 10 so ssuwrdungj regex,  password = 6 so
        try {
            if (username.matches("[0-9]{10}") && password.matches("[0-9]{6}")) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Login failed");
        }
        return false;
    }

    @Override
    public boolean logout() {
        //logout
        isUser = false;
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