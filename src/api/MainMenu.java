package api;

import model.Customer;
import service.CustomerService;

import java.util.Scanner;

import static service.CustomerService.addCustomer;

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
//                        // Find and reserve a room
//                        case 1:
//                            HotelResource bookARoom();
//                            return;
//                        // See my reservations
//                        case 2:
//                            return;
                        // Create an Account
                        case 3:
                            System.out.println("Enter email format : name@domain.com");
                            String email = scanner.nextLine();

                            System.out.println("Enter firstName");
                            String firstName = scanner.nextLine();

                            System.out.println("Enter lastName");
                            String lastName = scanner.nextLine();

                            addCustomer(email, firstName, lastName);

                            System.out.println("Welcome to the Hotel Reservation Application");

                            break;
                        // Admin
                        case 4:
                            return;
                        // Exit
                        case 5:
                            return;
                    }

                } catch (Exception ex) {

                }
            }


        }



    }


    public static void main(String args[]){
        MainMenu menuObject = new MainMenu();
        menuObject.startAction();


    }


}