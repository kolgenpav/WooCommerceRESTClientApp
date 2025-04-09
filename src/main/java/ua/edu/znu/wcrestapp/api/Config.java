package ua.edu.znu.wcrestapp.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.Credentials;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.logging.Logger;

public class Config {

    /**
     * Get the base URL for the API.
     *
     * @return the base URL
     */
    public String getBaseUrl() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
        return properties.getProperty("base_url");
    }

    /**
     * Get the credential for the request.
     *
     * @return the credential
     */
    public String getCredential() {
        Properties credentialsProps = new Properties();
        try {
            credentialsProps.load(new FileInputStream("src/main/resources/credentials.properties"));
            credentialsProps.load(new FileInputStream("src/main/resources/credentials.properties"));
        } catch (IOException e) {
            Logger.getGlobal().severe(e.getMessage());
        }
        return Credentials.basic(credentialsProps.getProperty("consumer_key"), credentialsProps.getProperty("consumer_secret"));
    }

    public Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }
}
