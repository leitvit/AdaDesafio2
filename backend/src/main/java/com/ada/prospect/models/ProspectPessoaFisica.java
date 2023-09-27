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

@Entity
@Getter
@Setter
public class ProspectPessoaFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @NotBlank
    @Size(min = 1,max = 50,message = "Nome deve conter até 50 caracteres.")
    @Schema(example = "Joaquim Bezerra")
    private String nome;

    @NotBlank
    @Size(min = 4,max = 4,message = "MCC deve conter 4 números.")
    @Pattern(regexp = RegexPatterns.NUMERICAL_STRING_PATTERN,message = "MCC deve ser composto apenas por números.")
    @Schema(example = "1234")
    private String merchantCategoryCode;

    @NotBlank
    @Size(min = 11,max = 11,message = "CPF deve conter 11 números.")
    @Pattern(regexp = RegexPatterns.NUMERICAL_STRING_PATTERN,message = "CPF deve ser composto apenas por números.")
    @Schema(example = "12345678900")
    private String cpf;

    @NotBlank
    @Pattern(regexp = RegexPatterns.EMAIL_VALIDATION_PATTERN,message = "Informe um email válido.")
    @Schema(example = "joaquim.bezerra@aol.com.br")
    private String email;

}
