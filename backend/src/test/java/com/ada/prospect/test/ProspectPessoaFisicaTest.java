package com.ada.prospect.test;

import com.ada.prospect.models.ProspectPessoaFisica;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

class ProspectPessoaFisicaTest {


    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void testCanInstantiateProspect() {
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111"); // CPF Tamanho 11
        prospectPessoaFisica.setEmail("test@bol.com.br");
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setMerchantCategoryCode("1234");

        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void testNomeNotEmptyValidation() {
        // Tests if raises error when Nome is empty
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111"); // CPF Tamanho 11
        prospectPessoaFisica.setEmail("test@bol.com.br");
        prospectPessoaFisica.setMerchantCategoryCode("1234");

        prospectPessoaFisica.setNome("");

        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testNomeRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when size over 50
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111");
        prospectPessoaFisica.setEmail("test@bol.com.br");
        prospectPessoaFisica.setMerchantCategoryCode("1234");

        String largeString = "N9zKp2vAxB6eWcJtUdYfGgRi3Hj5Ml1OqPwXyZ2rgwLKNfflkqz"; // Tamanho 51
        prospectPessoaFisica.setNome(largeString);

        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }
    @Test
    void testMerchantCategoryCodeNotEmptyValidation() {
        // Tests if raises error when MCC is empty
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111"); // CPF Tamanho 11
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");

        prospectPessoaFisica.setMerchantCategoryCode("");


        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testMerchantCategoryCodeMustContainNumbersOnly() {
        // Tests if raises error when MCC not comprised of Numbers
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111"); // CPF Tamanho 11
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");

        prospectPessoaFisica.setMerchantCategoryCode("ABCD");

        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when MCC larger than 4 digits
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111"); // CPF Tamanho 11
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");

        prospectPessoaFisica.setMerchantCategoryCode("12345");


        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfSmallerThanSpecifiedSize() {
        // Tests if raises error when MCC smaller than 4 digits
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setCpf("11111111111"); // CPF Tamanho 11
        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");

        prospectPessoaFisica.setMerchantCategoryCode("123");


        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }


    @Test
    void testCpfMustContainNumbersOnly() {
        // Tests if raises error when CPF not comprised of Numbers
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");
        prospectPessoaFisica.setMerchantCategoryCode("1234");

        prospectPessoaFisica.setCpf("A1234567890"); // CPF Tamanho 11 com letra

        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testCpfRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when larger than 4 digits
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");
        prospectPessoaFisica.setMerchantCategoryCode("1234");

        prospectPessoaFisica.setCpf("123456789012"); // CPF Tamanho 12


        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }

    @Test
    void testCpfRaisesErrorIfSmallerThanSpecifiedSize() {
        // Tests if raises error when smaller than 4 digits
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setEmail("test@bol.com.br");
        prospectPessoaFisica.setMerchantCategoryCode("1234");

        prospectPessoaFisica.setCpf("1234567890"); // CPF Tamanho 10


        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }


    @Test
    void testEmailRaisesErrorWhenNotMatchPattern() {
        // Tests if Email raises error when not matching email pattern
        ProspectPessoaFisica prospectPessoaFisica = new ProspectPessoaFisica();

        prospectPessoaFisica.setNome("Teste da Silva");
        prospectPessoaFisica.setMerchantCategoryCode("1234");
        prospectPessoaFisica.setCpf("12345678901");

        // Email em formato não aceito
        prospectPessoaFisica.setEmail("aaaaaaaaabbbbcccc");

        Set<ConstraintViolation<ProspectPessoaFisica>> violations = validator.validate(prospectPessoaFisica);
        Assertions.assertFalse(violations.isEmpty());
    }
}