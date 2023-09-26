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
public class ProspectPessoaJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String razaoSocial;

    @NotBlank
    @Size(
            min = 14,
            max = 14,
            message = "CNPJ deve conter 14 números."
    )
    @Pattern(
            regexp = RegexPatterns.NUMERICAL_STRING_PATTERN,
            message = "CNPJ deve ser composto apenas por números."
    )
    private String cnpj;

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
    private Integer merchantCategoryCode;

    @NotBlank
    @Size(
            max = 50,
            message = "Nome deve conter até 50 caracteres."
    )
    private String nomeContato;

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
    private String cpfContato;

    @NotBlank
    @Pattern(
            regexp = RegexPatterns.EMAIL_VALIDATION_PATTERN,
            message = "Informe um email válido."
    )
    private String email;
}
