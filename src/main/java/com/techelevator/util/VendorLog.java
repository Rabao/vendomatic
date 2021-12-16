package com.techelevator.util;

import com.techelevator.view.DollarCalculator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class VendorLog {
    static PrintWriter logWriter = null;
    static LocalDate date = LocalDate.now();
    static LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);

    public static void log(String message, DollarCalculator deposit, DollarCalculator balance){
        File dataFile = new File("logs/log.txt");

        try{
            if(logWriter == null){
                logWriter = new PrintWriter(new FileOutputStream(dataFile, true));
            }
            String formattedProductLog = String.format("%1$-1s %2$-15s %3$-15s %4$-15s %5$-8s %6$-7s", ">",date,time.format(DateTimeFormatter.ofPattern("hh:mm:ss a")),message,deposit,balance);
            logWriter.println(formattedProductLog);
            logWriter.flush();
        }catch(VendorLogException e){
            System.out.println();
        }catch (FileNotFoundException e){
            System.out.println("Log file error");
        }
    }
}
