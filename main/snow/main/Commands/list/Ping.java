package main.Commands.list;

import main.util.JsonFileManager;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.DiscordLocale;
import org.json.simple.JSONObject;

public class Ping {

    public static JSONObject jsonObject;

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ping")) return;

        JsonFileManager manager = new JsonFileManager("src/main/snow/main/lang/zh_TW.json", true);

        String ping = manager.getObj().get("ping").toString(); // "延遲"
        String guild = (String) manager.getObj().get("noinguild");

        DiscordLocale locale = event.getUserLocale();

        System.out.println(locale);


//        String lang = manager.getObj().getString(event.getGuild().getId());
//
//        System.out.println(lang);
//
//
        if (!event.isFromGuild()) {
            event.getChannel().sendMessage(guild).queue();
            return;
        }
        event.getInteraction().deferReply().setContent(ping + ": " + event.getJDA().getGatewayPing()).queue();


    }
}
