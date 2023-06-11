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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author user
 */
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String phoneNumber;

    // Constructors, getters, and setters
    // ...

    public void placeOrder(Order order) {
        OrderDAOImpl orderDAO = new OrderDAOImpl();
        order.setCustomer(this);
        orderDAO.addOrder(order);
    }

    public List<Flavor> selectFlavor() {
        FlavorDAOImpl flavorDAO = new FlavorDAOImpl();
        return flavorDAO.getAllFlavors();
    }

    public List<Topping> selectTopping() {
        ToppingDAOImpl toppingDAO = new ToppingDAOImpl();
        return toppingDAO.getAllToppings();
    }

    public void chooseQuantity(Order order, String quantity) {
        order.setQuantity(quantity);
    }

    public void choosePaymentMethod(Order order, String paymentMethod) {
        order.setPaymentMethod(paymentMethod);
    }
    
    public static void main(String[] args) {
        // Example usage
        Customer customer = new Customer();
        customer.setName("Maryam");
        customer.setPhoneNumber("1234567890");

        // Place an order
        Order order = new Order();
        order.setPopcornType("Cheese");
        order.setWrapping("Paper");
        order.setFlavor("Sweet");
        order.setConfirmed(true);
        customer.placeOrder(order);

        // Select flavors
        List<Flavor> flavors = customer.selectFlavor();
        for (Flavor flavor : flavors) {
            System.out.println(flavor.getName());
        }

        // Select toppings
        List<Topping> toppings = customer.selectTopping();
        for (Topping topping : toppings) {
            System.out.println(topping.getName());
        }

        // Choose quantity
        customer.chooseQuantity(order, "Large");

        // Choose payment method
        customer.choosePaymentMethod(order, "Credit Card");
    }

    private void setName(String Maryam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setPhoneNumber(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}