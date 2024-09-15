package com.example.dressrental;

import java.sql.*;
import java.util.Scanner;

public class DressManager {

    // Elbise ekleme işlemi
    public void addDress() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Elbise adı: ");
        String name = scanner.nextLine();
        System.out.print("Beden: ");
        String size = scanner.nextLine();
        System.out.print("Fiyat: ");
        double price = scanner.nextDouble();
        System.out.print("Mevcut mu (true/false): ");
        boolean available = scanner.nextBoolean();

        String sql = "INSERT INTO dresses (name, size, price, available) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.setString(2, size);
            pstmt.setDouble(3, price);
            pstmt.setBoolean(4, available);
            pstmt.executeUpdate();
            System.out.println("Elbise başarıyla eklendi.");

        } catch (SQLException e) {
            System.out.println("Elbise ekleme işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    // Elbiseleri listeleme işlemi
    public void listDresses() {
        String sql = "SELECT * FROM dresses";

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Ad: " + rs.getString("name") +
                        ", Beden: " + rs.getString("size") +
                        ", Fiyat: " + rs.getDouble("price") +
                        ", Mevcut: " + rs.getBoolean("available"));
            }

        } catch (SQLException e) {
            System.out.println("Elbiseleri listeleme işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }
}
