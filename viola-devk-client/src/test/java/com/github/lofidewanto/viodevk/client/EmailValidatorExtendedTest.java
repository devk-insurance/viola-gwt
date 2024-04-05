package com.github.lofidewanto.viodevk.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailValidatorExtendedTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void validateEmail_validEmail() {
        EmailValidatorExtended emailValidatorExtended = new EmailValidatorExtended();
        String validEmail = "test@example.com";

        boolean emailValid = emailValidatorExtended.isEmailValid(validEmail);

        assertTrue(emailValid);
    }

    @Test
    void validateEmail_invalidEmail() {
        EmailValidatorExtended emailValidatorExtended = new EmailValidatorExtended();
        String invalidEmail = "invalid_email";

        boolean emailValid = emailValidatorExtended.isEmailValid(invalidEmail);

        assertFalse(emailValid);
    }

    @Test
    void validateEmail_invalidEmail_Without_Dot() {
        EmailValidatorExtended emailValidatorExtended = new EmailValidatorExtended();
        String invalidEmail = "invalid_email@example";

        boolean emailValid = emailValidatorExtended.isEmailValid(invalidEmail);

        assertFalse(emailValid);
    }
}