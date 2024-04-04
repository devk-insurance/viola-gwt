package com.github.lofidewanto.viodevk.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLButtonElement;

import java.util.logging.Logger;

public class AppEntryPoint implements EntryPoint {

	private static final Logger logger = Logger
			.getLogger(AppEntryPoint.class.getName());

	@Override
	public void onModuleLoad() {
		final HTMLButtonElement button = (HTMLButtonElement) DomGlobal.document.getElementById("helloButton");
		button.addEventListener("click", (Event event) -> {
            Window.alert("Hello World Lofi!");
			logger.info("Hello World Lofi!");
        });
	}
}
