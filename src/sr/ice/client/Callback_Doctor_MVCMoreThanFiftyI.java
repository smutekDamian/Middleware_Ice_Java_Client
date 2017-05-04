package sr.ice.client;

import Hospital.Callback_Doctor_MVCMoreThanFifty;
import Hospital.PatientRecord;
import Ice.LocalException;

import java.util.List;

/**
 * Created by Damian on 03.05.2017.
 */
public class Callback_Doctor_MVCMoreThanFiftyI extends Callback_Doctor_MVCMoreThanFifty {
    @Override
    public void response(List<PatientRecord> patientRecords) {
        for (PatientRecord record: patientRecords){
            Client.readRecord(record);
        }

    }

    @Override
    public void exception(LocalException e) {
        e.printStackTrace();
    }
}
