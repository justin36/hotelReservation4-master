package service;

import model.Customer;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    static HashMap<String, Customer> mapOfCustomers = new HashMap<String, Customer>();

    public static void addCustomer(Map<String, Customer> map, Customer customer) {
        map.put(customer.getEmail(), customer);
    }

    public static Customer getCustomer(String customerEmail) {
        return mapOfCustomers.get(customerEmail);
    }

    public static Collection<Customer> getAllCustomers() {
        return mapOfCustomers.values();
    }

    public static void main(String[] args) {
        Customer joon = new Customer("Joon", "Kim", "justinkim36@naver.com");

        ArrayList<Customer> customer = new ArrayList<Customer>();
        customer.add(joon);

        for (Customer c : customer) {
            CustomerService.addCustomer(mapOfCustomers, c);
        }

        System.out.println(getCustomer("justinkim36@naver.com"));

        System.out.println(getAllCustomers());
    }
}
