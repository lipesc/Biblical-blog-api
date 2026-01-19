package git.lipesc.biblical_blog_api.domain.dto.request;

import java.util.Set;
import java.util.UUID;

import git.lipesc.biblical_blog_api.domain.enums.PostStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BiblicalPostRequest(
    @NotBlank(message = "Título é obrigatório")
    @Size(max = 150, message = "Título deve ter no máximo 150 caracteres")
    String title,

    @NotBlank(message = "Conteúdo é obrigatório")
    @Size(max = 5000, message = "Conteúdo deve ter no máximo 5000 caracteres")
    String thought,

    @NotBlank(message = "Versículo bíblico é obrigatório")
    @Size(max = 100, message = "Versículo bíblico deve ter no máximo 100 caracteres")
    String bibleVerse,

    @NotBlank(message = "Texto do versículo é obrigatório")
    @Size(max = 5000, message = "Texto do versículo deve ter no máximo 5000 caracteres")
    String verseText,

    @NotBlank(message = "Versão da Bíblia é obrigatória")
    @Size(max = 50, message = "Versão da Bíblia deve ter no máximo 50 caracteres")
    String bibleVersion,

    @NotNull(message = "Status é obrigatório")
    PostStatus status,

    @NotNull(message = "Categoria é obrigatória")
    UUID categoryId,

    @Size(max = 10, message = "Tags não pode ter mais de 10 itens")
) {}
