package storage;

import model.Event;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccess implements IDataAccess{
    public List<Event> events = new ArrayList<>();
    private static DataAccess instance;

    private final String fileEvent = "event.csv";
    private DataAccess(){}
    public static DataAccess getInstance(){
        if (instance == null){
            instance = new DataAccess();
        }
        return instance;
    }


    @Override
    public List<Event> readEvents() {
        try {
            File file = new File(fileEvent);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!= null){
                String[] data = line.split(",");
                Event event = new Event();
                event.setName(data[0]);
                event.setTime(LocalDate.parse(data[1]));
                event.setLocation(data[2]);
                event.setDescription(data[3]);
                event.setCreator(data[4]);
                events.add(event);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return events;
    }

    @Override
    public void writeEvent(List<Event> events) {
        try {
            File file = new File(fileEvent);
            FileWriter fileWriter = new FileWriter(file);
            if (!file.exists()){
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Event event: events){
                bufferedWriter.write(event.getName()+","+event.getTime()+","+event.getLocation()+","+event.getDescription()+","+event.getCreator());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}