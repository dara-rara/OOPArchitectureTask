package ru.urfu;

import discord4j.common.util.Snowflake;
import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.Message;
import discord4j.core.object.entity.channel.MessageChannel;

/**
 * Дискорд бот
 */
public class DiscordBot {

    private final String token;
    private final AdapterBotMessage adapterBotMessage;

    private GatewayDiscordClient client;

    public DiscordBot(String token, AdapterBotMessage adapterBotMessage) {
        this.token = token;
        this.adapterBotMessage = adapterBotMessage;
    }

    /**
     * Запустить Дискорд бота
     */
    public void start() {
        client = DiscordClient.create(token).login().block();
        if (client == null) {
            throw new RuntimeException("Ошибка при входе в Discord");
        }
        client.on(MessageCreateEvent.class)
                .doOnError(throwable -> {
                    throw new RuntimeException("Ошибка при работе Discord бота", throwable);
                })
                .subscribe(event -> {
                    Message eventMessage = event.getMessage();
                    boolean isUser = eventMessage.getAuthor()
                            .map(user -> !user.isBot())
                            .orElse(false);
                    if (isUser) {
                        String chatId = eventMessage.getChannelId().asString();
                        String messageFromUser = eventMessage.getContent();
                        sendMessage(chatId,  adapterBotMessage.processMessage(messageFromUser));
                    }
                });
        System.out.println("Discord бот запущен");
        client.onDisconnect().block();
    }

    /**
     * Отправить сообщение
     * @param chatId идентификатор чата
     * @param message текст сообщения
     */
    private void sendMessage(String chatId, String message) {
        Snowflake channelId = Snowflake.of(chatId);
        MessageChannel channel = client.getChannelById(channelId)
                .ofType(MessageChannel.class).block();
        if (channel != null) {
            channel.createMessage(message).block();
        } else {
            System.err.println("Канал не найден");
        }
    }
}
