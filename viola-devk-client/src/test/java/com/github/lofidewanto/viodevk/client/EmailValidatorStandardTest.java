package com.github.lofidewanto.viodevk.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorStandardTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void validateEmail_validEmail() {
        EmailValidatorStandard emailValidatorStandard = new EmailValidatorStandard();
        String validEmail = "test@example.com";

        boolean emailValid = emailValidatorStandard.isEmailValid(validEmail);

        assertTrue(emailValid);
    }

    @Test
    void validateEmail_invalidEmail() {
        EmailValidatorStandard emailValidatorStandard = new EmailValidatorStandard();
        String invalidEmail = "invalid_email";

        boolean emailValid = emailValidatorStandard.isEmailValid(invalidEmail);

        assertFalse(emailValid);
    }

    @Test
    void validateEmail_invalidEmail_Without_Dot() {
        EmailValidatorStandard emailValidatorStandard = new EmailValidatorStandard();
        String invalidEmail = "invalid_email@example";

        boolean emailValid = emailValidatorStandard.isEmailValid(invalidEmail);

        assertTrue(emailValid);
    }
}