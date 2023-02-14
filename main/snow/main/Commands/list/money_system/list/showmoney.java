package main.Commands.list.money_system.list;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class showmoney {

    MoneyManager moneyManager = new MoneyManager();

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if(!event.getName().equals("money")) return;
        event.deferReply(true).setContent("").queue();

        long user_id = event.getUser().getIdLong();
        System.out.println(user_id);
        long guild_id = event.getGuild().getIdLong();
        moneyManager.money(event, user_id, guild_id);
    }
}
