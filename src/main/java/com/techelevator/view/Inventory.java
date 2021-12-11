package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The inventory class is responsible for organizing and maintaining its
 * inventory.
 */
public class Inventory {
    private List<Product> productList = new ArrayList<>();


//    public void setProductList(File productFile) {
//        File filePath = new File("vendingmachine.csv");
//        Product[] menuProduct;
//
//        int lineCount = 0;
//        try(Scanner file = new Scanner(filePath)){
//            while(file.hasNext()){
//
//                //Iterates through each line in the file and counts it
//                while(file.hasNext()) {
//                    String lineInput = file.nextLine();
//                    lineCount++;
//                }
//
//                //Loops through each line and adds that line to a Product Array
//                for(int x = 0; x < lineCount; x++){
//                    String lineInput = file.nextLine(); //Stores current line
//                    String[] inputArray = lineInput.split("\\|"); // Stores split string into an Array
//                    menuProduct = new Product[lineCount]; // Initializes array with lineCount
//
//                    menuProduct[x].setSlotId(inputArray[0]);
//                    menuProduct[x].setName(inputArray[1]);
//                    menuProduct[x].setPrice(inputArray[2]);
//                    menuProduct[x].setType(inputArray[3]);
//                }
//            }
//        }catch(FileNotFoundException e){}
//
//    }

    /**
     * 3.Vending machine inventory is stocked via an input file.
     * sets all inventory products in the vendingmachine.csv file
     * to a productList of type Product.
     *
     * Open a file Object
     * Open Scanner Object to read file
     * loop through each product line
     * store each product line in string var
     * split lineInput at pipeline into String array
     * convert price string to a double data type
     * Create Product Object, use the values in String array to set product state.
     * add newly created product to productList
     */
    public void setProductList(){
        File vendingMachineFilePath = new File("vendingmachine.csv");
        try(Scanner vendingMachineFileInput = new Scanner(vendingMachineFilePath)){
            while (vendingMachineFileInput.hasNext()){
                String lineInput = vendingMachineFileInput.nextLine();
                String[] productAttributes = lineInput.split("\\|");
                double productPrice = Double.parseDouble(productAttributes[2]);
                Product product = new Product(productAttributes[0],productAttributes[1],productPrice,productAttributes[3],5);
                productList.add(product);
            }
        }catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    /**
     * 5. When the customer selects (1) Display Vending Machine Items they are
     * presented a list of all items in the vending machine with its quantity remaining.
     *
     * DisplaysInventory simply iterates over
     * every product in productList and prints it
     * to the console.
     */
    public void displayInventoryProducts(){
        for(Product product : productList) {
            System.out.println(product);
        }
    }
}
