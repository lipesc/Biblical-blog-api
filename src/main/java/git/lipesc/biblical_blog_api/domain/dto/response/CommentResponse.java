package git.lipesc.biblical_blog_api.domain.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommentResponse(
    UUID id,
    String content,
    UserResponse user,
    UUID postId,
    Boolean approved,
    LocalDateTime createdAt
) {}
