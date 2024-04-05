package com.github.lofidewanto.viodevk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.regexp.shared.RegExp;
import com.google.gwt.user.client.Window;
import elemental2.dom.*;

import java.util.logging.Logger;

public class AppEntryPoint implements EntryPoint {

    private static final Logger logger = Logger
            .getLogger(AppEntryPoint.class.getName());

    private static void addJunitTextArea() {
        final HTMLTextAreaElement junitTextArea = (HTMLTextAreaElement) DomGlobal.document.getElementById("junitTextArea");
        junitTextArea.value = "boolean isEmailValid(String email) {\n" +
                "    String emailRegex = \"^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$\";\n" +
                "    RegExp pattern = RegExp.compile(emailRegex);\n" +
                "    return pattern.test(email);\n" +
                "}";
    }

    @Override
    public void onModuleLoad() {
        addHelloButton();
        addTextArea();
        addJunitTextArea();
        addDeleteButton();
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

    void addDeleteButton() {
        final HTMLButtonElement button = (HTMLButtonElement) DomGlobal.document.getElementById("deleteButton");
        button.addEventListener("click", (Event event) -> {
            logger.info("Delete Button clicked");
            makeSomethingFunny();
        });
    }

    void makeSomethingFunny() {
        final HTMLInputElement input = (HTMLInputElement) DomGlobal.document.getElementById("emailInput");
        String inputContent = input.value;
        if (inputContent.isEmpty()) {
            Window.alert("Bitte geben Sie eine E-Mail-Adresse ein.");
        } else {
            boolean emailValid = isEmailValid(inputContent);
            if (emailValid) {
                Window.alert("E-Mail-Adresse " + inputContent + " ist valid, sie wird gelöscht.");
                input.value = "";
            } else {
                Window.alert("E-Mail-Adresse " + inputContent + " ist ungültig.");
            }
        }
    }

    boolean isEmailValid(String email) {
        // String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        RegExp pattern = RegExp.compile(emailRegex);
        return pattern.test(email);
    }
}
