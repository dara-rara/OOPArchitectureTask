package ru.urfu;

/**
 * Адаптер сообщений бота
 */
public interface AdapterBotMessage {
    /**
     * Обработать сообщение
     */
    String processMessage(String message);
}
