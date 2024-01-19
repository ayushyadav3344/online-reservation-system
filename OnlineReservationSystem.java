import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

class Reservation {
    private static Map<String, String> reservations = new HashMap<>(); // PNR number as key, reservation details as
                                                                       // value

    public static void makeReservation(String pnr, String details) {
        reservations.put(pnr, details);
        System.out.println("Reservation successful! Your PNR number is: " + pnr);
    }

    public static void cancelReservation(String pnr) {
        if (reservations.containsKey(pnr)) {
            reservations.remove(pnr);
            System.out.println("Cancellation successful for PNR: " + pnr);
        } else {
            System.out.println("Reservation with PNR " + pnr + " not found.");
        }
    }
}

public class OnlineReservationSystem {
    private static Map<String, User> users = new HashMap<>(); // Username as key, User object as value
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Creating some sample users for demonstration
        users.put("user1", new User("user1", "password1"));
        users.put("user2", new User("user2", "password2"));

        // Login
        User loggedInUser = login();
        if (loggedInUser != null) {
            // After successful login, user can access reservation or cancellation
            System.out.println("Login successful! Welcome, " + loggedInUser.getUsername() + ".");

            // Reservation or Cancellation
            System.out.println("Choose an option:");
            System.out.println("1. Make Reservation");
            System.out.println("2. Cancel Reservation");
            int choice = scanner.nextInt();

            if (choice == 1) {
                makeReservation(loggedInUser);
            } else if (choice == 2) {
                cancelReservation(loggedInUser);
            } else {
                System.out.println("Invalid choice. Exiting.");
            }
        } else {
            System.out.println("Login failed. Exiting.");
        }

        scanner.close();
    }

    private static User login() {
        System.out.print("Enter username: ");
        String username = scanner.next();
        System.out.print("Enter password: ");
        String password = scanner.next();

        if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
            return users.get(username);
        } else {
            System.out.println("Invalid username or password. Login failed.");
            return null;
        }
    }

    private static void makeReservation(User user) {
        System.out.print("Enter PNR number: ");
        String pnr = scanner.next();
        // Additional details like train number, train name, class type, date, etc. can
        // be added here
        String details = "Sample Reservation Details";

        Reservation.makeReservation(pnr, details);
    }

    private static void cancelReservation(User user) {
        System.out.print("Enter PNR number to cancel: ");
        String pnr = scanner.next();
        Reservation.cancelReservation(pnr);
    }
}
