package git.lipesc.biblical_blog_api.domain.entity;

import jakarta.persistence.*;

import java.util.*; 
import java.time.*;


@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Column(nullable = false, length = 2000)
    private String content;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_id", nullable = false)
    private BiblicalPost post;

    @Column(nullable = false)
    private Boolean approved = false;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    protected Comment() {}

    private Comment(Builder builder) {
        this.content = builder.content;
        this.user = builder.user;
        this.post = builder.post;
        this.approved = builder.approved;
    }

    public UUID id() {
        return id;
    }
    public String content() {
        return content;
    }
    public User user() {
        return user;
    }
    public BiblicalPost post() {
        return post;
    }
    public Boolean approved() {
        return approved;
    }
    public LocalDateTime createdAt() {
        return createdAt;
    }
    

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private String content;
        private User user;
        private BiblicalPost post;
        private Boolean approved = false;

        
        public Builder content(String content) {
            this.content = content;
            return this;
        }
        public Builder user(User user) {
            this.user = user;
            return this;
        }
        public Builder post(BiblicalPost post) {
            this.post = post;
            return this;
        }
        public Builder approved(Boolean approved) {
            this.approved = approved;
            return this;
        }
        public Comment build() {
            return new Comment(this);
        }
    }


}
