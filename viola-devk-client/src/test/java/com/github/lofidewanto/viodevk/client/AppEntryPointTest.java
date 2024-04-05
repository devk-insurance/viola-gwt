package com.github.lofidewanto.viodevk.client;

import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AppEntryPointTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private HTMLDocument document;

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    private HTMLButtonElement button;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void addButton_created() {
        AppEntryPoint appEntryPoint = spy(AppEntryPoint.class);

        appEntryPoint.addHelloButton();

        verify(button, times(1)).addEventListener(eq("click"), any());
    }
}