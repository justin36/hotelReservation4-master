package service;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService {

    private static final Map<String, IRoom> roomInfo = new HashMap<String, IRoom>();
    private static final Map<String, Collection<Reservation>> reservationInfo = new HashMap<String, Collection<Reservation>>();

    public static void addRoom(IRoom room){
        roomInfo.put(room.getRoomNumber(), room);
    }

    public static IRoom getRoom(String roomId){
        return roomInfo.get(roomId);
    }

    public static Collection<IRoom> getAllRooms() {
        return roomInfo.values();
    }


    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        if(isRoomReserved(room, checkInDate, checkOutDate)){
            System.out.println(1);
            return null;
        }

        System.out.println(2);

        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);

        Collection<Reservation> customerReservations = getCustomerReservations(customer);
        if(customerReservations == null){
            customerReservations = new LinkedList<>();
        }
        customerReservations.add(reservation);
        reservationInfo.put(customer.getEmail(), customerReservations);

        System.out.println(4);
        System.out.println(reservation);
        System.out.println(3);
        System.out.println(reservationInfo);
        return reservation;
    }

    public static boolean isRoomReserved(IRoom room, Date checkInDate, Date checkOutDate) {
        Collection<IRoom> reservedRooms = getAllReservedRooms(checkInDate, checkOutDate);
        if(reservedRooms.contains(room)) {
            return true;
        }
        return false;
    }

    public static Collection<Reservation> getCustomerReservations(Customer customer){
        // Like the name suggests, it's getCustomerReservations, unless I put two dates on the customer it will always come out as null
        System.out.println(5);
        System.out.println(reservationInfo.get(customer.getEmail()));
        return reservationInfo.get(customer.getEmail());
    }


    public static Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> reservedRooms = getAllReservedRooms(checkInDate, checkOutDate);
        Collection<IRoom> availableRooms = new LinkedList<>();
            for (IRoom room : getAllRooms()) {
                if(!reservedRooms.contains(room)){
                    availableRooms.add(room);
                }
            }
            return availableRooms;
    }


    private static Collection<IRoom> getAllReservedRooms(Date checkInDate, Date checkOutDate) {
        LinkedList<IRoom> reservedRooms = new LinkedList<>();

        return reservedRooms;
    }

    public static Collection<Reservation> printAllReservations() {
        Collection<Reservation> allReservations = new LinkedList<>();
        for (Collection<Reservation> customerReservations : reservationInfo.values()) {
            allReservations.addAll(customerReservations);
        }
        System.out.println(allReservations);
        return allReservations;
    }

    public static void main(String[] args) {
        Date date1 = new Date(2022,04,03);
        Date date2 = new Date(2022,04,04);

        System.out.println(date1);

        Customer joon = new Customer("Joon", "Kim", "justinkim36@naver.com");
        Customer arthur = new Customer("Arthur", "Lau", "pauluskim0306@gmail.com");
        Room room101 = new Room("101", 100.0, RoomType.SINGLE);

        reserveARoom(joon, room101, date1, date2);
        reserveARoom(arthur, room101, date1, date2);
        getCustomerReservations(joon);
        printAllReservations();
//        Reservation reservationJan1 = new Reservation(joon, room101, date1, date2);

//        ArrayList<Reservation> reservation = new ArrayList<Reservation>();
//        reservation.add(reservationJan1);

//        System.out.println(reserveARoom());
    }


}
