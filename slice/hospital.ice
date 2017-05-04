
#ifndef HOSPITAL_ICE
#define HOSPITAL_ICE

module Hospital
{
    class Parameter {
        string name;
        double value;
    };

    ["java:type:java.util.LinkedList<>"]
    sequence<Parameter> ListOfParameters;
    class Group {
        string name;
        ListOfParameters listOfParams;
    };
    ["java:type:java.util.LinkedList<>"]
    sequence<Group> ListOfGroups;
    class Examination {
        string patientName;
        string date;
        string doctorName;
        ListOfGroups listOfGroups;
    };
    ["java:type:java.util.LinkedList<>"]
    sequence<Examination> ListOfExaminations;
    class PatientRecord {
        string firstName;
        string lastName;
        ListOfExaminations listOfExaminations;
    };
    ["java:type:java.util.LinkedList<>"]
    sequence<PatientRecord> records;
  interface LabWorker
  {
    void addExamination(Examination examination, string patientFirstName, string patientLastName);
  };
  interface Patient{
    PatientRecord getRecord( string patientFirstName, string patientLastName);
  };
  interface Doctor{
    records getRecords();
    PatientRecord getRecord( string patientFirstName, string patientLastName);
    records MVCMoreThanFifty();
  };

};

#endif
