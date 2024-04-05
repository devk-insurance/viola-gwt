package com.github.lofidewanto.viodevk.client;

import com.google.gwt.regexp.shared.RegExp;

public class EmailValidatorExtended {

    public boolean isEmailValid(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        RegExp pattern = RegExp.compile(emailRegex);
        return pattern.test(email);
    }
}
