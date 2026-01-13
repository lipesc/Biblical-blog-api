package git.lipesc.biblical_blog_api.domain.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.CreationTimestamp;
import java.util.*;
import java.time.*;


@Entity
@Table(name = "users")
public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.UUID)
		private UUID id;

		@Column(nullable = false, unique=true)
		private String keycloakId;


		@Column(nullable = false, unique = true, length = 64)
		private String userName;

		@Column(nullable = false, unique = true, length = 128)
		private String email;

		@Column(nullable = false, length = 128)
		private String fullName;

		@Column(length = 255)
		private String bio;

		@Column(length = 255)
		private String profilePicUrl;

		@Column(nullable = false)
		private Boolean active = true;

		@Column(nullable = false)
		private Boolean emailVerified = false;

		@CreationTimestamp
		@Column(nullable = false, updatable = false)
		private LocalDateTime createdAt;

		@UpdateTimestamp
		private LocalDateTime updateAt;

		@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
		private Set<BiblicalPost> posts = new HashSet<>();

		@OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
		private Set<Comment> comments = new HashSet<>();
}
