package com.dinesh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking(String name, int busno, Date date){
        this.passengerName = name;
        this.busNo = busno;
        this.date = date;
    }
    public String getPassengerName(){
        return passengerName;
    }
    public int getBusNo(){
        return busNo;
    }
    public Date getDate(){
        return date;
    }
}
