package api;

import model.Customer;
import model.Room;
import model.RoomType;
import service.CustomerService;
import service.ReservationService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

import static service.CustomerService.*;
import static service.ReservationService.getAllRooms;

public class MainMenu {

    public void startAction(){
        boolean keepRunning = true;

        try(Scanner scanner = new Scanner(System.in)) {

            while (keepRunning) {
                try {
                    System.out.println("○●○●○●○●○●○●○●○●○●○●○");
                    System.out.println("= Joon's Hotel =");
                    System.out.println("○●○●○●○●○●○●○●○●○●○●○");
                    System.out.println("1. Find and reserve a room");
                    System.out.println("2. See my reservation");
                    System.out.println("3. Create an Account");
                    System.out.println("4. Admin");
                    System.out.println("5. Exit");
                    int action = Integer.parseInt(scanner.nextLine());

                    switch(action) {
                        // Find and reserve a room
                        case 1:
                            System.out.println("Enter CheckIn Date mm/dd/yyyy");

                            Date startDate = new SimpleDateFormat("mm/dd/yyyy").parse(scanner.nextLine());

                            System.out.println("1");
                            System.out.print(startDate);


                            Customer customer = getCustomer(getUserEmail(scanner));

//                            HotelResource bookARoom(customer.getEmail(), );
                            break;
//                        // See my reservations
//                        case 2:
//                            return;
                        // Create an Account
                        case 3:
                            String email = getUserEmail(scanner);

                            System.out.println("Enter firstName");
                            String firstName = scanner.nextLine();

                            System.out.println("Enter lastName");
                            String lastName = scanner.nextLine();

                            addCustomer(email, firstName, lastName);

                            System.out.println("Welcome to the Hotel Reservation Application");

                            break;
                        // Admin
                        case 4:
                            AdminMenu();
                            break;
                        // Exit
                        case 5:
                            keepRunning = false;
                            break;
                    }

                } catch (Exception ex) {
                    System.out.println("Please enter a number");
                }
            }
        }
    }

    public void AdminMenu(){
        boolean keepRunning = true;

        try(Scanner scanner = new Scanner(System.in)) {

            while (keepRunning) {
                try {
                    System.out.println("○●○●○●○●○●○●○●○●○●○●○");
                    System.out.println("= Admin Menu =");
                    System.out.println("○●○●○●○●○●○●○●○●○●○●○");
                    System.out.println("1. See all Customers");
                    System.out.println("2. See all Rooms");
                    System.out.println("3. See all Reservations");
                    System.out.println("4. Add a Room");
                    System.out.println("5. Back to Main Menu");
                    int action = Integer.parseInt(scanner.nextLine());

                    switch (action) {
                        // See all Customers
                        case 1:
                            System.out.println("See all Customers");
                            System.out.println(getAllCustomers());
                            break;


                        // See all my Rooms
                        case 2:
                            System.out.println("See all Rooms");
                            System.out.println(getAllRooms());
                            break;

                          // See all Reservations
//                        case 3:
//                            System.out.println("Enter email format : name@domain.com");
//                            String email = scanner.nextLine();
//
//                            System.out.println("Enter firstName");
//                            String firstName = scanner.nextLine();
//
//                            System.out.println("Enter lastName");
//                            String lastName = scanner.nextLine();
//
//                            addCustomer(email, firstName, lastName);
//
//                            System.out.println("Welcome to the Hotel Reservation Application");
//
//                            break;
//                        // Add a room
                        case 4:
                            System.out.println("Enter room number");
                            String roomNumber = scanner.nextLine();

                            System.out.println("Enter room price");
                            double roomPrice = Double.parseDouble(scanner.nextLine());

                            System.out.println("Room type: 1. Single Bed, 2. Double Bed");
                            String roomTypeInput = scanner.nextLine();

                            RoomType roomType = null;
                            if(Objects.equals(roomTypeInput, "1")) {
                                roomType = RoomType.SINGLE;

                            } else if (Objects.equals(roomTypeInput, "2")) {
                                roomType = RoomType.DOUBLE;
                            }

                            ReservationService.addRoom(new Room(roomNumber, roomPrice, roomType));

                            break;
                        // Back to Main Menu
                        case 5:
                            startAction();
                            break;
                    }
                } catch(Exception ex){
                    System.out.println("Please enter a number");
                }
            }
        }
    }

    public String getUserEmail(Scanner scanner) {
        System.out.println("Enter email format : name@domain.com");

        return scanner.nextLine();

    }


    public static void main(String args[]){
        MainMenu menuObject = new MainMenu();
        menuObject.startAction();

    }
}
