package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {

    public Customer getCustomer(String email) {
        return CustomerService.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) throws IllegalAccessException{
        CustomerService.addCustomer(email, firstName, lastName);
    }

    public static IRoom getRoom(String roomId) {
        return ReservationService.getRoom(roomId);
    }

    public Reservation bookARoom(String email, IRoom room, Date checkInDate, Date checkOutDate) {
        Customer customer = CustomerService.getCustomer(email);
        return ReservationService.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String email) {
        Customer customer = CustomerService.getCustomer(email);
        return ReservationService.getCustomerReservations(customer);
    }

    public Collection<IRoom> findARoom(Date checkInDate, Date checkOut){
        return ReservationService.findRooms(checkInDate, checkOut);
    }



}
