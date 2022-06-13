import discord4j.core.DiscordClient;
import discord4j.core.GatewayDiscordClient;
import reactor.core.publisher.Mono;

public class MyBot {
    public static void main(String[] args) {
        DiscordClient client = DiscordClient.create("TOKEN");
    }
}

public static void main(String[]args){

        Mono<Void> login = client.withGateway((GatewayDiscordClient gateway) -> Mono.empty());
        login.block();

        DiscordClient.create("TOKEN")
        .withGateway(client ->
        client.on(MessageCreateEvent.class, event -> {
        Message message = event.getMessage();

        if (message.getContent().equalsIgnoreCase("!ping")) {
        return message.getChannel()
        .flatMap(channel -> channel.createMessage("Pong!"));
        }

        return Mono.empty();
        }))
        .block();

        }