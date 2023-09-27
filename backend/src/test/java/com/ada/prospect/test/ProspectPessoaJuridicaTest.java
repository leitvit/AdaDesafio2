package com.ada.prospect.test;

import com.ada.prospect.models.ProspectPessoaJuridica;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProspectPessoaJuridicaTest {


    private Validator validator;

    private final ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
        // Correctly formatted properties
        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
    }

    private void assertValidationError() {
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(this.prospectPessoaJuridica);
        assertFalse(violations.isEmpty());
    }

    private void assertValidationSuccessful() {
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(this.prospectPessoaJuridica);
        assertTrue(violations.isEmpty());
    }

    @Test
    void testCanInstantiateProspect() {
        // Given valid Prospect
        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        // Then
        assertValidationSuccessful();
    }

    @Test
    void testNomeContatoNotEmptyValidation() {
        // Given empty nomeContato
        prospectPessoaJuridica.setNomeContato("");
        // Then
        assertValidationError();
    }

    @Test
    void testNomeContatoRaisesErrorIfLargerThanSpecifiedSize() {
        // Given NomeContato size over 50
        String largeString = "N9zKp2vAxB6eWcJtUdYfGgRi3Hj5Ml1OqPwXyZ2rgwLKNfflkqw"; // Size 51
        prospectPessoaJuridica.setNomeContato(largeString);
        // Then
        assertValidationError();
    }


    @Test
    void testRazaoSocialNotEmptyValidation() {
        // Given RazaoSocial is empty
        prospectPessoaJuridica.setRazaoSocial("");
        // Then
        assertValidationError();
    }

    @Test
    void testRazaoSocialRaisesErrorIfLargerThanSpecifiedSize() {
        // Given RazaoSocial size is over 50
        String largeString = "N9zKp2vAxB6eWcJtUdYfGgRi3Hj5Ml1OqPwXyZ2rgwLKNfflkqw"; // Size 51
        prospectPessoaJuridica.setRazaoSocial(largeString);
        // Then
        assertValidationError();

    }

    @Test
    void testMerchantCategoryCodeNotEmptyValidation() {
        // Given MerchantCategoryCode is empty
        prospectPessoaJuridica.setMerchantCategoryCode("");
        // Then
        assertValidationError();
    }

    @Test
    void testMerchantCategoryCodeMustContainNumbersOnly() {
        // Given MerchantCategoryCode is not only composed of numbers
        prospectPessoaJuridica.setMerchantCategoryCode("ABCD"); // MCC composed of letters
        // Then
        assertValidationError();
    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfLargerThanSpecifiedSize() {
        // Given MerchantCategoryCode size is over 4 characters
        prospectPessoaJuridica.setMerchantCategoryCode("12345"); // MCC size 5
        // Then
        assertValidationError();
    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfSmallerThanSpecifiedSize() {
        // Given MerchantCategoryCode size is smaller than 4 characters
        prospectPessoaJuridica.setMerchantCategoryCode("123"); // MCC size 3
        // Then
        assertValidationError();
    }


    @Test
    void testCpfContatoMustContainNumbersOnly() {
        // Given cpfContato is not only composed of numbers
        prospectPessoaJuridica.setCpfContato("A1234567890"); // CPF size 11 with letters
        // Then
        assertValidationError();
    }

    @Test
    void testCpfContatoRaisesErrorIfLargerThanSpecifiedSize() {
        // Given cpfContato size is larger than 11 characters
        prospectPessoaJuridica.setCpfContato("123456789012"); // CPF size 12
        // Then
        assertValidationError();
    }

    @Test
    void testCpfContatoRaisesErrorIfSmallerThanSpecifiedSize() {
        // Given cpfContato size is smaller than 11 characters
        prospectPessoaJuridica.setCpfContato("1234567890"); // CPF size 10
        // Then
        assertValidationError();
    }
    @Test
    void testCnpjMustContainNumbersOnly() {
        // Given Cnpj is not only composed of numbers
        prospectPessoaJuridica.setCnpj("A2345678901234"); // CNPJ size 14 with letters
        // Then
        assertValidationError();
    }

    @Test
    void testCnpjRaisesErrorIfLargerThanSpecifiedSize() {
        // Given Cnpj size is larger than 14 characters
        prospectPessoaJuridica.setCnpj("123456789012345"); // Cnpj size 15
        // Then
        assertValidationError();
    }

    @Test
    void testCnpjRaisesErrorIfSmallerThanSpecifiedSize() {
        // Given Cnpj size is smaller than 14 characters
        prospectPessoaJuridica.setCnpj("1234567890123"); // Cnpj size 13
        // Then
        assertValidationError();
    }


    @Test
    void testEmailRaisesErrorWhenNotMatchPattern() {
        // Given incorrect email format
        prospectPessoaJuridica.setEmail("aaaaaaaaabbbbcccc");
        // Then
        assertValidationError();
    }
}