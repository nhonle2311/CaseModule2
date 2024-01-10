package storage;

import model.Event;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IDataAccess {
    List<Event> readEvents() throws IOException;
    void writeEvent(List<Event> events) throws IOException;
}
