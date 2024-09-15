package com.example.dressrental;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        DatabaseManager.initializeDatabase();  // Veritabanı tablolarını oluştur

        UserManager userManager = new UserManager();
        DressManager dressManager = new DressManager();
        RentalManager rentalManager = new RentalManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Kullanıcı Kaydı");
        System.out.println("2. Kullanıcı Girişi");
        System.out.print("Seçiminiz: ");
        int choice = scanner.nextInt();

        boolean loggedIn = false;
        if (choice == 1) {
            userManager.registerUser();
            loggedIn = userManager.loginUser();
        } else if (choice == 2) {
            loggedIn = userManager.loginUser();
        }

        if (!loggedIn) {
            System.out.println("Giriş yapılamadı, program sonlanıyor.");
            return;
        }

        while (true) {
            System.out.println("\n1. Elbise Ekle");
            System.out.println("2. Elbiseleri Listele");
            System.out.println("3. Elbise Kirala");
            System.out.println("4. Kiralanan Elbiseleri Listele");
            System.out.println("5. Çıkış");
            System.out.print("Seçiminiz: ");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    dressManager.addDress();
                    break;
                case 2:
                    dressManager.listDresses();
                    break;
                case 3:
                    System.out.print("Kullanıcı ID'nizi girin: ");
                    int userId = scanner.nextInt();
                    rentalManager.rentDress(userId);
                    break;
                case 4:
                    rentalManager.listRentals();
                    break;
                case 5:
                    System.out.println("Çıkış yapılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}
