package ua.edu.znu.wcrestapp;

import com.google.gson.Gson;
import okhttp3.*;
import ua.edu.znu.wcrestapp.api.Config;
import ua.edu.znu.wcrestapp.api.OrderCall;
import ua.edu.znu.wcrestapp.api.ProductCall;
import ua.edu.znu.wcrestapp.entities.order.*;
import ua.edu.znu.wcrestapp.entities.product.WCProduct;

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
            ProductCall productCall = new ProductCall();
            WCProduct product = productCall.getProduct(productId, client, gson, config);
            System.out.println(product);

            /*Create an order*/
            OrderCall orderCall = new OrderCall();
            OrderStatus orderStatus = OrderStatus.PROCESSING;
            ProductItem[] products = new ProductItem[1];
            ProductItem productItem = new ProductItem(productId, 1);
            productItem.setSku("109-10821388");
            products[0] = productItem;
            WCOrder order = orderCall.prepeareWcOrder(products, orderStatus);
            System.out.println(gson.toJson(order));
            WCOrder orderReturned = orderCall.createOrder(order, client, gson, config);
            System.out.println(orderReturned);
        } catch (Exception e) {
            Logger.getGlobal().severe(e.getMessage());
        }
    }
}
