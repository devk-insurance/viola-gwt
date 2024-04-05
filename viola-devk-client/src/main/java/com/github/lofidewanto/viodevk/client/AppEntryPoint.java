package com.github.lofidewanto.viodevk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import elemental2.dom.*;

import java.util.logging.Logger;

public class AppEntryPoint implements EntryPoint {

    private static final Logger logger = Logger
            .getLogger(AppEntryPoint.class.getName());

    @Override
    public void onModuleLoad() {
        addButton();
        addTextArea();
    }

     void addTextArea() {
        final HTMLTextAreaElement textArea = (HTMLTextAreaElement) getDocument().getElementById("stepsTextArea");
        textArea.value = "Hier sind einige Schritte, die du stattdessen unternehmen kannst:\n\n" +
                "1. System?\n" +
                "2. Benachrichtigung?\n" +
                "3. Beweis?\n" +
                "4. Was verbessern?\n";
    }

     void addButton() {
        final HTMLButtonElement button = (HTMLButtonElement) getDocument().getElementById("helloButton");
        button.addEventListener("click", (Event event) -> {
            logger.info("Button clicked");
            Window.alert("Hello World!");
        });
    }
    
    HTMLDocument getDocument() {
        return DomGlobal.document;
    }
}
