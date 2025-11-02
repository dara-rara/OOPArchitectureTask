package ru.urfu;

/**
 * Реализация {@link MessageHandler}
 */
public class MessageHandlerSimple implements MessageHandler {
    @Override
    public String handle(String message) {
        return "Ваше сообщение: '" + message + "'";
    }
}
