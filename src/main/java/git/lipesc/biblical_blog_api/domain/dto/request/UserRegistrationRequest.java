package git.lipesc.biblical_blog_api.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserRegistrationRequest (
    @NotBlank(message = "Nome de usuário é obrigatório")
    @Size(min = 3, max = 64, message = "Nome de usuário deve ter entre 3 e 64 caracteres")    
    String username,

    @NotBlank(message = "Email é obrigatório")
    @Size(max = 128, message = "Email deve ter no máximo 128 caracteres")
    String email,

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, max = 128, message = "Senha deve ter entre 6 e 128 caracteres")
    @Pattern(
        regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
        message = "Senha deve conter maiúsculas, minúsculas, números e caracteres especiais"
    )
    String password,

    @NotBlank(message = "Nome completo é obrigatório")
    @Size(max = 128, message = "Nome completo deve ter no máximo 128 caracteres")
    String fullName,

    @Size(max = 255, message = "Bio deve ter no máximo 255 caracteres")
    String bio
) {}
