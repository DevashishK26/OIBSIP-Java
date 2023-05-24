import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {
    private String eventId;
    private String eventName;
    private int availableSeats;

    public Ticket(String eventId, String eventName, int availableSeats) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.availableSeats = availableSeats;
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

class Reservation {
    private String reservationId;
    private String eventId;
    private int numOfSeats;

    public Reservation(String reservationId, String eventId, int numOfSeats) {
        this.reservationId = reservationId;
        this.eventId = eventId;
        this.numOfSeats = numOfSeats;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getEventId() {
        return eventId;
    }

    public int getNumOfSeats() {
        return numOfSeats;
    }
}

class TicketReservationSystem {
    private List<Ticket> tickets;
    private List<Reservation> reservations;
    private int reservationCounter;

    public TicketReservationSystem() {
        this.tickets = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.reservationCounter = 1;
    }

    public void addTicket(String eventId, String eventName, int availableSeats) {
        Ticket ticket = new Ticket(eventId, eventName, availableSeats);
        tickets.add(ticket);
    }

    public void reserveTickets(String eventId, int numOfSeats) {
        Ticket ticket = findTicket(eventId);
        if (ticket != null && ticket.getAvailableSeats() >= numOfSeats) {
            Reservation reservation = new Reservation(
                    "R" + reservationCounter,
                    eventId,
                    numOfSeats);
            reservations.add(reservation);
            ticket.setAvailableSeats(ticket.getAvailableSeats() - numOfSeats);
            reservationCounter++;
            System.out.println("Reservation successful. Reservation ID: " + reservation.getReservationId());
        } else {
            System.out.println("Tickets not available for the specified event or insufficient seats.");
        }
    }

    private Ticket findTicket(String eventId) {
        for (Ticket ticket : tickets) {
            if (ticket.getEventId().equals(eventId)) {
                return ticket;
            }
        }
        return null;
    }

    public void printAvailableTickets() {
        System.out.println("Available Tickets:");
        for (Ticket ticket : tickets) {
            System.out.println("Event ID: " + ticket.getEventId() +
                    ", Event Name: " + ticket.getEventName() +
                    ", Available Seats: " + ticket.getAvailableSeats());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TicketReservationSystem reservationSystem = new TicketReservationSystem();
        reservationSystem.addTicket("E001", "Concert", 100);
        reservationSystem.addTicket("E002", "Sports Event", 200);

        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            System.out.println("\nTicket Reservation System");
            System.out.println("1. Reserve Tickets");
            System.out.println("2. View Available Tickets");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter the event ID: ");
                    String eventId = scanner.nextLine();
                    System.out.print("Enter the number of seats to reserve: ");
                    int numOfSeats = Integer.parseInt(scanner.nextLine());
                    reservationSystem.reserveTickets(eventId, numOfSeats);
                    break;
                case "2":
                    reservationSystem.printAvailableTickets();
                    break;
                case "3":
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("3"));

        scanner.close();
    }
}
