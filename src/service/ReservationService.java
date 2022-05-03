package service;

import model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReservationService {

    static Map<String, Room> mapOfRooms = new HashMap<String, Room>();
    private static final Map<String, Collection<Reservation>> reservationInfo = new HashMap<String, Collection<Reservation>>();

    public static void addRoom(Map<String, Room> map, Room room) {
        map.put(room.getRoomNumber(), room);
    }

    public static Room getARoom(String roomNumber) {
        return mapOfRooms.get(roomNumber);
    }

    public static Collection<Room> getAllRooms() {
        return mapOfRooms.values();
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> reservedRooms = getAllReservedRooms(checkInDate, checkOutDate);
        Collection<IRoom> availableRooms = new LinkedList<>();
        for (IRoom room : getAllRooms()) {
            if(!reservedRooms.contains(room)){
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public static Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);


        return reservation;
    }

//    private static Collection<IRoom> getAllReservedRooms(Date checkInDate, Date checkOutDate) {
//        LinkedList<IRoom> reservedRooms = new LinkedList<>();
//        for (Reservation reservation : printAllReservations()) {
//            if(reservation.isRoomReserved(checkInDate, checkOutDate)){
//                reservedRooms.add(reservation.getRoom());
//            }
//        }
//        return reservedRooms;
//    }

    public static Collection<Reservation> printAllReservations() {
        Collection<Reservation> allReservations = new LinkedList<>();
        for (Collection<Reservation> customerReservations : reservationInfo.values()) {
            allReservations.addAll(customerReservations);
        }
        return allReservations;
    }
//
//    static boolean isRoomReserved(IRoom room, Date checkInDate, Date checkOutDate) {
//        Collection<IRoom> reservedRooms = getAllReservedRooms(checkInDate, checkOutDate);
//        if(reservedRooms.contains(room)){
//            return true;
//        }
//        return false;
//    }


//
//    public Collection<Reservation> getCustomersReservation(Customer customer) {
//        Collection<Reservation> customerReservation_HashSet = new HashSet<>();
//        return null;
//    }


//    public static Date convertDateFromString(String dateString) {
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
//        Date returnDate = null;
//        try {
//            returnDate formatter.parse(dateString);
//        } catch(ParseException e) {
//            e.printStackTrace();
//        }
//        return returnDate;
//    }


//    public static void main(String[] args) {
//        Calendar calendar1 = Calendar.getInstance();
//        Calendar calendar2 = Calendar.getInstance();
//
//        calendar1.set(2022, 00, 01);
//        calendar2.set(2022, 00, 02);
//
//        Date date1 = calendar1.getTime();
//        Date date2 = calendar2.getTime();
//
//        System.out.println(date1);
//
////        String date1 = "01/01/2022";
////
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(date1);
////
////        Date date = new Date();
//
//        Customer joon = new Customer("Joon", "Kim", "justinkim36@naver.com");
//        Room room101 = new Room("101", 100.0, RoomType.SINGLE);
//        Reservation reservationJan1 = new Reservation(joon, room101, date1, date2);
//
////        mapOfRooms.put("101", room101);
//
//        ArrayList<Reservation> reservation = new ArrayList<Reservation>();
//        reservation.add(reservationJan1);
//
////        for (Reservation r : reservation) {
////            ReservationService.addRoom(mapOfRooms, r);
////        }
//
////        System.out.println(getARoom("101"));
//
//        System.out.println(reservation);
//    }

}
