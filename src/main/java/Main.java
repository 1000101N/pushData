import com.google.gson.Gson;
import domain.push.PushData;
import domain.push.PushRequest;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException{


//        String authKey = "AIzaSyCvInhCQ7OyHfeH2nFztoVIkH0PLKkozAk"; // You FCM AUTH key
//        String FMCurl = "https://fcm.googleapis.com/fcm/send";
//
//        URL url = new URL(FMCurl);
//        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//
//        conn.setUseCaches(false);
//        conn.setDoInput(true);
//        conn.setDoOutput(true);
//
//        conn.setRequestMethod("POST");
//        conn.setRequestProperty("Authorization", "key=" + authKey);
//        conn.setRequestProperty("Content-Type", "application/json");
//
//        JSONObject json = new JSONObject();
////e5srbXiPaiM:APA91bEAUDpuoEL64kKQvq43QUqFINyA-l3Ta7Mx9DwKVCumwbLtRJQdv_7-zubx-iwrmdwcuT8oDUshPZFqMkf3CoMuOKXdp0CV7bimBb28CasnKHcrexmiJiObpw1S-Mo17BqIamHZ
//        json.put("to", new String("e5srbXiPaiM:APA91bEAUDpuoEL64kKQvq43QUqFINyA-l3Ta7Mx9DwKVCumwbLtRJQdv_7-zubx-iwrmdwcuT8oDUshPZFqMkf3CoMuOKXdp0CV7bimBb28CasnKHcrexmiJiObpw1S-Mo17BqIamHZ").trim());
////        json.put("to", new String("fzB4OzCHd7U:APA91bFSFegUwyGjsSexFiEgk125m3bHn6uczfK8E05ryp0wngWepUO_uiAlcdil_eS5I-RF87JwtgzWXBzpLP9vPruy9Xw6KD7Q8WJ-1pmuYzc8ApzG_rKWpQfrCCWzs1FUEgMhgkNx").trim());
//        JSONObject info = new JSONObject();
//        info.put("title", "notification title"); // Notification title
////        info.put("body", "message body"); // Notification
//        // body
//        info.put("body", new PushData("POST","http://localhost:8080/pushdata/api/data/send","Any information"));
//        json.put("notification", info);
//        System.out.println(json.toString());
//        try {
//            OutputStreamWriter wr = new OutputStreamWriter(
//                    conn.getOutputStream());
//            wr.write(json.toString());
//            wr.flush();
//
//            BufferedReader br = new BufferedReader(new InputStreamReader(
//                    (conn.getInputStream())));
//
//            String output;
//            System.out.println("Output from Server .... \n");
//            while ((output = br.readLine()) != null) {
//                System.out.println(output);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println("GCM Notification is sent successfully");

//        System.out.println(new Gson().toJson(new PushRequest("qweqweqweqwe","GET DATA", new PushData("POST","HTTP","Any information"))).toString());


    }
}
