package com.example.dressrental;

import java.sql.*;
import java.util.Scanner;

public class UserManager {

    // Kullanıcı kayıt işlemi
    public void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adı: ");
        String username = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.executeUpdate();
            System.out.println("Kullanıcı başarıyla kayıt edildi.");

        } catch (SQLException e) {
            System.out.println("Kayıt işlemi sırasında hata oluştu: " + e.getMessage());
        }
    }

    // Kullanıcı giriş işlemi
    public boolean loginUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanıcı adı: ");
        String username = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Giriş başarılı.");
                return true;
            } else {
                System.out.println("Giriş başarısız.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Giriş işlemi sırasında hata oluştu: " + e.getMessage());
            return false;
        }
    }
}
