package main.Commands.list;

import main.Commands.list.money_system.list.onReadyDB;
import main.util.JsonFileManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.components.selections.EntitySelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class help {


    public void onSlashCommand(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("help")) return;
        event.deferReply(true).setContent("").queue();
        try {
            JsonFileManager zh_TW = new JsonFileManager("src/main/snow/main/lang/zh_TW.json", true);
            JsonFileManager en_US = new JsonFileManager("src/main/snow/main/lang/en_US.json", true);
            JsonFileManager ja_JP = new JsonFileManager("src/main/snow/main/lang/ja_JP.json", true);
            JsonFileManager zh_CN = new JsonFileManager("src/main/snow/main/lang/zh_CN.json", true);

            Statement statement = onReadyDB.conn1.createStatement();
            String sql = "SELECT * FROM Guild_Settings WHERE id=" + event.getGuild().getIdLong();
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                String lang_code = rs.getString("Lang_Code");
                switch (lang_code){
                    case "zh_TW":
                        StringSelectMenu zh_TW_help = StringSelectMenu.create("help_zh_TW").setPlaceholder(zh_TW.getObj().getString("project"))
                                .addOption(zh_TW.getObj().getString("common_problem") + "\uD83E\uDD14", "01")
                                .addOption(zh_TW.getObj().getString("money_system")+" \uD83D\uDCB8", "02")
                                .setRequiredRange(1, 1)
                                .build();
                        event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("\t"+ zh_TW.getObj().getString("helpCT")).setDescription(zh_TW.getObj().getString("help_project")).build()).addActionRow(zh_TW_help).queue();
                        break;
                    case "en_US":
                        StringSelectMenu en_US_help = StringSelectMenu.create("help_en_US").setPlaceholder(en_US.getObj().getString("project"))
                                .addOption(en_US.getObj().getString("common_problem") + "\uD83E\uDD14", "01")
                                .addOption(en_US.getObj().getString("money_system")+" \uD83D\uDCB8", "02")
                                .setRequiredRange(1, 1)
                                .build();
                        event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("\t" + en_US.getObj().getString("helpCT")).setDescription(en_US.getObj().getString("help_project")).build()).addActionRow(en_US_help).queue();
                        break;
                    case "ja_JP":
                        StringSelectMenu ja_JP_help = StringSelectMenu.create("help_ja_JP").setPlaceholder(ja_JP.getObj().getString("project"))
                                .addOption(ja_JP.getObj().getString("common_problem") + "\uD83E\uDD14", "01")
                                .addOption(ja_JP.getObj().getString("money_system")+" \uD83D\uDCB8", "02")
                                .setRequiredRange(1, 1)
                                .build();
                        event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("\t" + ja_JP.getObj().getString("helpCT")).setDescription(ja_JP.getObj().getString("help_project")).build()).addActionRow(ja_JP_help).queue();
                        break;
                    case "zh_CN":
                        StringSelectMenu zh_CN_help = StringSelectMenu.create("help_zh_CN").setPlaceholder(zh_CN.getObj().getString("project"))
                                .addOption(zh_CN.getObj().getString("common_problem") + "\uD83E\uDD14", "01")
                                .addOption(zh_CN.getObj().getString("money_system")+" \uD83D\uDCB8", "02")
                                .setRequiredRange(1, 1)
                                .build();
                        event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("\t" + zh_CN.getObj().getString("helpCT")).setDescription(zh_CN.getObj().getString("help_project")).build()).addActionRow(zh_CN_help).queue();
                        break;
                }
            } else {
                StringSelectMenu en_US_help = StringSelectMenu.create("help_en_US").setPlaceholder(en_US.getObj().getString("project"))
                        .addOption(en_US.getObj().getString("common_problem") + "\uD83E\uDD14", "01")
                        .addOption(en_US.getObj().getString("money_system")+" \uD83D\uDCB8", "02")
                        .setRequiredRange(1, 1)
                        .build();

                event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("\t" + en_US.getObj().getString("helpCT")).setDescription(en_US.getObj().getString("help_project")).build()).addActionRow(en_US_help).queue();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
