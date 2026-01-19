package git.lipesc.biblical_blog_api.domain.dto.response;

import java.util.UUID;

public record CategoryResponse(
    UUID id,
    String name,
    String description,
    Boolean approved,
    String slug
) {}
