package service;

import model.Customer;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private static Map<String, Customer> customerInfo = new HashMap<String, Customer>();

    public static void addCustomer(String email, String firstName, String lastName) throws IllegalAccessException {
        Customer newCustomer = new Customer(firstName, lastName, email);
        customerInfo.put(newCustomer.getEmail(), newCustomer);
    }
    public static Customer getCustomer(String email) {
        return customerInfo.get(email);
    }
    public static Collection<Customer> getAllCustomers() {
        return customerInfo.values();
    }

//    public static void main(String[] args) {
//        Customer joon = new Customer("Joon", "Kim", "justinkim36@naver.com");
//
//        ArrayList<Customer> customer = new ArrayList<Customer>();
//        customer.add(joon);
//
//        for (Customer c : customer) {
//            CustomerService.addCustomer(mapOfCustomers, c);
//        }
//
//        System.out.println(getCustomer("justinkim36@naver.com"));
//
//        System.out.println(getAllCustomers());
//    }
}
