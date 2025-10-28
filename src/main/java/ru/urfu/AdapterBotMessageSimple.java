package ru.urfu;

public class AdapterBotMessageSimple implements AdapterBotMessage{
    @Override
    public String processMessage(String message) {
        return "Ваше сообщение: '" + message + "'";
    }
}
