package com.example.dressrental;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    private static final String URL = System.getenv("DB_URL");
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        if (URL == null || USER == null || PASSWORD == null) {
            System.out.println("Veritabanı bağlantı bilgileri eksik: URL, kullanıcı adı veya şifre null olabilir.");
            throw new SQLException("Veritabanı bağlantı bilgileri eksik: URL, kullanıcı adı veya şifre null olabilir.");
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Tabloları oluşturma metodu
    public static void initializeDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            // Kullanıcı tablosu oluşturuluyor
            String createUsersTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        username VARCHAR(50) NOT NULL UNIQUE,
                        password VARCHAR(100) NOT NULL
                    );
                    """;

            // Elbise tablosu oluşturuluyor
            String createDressesTable = """
                    CREATE TABLE IF NOT EXISTS dresses (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(100) NOT NULL,
                        size VARCHAR(10),
                        price DECIMAL(10, 2) NOT NULL,
                        available BOOLEAN NOT NULL
                    );
                    """;

            // Kiralama tablosu oluşturuluyor
            String createRentalsTable = """
                    CREATE TABLE IF NOT EXISTS rentals (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        user_id INT,
                        dress_id INT,
                        rental_date DATE,
                        return_date DATE,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (dress_id) REFERENCES dresses(id)
                    );
                    """;

            stmt.execute(createUsersTable);
            stmt.execute(createDressesTable);
            stmt.execute(createRentalsTable);

            System.out.println("Veritabanı tabloları başarıyla oluşturuldu.");
        } catch (SQLException e) {
            System.out.println("Veritabanı tabloları oluşturulurken hata oluştu: " + e.getMessage());
        }
    }
}
