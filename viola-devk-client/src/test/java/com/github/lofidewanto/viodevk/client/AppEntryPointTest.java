package com.github.lofidewanto.viodevk.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
public class AppEntryPointTest {
    @BeforeEach
    public void setUp() {
    }

    @Test
    public void validateEmail_validEmail() {
        AppEntryPoint appEntryPoint = new AppEntryPoint();
        String validEmail = "test@example.com";

        boolean emailValid = appEntryPoint.isEmailValid(validEmail);

        assertTrue(emailValid);
    }

    @Test
    public void validateEmail_invalidEmail() {
        AppEntryPoint appEntryPoint = new AppEntryPoint();
        String invalidEmail = "invalid_email";

        boolean emailValid = appEntryPoint.isEmailValid(invalidEmail);

        assertFalse(emailValid);
    }

    @Test
    public void validateEmail_invalidEmail_Without_Dot() {
        AppEntryPoint appEntryPoint = new AppEntryPoint();
        String invalidEmail = "invalid_email@example";

        boolean emailValid = appEntryPoint.isEmailValid(invalidEmail);

        assertTrue(emailValid);
    }
}