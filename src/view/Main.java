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
        EventManager eventManager = new EventManager();
        Event eventnhon3 = new Event("nhon3", LocalDate.parse("2021-12-12"),"location1","description1","creator1");
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

                                eventManager.addEvent( eventnhon3  , getAdmin("admin","admin"));
                            case 2:
                                eventManager.editEvent(eventnhon3 , getAdmin("admin","admin"));
                            case 3:
                                eventManager.deleteEvent(eventnhon3 , getAdmin("admin","admin"));
                            case 4:
                                eventManager.searchEvent(eventnhon3.getName(), eventnhon3.getCreator());
                        }
                    }while (choiceAd!=-1);
                case 2:

            }
        }while (choice != -1);
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

}

