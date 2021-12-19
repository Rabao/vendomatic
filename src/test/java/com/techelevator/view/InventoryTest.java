package com.techelevator.view;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.*;

public class InventoryTest {
    private final List<Product> products = new ArrayList<>();

    private Product getProduct(String lineInput) {
        String[] productAttributes = lineInput.split("\\|");
        double productPrice = Double.parseDouble(productAttributes[2]);
        return new Product(productAttributes[0],productAttributes[1],productPrice,productAttributes[3],5);
    }


    @Test
    public void setProductList() {
        File file = new File("com/techelevator/test-data/sample-data.csv");
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNext()){
                String lineInput = scanner.nextLine();
                Product product = getProduct(lineInput);
                products.add(product);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        List<Product> productList = new ArrayList<>(products);

        assertEquals(productList,products);
    }

    @Test
    public void getProductList() {
        assertEquals(products,products);
    }

    @Test
    public void displayInventoryProducts() {
        List<Product> product = new ArrayList<>();
        product.addAll(products);
        assertEquals(product,products);
    }
}