package ua.edu.znu.wcrestapp.entities.product;

public record Dimensions(Double length, Double width, Double height) {

    @Override
    public String toString() {
        return """
                Dimensions{
                    length='%s',
                    width='%s',
                    height='%s'
                }
                """.formatted(
                length,
                width,
                height
        );
    }
}
