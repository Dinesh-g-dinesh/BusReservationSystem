package com.dinesh;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        BookingDAO bookingdao = new BookingDAO();
        BusDAO busdao = new BusDAO();

        while (true){
            System.out.println("-- Welcome to Bus Booking Menu --");
            System.out.println("1.View All Buses");
            System.out.println("2.Book Tickets");
            System.out.println("3.View Bokkings");
            System.out.println("4.Cancel Booking");
            System.out.println("5.Exit");
            System.out.println("Enter the option: ");
            int option = scan.nextInt();

            switch (option){
                case 1:
                    busdao.displayBusInfo();
                    break;
                case 2:
                    System.out.println("Enter Passenger Name: ");
                    String name = scan.next();
                    System.out.println("Enter Bus No: ");
                    int busno = scan.nextInt();

                    if(!busdao.isAvailable(busno)){
                        System.out.println("No Seats Available for this Bus!");
                    }

                    System.out.println("Enter the Date: ");
                    String datestr = scan.next();
                    Date date = new SimpleDateFormat("dd-MM-yyyy").parse(datestr);

                    Booking booking = new Booking(name,busno,date);
                    bookingdao.addBooking(booking);
                    busdao.ReduceSeatCount(busno);
                    System.out.println("Booking is Confirmed");
                    break;

                case 3:
                    bookingdao.ViewBooking();
                    break;

                case 4:
                    System.out.println("Enter Passenger Name:");
                    String cname = scan.next();
                    System.out.println("Enter Bus No:");
                    int cbusno = scan.nextInt();

                    bookingdao.CancelBooking(cname,cbusno);
                    System.out.println("Booking Canceled");
                    break;

                case 5:
                    System.out.println("Thanks for Using Booking Syatem!");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }

    }
}