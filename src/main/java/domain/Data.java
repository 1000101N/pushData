package domain;

import javax.persistence.*;

@Entity
@Table(name = "data_s")
public class Data {
    @Id @GeneratedValue
    private long id;
    private String data;

    public Data() {
    }

    public Data(String data) {
        this.data = data;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "Data{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }
}
