package ua.edu.znu.wcrestapp.model.customer;

import lombok.*;

@Data
public class CustomerMetaData {
    @Builder(builderMethodName = "customBuilder")
    public static CustomerMetaData of(String key, String value) {
        CustomerMetaData customerMetaData = new CustomerMetaData();
        customerMetaData.setKey(key);
        customerMetaData.setValue(value);
        return customerMetaData;
    }

    @Setter(AccessLevel.NONE)
    private Long id;
    private String key;
    private String value;
}
