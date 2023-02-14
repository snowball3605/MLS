package main;

import main.Commands.list.Ping;
import main.Commands.list.changelang;
import main.Commands.list.help;
import main.Commands.list.money_system.list.*;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.GenericSelectMenuInteractionEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class Listener extends ListenerAdapter {
    Ping R6stats = new Ping();
    changelang changelang = new changelang();
    setmoney setmoney = new setmoney();
    givemoney givemoney = new givemoney();
    onReadyDB onReadyDB = new onReadyDB();
    showmoney showmoney = new showmoney();
    help help = new help();
    help_menu help_menu = new help_menu();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        R6stats.onSlashCommand(event);
        changelang.onSlashCommand(event);
        setmoney.onSlashCommand(event);
        givemoney.onSlashCommand(event);
        showmoney.onSlashCommand(event);
        help.onSlashCommand(event);
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        onReadyDB.onReady(event);
    }

    @Override
    public void onGenericSelectMenuInteraction(@NotNull GenericSelectMenuInteractionEvent event) {
        changelang.SelectMenu(event);
        help_menu.SelectMenu(event);
    }
}


