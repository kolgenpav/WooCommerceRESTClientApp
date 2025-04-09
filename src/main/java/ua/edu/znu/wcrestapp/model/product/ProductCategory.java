package ua.edu.znu.wcrestapp.model.product;

public record ProductCategory(Long id, String name, String slug) {

    @Override
    public String toString() {
        return """
                Category{
                    id='%s',
                    name='%s',
                    slug='%s'
                }
                """.formatted(
                id,
                name,
                slug
        );
    }
}
