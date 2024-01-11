package storage;

import model.Event;

import java.util.List;
import java.util.Queue;

public interface IDataAccess {
    List<Event> readEvents();
    void writeEvent(List<Event> events);

    Queue<Event> readEventQueue();

    void writeEventQueue(Queue<Event> eventQueue);
}
