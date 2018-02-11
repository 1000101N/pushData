package domain.push;

public class PushInfo {
    private String title;
    private String body;

    public PushInfo() {
    }

    public PushInfo(String title, String body) {

        this.title = title;
        this.body = body;
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
        return "PushInfo{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
