/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scd.project;

import java.util.List;

/**
 *
 * @author user
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;

/**
 *
 * @author user
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlavorDAOImpl extends FlavorDAO {
    private Connection connection;

    // Constructor to establish the database connection
    public FlavorDAOImpl() {
        try {
            // Replace with your database credentials
            String url = "jdbc:mysql://localhost:3306/your_database";
            String username = "your_username";
            String password = "your_password";
            
            // Establish the connection
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Flavor> getAllFlavors() {
        List<Flavor> flavors = new ArrayList<>();
        
        try {
            // Create the SQL statement
            String sql = "SELECT * FROM flavors";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");

                Flavor flavor = new Flavor(id, name, quantity);
                flavors.add(flavor);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flavors;
    }

    public Flavor getFlavorById(int id) {
        Flavor flavor = null;
        
        try {
            // Create the SQL statement
            String sql = "SELECT * FROM flavors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            // Execute the query
            ResultSet resultSet = statement.executeQuery();

            // Process the result
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int quantity = resultSet.getInt("quantity");

                flavor = new Flavor(id, name, quantity);
            }

            // Close the resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flavor;
    }

    @Override
    public void addFlavor(Flavor flavor) {
        try {
            // Create the SQL statement
            String sql = "INSERT INTO flavors (id, name, quantity) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, flavor.getId());
            statement.setString(2, flavor.getName());
            statement.setInt(3, flavor.getQuantity());

            // Execute the update
            statement.executeUpdate();

            // Close the resources
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFlavor(Flavor flavor) {
        try {
            // Create the SQL statement
            String sql = "UPDATE flavors SET name = ?, quantity = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, flavor.getName());
            statement.setInt(2, flavor.getQuantity());
            statement.setInt(3, flavor.getId());

            // Execute the update
            statement.executeUpdate();

            // Close the resources
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public void deleteFlavor(int id) {
        try {
            // Create the SQL statement
            String sql = "DELETE FROM flavors WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            // Execute the update
            statement.executeUpdate();

            // Close the resources
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close the database connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



  
