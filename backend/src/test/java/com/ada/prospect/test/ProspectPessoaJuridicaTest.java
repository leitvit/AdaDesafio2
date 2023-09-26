package com.ada.prospect.test;

import com.ada.prospect.models.ProspectPessoaJuridica;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

class ProspectPessoaJuridicaTest {


    private Validator validator;

    @BeforeEach
    public void setUp() {
        ValidatorFactory factory = buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    void testCanInstantiateProspect() {
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());
    }

    @Test
    void testNomeContatoNotEmptyValidation() {
        // Tests if raises error when Nome is empty
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setCpfContato("11111111111"); // CPF Tamanho 11
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setNomeContato("");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testNomeContatoRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when size over 50
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());



        // Verifica que o prospect viola validação esperada.
        String largeString = "N9zKp2vAxB6eWcJtUdYfGgRi3Hj5Ml1OqPwXyZ2rgwLKNfflkqw"; // Tamanho 51
        prospectPessoaJuridica.setNomeContato(largeString);

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }


    @Test
    void testRazaoSocialNotEmptyValidation() {
        // Tests if raises error when Nome is empty
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setCpfContato("11111111111"); // CPF Tamanho 11
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setRazaoSocial("");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testRazaoSocialRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when size over 50
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());



        // Verifica que o prospect viola validação esperada.
        String largeString = "N9zKp2vAxB6eWcJtUdYfGgRi3Hj5Ml1OqPwXyZ2rgwLKNfflkqw"; // Tamanho 51
        prospectPessoaJuridica.setRazaoSocial(largeString);

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testMerchantCategoryCodeNotEmptyValidation() {
        // Tests if raises error when MCC is empty
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());


        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setMerchantCategoryCode("");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testMerchantCategoryCodeMustContainNumbersOnly() {
        // Tests if raises error when MCC not comprised of Numbers
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());


        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setMerchantCategoryCode("ABCD");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when MCC larger than 4 digits
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());


        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setMerchantCategoryCode("12345");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());

    }

    @Test
    void testMerchantCategoryCodeRaisesErrorIfSmallerThanSpecifiedSize() {
        // Tests if raises error when MCC smaller than 4 digits
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());


        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setMerchantCategoryCode("123");

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }


    @Test
    void testCpfContatoMustContainNumbersOnly() {
        // Tests if raises error when CPF not comprised of Numbers
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setCpfContato("11111111111");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setCpfContato("A1234567890"); // CPF Tamanho 11 com letra

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testCpfContatoRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when larger than 4 digits
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setCpfContato("11111111111");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setCpfContato("123456789012"); // CPF Tamanho 12

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testCpfContatoRaisesErrorIfSmallerThanSpecifiedSize() {
        // Tests if raises error when smaller than 4 digits
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setCpfContato("11111111111");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setCpfContato("1234567890"); // CPF Tamanho 10

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());

    }
    @Test
    void testCnpjMustContainNumbersOnly() {
        // Tests if raises error when CPF not comprised of Numbers
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setCpfContato("11111111111");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setCnpj("A2345678901234"); // CNPJ Tamanho 14 com letra

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testCnpjRaisesErrorIfLargerThanSpecifiedSize() {
        // Tests if raises error when larger than 4 digits
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setCpfContato("11111111111");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setCnpj("123456789012345"); // Cnpj Tamanho 15

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }

    @Test
    void testCnpjRaisesErrorIfSmallerThanSpecifiedSize() {
        // Tests if raises error when smaller than 4 digits
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setEmail("test@bol.com.br");
        prospectPessoaJuridica.setCpfContato("11111111111");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setCnpj("1234567890123"); // Cnpj Tamanho 13

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());

    }


    @Test
    void testEmailRaisesErrorWhenNotMatchPattern() {
        // Tests if Email raises error when not matching email pattern
        ProspectPessoaJuridica prospectPessoaJuridica = new ProspectPessoaJuridica();

        prospectPessoaJuridica.setRazaoSocial("razaoSocial");
        prospectPessoaJuridica.setCnpj("12345678901234");
        prospectPessoaJuridica.setMerchantCategoryCode("1234");
        prospectPessoaJuridica.setNomeContato("Teste da Silva");
        prospectPessoaJuridica.setCpfContato("11111111111");
        prospectPessoaJuridica.setEmail("test@bol.com.br");

        // Verifica que o prospect não viola nenhuma validação.
        Set<ConstraintViolation<ProspectPessoaJuridica>> violations = validator.validate(prospectPessoaJuridica);
        Assertions.assertTrue(violations.isEmpty());

        // Verifica que o prospect viola validação esperada.
        prospectPessoaJuridica.setEmail("aaaaaaaaabbbbcccc"); //email em formato incorreto

        Set<ConstraintViolation<ProspectPessoaJuridica>> violationsWithMistake = validator.validate(prospectPessoaJuridica);
        Assertions.assertFalse(violationsWithMistake.isEmpty());
    }
}