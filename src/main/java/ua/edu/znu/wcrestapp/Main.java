package ua.edu.znu.wcrestapp;

import com.google.gson.Gson;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import ua.edu.znu.wcrestapp.entities.order.*;
import ua.edu.znu.wcrestapp.entities.product.WCProduct;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class Main {

    public static final String BASE_URL = "http://localhost/edusite/wp-json/wc/v3";

    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();

        //Get the product id
        Long productId = 109L;
        try {
            WCProduct product = getProduct(productId, client, gson);
            System.out.println(product);

            //Create an order
            OrderStatus orderStatus = OrderStatus.PROCESSING;
            ProductItem[] products = new ProductItem[1];
            ProductItem productItem = new ProductItem(productId, 1);
            productItem.setSku("109-10821388");
            products[0] = productItem;
            WCOrder order = prepeareWcOrder(products, orderStatus);
            System.out.println(gson.toJson(order));
            WCOrder orderReturned = createOrder(order, client, gson);
            System.out.println(orderReturned);
        } catch (Exception e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }

    /**
     * Get the product by id.
     *
     * @param productId the product id
     * @param client    the OkHttpClient
     * @param gson      the Gson
     * @return the product instance
     */
    private static WCProduct getProduct(Long productId, OkHttpClient client, Gson gson) {
        String url = BASE_URL + "/products/" + productId;
        String credential = getCredential();
        String resultJson = "";
        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Authorization", credential)
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
        return gson.fromJson(resultJson, WCProduct.class);
    }

    /**
     * Create an order.
     *
     * @param order  Woocommerce order to create
     * @param client OkHttpClient
     * @param gson   Gson
     * @return the created order
     */
    private static WCOrder createOrder(WCOrder order, OkHttpClient client, Gson gson) {
        String url = BASE_URL + "/orders";
        String credential = getCredential();
        String resultJson = "";
        RequestBody body = RequestBody.create(gson.toJson(order), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("Accept", "application/json")
                .header("Authorization", credential)
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

    /**
     * Get the WCOrder instance.
     *
     * @param products the products
     * @return the WCOrder instance
     */
    @NotNull
    private static WCOrder prepeareWcOrder(ProductItem[] products, OrderStatus orderStatus) {
        Shipping shipping = new Shipping("John", "Doe", "Company", "Address 1", "Address 2", "City", "State", "Postcode", "Country");
        Billing billing = new Billing("John", "Doe", "Company", "Address 1", "Address 2", "City", "State", "Postcode", "Country", "john@gail.com", "1234567890");
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
     * Get the credential for the request.
     *
     * @return the credential
     */
    private static String getCredential() {
        Properties credentialsProps = new Properties();
        try {
            credentialsProps.load(new FileInputStream("src/main/resources/credentials.properties"));
            credentialsProps.load(new FileInputStream("src/main/resources/credentials.properties"));
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
        return Credentials.basic(credentialsProps.getProperty("consumer_key"), credentialsProps.getProperty("consumer_secret"));
    }
}
