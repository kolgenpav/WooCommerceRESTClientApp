package ua.edu.znu.wcrestapp.api;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import ua.edu.znu.wcrestapp.model.Product;

import java.io.IOException;
import java.util.logging.Logger;

public class ProductApi {

    /**
     * Get the product by id.
     *
     * @param productId the product id
     * @param client    the OkHttpClient
     * @param gson      the Gson
     * @param config    the Config instance
     * @return the product instance
     */
    public Product getProduct(Long productId, OkHttpClient client, Gson gson, Config config) {
        String url = config.getBaseUrl() + "/products/" + productId;
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
        return gson.fromJson(resultJson, Product.class);
    }
}
