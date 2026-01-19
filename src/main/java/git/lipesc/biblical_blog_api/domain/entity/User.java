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

		@CreationTimestamp
		private LocalDateTime createdAt;

		@UpdateTimestamp
		private LocalDateTime updateAt;

		@OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
		private Set<BiblicalPost> posts = new HashSet<>();

		@OneToMany(mappedBy = "user",  cascade = CascadeType.ALL, orphanRemoval = true)
		private Set<Comment> comments = new HashSet<>();


		protected User () {}

		private User(Builder builder) {
				this.keycloakId = builder.keycloakId;
				this.userName = builder.userName;
				this.email = builder.email;
				this.fullName = builder.fullName;
				this.bio = builder.bio;
				this.profilePicUrl = builder.profilePicUrl;
				this.active = builder.active;
			}

		public UUID id() {
				return id;
		}

		public String userName() {
				return userName;
		}

		public String email() {
				return email;
		}
		public String fullName() {
				return fullName;
		}
		public String bio() {
				return bio;
		}
		public String profilePicUrl() {
				return profilePicUrl;
		}
		public Boolean active() {
				return active;
		}
		public LocalDateTime createdAt() {
				return createdAt;
		}
		public int getPostCount() {
				return posts != null ? posts.size() : 0;
		}
		

		
		public static Builder builder() {
				return new Builder();
		}

		public static class Builder {
				private String keycloakId;
				private String userName;
				private String email;
				private String fullName;
				private String bio;
				private String profilePicUrl;
				private Boolean active = true;

				public Builder keycloakId(String keycloakId){

						return this;
				}

				public Builder userName(String userName) {
						this.userName = userName;
						return this;
				}

				public Builder email(String email) {
						this.email = email;
						return this;
				}

				public Builder fullName(String fullName) {
						this.fullName = fullName;
						return this;
				}

				public Builder bio(String bio) {
						this.bio = bio;
						return this;
				}

				public Builder profilePicUrl(String profilePicUrl)
				{
						this.profilePicUrl = profilePicUrl;
						return this;
				}

				public User builder() {
						return new User(this);
				}
		}
}
