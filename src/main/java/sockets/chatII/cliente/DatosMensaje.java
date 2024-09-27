package sockets.chatII.cliente;

import java.io.Serializable;
import java.util.ArrayList;

public class DatosMensaje implements Serializable {

    private String nick;
    private String ipAddress;
    private String message;

    //ArrayList para almacenar IPS conectadas
    private ArrayList<String> ips = new ArrayList<String>();

    public ArrayList<String> getIps() {
        return ips;
    }

    public void setIps(ArrayList<String> ips) {
        this.ips = ips;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
