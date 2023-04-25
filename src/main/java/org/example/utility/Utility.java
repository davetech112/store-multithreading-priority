package org.example.utility;

import org.example.entity.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Utility {
    public void bufferReader() {
       final String file = "src/main/resources/file.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String theLine = reader.readLine();
            String seperate = ",";
            ArrayList<Product> products = new ArrayList<>();
            while((theLine = reader.readLine()) != null){
                String[] product = theLine.split(seperate);

                Product prod = new Product(product[0],Integer.parseInt(product[3]),Double.parseDouble(product[2]),product[1]);
                products.add(prod);
            }
            System.out.println(products);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
