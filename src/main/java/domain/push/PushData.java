package domain.push;

public class PushData {
    private String requestType;
    private String request;
    private String message;

    public PushData() {
    }

    public PushData(String requestType, String request, String message) {
        this.requestType = requestType;
        this.request = request;
        this.message = message;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "PushData{" +
                "requestType='" + requestType + '\'' +
                ", request='" + request + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
