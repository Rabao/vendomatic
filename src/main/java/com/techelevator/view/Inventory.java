package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    private List<Product> productList = new ArrayList<>();

    public List<String> getProductList() {
        return null;
    }

    public void setProductList(File productFile) {
        File filePath = new File("vendingmachine.csv");
        Product[] menuProduct;

        int lineCount = 0;
        try(Scanner file = new Scanner(filePath)){
            while(file.hasNext()){

                //Iterates through each line in the file and counts it
                while(file.hasNext()) {
                    String lineInput = file.nextLine();
                    lineCount++;
                }

                //Loops through each line and adds that line to a Product Array
                for(int x = 0; x < lineCount; x++){
                    String lineInput = file.nextLine(); //Stores current line
                    String[] inputArray = lineInput.split("|"); // Stores split string into an Array
                    menuProduct = new Product[lineCount]; // Initializes array with lineCount

                    menuProduct[x].setSlotId(inputArray[0]);
                    menuProduct[x].setName(inputArray[1]);
                    menuProduct[x].setPrice(inputArray[2]);
                    menuProduct[x].setType(inputArray[3]);
                }
            }
        }catch(FileNotFoundException e){}

    }
}
