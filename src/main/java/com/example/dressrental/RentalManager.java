package com.example.dressrental;

import java.sql.*;
import java.util.Scanner;

public class RentalManager {

    // Elbise kiralama işlemi
    public void rentDress(int userId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kiralayacağınız elbise ID'sini girin: ");
        int dressId = scanner.nextInt();

        String sql = "INSERT INTO rentals (user_id, dress_id, rental_date, return_date) VALUES (?, ?, CURDATE(), NULL)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, userId);
            pstmt.setInt(2, dressId);
            pstmt.executeUpdate();
            System.out.println("Elbise başarıyla kiralandı.");

        } catch (SQLException e) {
            System.out.println("Kiralama işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    // Kiralanan elbiseleri listeleme işlemi
    public void listRentals() {
        String sql = """
                SELECT r.id, u.username, d.name, r.rental_date 
                FROM rentals r 
                JOIN users u ON r.user_id = u.id 
                JOIN dresses d ON r.dress_id = d.id
                """;

        try (Connection conn = DatabaseManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("Kiralama ID: " + rs.getInt("id") +
                        ", Kullanıcı: " + rs.getString("username") +
                        ", Elbise: " + rs.getString("name") +
                        ", Kiralama Tarihi: " + rs.getDate("rental_date"));
            }

        } catch (SQLException e) {
            System.out.println("Kiralama listeleme işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }
}
