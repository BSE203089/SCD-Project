/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scd.project;

/**
 *
 * @author user
 */

 import java.util.ArrayList;
import java.util.List;
class OrderDAO {

  
    
    private List<Order> orders;

    public OrderDAO() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public List<Order> getOrdersByCustomer(String customerName) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerName().equalsIgnoreCase(customerName)) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }
}



