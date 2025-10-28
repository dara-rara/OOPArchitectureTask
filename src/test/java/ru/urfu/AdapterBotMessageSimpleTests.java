package ru.urfu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тесты для класса AdapterBotMessageSimple
 */
@DisplayName("Тесты класса AdapterBotMessageSimple")
class AdapterBotMessageSimpleTests {
    private final AdapterBotMessage adapterBotMessageSimple = new AdapterBotMessageSimple();

    /**
     * Тест для метода processMessage
     * Проверка с валидными данными
     */
    @Test
    @DisplayName("Позитивная проверка processMessage")
    void processMessagePositiveTest() {
        String expected = "Ваше сообщение: 'test'";
        assertEquals(expected, adapterBotMessageSimple.processMessage("test"));
    }
}
