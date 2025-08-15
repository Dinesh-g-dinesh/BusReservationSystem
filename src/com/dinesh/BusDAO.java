package com.dinesh;

import java.sql.*;

public class BusDAO {


    public void displayBusInfo() throws SQLException {
        Connection con = DBconnection.getConnection();
        String query = "select * from Bus";
        ResultSet rs = con.createStatement().executeQuery(query);

        System.out.println("\nBus No | AC | Capacity | Available Seats");
        while (rs.next()){
            System.out.println(
                    rs.getInt("bus_no") + " | " +
                            (rs.getBoolean("ac") ? "AC" : "Non-AC") + " | " +
                            rs.getInt("capacity") + " | " +
                            rs.getInt("available_seats")
            );
        }
    }

    public boolean isAvailable(int busno) throws Exception {
        Connection con = DBconnection.getConnection();
        String query = "SELECT available_seats FROM bus WHERE bus_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,busno);
        ResultSet rs = pst.executeQuery();
        while (rs.next()){
            return rs.getInt("available_seats")>0;
        }
        return false;
    }
    public void ReduceSeatCount(int busno) throws Exception{
        Connection con = DBconnection.getConnection();
        String query = "UPDATE bus set available_seats = available_seats - 1 WHERE bus_no = ? ";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,busno);
        pst.executeUpdate();
    }
    public void IncreaseSeatCount(int busno) throws Exception{
        Connection con = DBconnection.getConnection();
        String query = "UPDATE bus set available_seats = available_seats + 1 WHERE bus_no = ?";
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1,busno);
        pst.executeUpdate();
    }
}
