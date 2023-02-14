package main;

import main.Commands.list.money_system.list.onReadyDB;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import net.dv8tion.jda.internal.interactions.CommandDataImpl;

import static main.util.CommandOption.*;

public class Main {
    private static final String TOKEN = "MTA2ODUwNzk2ODU0ODYzNDY5NQ.GXlNPj.q0sGOmvbc9WGfPg_LoT8yz0kUTLzGqCQPKU2Tc";

    public static JDA jda;

    public static void main(String[] args) throws Exception {
        JDABuilder jdaBuilder = JDABuilder.createDefault(TOKEN)
                .setLargeThreshold(250)
                .enableCache(CacheFlag.ONLINE_STATUS, CacheFlag.ACTIVITY)
                .enableIntents(GatewayIntent.GUILD_BANS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_PRESENCES)
                .setBulkDeleteSplittingEnabled(false)
                .setActivity(Activity.playing("IceXinShou"))
                .setStatus(OnlineStatus.ONLINE)
                .addEventListeners(new Listener());


        jda = jdaBuilder.build().awaitReady();

        jda.updateCommands().addCommands(
                new CommandDataImpl("ping", "Ping"),
                new CommandDataImpl("lang", "change lang"),
                new CommandDataImpl("setmoney", "setmoney")
                        .addOption(OptionType.INTEGER, SETMONEY, "SETMONEY", true)
                        .addOption(OptionType.MENTIONABLE, MEMBER, "USERID", true),
                new CommandDataImpl("givemoney", "givemoney")
                        .addOption(OptionType.INTEGER, MONEY_GIVE, "give money (int)", true)
                        .addOption(OptionType.MENTIONABLE, MEMBER_GIVE, "you want give who money", true),
                new CommandDataImpl("money", "showmoney"),
                new CommandDataImpl("help", "help")
        ).queue();
    }

}

