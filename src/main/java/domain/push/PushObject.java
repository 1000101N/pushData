package domain.push;

import javax.json.JsonObject;

public class PushObject {
    private String to;
    private String title;
    private String body;

    public PushObject() {
    }

    public PushObject(String to, String title, String body) {

        this.to = to;
        this.title = title;
        this.body = body;
    }

    public String getTo() {

        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "PushObject{" +
                "to='" + to + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
