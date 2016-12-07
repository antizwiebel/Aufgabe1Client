package fh.hagenberg.PenederMauler;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Timer;

/**
 * Created by Mark on 07.12.2016.
 */
public class EnvDataClient {

    public static void main (String[] _argv) {
        try {
            String adr = "EnvDataServer";
            IEnvironmentData environmentData= (IEnvironmentData) Naming.lookup(adr);
            //schedules a timer that runs the datatask every second
            Timer dataTimer = new Timer();
            dataTimer.schedule(new EnvDataTask(environmentData), 0, 1000);
        } catch (Exception _e) {
            _e.printStackTrace();
        }
    }
}
