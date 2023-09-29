package com.ada.prospect.models;


import com.ada.prospect.utilities.RegexPatterns;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseProspect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 4, max = 4, message = "MCC deve conter 4 números.")
    @Pattern(regexp = RegexPatterns.NUMERICAL_STRING_PATTERN, message = "MCC deve ser composto apenas por números.")
    @Schema(example = "1234")
    @Column(name = "merchant_category_code")
    private String merchantCategoryCode;

    @NotBlank
    @Pattern(regexp = RegexPatterns.EMAIL_VALIDATION_PATTERN, message = "Informe um email válido.")
    @Schema(example = "joaquim.bezerra@aol.com.br")
    private String email;
}
