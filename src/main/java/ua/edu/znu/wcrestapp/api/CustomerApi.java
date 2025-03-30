package ua.edu.znu.wcrestapp.api;

import com.google.gson.Gson;
import okhttp3.*;
import ua.edu.znu.wcrestapp.model.Billing;
import ua.edu.znu.wcrestapp.model.Customer;
import ua.edu.znu.wcrestapp.model.Shipping;

import java.io.IOException;
import java.util.logging.Logger;

public class CustomerApi {

    /**
     * Prepare a customer object with the given parameters.
     *
     * @param firstName first name of the customer
     * @param lastName  last name of the customer
     * @param email     email of the customer
     * @param username  username of the customer
     * @param password  password of the customer
     * @param company   company name of the customer
     * @param address1  address line 1 of the customer
     * @param address2  address line 2 of the customer
     * @param city      city of the customer
     * @param state     state of the customer
     * @param postcode  postcode of the customer
     * @param country   country of the customer
     * @param phone     phone number of the customer
     * @return the customer object
     */
    public Customer prepareCustomer(String firstName, String lastName, String email, String username, String password, String company, String address1, String address2, String city, String state, String postcode, String country, String phone) {
        Shipping shipping = new Shipping(firstName, lastName, company, address1, address2,
                city, state, postcode, country);
        Billing billing = new Billing(firstName, lastName, company, address1, address2,
                city, state, postcode, country, email, phone);
        Customer customer = new Customer();
        customer.setFirst_name(firstName);
        customer.setLast_name(lastName);
        customer.setEmail(email);
        customer.setUsername(username);
        customer.setPassword(password);
        customer.setBilling(billing);
        customer.setShipping(shipping);
        return customer;
    }

    /**
     * Create a customer in the WooCommerce store.
     *
     * @param customer the customer object to be created
     * @param client   the OkHttpClient instance
     * @param gson     the Gson instance
     * @param config   the Config instance
     * @return the created customer object
     */
    public Customer createCustomer(Customer customer, OkHttpClient client, Gson gson, Config config) {
        String url = config.getBaseUrl() + "/customers";
        String resultJson = "";
        RequestBody body = RequestBody.create(gson.toJson(customer), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Authorization", config.getCredential())
                .post(body)
                .build();   //synchronous POST request
        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            if (response.body() != null) {
                resultJson = response.body().string();
            }
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
        System.out.println(resultJson);
        return gson.fromJson(resultJson, Customer.class);
    }

    /**
     * Get the customer by id.
     *
     * @param customerId the customer id
     * @param client     the OkHttpClient instance
     * @param gson       the Gson instance
     * @param config     the Config instance
     * @return the customer object
     */
    public Customer getCustomer(Long customerId, OkHttpClient client, Gson gson, Config config) {
        String url = config.getBaseUrl() + "/customers/" + customerId;
        String resultJson = "";
        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Authorization", config.getCredential())
                .build();   //synchronous GET request is default
        try (Response response = client.newCall(request).execute()) {
            System.out.println("Response Code: " + response.code());
            if (response.body() != null) {
                resultJson = response.body().string();
            }
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
        System.out.println(resultJson);
        return gson.fromJson(resultJson, Customer.class);
    }
}
