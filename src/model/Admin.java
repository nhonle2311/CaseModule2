package model;

public class Admin implements IUser {

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public boolean logout() {
        return false;
    }

    @Override
    public void createEvent(String name, String time, String location, String description, String creator) {

    }

    @Override
    public void editEvent(String name, String time, String location, String description, String creator) {

    }

    @Override
    public void deleteEvent(String name, String time, String location, String description, String creator) {

    }

    @Override
    public void listEvents() {

    }

    @Override
    public void searchEvents(String name, String time, String location, String description, String creator) {

    }

    @Override
    public void exportEvents(String name, String time, String location, String description, String creator) {
    }
    public void approveUser(String username) {
    }
    public void rejectEvent(String username) {
    }
}
