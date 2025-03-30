package ua.edu.znu.wcrestapp.api;

import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import ua.edu.znu.wcrestapp.entities.order.*;

import java.io.IOException;
import java.util.logging.Logger;

public class OrderCall {
    /**
     * Get the WCOrder instance.
     *
     * @param products the products
     * @return the WCOrder instance
     */
    @NotNull
    public WCOrder prepeareWcOrder(ProductItem[] products, OrderStatus orderStatus) {
        Shipping shipping = new Shipping("John", "Doe", "Company", "Address 1", "Address 2",
                "City", "State", "Postcode", "Country");
        Billing billing = new Billing("John", "Doe", "Company", "Address 1", "Address 2",
                "City", "State", "Postcode", "Country", "john@gail.com", "1234567890");
        WCOrder order = new WCOrder();
        order.setLine_items(products);
        order.setBilling(billing);
        order.setShipping(shipping);
        order.setPayment_method("cod");
        order.setPayment_method_title("Готівка при отриманні");
        order.setStatus(orderStatus.getStatus());
        System.out.println(order.getStatus());
        return order;
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
    public WCOrder createOrder(WCOrder order, OkHttpClient client, Gson gson, Config config) {
        String url = config.getBaseUrl() + "/orders";
//        String credential = getCredential();
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
        return gson.fromJson(resultJson, WCOrder.class);
    }
}
