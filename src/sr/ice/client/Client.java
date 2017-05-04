package sr.ice.client;
// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************



import Hospital.*;
import Ice.AsyncResult;
import Ice.ObjectPrx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client 
{
	public static void main(String[] args) 
	{
		int status = 0;
		Ice.Communicator communicator = null;

		try {
			// 1. Inicjalizacja ICE
			communicator = Ice.Util.initialize(args);

			// 2. Uzyskanie referencji obiektu na podstawie linii w pliku konfiguracyjnym
			//Ice.ObjectPrx base = communicator.propertyToProxy("Calc1.Proxy");
			// 2. To samo co powy�ej, ale mniej �adnie
			Ice.ObjectPrx labWorkerBase = communicator.stringToProxy("hospital/labWorker:tcp -h localhost -p 10000:udp -h localhost -p 10000");
			Ice.ObjectPrx doctorBase = communicator.stringToProxy("hospital/doctor:tcp -h localhost -p 10000:udp -h localhost -p 10000");
			Ice.ObjectPrx patientBase = communicator.stringToProxy("hospital/patient:tcp -h localhost -p 10000:udp -h localhost -p 10000");

			// 3. Rzutowanie, zaw�anie
			LabWorkerPrx labWorkerObj = LabWorkerPrxHelper.checkedCast(labWorkerBase);
			if (labWorkerObj == null) throw new Error("Invalid proxy");

			DoctorPrx doctorObj = DoctorPrxHelper.checkedCast(doctorBase);
			if (doctorObj == null) throw new Error("Invalid proxy");

			PatientPrx patientObj = PatientPrxHelper.checkedCast(patientBase);
			if (patientObj == null) throw new Error("Invalid proxy");
			
//	        CalcPrx objOneway = (CalcPrx)labWorkerObj.ice_oneway();
//	        CalcPrx objBatchOneway = (CalcPrx)labWorkerObj.ice_batchOneway();
//	        CalcPrx objDatagram = (CalcPrx)labWorkerObj.ice_datagram();
//	        CalcPrx objBatchDatagram = (CalcPrx)labWorkerObj.ice_batchDatagram();

			// 4. Wywolanie zdalnych operacji
			
			String line = null;
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			AsyncResult ar = null;

			System.out.println("Choose type of user");
			System.out.println("1 -> Lab Worker");
			System.out.println("2 -> Patient");
			System.out.println("3 -> Doctor");
			line = in.readLine();
			if (line.equals("3"))
			{
				doDoctor(doctorObj);
			}
			else if (line.equals("2")){
				doPatient(patientObj);
			}
			else if (line.equals("1")){
				doLabWorker(labWorkerObj);
			}
			do
			{
				try
				{
					System.out.print("==> ");
					System.out.flush();
					line = in.readLine();
					if (line == null)
					{
						break;
					}
					if (line.equals("add"))
					{
//						long r = labWorkerObj.add(7, 8);
//						System.out.println("RESULT = " + r);
					}
					if (line.equals("subtract"))
					{
//						long r = labWorkerObj.subtract(7, 8);
//						System.out.println("RESULT = " + r);
					}
					else if (line.equals("x"))
					{
						// Nothing to do
					}
				}
				catch (java.io.IOException ex)
				{
					System.err.println(ex);
				}
			}
			while (!line.equals("x"));


		} catch (Ice.LocalException e) {
			e.printStackTrace();
			status = 1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			status = 1;
		}
		if (communicator != null) {
			// Clean up
			//
			try {
				communicator.destroy();
			} catch (Exception e) {
				System.err.println(e.getMessage());
				status = 1;
			}
		}
		System.exit(status);
	}

	private static void doLabWorker(LabWorkerPrx labWorkerObj) {
        String line = null;
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	    while (true){
            System.out.println("1 -> Enter text examination");
            System.out.println("2 -> Enter examination");
            try {
                line = in.readLine();
                if (line.equals("1")){
                    System.out.println("You added test examination");
                    List<Parameter> parameters = new ArrayList<>();
                    parameters.add(new Parameter("Potas", 200));
                    parameters.add(new Parameter("Homoglobina", 220));

                    List<Group> groups = new ArrayList<>();
                    groups.add(new Group("Morfologia", parameters));
                    Examination examination = new Examination("Nowak", "Kowalski", "20.02.2014", groups );
                    labWorkerObj.addExamination(examination, "Jan", "Nowak");
                }
                else if (line.equals("2")){

                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

	}

	private static void doPatient(PatientPrx patientObj) {
	    while (true){
            String line = null;
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            System.out.println("Write your name: ");
            try {
                String firstName = in.readLine();
                System.out.println("Write your last name");
                String lastName = in.readLine();
                System.out.println("Your hospital record with your examinations");
                PatientRecord patientRecord = patientObj.getRecord(firstName, lastName);
                readRecord(patientRecord);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

	}

	private static void doDoctor(DoctorPrx doctorPrx) {
        String line = null;
        java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        Ice.AsyncResult r = null;
	    while(true){
            System.out.println("1 -> read all records");
            System.out.println("2 -> read record");
            System.out.println("3 -> MCV > 50 (Asynchronic)");
            try {
                line = in.readLine();
                if (line.equals("1")){
                    List<PatientRecord> records = doctorPrx.getRecords();
                    System.out.println("Reading records");
                    for (int i = 0; i < records.size(); i++){
                        readRecord(records.get(i));
                    }
                }
                else if (line.equals("2")){
                    System.out.println("Enter first name of patient");
                    String firstName = in.readLine();
                    System.out.println("Enter last name of patient");
                    String lastName = in.readLine();
                    PatientRecord record = doctorPrx.getRecord(firstName, lastName);
                    if (record == null){
                        continue;
                    }
                    readRecord(record);
                }
                else if (line.equals("3")){
                   r =  doctorPrx.begin_MVCMoreThanFifty(new Callback_Doctor_MVCMoreThanFiftyI());
                }
                else if(line.equals("4")){
                    List<PatientRecord> records = doctorPrx.end_MVCMoreThanFifty(r);
                    for (PatientRecord record: records){
                        readRecord(record);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

	}
	public static void readRecord(PatientRecord record){
        System.out.println();
        System.out.println();
        System.out.println("<><><><><><><><><><><><><><><><><><><><><><><>");
        System.out.println("\tPatient First Name: " + record.firstName);
		System.out.println("\tPatient Last Name: " + record.lastName);
		List<Examination> examinations = record.listOfExaminations;
		for (Examination ex: examinations){
            System.out.println("\t#######################################");
            System.out.println("\t\t Patient name: " + ex.patientName);
			System.out.println("\t\t Date of examination: " + ex.date);
			System.out.println("\t\t Doctor name: " + ex.doctorName);
			List<Group> groups = ex.listOfGroups;
			for (Group gr: groups){
                System.out.println("\t\t\tXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                System.out.println("\t\t\t" + gr.name);
                List<Parameter> parameters = gr.listOfParams;
				for (Parameter pr: parameters){
					System.out.println("\t\t\t\t" + pr.name + "\t" + pr.value);

				}
			}
		}
	}

}