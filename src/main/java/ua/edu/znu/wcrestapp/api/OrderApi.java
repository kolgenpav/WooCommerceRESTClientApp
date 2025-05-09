package ua.edu.znu.wcrestapp.api;

import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import ua.edu.znu.wcrestapp.model.*;
import ua.edu.znu.wcrestapp.model.order.Order;
import ua.edu.znu.wcrestapp.model.order.ProductItem;

import java.io.IOException;
import java.util.logging.Logger;

public class OrderApi {
    /**
     * Get the Order instance.
     *
     * @param products the products
     * @return the Order instance
     */
    @NotNull
    public Order prepeareOrder(ProductItem[] products) {
        Shipping shipping = Shipping.builder().first_name("John").last_name("Doe").company("Company")
                .address_1("Address 1").address_2("Address 2").city("City").state("State")
                .postcode("Postcode").country("Country").build();
        Billing billing = Billing.billingBuilder().firstName("John").lastName("Doe").company("Company")
                .address1("Address 1").address2("Address 2").city("City").state("State")
                .postcode("Postcode").country("Country").email("john@gail.com").phone("1234567890").build();
        return Order.orderBuilder()
                .line_items(products)
                .billing(billing)
                .shipping(shipping)
                .payment_method("cod")
                .payment_method_title("Готівка при отриманні")
                .build();
    }

    /**
     * Create an order.
     *
     * @param order  Woocommerce order to create
     * @param client OkHttpClient
     * @param gson   Gson
     * @param config the Config instance
     * @return the created order
     */
    public Order createOrder(Order order, OkHttpClient client, Gson gson, Config config) {
        String url = config.getBaseUrl() + "/orders";
        String resultJson = "";
        RequestBody body = RequestBody.create(gson.toJson(order), MediaType.parse("application/json"));
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
        return gson.fromJson(resultJson, Order.class);
    }
}
