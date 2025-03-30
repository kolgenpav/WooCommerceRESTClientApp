package ua.edu.znu.wcrestapp;

import com.google.gson.Gson;
import okhttp3.*;
import ua.edu.znu.wcrestapp.api.Config;
import ua.edu.znu.wcrestapp.api.CustomerApi;
import ua.edu.znu.wcrestapp.api.OrderApi;
import ua.edu.znu.wcrestapp.api.ProductApi;
import ua.edu.znu.wcrestapp.model.*;

import java.util.logging.Logger;

public class ClientUsageDemo {

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        Config config = new Config();

        try {
            /*Product id*/
            Long productId = 109L;
            /*Get the product*/
            ProductApi productApi = new ProductApi();
            Product product = productApi.getProduct(productId, client, gson, config);
            System.out.println(product);

            /*Create an order*/
            OrderApi orderApi = new OrderApi();
            OrderStatus orderStatus = OrderStatus.PROCESSING;
            ProductItem[] products = new ProductItem[1];
            ProductItem productItem = new ProductItem(productId, 1);
            productItem.setSku("109-10821388");
            products[0] = productItem;
            Order order = orderApi.prepeareWcOrder(products, orderStatus);
            System.out.println(gson.toJson(order));
            Order orderReturned = orderApi.createOrder(order, client, gson, config);
            System.out.println(orderReturned);

            /*Customers*/
            CustomerApi customerApi = new CustomerApi();
            /*Create a customer*/
            String firstName = "Марія";
            String lastName = "Шевченко";
            String email = "maria@gmail.com";
            String username = "maria";
            String phone = "1234567890";
            String password = "password";
            String company = "Company";
            String address1 = "Address 1";
            String address2 = "Address 2";
            String city = "City";
            String state = "State";
            String postcode = "Postcode";
            String country = "Country";
            Customer customer = customerApi.prepareCustomer(firstName, lastName, email, username, password, company, address1, address2, city, state, postcode, country, phone);
            Customer customerReturned = customerApi.createCustomer(customer, client, gson, config);
            System.out.println(customerReturned);

            /*Get a customer by Id*/
            Customer customerGet = customerApi.getCustomer(3L, client, gson, config);
            System.out.println(customerGet);

        } catch (Exception e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }
}
