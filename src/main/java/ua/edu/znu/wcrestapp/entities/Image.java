package ua.edu.znu.wcrestapp.entities;

public record Image(Long id, String src, String name, String alt) {

    @Override
    public String toString() {
        return """
                  Image{
                    id='%s',
                    src='%s',
                    name='%s',
                    alt='%s'
                  }
                """.formatted(id, src, name, alt);
    }
}
