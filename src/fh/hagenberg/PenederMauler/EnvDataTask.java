package fh.hagenberg.PenederMauler;

import java.rmi.RemoteException;
import java.util.TimerTask;

/**
 * Created by Mark on 07.12.2016.
 */
public class EnvDataTask extends TimerTask {

    private IEnvironmentData envData;

    public EnvDataTask(IEnvironmentData _data) {
        envData = _data;
    }

    @Override
    public void run() {
        try {
            String[] dataTypes=envData.requestEnvironmentDataTypes();
            EnvData[] allEnvData;
            System.out.println("All sensortypes: ");
            for (String type: dataTypes) {
                System.out.print(", "+type);
            }
            System.out.println();
            allEnvData= envData.requestAll();
            System.out.println("Requesting air pressure: ");
            EnvData airData = envData.requestEnvironmentData("air");

            System.out.println("TimeStamp"+ airData.getTimeStamp().toString()+ ", Value " + airData.getAirPressure());
            System.out.println("Requesting all data: ");

            for (EnvData e: allEnvData) {
                System.out.print("TimeStamp"+ e.getTimeStamp().toString()+ ", Value " + e.getAirPressure());
            }


        } catch (Exception _e) {
            _e.printStackTrace();
        }

    }
}
