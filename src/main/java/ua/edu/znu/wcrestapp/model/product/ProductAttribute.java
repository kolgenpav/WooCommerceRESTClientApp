package ua.edu.znu.wcrestapp.model.product;

import java.util.Arrays;

public record ProductAttribute(String id, String name, String slug, String position, boolean visible, String variation,
                               boolean has_terms, String[] options) {

    @Override
    public String toString() {
        return """
                Attribute{
                    id='%s',
                    name='%s',
                    slug='%s',
                    position='%s',
                    visible='%s',
                    variation='%s',
                    has_terms='%s',
                    options=%s
                }
                """.formatted(
                id,
                name,
                slug,
                position,
                visible,
                variation,
                has_terms,
                Arrays.toString(options)
        );
    }
}
