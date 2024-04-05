package com.github.lofidewanto.viodevk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLTextAreaElement;

import java.util.logging.Logger;

public class AppEntryPoint implements EntryPoint {

    private static final Logger logger = Logger
            .getLogger(AppEntryPoint.class.getName());

    @Override
    public void onModuleLoad() {
        addHelloButton();
        addTextArea();
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

    }
}
