package git.lipesc.biblical_blog_api.domain.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import git.lipesc.biblical_blog_api.domain.enums.PostStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "biblical_posts")
public class BiblicalPost {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 5000)
    private String thought;

    @Column(name = "bible_verse", nullable = false, length = 100)
    private String bibleVerse;

    @Column(name = "verse_text", nullable = false, length = 5000)
    private String verseText;

    @Column(nullable = false, name = "bible_version", length = 50)
    private String bibleVersion;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PostStatus status;

    @Column(nullable = false)
    private Boolean featured;

    @Column(name = "view_count", nullable = false)
    private Integer viewCount = 0;

    @Column(name = "like_count", nullable = false)
    private Integer likeCount = 0;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category categoty;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ElementCollection
    @CollectionTable(name = "post_tags", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "tag", length = 50)
    private Set<String> tags = new HashSet<>();

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    protected BiblicalPost() {  }

    private BiblicalPost(Builder builder) {
        this.title = builder.title;
        this.thought = builder.thought;
        this.bibleVerse = builder.bibleVerse;
        this.verseText = builder.verseText;
        this.bibleVersion = builder.bibleVersion;
        this.status = builder.status;
        this.featured = builder.featured;
        this.viewCount = builder.viewCount;
        this.likeCount = builder.likeCount;
        this.author = builder.author;
        this.categoty = builder.categoty;
        this.tags = new HashSet<>(builder.tags);
        this.publishedAt = builder.publishedAt;
    }

    public UUID id() {
        return id;
    }

    public String title() {
        return title;
    }

    public String thought() {
        return thought;
    }

    public String bibleVerse() {
        return bibleVerse;
    }

    public String verseText() {
        return verseText;
    }

    public String bibleVersion() {
        return bibleVersion;
    }

    public PostStatus status() {
        return status;
    }

    public Boolean featured() {
        return featured;
    }

    public Integer viewCount() {
        return viewCount;
    }

    public Integer likeCount() {
        return likeCount;
    }
    public User authorId() {
        return author;
    }
    public Category categoty() {
        return categoty;
    }
    public Set<String> tags() {
        return Set.copyOf(tags);
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime publishedAt() {
        return publishedAt;
    }


    public static Builder builder() {
        return new Builder();   
    }

    public static class Builder {
        private String title;
        private String thought;
        private String bibleVerse;
        private String verseText;
        private String bibleVersion;
        private PostStatus status = PostStatus.PUBLISHED;
        private Boolean featured = false;
        private Integer viewCount = 0;
        private Integer likeCount = 0;
        private User author;
        private Category categoty;
        private Set<String> tags = new HashSet<>();
        private LocalDateTime publishedAt;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder thought(String thought) {
            this.thought = thought;
            return this;
        }

        public Builder bibleVerse(String bibleVerse) {
            this.bibleVerse = bibleVerse;
            return this;
        }

        public Builder verseText(String verseText) {
            this.verseText = verseText;
            return this;
        }

        public Builder bibleVersion(String bibleVersion) {
            this.bibleVersion = bibleVersion;
            return this;
        }
        public Builder status(PostStatus status) {
            this.status = status;
            return this;
        }

        public Builder featured(Boolean featured) {
            this.featured = featured;
            return this;
        }

        public Builder viewCount(Integer viewCount) {
            this.viewCount = viewCount;
            return this;
        }

        public Builder likeCount(Integer likeCount) {
            this.likeCount = likeCount;
            return this;
        }
        public Builder author(User author) {
            this.author = author;
            return this;
        }

        public Builder categoty(Category categoty) {
            this.categoty = categoty;
            return this;
        }

        public Builder tags(Set<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder publishedAt(LocalDateTime publishedAt) {
            this.publishedAt = publishedAt;
            return this;
        }
    
        public BiblicalPost build() {
            return new BiblicalPost(this);
        }

    }
}
