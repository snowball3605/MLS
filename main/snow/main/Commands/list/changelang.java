package main.Commands.list;

import main.Commands.list.money_system.list.MoneyManager;
import main.Commands.list.money_system.list.login_DB;
import main.Commands.list.money_system.list.onReadyDB;
import main.util.JsonFileManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.sql.*;
import java.util.Objects;

import static main.Commands.list.money_system.list.onReadyDB.conn;
import static main.Commands.list.money_system.list.onReadyDB.conn1;

public class changelang extends ListenerAdapter {
    MoneyManager moneyManager = new MoneyManager();

    public void SelectMenu(GenericSelectMenuInteractionEvent event) {
        try {
            event.deferReply(true).setContent("").queue();
            if (event.getComponent().getId().equals("d")) {
                for (int i = 0; i < event.getValues().size(); i++) {
                    Object o = event.getValues().get(i);
                    if ("1".equals(o)) {
                        moneyManager.SelectLang(event, conn1, "src/main/snow/main/lang/zh_TW.json", "zh_TW");
                    } else if ("2".equals(o)) {
                        moneyManager.SelectLang(event, conn1, "src/main/snow/main/lang/ja_JP.json", "ja_JP");
                    } else if ("3".equals(o)) {
                        moneyManager.SelectLang(event, conn1, "src/main/snow/main/lang/en_US.json", "en_US");
                    } else if ("4".equals(o)) {
                        moneyManager.SelectLang(event, conn1, "src/main/snow/main/lang/zh_CN.json", "zh_CN");
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("lang")) return;
        event.deferReply(true).setContent("").queue();
        if (!event.isFromGuild()) {
            event.getChannel().sendMessage("Please use this command in the guild").queue();
            return;
        }
        StringSelectMenu menu = StringSelectMenu.create("d")
                .setPlaceholder("lang")
                .setRequiredRange(1, 1)
                .addOption("繁體中文", "1")
                .addOption("简体中文", "4")
                .addOption("日本語", "2")
                .addOption("English", "3")
                .build();

        try {
            Connection connection;
            connection = DriverManager.getConnection(login_DB.Step2.DB_URL, login_DB.Step2.USER, login_DB.Step2.PASS);
            Statement stmt = connection.createStatement();
            String sql = ("SELECT * FROM Guild_Settings WHERE id = " + event.getGuild().getIdLong());
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                try {
                    long guild = event.getGuild().getIdLong();
                    moneyManager.sendlang(guild, event, "請選擇你想要更換私語言", "Please select the private language you want to change", "変更したいプライベート言語を選択してください", "请选择你想要更换私语言", menu);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}

