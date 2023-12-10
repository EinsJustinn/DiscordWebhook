package de.justin.discordwebhook;

import de.justin.json.JsonObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Embed {

    private String title;
    private String url;
    private String description;
    private Color color;
    private String thumbnailURL;
    private String imageURL;

    private Author author;
    private Footer footer;

    private final List<Field> fieldList = new ArrayList<>();

    public JsonObject getJson() {
        return new JsonObject()
                .put("title", title)
                .put("url", url)
                .put("description", description)
                .put("color", color != null ? getDecimalColor(color) : null)
                .put("thumbnail", (thumbnailURL != null) ? new JsonObject().put("url", thumbnailURL) : null)
                .put("image", (imageURL != null) ? new JsonObject().put("url", imageURL) : null)
                .put("author", author != null ? author.getJson() : null)
                .put("footer", footer != null ? footer.getJson() : null)
                .put("fields", !fieldList.isEmpty() ? toFieldJsonList().toArray() : null);
    }

    public Embed setAuthor(String name, String url, String iconURL) {
        author = new Author(name, url, iconURL);
        return this;
    }

    public Embed setFooter(String text, String iconURL) {
        footer = new Footer(text, iconURL);
        return this;
    }

    public Embed setTitle(String title) {
        this.title = title;
        return this;
    }

    public Embed setURL(String url) {
        this.url = url;
        return this;
    }

    public Embed setDescription(String description) {
        this.description = description;
        return this;
    }

    public Embed setColor(Color color) {
        this.color = color;
        return this;
    }

    public Embed setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
        return this;
    }

    public Embed setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Embed addField(String name, String value, boolean inline) {
        fieldList.add(new Field(name, value, inline));
        return this;
    }

    private List<JsonObject> toFieldJsonList() {
        return fieldList.stream()
                .map(Field::getJson)
                .collect(Collectors.toList());
    }

    private int getDecimalColor(Color color) {
        int red = color.getRed();
        int green = color.getGreen();
        int blue = color.getBlue();
        return (red << 16) + (green << 8) + blue;
    }

    private static class Field {

        private final String name;
        private final String value;
        private final boolean inline;

        public Field(String name, String value, boolean inline) {
            this.name = name;
            this.value = value;
            this.inline = inline;
        }

        public JsonObject getJson() {
            return new JsonObject()
                    .put("name", name)
                    .put("value", value)
                    .put("inline", inline);
        }
    }

    private static class Author {

        private final String name;
        private final String url;
        private final String iconURL;

        public Author(String name, String url, String iconURL) {
            this.name = name;
            this.url = url;
            this.iconURL = iconURL;
        }

        public JsonObject getJson() {
            return new JsonObject()
                    .put("name", name)
                    .put("url", url)
                    .put("icon_url", iconURL);
        }
    }

    private static class Footer {

        private final String text;
        private final String iconURL;

        public Footer(String text, String iconURL) {
            this.text = text;
            this.iconURL = iconURL;
        }

        public JsonObject getJson() {
            return new JsonObject()
                    .put("text", text)
                    .put("icon_url", iconURL);
        }
    }
}