package git.lipesc.biblical_blog_api.domain.dto.response;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import git.lipesc.biblical_blog_api.domain.enums.PostStatus;

public record BiblicalPostResponse(
    UUID id,
    String title,
    String thought,
    String bibleVerse,
    String verseText,
    String bibleVersion,
    PostStatus status,
    Boolean featured,
    Integer viewCount,
    Integer likeCount,
    Integer commentCount,
    UserResponse author,
    CategoryResponse category,
    Set<String> tags,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {

}
