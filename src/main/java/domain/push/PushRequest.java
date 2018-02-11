package domain.push;

public class PushRequest {
    private String to;
    private String title;
    private PushData data;

    public PushRequest(String to, String title, PushData data) {
        this.to = to;
        this.title = title;
        this.data = data;
    }

    public PushRequest() {

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

    public PushData getData() {
        return data;
    }

    public void setData(PushData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PushRequest{" +
                "to='" + to + '\'' +
                ", title='" + title + '\'' +
                ", data=" + data +
                '}';
    }
}
