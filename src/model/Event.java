package model;

import java.time.LocalDate;

public class Event {
    private String name;
    private LocalDate time;
    private String location;
    private String description;
    private String creator;
    private boolean approved;

    public Event() {
    }

    public Event(String name, LocalDate time, String location, String description, String creator) {
        this.name = name;
        this.time = time;
        this.location = location;
        this.description = description;
        this.creator = creator;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", creator='" + creator + '\'' +
                '}';
    }


}
