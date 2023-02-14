package main.Commands.list.money_system.list;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;

public class help_menu  {
    public void SelectMenu(GenericSelectMenuInteractionEvent event) {
        if (event.getComponent().getId().equals("help_zh_TW")) {
            for (int i = 0; i < event.getValues().size(); i++) {
                Object o = event.getValues().get(i);
                if ("01".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("常見問題").setDescription("\n~ Ping\n查看機械人延遲\n\n~lang\n更換語言").build()).queue();
                } else if ("02".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("金錢系統").setDescription("\n~ givemoney\n發迭金錢[管理員指令]\n\n" +
                            "~ setmoney\n設定金錢[管理員指令]\n\n" +
                            "~ money\n查看金錢").build()).queue();
                }
            }
        }
        if (event.getComponent().getId().equals("help_en_US")) {
            for (int i = 0; i < event.getValues().size(); i++) {
                Object o = event.getValues().get(i);
                if ("01".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("common problem").setDescription("\n~ Ping\ncheck bot ping\n\n~lang\nchange lang").build()).queue();
                } else if ("02".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("money system").setDescription("\n~ givemoney\ngive money[only administrator]\n\n" +
                            "~ setmoney\nset money[only administrator]\n\n" +
                            "~ money\ncheck your money").build()).queue();
                }
            }
        }
        if (event.getComponent().getId().equals("help_ja_JP")) {
            for (int i = 0; i < event.getValues().size(); i++) {
                Object o = event.getValues().get(i);
                if ("01".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("よくある問題").setDescription("\n~ Ping\nロボットの ping を確認する\n\n~lang\n言語を変えてください").build()).queue();
                } else if ("02".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("マネーシステム").setDescription("\n~ givemoney\nお金をあげる[管理者のみ]\n\n" +
                            "~ setmoney\nお金を設定する[管理者のみ]\n\n" +
                            "~ money\nあなたのお金をチェックしてください").build()).queue();
                }
            }
        }
        if (event.getComponent().getId().equals("help_zh_CN")) {
            for (int i = 0; i < event.getValues().size(); i++) {
                Object o = event.getValues().get(i);
                if ("01".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("常见问题").setDescription("\n~ Ping\n检查机器人 ping\n\n~lang\n改变语言").build()).queue();
                } else if ("02".equals(o)) {
                    event.getHook().sendMessageEmbeds(new EmbedBuilder().setTitle("金钱系统").setDescription("\n~ givemoney\n给钱[只有管理员]\n\n" +
                            "~ setmoney\n设定金钱[只有管理员]\n\n" +
                            "~ money\n检查你的钱").build()).queue();
                }
            }
        }
    }
}
