package websocket;

import com.google.gson.Gson;
import domain.push.PushData;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint("/pushData/{userId}")
public class PushEndPoint {


    private static final Logger logger = Logger.getLogger("requestEndpoint");
    static Queue<Session> queue = new ConcurrentLinkedQueue<>();
    static HashMap<Long, Session> queue1 = new HashMap<>();

    public static void send(long id, PushData pushData){
        String msg = "";
//        if(status == 1) {
//            msg = "User with name "+fr.getReceiver().getName()+" accepted your request for friendship.";
//        } else if (status == 2) {
//            msg= "User with name "+fr.getSender().getName()+" sent to you request for friendship.";
//        }
//        else if (status == 3) {
//            msg+=" removed your request for friendship.";
//        }
        try {

            Session s = queue1.get(id);
//            for (Session session : queue){
//                session.getBasicRemote().sendText(msg);
            if (s == null){


                logger.log(Level.INFO, "ERROR MESSAGE");
            } else {
                s.getBasicRemote().sendText(new Gson().toJson(pushData).toString());
                logger.log(Level.INFO, "Sent: {0}", new Gson().toJson(pushData).toString());
            }
//            }
        } catch (IOException e){
            logger.log(Level.INFO, e.toString());
        }
    }

    @OnOpen
    public void openConnection(Session session, @PathParam("userId") long id){
        queue.add(session);
        queue1.put(id, session);
        logger.log(Level.INFO,"Connection opened."+"Id = " + id);
    }

    @OnClose
    public void closeConnection(Session session){
        queue.remove(session);
        long id=-1;
        Set<Long> longSet = queue1.keySet();
        for (Long l:
                longSet) {
            if(queue1.get(l).equals(session)){
                id = l;
                queue1.remove(l);
            }
        }
        logger.log(Level.INFO, "Connection closed." + "Id = " + id);
    }

    @OnError
    public void error(Session session, Throwable t){
        queue.remove(session);
        long id=-1;
        Set<Long> longSet = queue1.keySet();
        for (Long l:
                longSet) {
            if(queue1.get(l).equals(session)){
                id = l;
                queue1.remove(l);
            }
        }
        logger.log(Level.INFO, t.toString());
        logger.log(Level.INFO, "Connection error." + "Id = " + id);
    }

}
