package com.techelevator.view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class VendorLog {
    static PrintWriter logWriter = null;
    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    static NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

    public static void log(String message, double deposit, double balance){

        try{ if(logWriter == null){
                logWriter = new PrintWriter(new FileOutputStream("logs\\Log.txt", true));
              }
              logWriter.println(">" + date + " " + time.format(DateTimeFormatter.ofPattern("hh:mm:ss a")) + " " + message + ": " +
                      moneyFormat.format(deposit) + " " + moneyFormat.format(balance));
            logWriter.flush();
        }catch(FileNotFoundException e){

        }
    }
}
