package com.ada.prospect.test;

import com.ada.prospect.models.ProspectPessoaFisica;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProspectPessoaFisicaTest {


    private Validator validator;

    private final ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
        // Correctly formatted properties
        prospectPessoaFisica.setMerchantCategoryCode("1234");
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setCpf("11111111111");
        prospectPessoaFisica.setEmail("test@bol.com.br");
    }

    private void assertValidationError() {
        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(this.prospectPessoaFisica);
        assertFalse(violations.isEmpty());
    }

    private void assertValidationSuccessful() {
        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(this.prospectPessoaFisica);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testCanInstantiateProspect() {
        // Given valid Prospect
        prospectPessoaFisica.setMerchantCategoryCode("1234");
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setCpf("11111111111");
        prospectPessoaFisica.setEmail("test@bol.com.br");

        assertValidationSuccessful();
    }

    @Test
    void testNomeNotEmptyValidation() {
        // Given empty Nome
        prospectPessoaFisica.setNome("");

        assertValidationError();
    }

    @Test
    void testNomeRaisesErrorIfLargerThanSpecifiedSize() {
        // Given Nome size over 50
        String largeString = "N9zKp2vAxB6eWcJtUdYfGgRi3Hj5Ml1OqPwXyZ2rgwLKNfflkqz"; // Size 51
        prospectPessoaFisica.setNome(largeString);

        assertValidationError();
    }

    @Test
    void testMerchantCategoryCodeNotEmptyValidation() {
        // Given MerchantCategoryCode is empty
        prospectPessoaFisica.setMerchantCategoryCode("");
        // Then
        assertValidationError();
    }

    @Test
    void testMerchantCategoryCodeMustContainNumbersOnly() {
        // Given MerchantCategoryCode not composed entirely of numbers
        prospectPessoaFisica.setMerchantCategoryCode("ABCD");
        // Then
        assertValidationError();

    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfLargerThanSpecifiedSize() {
        // Given MerchantCategoryCode size larger than 4 digits
        prospectPessoaFisica.setMerchantCategoryCode("12345");
        // Then
        assertValidationError();
    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfSmallerThanSpecifiedSize() {
        // Given MerchantCategoryCode smaller than 4 digits
        prospectPessoaFisica.setMerchantCategoryCode("123");
        // Then
        assertValidationError();
    }


    @Test
    void testCpfMustContainNumbersOnly() {
        // Given Cpf not composed entirely of numbers
        prospectPessoaFisica.setCpf("A1234567890"); // CPF size 11 with letters
        // Then
        assertValidationError();
    }

    @Test
    void testCpfRaisesErrorIfLargerThanSpecifiedSize() {
        // Given Cpf larger than 11 digits
        prospectPessoaFisica.setCpf("123456789012"); // CPF Tamanho 12
        // Then
        assertValidationError();
    }

    @Test
    void testCpfRaisesErrorIfSmallerThanSpecifiedSize() {
        // Given Cpf smaller than 11 digits
        prospectPessoaFisica.setCpf("1234567890"); // CPF size 10
        // Then
        assertValidationError();
    }


    @Test
    void testEmailRaisesErrorWhenNotMatchPattern() {
        // Given incorrect email format
        prospectPessoaFisica.setEmail("aaaaaaaaabbbbcccc");
        // Then
        assertValidationError();
    }
}