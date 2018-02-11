package domain;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "getAllDevices", query = "select d from Device d"),
@NamedQuery(name = "deleteAll", query = "delete Device d")})
public class Device {
    @Id @GeneratedValue
    private long _id;
    private String name;
    private String token;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "dev_data",
    joinColumns = @JoinColumn(name = "id_dev"),
    inverseJoinColumns = @JoinColumn(name = "id_data"))
//    @Transient
    private List<Data> data;

    public Device() {
    }

    public Device(String name, String token, List<Data> data) {
        this.name = name;
        this.token = token;
        this.data = data;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long id) {
        this._id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Device{" +
                "_id=" + _id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", data=" + data +
                '}';
    }
}
