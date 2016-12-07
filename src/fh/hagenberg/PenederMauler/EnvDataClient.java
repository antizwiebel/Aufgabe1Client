package fh.hagenberg.PenederMauler;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by Mark on 07.12.2016.
 */
public class EnvDataClient {

    public static void main (String[] _argv) {
        try {
            String adr = "//127.0.0.1:1099/EnvDataServer";
            IEnvironmentData environmentData= (IEnvironmentData) Naming.lookup(adr);
            EnvData data= environmentData.requestEnvironmentData("luft");

        } catch (Exception _e) {
            _e.printStackTrace();
        }
    }
}
