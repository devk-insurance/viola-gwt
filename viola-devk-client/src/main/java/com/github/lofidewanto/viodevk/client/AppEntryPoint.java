package com.github.lofidewanto.viodevk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import elemental2.dom.*;

import java.util.logging.Logger;

public class AppEntryPoint implements EntryPoint {

    private static final Logger logger = Logger
            .getLogger(AppEntryPoint.class.getName());

    private EmailValidatorExtended emailValidatorExtended;

    private EmailValidatorStandard emailValidatorStandard;

    private boolean isEmailValidatorWithExtensionInUse = false;

    @Override
    public void onModuleLoad() {
        emailValidatorStandard = new EmailValidatorStandard();
        emailValidatorExtended = new EmailValidatorExtended();

        addHelloButton();
        addTextArea();
        addValidationTextArea();
        addValidateButton();
        addResultButton();
    }

    void addTextArea() {
        final HTMLTextAreaElement textArea = (HTMLTextAreaElement) DomGlobal.document.getElementById("stepsTextArea");
        textArea.value = "Hier sind einige Schritte, die du unternehmen kannst:\n\n" +
                "1. System?\n" +
                "2. Benachrichtigung?\n" +
                "3. Beweis?\n" +
                "4. Was verbessern?\n";
    }

    void addHelloButton() {
        final HTMLButtonElement button = (HTMLButtonElement) DomGlobal.document.getElementById("helloButton");
        button.addEventListener("click", (Event event) -> {
            logger.info("Hello Button clicked");
            Window.alert("Hello World!");
        });
    }

    void addValidateButton() {
        final HTMLButtonElement button = (HTMLButtonElement) DomGlobal.document.getElementById("validateButton");
        button.addEventListener("click", (Event event) -> {
            logger.info("Validate Button clicked");
            validateEmail();
        });
    }

    void addValidationTextArea() {
        final HTMLTextAreaElement junitTextArea = (HTMLTextAreaElement) DomGlobal.document.getElementById("validationTextArea");
        junitTextArea.value = "boolean isEmailValid(String email) {\n" +
                "    String emailRegex = \"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$\";\n" +
                "    RegExp pattern = RegExp.compile(emailRegex);\n" +
                "    return pattern.test(email);\n" +
                "}";

        isEmailValidatorWithExtensionInUse = false;
    }

    void addValidationWithExtensionTextArea() {
        final HTMLTextAreaElement junitTextArea = (HTMLTextAreaElement) DomGlobal.document.getElementById("validationTextArea");
        junitTextArea.value = "boolean isEmailValid(String email) {\n" +
                "    String emailRegex = \"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$\";\n" +
                "    RegExp pattern = RegExp.compile(emailRegex);\n" +
                "    return pattern.test(email);\n" +
                "}";

        isEmailValidatorWithExtensionInUse = true;
    }

    void addResultButton() {
        final HTMLButtonElement button = (HTMLButtonElement) DomGlobal.document.getElementById("resultButton");
        button.addEventListener("click", (Event event) -> {
            logger.info("Result Button clicked");

            boolean isReset = button.textContent.equals("Ergebnis zurückstellen");
            button.textContent = isReset ? "Lösung: Validation erweitern" : "Ergebnis zurückstellen";

            if (isReset) {
                addValidationTextArea();
            } else {
                addValidationWithExtensionTextArea();
            }
        });
    }

    void validateEmail() {
        final HTMLInputElement input = (HTMLInputElement) DomGlobal.document.getElementById("emailInput");
        String inputContent = input.value;
        if (inputContent.isEmpty()) {
            Window.alert("Bitte geben Sie eine E-Mail-Adresse ein.");
        } else {
            checkInput(inputContent, input);
        }
    }

    void checkInput(String inputContent, HTMLInputElement input) {
        String validatorType = isEmailValidatorWithExtensionInUse ? "EmailValidatorExtended" : "EmailValidatorStandard";
        logger.info(validatorType);

        boolean emailValid = isEmailValidatorWithExtensionInUse ?
                emailValidatorExtended.isEmailValid(inputContent) :
                emailValidatorStandard.isEmailValid(inputContent);

        String alertMessage = emailValid ?
                "E-Mail-Adresse " + inputContent + " ist gültig, sie wird gelöscht." :
                "E-Mail-Adresse " + inputContent + " ist ungültig.";

        Window.alert(alertMessage);

        if (emailValid) {
            input.value = "";
        }
    }
}
