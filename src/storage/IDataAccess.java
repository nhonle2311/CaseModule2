package storage;

import model.Event;

import java.util.List;

public interface IDataAccess {
    List<Event> readEvents() throws Exception;
    void writeEvent(List<Event> events) throws Exception;
}
