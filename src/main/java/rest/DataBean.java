package rest;

import domain.*;
import domain.push.PushData;
import domain.push.PushRequest;
import org.json.JSONObject;

import javax.annotation.PostConstruct;
import javax.ejb.Schedule;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@Stateless
@Path("data")
public class DataBean {

    private String token;
    private String isData;
    private String message;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIsData() {
        return isData;
    }

    public void setIsData(String isData) {
        this.isData = isData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Inject
    private EntityManager em;

    private List<Device> dev;

    public void setDev(List<Device> dev) {
        this.dev = dev;
    }

    public List<Device> getDev() {
        return dev;
    }

    public DataBean() {
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Device> getDevices(){
        TypedQuery<Device> deviceTypedQuery = em.createNamedQuery("getAllDevices",Device.class);
        List<Device> deviceList = deviceTypedQuery.getResultList();
        if(deviceList != null) {
            return deviceList;
        } else {
            return null;
        }
    }

    @GET
    @Path("sendPush")
    public void pushData(@QueryParam("token") String token,@QueryParam("isData") String isData,@QueryParam("message") String message) throws Exception{
        this.token = token;
        this.isData = isData;
        this.message = message;

        String authKey = "AIzaSyCvInhCQ7OyHfeH2nFztoVIkH0PLKkozAk";
//                "AIzaSyCAwAncIRgtHhQY9N7VOmSvd1abebowDqg"; // You FCM AUTH key
        String FMCurl = "https://fcm.googleapis.com/fcm/send";

        URL url = new URL(FMCurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        conn.setRequestMethod("POST");
        conn.setRequestProperty("Authorization", "key=" + authKey);
        conn.setRequestProperty("Content-Type", "application/json");

        JSONObject json = new JSONObject();
//e5srbXiPaiM:APA91bEAUDpuoEL64kKQvq43QUqFINyA-l3Ta7Mx9DwKVCumwbLtRJQdv_7-zubx-iwrmdwcuT8oDUshPZFqMkf3CoMuOKXdp0CV7bimBb28CasnKHcrexmiJiObpw1S-Mo17BqIamHZ
//        json.put("to", new String("e5srbXiPaiM:APA91bEAUDpuoEL64kKQvq43QUqFINyA-l3Ta7Mx9DwKVCumwbLtRJQdv_7-zubx-iwrmdwcuT8oDUshPZFqMkf3CoMuOKXdp0CV7bimBb28CasnKHcrexmiJiObpw1S-Mo17BqIamHZ").trim());
//        json.put("to", new String("fzB4OzCHd7U:APA91bFSFegUwyGjsSexFiEgk125m3bHn6uczfK8E05ryp0wngWepUO_uiAlcdil_eS5I-RF87JwtgzWXBzpLP9vPruy9Xw6KD7Q8WJ-1pmuYzc8ApzG_rKWpQfrCCWzs1FUEgMhgkNx").trim());
        json.put("to", this.token.trim());
        JSONObject info = new JSONObject();
        info.put("title", "Title "); // Notification title
        info.put("body", this.message); // Notification

        if(Integer.parseInt(this.isData)==1){
            json.put("data",info);
            System.out.println("data");
        } else if(Integer.parseInt(this.isData)==0){
            System.out.println("notification");
            json.put("notification", info);
        }
        try {
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("GCM Notification is sent successfully");
    }


    @GET
    @Path("delete")
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult example(){
        RestResult restResult = new RestResult();
        try {
            int q = em.createNamedQuery("deleteAll").executeUpdate();
            restResult.setStatus(1);
            restResult.setMessage("OK");
            restResult.setData(q);
        } catch (Exception e) {
            restResult.setStatus(2);
            restResult.setMessage("ERROR " + e.getMessage());
            restResult.setData(null);
        }

        return restResult;
    }

    @POST
    @Path("send")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult sendData(Data data){
        RestResult restResult = new RestResult();
        try {

            em.persist(data);
            restResult.setStatus(1);
            restResult.setMessage("OK");
            restResult.setData(data);
        } catch (Exception e) {
            restResult.setStatus(2);
            restResult.setMessage("ERROR " + e.getMessage());
            restResult.setData(null);
        }
        return restResult;
    }

    @POST
    @Path("signUp")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public RestResult signUp(Device device){
        RestResult restResult = new RestResult();
        try {
            em.persist(device);
            restResult.setStatus(1);
            restResult.setMessage("OK");
            restResult.setData(device);
        } catch (Exception e) {
            restResult.setStatus(2);
            restResult.setMessage("ERROR " + e.getMessage());
            restResult.setData(null);
        }
        return restResult;
    }

    @PostConstruct
    public void devLoad() {
        TypedQuery<Device> deviceTypedQuery = em.createNamedQuery("getAllDevices",Device.class);
        List<Device> deviceList = deviceTypedQuery.getResultList();
        dev = deviceList;
    }

}
