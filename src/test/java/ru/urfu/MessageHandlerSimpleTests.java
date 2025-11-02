package ru.urfu;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тесты для класса MessageHandlerSimple
 */
@DisplayName("Тесты класса MessageHandlerSimple")
class MessageHandlerSimpleTests {
    private final MessageHandler messageHandlerSimple = new MessageHandlerSimple();

    /**
     * Тест для метода handle
     * Проверка с валидными данными
     */
    @Test
    @DisplayName("Позитивная проверка handle")
    void processMessagePositiveTest() {
        String expected = "Ваше сообщение: 'test'";
        assertEquals(expected, messageHandlerSimple.handle("test"));
    }
}
