# DiscordWebhook for Java

This documentation provides information on how to use the DiscordWebhook to send messages with embeds to a Discord channel using webhooks.

## Getting Started

### Usage

#### Initialize DiscordWebhook

```java
DiscordWebhook discordWebhook = new DiscordWebhook("YOUR_WEBHOOK_URL");
```

Replace `YOUR_WEBHOOK_URL` with the actual webhook URL you obtained from Discord.

#### Set Username and Avatar

```java
        discordWebhook.setUsername(username: String);
        discordWebhook.setAvatarURL(avatarURL: String);
```

Set the username and avatar for the webhook message. Replace `YOUR_AVATAR_URL_HERE` with the URL of the desired avatar image.

#### Set Content and Embed

```java
discordWebhook.setContent(content: String);
        discordWebhook.setEmbed(
                new Embed()
                        .setTitle(title: String)
                        .setDescription(text: String)
                        .setAuthor(name: String, url: String, iconURL: String)
                        .setColor(new Color(255, 255, 255))
                        .setThumbnailURL(url: String)
                        .setFooter(text: String, iconUrl: String)
                        .setURL(url: String)
                        .setImageURL(imageURL: String)
        );
```

Set the main content of the message and configure the embed with various properties such as title, description, author, color, thumbnail, footer, URL, and image. Customize these properties based on your requirements.


#### Add Field

```java
discordWebhook.setEmbed(
                new Embed()
                        .setTitle(title: String)
                        .setDescription(text: String)
                        .setAuthor(name: String, url: String, iconURL: String)
                        .setColor(new Color(255, 255, 255))
                        .setThumbnailURL(url: String)
                        .setFooter(text: String, iconUrl: String)
                        .setURL(url: String)
                        .setImageURL(imageURL: String)
                        .addField(name: String, value: String, inline: Boolean)
                        .addField(name: String, value: String, inline: Boolean)
                        .addField(name: String, value: String, inline: Boolean)
        );
```

Use the addField method to add fields to the embed section. Adjust the field names, values, and inline settings based on your specific requirements

#### Send the Webhook

```java
discordWebhook.sendWebhook();
```

Send the configured webhook message to the specified Discord channel.

## Example

```java
public class DiscordWebhookExample {
    public static void main(String[] args) {

        DiscordWebhook discordWebhook = new DiscordWebhook(url: String);
        discordWebhook.setUsername(username: String);
        discordWebhook.setAvatarURL(avatarURL: String);
        discordWebhook.setContent(content: String);
        discordWebhook.setEmbed(
                new Embed()
                        .setTitle(title: String)
                        .setDescription(text: String)
                        .setAuthor(name: String, url: String, iconURL: String)
                        .setColor(new Color(255, 255, 255))
                        .setThumbnailURL(url: String)
                        .setFooter(text: String, iconUrl: String)
                        .setURL(url: String)
                        .setImageURL(imageURL: String)
                        .addField(name: String, value: String, inline: Boolean)
                        .addField(name: String, value: String, inline: Boolean)
                        .addField(name: String, value: String, inline: Boolean)
        );

        discordWebhook.sendWebhook();
    }
}
```

### Prerequisites

- Java 8
- no dependencies required

### Installation

#### Maven

```xml
<repository>
    <id>einsjustinnn-repo-snapshots</id>
    <url>https://repo.einsjustinnn.de/snapshots</url>
</repository>
```

```xml
<dependency>
    <groupId>de.justin</groupId>
    <artifactId>DiscordWebhook</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

#### Gradle
```gradle
repositories {
    maven {
        url 'https://repo.einsjustinnn.de/snapshots'
    }
}
```

```gradle
dependencies {
    implementation 'de.justin:DiscordWebhook:1.0-SNAPSHOT'
}
```
