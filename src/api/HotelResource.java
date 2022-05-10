package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;

import java.util.Date;

public class HotelResource {

    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) throws IllegalAccessException{
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber){
        return null;
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date CheckOutDate) {
        return null;
    }


}
