package com.ada.prospect.models;

import com.ada.prospect.utilities.RegexPatterns;
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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(
        name = "PROSPECT_PESSOA_JURIDICA",
        uniqueConstraints = @UniqueConstraint(columnNames = {"merchant_category_code"})
)
public class ProspectPessoaJuridica extends BaseProspect {

    @NotBlank
    @Size(min = 1, max = 50, message = "Razão social deve conter até 50 caracteres.")
    @Schema(example = "Padaria Belos Sonhos")
    @Column(name = "razao_social")
    private String razaoSocial;

    @NotBlank
    @Size(min = 14, max = 14, message = "CNPJ deve conter 14 números.")
    @Pattern(regexp = RegexPatterns.NUMERICAL_STRING_PATTERN, message = "CNPJ deve ser composto apenas por números.")
    @Schema(example = "12345678000110")
    @Column(name = "cnpj")
    private String cnpj;

    @NotBlank
    @Size(max = 50, message = "Nome deve conter até 50 caracteres.")
    @Schema(example = "Joaquim Bezerra")
    @Column(name = "nome_contato")
    private String nomeContato;

    @NotBlank
    @Size(min = 11, max = 11, message = "CPF deve conter 11 números.")
    @Pattern(regexp = RegexPatterns.NUMERICAL_STRING_PATTERN, message = "CPF deve ser composto apenas por números.")
    @Schema(example = "12345678900")
    @Column(name = "cpf_contato")
    private String cpfContato;
}
