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
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlavorDAO {
    private final String url;
    private final String username;
    private final String password;

    public FlavorDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public List<Flavor> getAllFlavors() {
        List<Flavor> flavors = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM flavors")) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Flavor flavor = new Flavor(name, description, price);
                flavors.add(flavor);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flavors;
    }

    public void addFlavor(Flavor flavor) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO flavors (name, description, price) VALUES (?, ?, ?)")) {

            statement.setString(1, flavor.getName());
            statement.setString(2, flavor.getDescription());
            statement.setDouble(3, flavor.getPrice());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateFlavor(Flavor flavor) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("UPDATE flavors SET description = ?, price = ? WHERE name = ?")) {

            statement.setString(1, flavor.getDescription());
            statement.setDouble(2, flavor.getPrice());
            statement.setString(3, flavor.getName());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteFlavor(String flavorName) {
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM flavors WHERE name = ?")) {

            statement.setString(1, flavorName);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
