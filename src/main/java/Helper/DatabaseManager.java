/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/aniapp";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "password";

    // Metode untuk mendapatkan koneksi ke database.
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // Metode untuk menutup koneksi.
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Metode untuk mendapatkan data pengguna berdasarkan username.
    public static UserModel getUserByUsername(String username) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM users WHERE username=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, username);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                return new UserModel(dbUsername, dbPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    // Metode untuk mendapatkan data hewan berdasarkan level.
    public static AnimalModel getAnimalByLevel(int level) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM animals WHERE level=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, level);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String information = resultSet.getString("information");
                String foodType = resultSet.getString("food_type");
                String animalGroup = resultSet.getString("animal_group");
                String scientificName = resultSet.getString("scientific_name");
                // Jangan lupa menyesuaikan dengan kolom-kolom yang sesuai di tabel hewan.
                // Icon dapat di-load dari file atau database sesuai dengan implementasi Anda.
                // Misalnya: ImageIcon icon = new ImageIcon(resultSet.getBytes("icon_data"));
                ImageIcon icon = null;
                return new AnimalModel(name, information, level, foodType, animalGroup, scientificName, icon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    // Metode untuk mendapatkan data tingkat/level.
    public static LevelModel getLevel(int level) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            String query = "SELECT * FROM levels WHERE level=?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, level);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String biomeName = resultSet.getString("biome_name");
                // Jangan lupa menyesuaikan dengan kolom-kolom yang sesuai di tabel tingkat.
                return new LevelModel(level, biomeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}

