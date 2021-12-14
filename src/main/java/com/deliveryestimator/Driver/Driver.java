package com.deliveryestimator.Driver;

import com.deliveryestimator.models.Meal;
import com.deliveryestimator.models.Order;
import com.deliveryestimator.models.Restaurant;
import com.deliveryestimator.services.AddDishToMenuService;
import com.deliveryestimator.services.PrepareVerifiedOrderService;
import com.deliveryestimator.services.SetDishService;
import com.deliveryestimator.services.SetRestaurantService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException, ParseException {

        Gson g = new Gson();
        Scanner sc = new Scanner(System.in);
        //String inputPath = args[0];
        //File file = new File(inputPath);

        Meal appetizer = SetDishService.setDish("A",17,1);
        Meal mainCourse = SetDishService.setDish("M",29,2);

        AddDishToMenuService.addDish(appetizer);
        AddDishToMenuService.addDish(mainCourse);

        Restaurant restaurant = SetRestaurantService.setRestaurant(100,7,8);


        BufferedReader reader = new BufferedReader(new FileReader("/Users/akshitbansal/my-app/Input.txt"));
        //BufferedReader reader = new BufferedReader(new FileReader(file));

        //taking user input in a string buffer
        StringBuilder sb = new StringBuilder();
        try {

            String line = reader.readLine();

            while (line != null) {

                sb.append(line);
                sb.append("X");
                line = reader.readLine();
            }

        } finally {
            reader.close();
        }

        //removing square brackets from the string buffer sb.
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);

        //creating a string array of all the orders received
        String inputString = sb.toString();
        String[] orderStringArray = inputString.split(",X");


        for(int i=0; i< orderStringArray.length; i++)
        {
            //creating json object from each input order string
            JsonObject jsonObject = new JsonParser().parse(orderStringArray[i]).getAsJsonObject();

            //json object is converted into an object of userInput class
            UserInput userInput = new Gson().fromJson(jsonObject, UserInput.class);

            int orderId = userInput.getOrderId();
            float distance = userInput.getDistance();
            String[] meals = userInput.getMeal();
            int totalItems = meals.length;

            //stores the mapping of appetizer/main course and their respective quantities.
            HashMap<String, Integer> itemQtyMapping = new HashMap<>();
            for(int j=0; j<meals.length; j++)
            {
                if(itemQtyMapping.containsKey(meals[j]))
                {
                    itemQtyMapping.put(meals[j], 1 + itemQtyMapping.get(meals[j]));
                }
                else
                {
                    itemQtyMapping.put(meals[j], 1);
                }
            }

            Order order = new Order(orderId,itemQtyMapping,totalItems,distance);

            //Verifies if the order can be prepared, if yes, then puts in the queue to prepare.
            PrepareVerifiedOrderService.createOrder(restaurant,order);
        }

        return;

    }

}
