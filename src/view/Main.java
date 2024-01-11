package view;//src


import model.Admin;
import model.Event;
import model.User;
import storage.DataAccess;
import manager.EventManager;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        Event event1 = new Event("event1", LocalDate.parse("2021-01-01"), "location1", "description1", "creator1");
//        Event event4 = new Event("event4", LocalDate.parse("2021-01-02"), "location2", "description2", "creator2");
//        EventManager eventManager = new EventManager();
//        //login
//        Admin admin = new Admin(true);

        int choice = -1;
        do {
            System.out.println(" chọn tài khoản ");
            System.out.println("1: Admin");
            System.out.println("2: User");
            Scanner scanner = new Scanner(System.in);
            int type = scanner.nextInt();
            switch (type){
                case 1:
                    loginAdmin(scanner);

                    int choiceAd = -1;
                    do {
                        System.out.println("chọn tính năng");
                        System.out.println("0.exit");
                        System.out.println("1: add");
                        System.out.println("2 :edit");
                        System.out.println("3 :delete");
                        System.out.println("4 :seach");
                        Scanner scanner1 = new Scanner(System.in);
                        int typeAd = scanner1.nextInt();
                        switch (typeAd){
                            case 0:
                                System.exit(0);
                            case 1:

                        }
                    }while (choiceAd!=-1);
                case 2:
            }
        }while (choice != -1);

//        System.out.println(eventManager.listEvents());
//        System.out.println(eventManager.addEvent(event1, admin));
//        System.out.println(eventManager.editEvent(event1,admin));
//        System.out.println(eventManager.listEvents());
//        System.out.println(eventManager.deleteEvent(event1,admin));
//        System.out.println(eventManager.listEvents());
////        System.out.println(eventManager.searchEvent(event1.getName(),event1.getCreator()));
//        User user1 = new User("0123456789","Nguy12","Nguyen Van A","nguyenvana@gmail.com",true);
//        user1.login("0123456789","Nguy12");
//        System.out.println(user1.login("0123456789","Nguy12"));
//        eventManager.addEventQueue(event4 ,user1,admin);

    }

    private static void loginAdmin(Scanner scanner) {
        System.out.println("Login");
        System.out.println("username");
        String username = scanner.next();
        System.out.println("password");
        String password = scanner.next();
        Admin admin = new Admin(username,password,"Admin Account", "  admin@gmail.com  ",true);
        while (!admin.login(username,password)){
            System.out.println("Login failed");
            System.out.println("username");
            username = scanner.next();
            System.out.println("password");
            password = scanner.next();
        }
    }

}

