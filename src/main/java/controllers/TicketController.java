package controllers;

import modules.Ticket;
import repositories.interfaces.ITicketRepository;

import java.util.List;

public class TicketController {
    // Repository for interacting with ticket data
    private final ITicketRepository repo;

    // Constructor to initialize a ticket controller with a ticket repository
    public TicketController(ITicketRepository repo) {
        this.repo = repo;
    }

    // Receives one ticket by its ID. Returns a string representation of the ticket or a message indicating that the ticket was not found.
    public String getTicket(int ticketId) {
        Ticket ticket = repo.getTicket(ticketId); // Trying to get a ticket from a repository

        // Conditional check to return ticket details or report ticket not found
        return (ticket == null ? "Ticket not found!" : ticket.toString());
    }

    // Gets all tickets from the repository and returns them as a string.
    public String getAllTickets() {
        List<Ticket> tickets = repo.getAllTickets(); //Getting all tickets
        // StringBuilder for accumulating ticket information
        StringBuilder response = new StringBuilder();
        for (Ticket ticket : tickets) {
            response.append(ticket.toString()).append("\n"); // Adding information about each ticket
        }

        return response.toString(); // Returning the collected ticket information string
    }
}
