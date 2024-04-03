package com.github.lofidewanto.viodevk.client;

import java.util.logging.Logger;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.ButtonElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

public class AppEntryPoint implements EntryPoint {

	private static Logger logger = Logger
			.getLogger(AppEntryPoint.class.getName());

	@Override
	public void onModuleLoad() {
		ButtonElement button = (ButtonElement) Document.get().getElementById("helloButton");
		button.
		button.addClickHandler(clickEvent -> {
			Window.alert("Hello World Lofi!");
			logger.info("Hello World!");
		});

		RootPanel.get("helloButton").add(button);
	}
}
