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
discordWebhook.setUsername("YOUR_USERNAME_HERE");
discordWebhook.setAvatarURL("YOUR_AVATAR_URL_HERE");
```

Set the username and avatar for the webhook message. Replace `YOUR_AVATAR_URL_HERE` with the URL of the desired avatar image.

#### Set Content and Embed

```java
discordWebhook.setContent("Text -> 2000 characters.");
discordWebhook.setEmbed(
        new Embed()
                .setTitle("Hello")
                .setDescription("Text message")
                .setAuthor("EinsJustinnn", "https://einsjustinnn.de", "https://i.imgur.com/cOpF2YF.png")
                .setColor(new Color(255, 255, 255))
                .setThumbnailURL("https://i.imgur.com/MxZKsw8.png")
                .setFooter("Use me :)", "https://i.imgur.com/xD2nmzz.jpeg")
                .setURL("https://google.de")
                .setImageURL("https://i.imgur.com/pMt3vY0.jpeg")
);
```

Set the main content of the message and configure the embed with various properties such as title, description, author, color, thumbnail, footer, URL, and image. Customize these properties based on your requirements.


#### Add Field

```java
discordWebhook.setEmbed(
        new Embed()
        .setTitle("Hello")
        .setDescription("Text message")
        .setAuthor("EinsJustinnn", "https://einsjustinnn.de", "https://i.imgur.com/cOpF2YF.png")
        .setColor(new Color(255, 255, 255))
        .setThumbnailURL("https://i.imgur.com/MxZKsw8.png")
        .setFooter("Use me :)", "https://i.imgur.com/xD2nmzz.jpeg")
        .setURL("https://google.de")
        .setImageURL("https://i.imgur.com/pMt3vY0.jpeg")
        .addField("test", "hi", true)
        .addField("test1", "hi1", true)
        .addField("test2", "hi2", true)
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

        DiscordWebhook discordWebhook = new DiscordWebhook("YOUR_WEBHOOK_URL");
        discordWebhook.setUsername("YOUR_USERNAME_HERE");
        discordWebhook.setAvatarURL("YOUR_AVATAR_URL_HERE");
        discordWebhook.setContent("Text -> 2000 characters.");
        discordWebhook.setEmbed(
                new Embed()
                        .setTitle("Hello")
                        .setDescription("Text message")
                        .setAuthor("EinsJustinnn", "https://einsjustinnn.de", "https://i.imgur.com/cOpF2YF.png")
                        .setColor(new Color(255, 255, 255))
                        .setThumbnailURL("https://i.imgur.com/MxZKsw8.png")
                        .setFooter("Use me :)", "https://i.imgur.com/xD2nmzz.jpeg")
                        .setURL("https://google.de")
                        .setImageURL("https://i.imgur.com/pMt3vY0.jpeg")
                        .addField("Field Text 1", "hi", true)
                        .addField("Field Text 2", "hi1", false)
                        .addField("Field Text 3", "hi2", true)
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
