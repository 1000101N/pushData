package rest;

import domain.Device;

import javax.ejb.*;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
@Startup
public class Timer {

    @Inject
    private EntityManager em;

    @EJB
    private DataBean dataBean;

    public List<Device> devices;

    @Schedule(second = "0", minute = "5", hour = "*", dayOfWeek = "*")
    public void sendPushs() throws Exception {
        System.out.println("TIMER TIRMETIMER TIRMETIMER TIRMETIMER TIRMETIMER TIRME");
        TypedQuery<Device> deviceTypedQuery = em.createNamedQuery("getAllDevices",Device.class);
        List<Device> deviceList = deviceTypedQuery.getResultList();
        devices = deviceList;
        if(devices!=null){
            System.out.println("devices not null");
        }
        if(deviceList != null) {
            for (Device d :
                    deviceList) {
                dataBean.pushData(d.getToken(), "1","Timer DATA");
            }
        } else {
            System.out.println("{PUSH}:NULL NULL NULL");
        }

    }



    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }
}
