package de.justin.discordwebhook;

import de.justin.json.JsonObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DiscordWebhook {

    private final String url;

    private String username;
    private String avatarURL;
    private String content;

    private Embed embed;

    private final JsonObject jsonObject;

    public DiscordWebhook(String url) {
        this.url = url;
        jsonObject = new JsonObject();
    }

    public void sendWebhook() {
        try {
            buildJson();

            URL url = new URL(this.url);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.addRequestProperty("Content-Type", "application/json");
            connection.addRequestProperty("User-Agent", "Java-DiscordWebhook");
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");

            try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
                outputStream.writeBytes(jsonObject.toString());
                outputStream.flush();
            }

            connection.getInputStream().close();

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void buildJson() {
        if (username != null) {
            jsonObject.put("username", username);
        }
        if (avatarURL != null) {
            jsonObject.put("avatar_url", avatarURL);
        }
        if (content != null) {
            jsonObject.put("content", content);
        }
        if (embed != null) {
            List<JsonObject> list = new ArrayList<>();
            list.add(embed.getJson());
            jsonObject.put("embeds", list.toArray());
        }
    }

    public JsonObject getJson() {
        buildJson();
        return jsonObject;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAvatarURL(String avatarURL) {
        this.avatarURL = avatarURL;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmbed(Embed embed) {
        this.embed = embed;
    }
}