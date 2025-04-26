package ua.edu.znu.wcrestapp.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
public class Image {
    @Builder(builderMethodName = "imageBuilder")
    public static Image of(String src, String name, String alt) {
        Image image = new Image();
        image.setSrc(src);
        image.setName(name);
        image.setAlt(alt);
        return image;
    }

    @Setter(AccessLevel.NONE)
    private Long id;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_created;
    @Setter(AccessLevel.NONE)
    private LocalDateTime date_modified;
    private String src;
    private String name;
    private String alt;
}
