package git.lipesc.biblical_blog_api.domain.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;


public record UserResponse(
    UUID id,
    String userName,
    String email,
    String fullName,
    String bio,
    String profilePicUrl,
    Boolean active,
    LocalDateTime createdAt,
    Integer postCount
) {}
