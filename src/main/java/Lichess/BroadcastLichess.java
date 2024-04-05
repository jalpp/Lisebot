package Lichess;

import chariot.Client;
import chariot.model.Many;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.List;

public class BroadcastLichess {

    private final Client client;
    private String broadURL;


    public BroadcastLichess(Client client){
        this.broadURL = "";
        this.client = client;

    }


    public EmbedBuilder getBroadData(){
        Many<chariot.model.Broadcast> broadcastMany = this.client.broadcasts().official();
        List<chariot.model.Broadcast> broadcasts = broadcastMany.stream().toList();
        String name = broadcasts.get(0).tour().name();
        String des = broadcasts.get(0).tour().description();
        this.broadURL = String.valueOf(broadcasts.get(0).tour().url());
        EmbedBuilder embedBuilder = new EmbedBuilder();
        embedBuilder.setColor(Color.green);
        embedBuilder.setTitle(name);
        embedBuilder.setDescription(des);
        embedBuilder.addField("View Tournament:", this.broadURL, true);
        embedBuilder.setFooter("Join our Server - https://discord.gg/uncmhknmYg ♟\uFE0F");
        embedBuilder.setThumbnail("https://static-00.iconduck.com/assets.00/lichess-icon-512x512-q0oh5bwk.png");
        return embedBuilder;
    }



}
