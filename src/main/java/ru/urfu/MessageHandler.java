package ru.urfu;


/**
 * Обработчик сообщений бота
 */
public interface MessageHandler {
    /**
     * Обработать сообщение и вернуть результат
     */
    String handle(String message);
}