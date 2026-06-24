import java.util.ArrayList;
import java.util.Scanner;

class Internship {
    int id;
    String company;
    String role;
    String location;
    String deadline;
    String status;

    Internship(int id, String company, String role, String location, String deadline, String status) {
        this.id = id;
        this.company = company;
        this.role = role;
        this.location = location;
        this.deadline = deadline;
        this.status = status;
    }
}

public class InternshipTracker {

    static ArrayList<Internship> list = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int idCounter = 1;

    // INSERT
    static void insert() {
        System.out.print("Enter company: ");
        String company = sc.nextLine();

        System.out.print("Enter role: ");
        String role = sc.nextLine();

        System.out.print("Enter location: ");
        String location = sc.nextLine();

        System.out.print("Enter deadline: ");
        String deadline = sc.nextLine();

        System.out.print("Enter status (Applied/Not Applied): ");
        String status = sc.nextLine();

        Internship i = new Internship(idCounter++, company, role, location, deadline, status);
        list.add(i);

        System.out.println("Internship added successfully!\n");
    }

    // DISPLAY
    static void display() {
        if (list.isEmpty()) {
            System.out.println("No internships found.\n");
            return;
        }

        System.out.println("\n--- Internship List ---");
        for (Internship i : list) {
            System.out.println("ID: " + i.id);
            System.out.println("Company: " + i.company);
            System.out.println("Role: " + i.role);
            System.out.println("Location: " + i.location);
            System.out.println("Deadline: " + i.deadline);
            System.out.println("Status: " + i.status);
            System.out.println("----------------------");
        }
    }

    // UPDATE
    static void update() {
        System.out.print("Enter ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        for (Internship i : list) {
            if (i.id == id) {
                System.out.print("Enter new company: ");
                i.company = sc.nextLine();

                System.out.print("Enter new role: ");
                i.role = sc.nextLine();

                System.out.print("Enter new location: ");
                i.location = sc.nextLine();

                System.out.print("Enter new deadline: ");
                i.deadline = sc.nextLine();

                System.out.print("Enter new status: ");
                i.status = sc.nextLine();

                System.out.println("Updated successfully!\n");
                return;
            }
        }

        System.out.println("ID not found!\n");
    }

    // DELETE
    static void delete() {
        System.out.print("Enter ID to delete: ");
        int id = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
                System.out.println("Deleted successfully!\n");
                return;
            }
        }

        System.out.println("ID not found!\n");
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== Internship Tracker =====");
            System.out.println("1. Insert Internship");
            System.out.println("2. Display Internships");
            System.out.println("3. Update Internship");
            System.out.println("4. Delete Internship");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    insert();
                    break;
                case 2:
                    display();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
