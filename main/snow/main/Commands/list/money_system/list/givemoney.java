package main.Commands.list.money_system.list;

import main.util.JsonFileManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;

import java.sql.*;

import static main.util.CommandOption.*;

public class givemoney {

    MoneyManager moneyManager = new MoneyManager();


    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("givemoney")) return;
        if (!event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
            try {
                event.deferReply(true).setContent("").queue();
                Statement statement = onReadyDB.conn1.createStatement();
                String sql = ("SELECT * FROM Guild_Settings WHERE id = " + event.getGuild().getIdLong());
                ResultSet rs = statement.executeQuery(sql);
                if (rs.next()) {
                    String lang_code = rs.getString("Lang_Code");
                    JsonFileManager manager = new JsonFileManager("src/main/snow/main/lang/" + lang_code + ".json", true);
                    event.deferReply().setContent("").queue();
                    event.getHook().sendMessage(manager.getObj().get("notpermission").toString()).queue();
                } else {
                    JsonFileManager manager = new JsonFileManager("src/main/snow/main/lang/en_US.json", true);
                    event.getHook().sendMessage(manager.getObj().get("notpermission").toString()).queue();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        Member member = event.getOption(MEMBER_GIVE).getAsMember();

        int givemoney = event.getOption(MONEY_GIVE).getAsInt();
        moneyManager.givemoney(event, member, givemoney);

    }
}
