package com.dinesh;

import java.sql.*;
import java.util.Date;
import java.util.zip.DataFormatException;

public class BookingDAO {

    public void addBooking(Booking booking) throws Exception{
        Connection con = DBconnection.getConnection();
        String query = "insert into booking(passenger_name,bus_no,travel_date) values (?,?,?)";
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,booking.passengerName);
        pst.setInt(2, booking.busNo);
        pst.setDate(3, sqldate);
        pst.executeUpdate();
    }
    public void ViewBooking() throws SQLException {
        Connection con = DBconnection.getConnection();
        String query = "SELECT * FROM booking";
        ResultSet rs = con.createStatement().executeQuery(query);

        while (rs.next()){
            System.out.println(
                    rs.getString("passenger_name") + " | " +
                            rs.getInt("bus_no") + " | " +
                            rs.getDate("travel_date")
            );
        }
    }
    public void CancelBooking(String passengerName, int busNo) throws Exception{
        Connection con = DBconnection.getConnection();
        String query = "DELETE FROM booking WHERE passenger_name = ? AND bus_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1,passengerName);
        pst.setInt(2,busNo);
        pst.executeUpdate();
    }
}
