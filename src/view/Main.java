package view;//src


import model.Admin;
import model.Event;
import model.User;
import manager.EventManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        EventManager eventManager = new EventManager();
        int choice = -1;
        while (choice!= 0) {
            System.out.println(" choose account type");
            System.out.println("1: Admin");
            System.out.println("2: User");
            System.out.println("0: exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    loginAdmin(scanner);
                    int choiceAd = -1;
                    while (choiceAd != 0) {
                        System.out.println(" choose action");
                        System.out.println("0: exit");
                        System.out.println("1: add event to list event");
                        System.out.println("2 :edit event by name");
                        System.out.println("3 :delete event by name");
                        System.out.println("4 :seach event by name or creator");
                        System.out.println("5 :approve event");
                        choiceAd = scanner.nextInt();
                        switch (choiceAd) {
                            case 0:
                                break;
                            case 1:
                                eventManager.addEvent(getEvent(scanner), getAdmin("admin", "admin"));
                                break;
                            case 2:
                                eventManager.editEvent(getAdmin("admin", "admin"));
                                break;
                            case 3:
                                eventManager.deleteEvent(getAdmin("admin", "admin"));
                                break;
                            case 4:
                                eventManager.searchEvent(getAdmin("admin", "admin"));
                                break;
                            case 5:
                                eventManager.approveEvent(getAdmin("admin", "admin"));
                                break;
                            default:
                                System.out.println("invalid choice");
                        }
                    }
                    break;
                case 2:
                    loginUser(scanner);
                    int choiceUs = -1;
                    while (choiceUs != 0) {
                        System.out.println(" choose action");
                        System.out.println("0.exit");
                        System.out.println("1: add event to queue");
                        System.out.println("2: Seach event by name or creator");
                        choiceUs = scanner.nextInt();
                        switch (choiceUs) {
                            case 0:
                                break;
                            case 1:
                                eventManager.addEventQueue( getEvent(scanner), getUser("user1", "123456"));
                                break;

                            case 2:
//                                eventManager.searchEvent( );
                                break;
                            default:
                                System.out.println("invalid choice");
                        }
                    }
                   break;
                case 3:
                    System.exit(0);
                default: {
                    System.out.println("invalid choice");
                }
            }
        }
        getEvent(scanner);
    }

    private static Event getEvent(Scanner scanner) {
        System.out.println("input name event");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("input time event");
        LocalDate time = LocalDate.parse(scanner.nextLine());
        System.out.println("input location event");
        String location = scanner.nextLine();
        System.out.println("input description event");
        String description = scanner.nextLine();
        System.out.println("input creator event");
        String creator = scanner.nextLine();
        Event event = new Event(name, time, location, description, creator);
        return event;
    }

    private static void loginAdmin(Scanner scanner) {
        System.out.println("Login");
        System.out.println("username");
        String username = scanner.next();
        System.out.println("password");
        String password = scanner.next();
        Admin admin = getAdmin(username, password);
        while (!admin.login(username,password)){
            System.out.println("Login failed");
            System.out.println("username");
            username = scanner.next();
            System.out.println("password");
            password = scanner.next();
        }
    }

    private static Admin getAdmin(String username, String password) {
        Admin admin = new Admin(username, password,"Admin Account", "  admin@gmail.com  ",true);
        return admin;
    }
    private static void loginUser(Scanner scanner) {
        System.out.println("Login");
        System.out.println("username");
        String username = scanner.next();
        System.out.println("password");
        String password = scanner.next();
        User user = getUser(username, password);
        while (!user.login(username,password)){
            System.out.println("Login failed");
            System.out.println("username");
            username = scanner.next();
            System.out.println("password");
            password = scanner.next();
        }
    }

    private static User getUser(String username, String password) {
        User user = new User(username, password,"User Account", "user1@mgail.com",true);
        return user;
    }


}

