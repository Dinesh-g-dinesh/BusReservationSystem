# BusReservationSystem
Java console-based Bus Reservation System with MySQL integration.

A Java console-based Bus Reservation System that allows users to view buses, book tickets, and manage reservations. The project is integrated with MySQL for data storage and retrieval.

## 🚀 Features
- View all bus details (Bus No, AC/Non-AC, Capacity, Available Seats)
- Book bus tickets with passenger details
- Cancel existing bookings
- Check seat availability before booking
- MySQL database integration using JDBC
- Simple and user-friendly console interface

## 🛠 Technologies Used
- **Java** (Core Java, OOP)
- **MySQL** (Relational Database)
- **JDBC** (Java Database Connectivity)
- **IntelliJ IDEA** (IDE)

## 📂 Project Structure
- **Bus.java** → Represents a bus with details like bus number, AC type, and capacity
- **Booking.java** → Handles ticket booking and stores passenger details
- **BusDAO.java** → Manages bus-related database operations
- **BookingDAO.java** → Manages booking-related database operations
- **DBConnection.java** → Handles database connection
- **BusDemo.java (Main Class)** → Runs the application
