package Abstraction.Player;

import chariot.Client;
import io.github.sornerol.chess.pubapi.client.PlayerClient;
import io.github.sornerol.chess.pubapi.domain.player.stats.PlayerStats;
import io.github.sornerol.chess.pubapi.exception.ChessComPubApiException;
import net.dv8tion.jda.api.EmbedBuilder;

import java.io.IOException;

public class UserObject {

    private Client client = Client.basic();
    private final String userID;

    private final PlayerClient playerClient = new PlayerClient();


    public UserObject(Client client, String userParsing){
        this.client = client;
        this.userID = userParsing.toLowerCase().trim();
    }


    public UserObject(String username){
        this.userID = username.toLowerCase().trim();
    }


    public Client getClient(){
        return this.client;
    }

    public String getUserID(){
        return this.userID;
    }

    public PlayerClient getPlayerClient() {
        return playerClient;
    }


    public PlayerStats getChessComStats() throws ChessComPubApiException, IOException {
        return getPlayerClient().getStatsForPlayer(this.userID);
    }

    public void setUserAgent(){
        playerClient.setUserAgent("your-app; username: your-username; contact: your-email");

    }


}
