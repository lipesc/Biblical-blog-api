package git.lipesc.biblical_blog_api.domain.entity;

import java.util.*;

import jakarta.persistence.*;


@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @Column(length = 255)
    private String description;

    @Column(nullable = false, unique = true, length = 100)
    private String slug;


    protected Category() {}

    private Category(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.slug = builder.slug;
    }

    public UUID id() {
        return id;
    }
    public String name() {
        return name;
    }
    public String description() {
        return description;
    }
    public String slug() {
        return slug;
    }
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private String name;
        private String description;
        private String slug;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder slug(String slug) {
            this.slug = slug;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }

}
