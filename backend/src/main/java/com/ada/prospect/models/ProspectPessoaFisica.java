package com.ada.prospect.models;

import com.ada.prospect.utilities.RegexPatterns;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id;

    @NotBlank
    @Size(
            min = 1,
            max = 50,
            message = "Nome deve conter até 50 caracteres."
    )
    private String nome;

    @NotBlank
    @Size(
            min = 4,
            max = 4,
            message = "MCC deve conter 4 números."
    )
    @Pattern(
            regexp = RegexPatterns.NUMERICAL_STRING_PATTERN,
            message = "MCC deve ser composto apenas por números."
    )
    private String merchantCategoryCode;

    @NotBlank
    @Size(
            min = 11,
            max = 11,
            message = "CPF deve conter 11 números."
    )
    @Pattern(
            regexp = RegexPatterns.NUMERICAL_STRING_PATTERN,
            message = "CPF deve ser composto apenas por números."
    )
    private String cpf;

    @NotBlank
    @Pattern(
            regexp = RegexPatterns.EMAIL_VALIDATION_PATTERN,
            message = "Informe um email válido."
    )
    private String email;

}
