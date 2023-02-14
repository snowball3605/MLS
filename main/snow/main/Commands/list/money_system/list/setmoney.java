package main.Commands.list.money_system.list;

import main.util.JsonFileManager;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;

import java.sql.*;

import static main.util.CommandOption.*;

public class setmoney {
    MoneyManager moneyManager = new MoneyManager();

    public void onSlashCommand(SlashCommandInteractionEvent event) {
       if (!event.getName().equals("setmoney")) return;
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
        event.deferReply(true).setContent("").queue();
        int a = event.getOption(SETMONEY).getAsInt();
        long guild = event.getGuild().getIdLong();
        Member Member = event.getOption(MEMBER).getAsMember();
        User User = Member.getUser();
        long Member_ID = User.getIdLong();
        event.deferReply().setContent("").queue();
        moneyManager.ReAddSetMoney(User, Member_ID, guild, a, event);
    }



}


