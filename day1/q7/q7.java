/*

7. Create a program with multi-dimensional List to store customer details (customerId,
customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
* Create a constructor to initialize size of customer details for five customers.
* Create customer method which takes the array of customer elements (sorted as a
customerName).
* Create a method to getCustomer(customerId) method which will return the customer
details as a List.
* Create a method to sortCustomer() method which will return the array in a sorted
order based on customer city.

*/

import java.util.*;

public class q7 {
    private List<List<String>> customerList;

    // Constructor to initialize customerList with five customers
    public q7() {
        customerList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            customerList.add(new ArrayList<String>(
                    Arrays.asList(Integer.toString(i + 1), "Customer" + (i + 1), "City" + (i + 1))));
        }
    }

    // Method to search for a customer by name using binary search algorithm
    public int searchCustomer(String name) {
        int left = 0;
        int right = customerList.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int compareResult = name.compareTo(customerList.get(mid).get(1));
            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1; // customer not found
    }

    // Method to get customer details by customer id
    public List<String> getCustomer(int customerId) {
        for (List<String> customer : customerList) {
            if (Integer.parseInt(customer.get(0)) == customerId) {
                return customer;
            }
        }
        return null; // customer not found
    }

    // Method to sort customerList by city name using insertion sort algorithm
    public void sortCustomer() {
        for (int i = 1; i < customerList.size(); i++) {
            List<String> key = customerList.get(i);
            int j = i - 1;
            while (j >= 0 && customerList.get(j).get(2).compareTo(key.get(2)) > 0) {
                customerList.set(j + 1, customerList.get(j));
                j--;
            }
            customerList.set(j + 1, key);
        }
    }

    // Main method to test the program
    public static void main(String[] args) {
        q7 customerDetails = new q7();

        System.out.println("Customer List:");
        for (List<String> customer : customerDetails.customerList) {
            System.out.println(customer.get(0) + "\t" + customer.get(1) + "\t" + customer.get(2));
        }

        customerDetails.sortCustomer();

        System.out.println("Sorted Customer List by City:");
        for (List<String> customer : customerDetails.customerList) {
            System.out.println(customer.get(0) + "\t" + customer.get(1) + "\t" + customer.get(2));
        }

        String searchName = "Customer3";
        int searchResult = customerDetails.searchCustomer(searchName);
        if (searchResult != -1) {
            System.out.println("Customer " + searchName + " found: " + customerDetails.customerList.get(searchResult));
        } else {
            System.out.println("Customer " + searchName + " not found.");
        }

        int customerId = 2;
        List<String> customerDetailsById = customerDetails.getCustomer(customerId);
        if (customerDetailsById != null) {
            System.out.println("Customer with ID " + customerId + ": " + customerDetailsById);
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }
}

/*
 * OUTPUT -
 * Customer List:
 * 1 Customer1 City1
 * 2 Customer2 City2
 * 3 Customer3 City3
 * 4 Customer4 City4
 * 5 Customer5 City5
 * Sorted Customer List by City:
 * 1 Customer1 City1
 * 2 Customer2 City2
 * 3 Customer3 City3
 * 4 Customer4 City4
 * 5 Customer5 City5
 * Customer Customer3 found: [3, Customer3, City3]
 * Customer with ID 2: [2, Customer2, City2]
 * 
 */
