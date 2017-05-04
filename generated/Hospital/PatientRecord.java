// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `hospital.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package Hospital;

public class PatientRecord extends Ice.ObjectImpl
{
    public PatientRecord()
    {
        firstName = "";
        lastName = "";
    }

    public PatientRecord(String firstName, String lastName, java.util.List<Examination> listOfExaminations)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.listOfExaminations = listOfExaminations;
    }

    private static class __F implements Ice.ObjectFactory
    {
        public Ice.Object create(String type)
        {
            assert(type.equals(ice_staticId()));
            return new PatientRecord();
        }

        public void destroy()
        {
        }
    }
    private static Ice.ObjectFactory _factory = new __F();

    public static Ice.ObjectFactory
    ice_factory()
    {
        return _factory;
    }

    public static final String[] __ids =
    {
        "::Hospital::PatientRecord",
        "::Ice::Object"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[0];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[0];
    }

    public static String ice_staticId()
    {
        return __ids[0];
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.writeString(firstName);
        __os.writeString(lastName);
        ListOfExaminationsHelper.write(__os, listOfExaminations);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        firstName = __is.readString();
        lastName = __is.readString();
        listOfExaminations = ListOfExaminationsHelper.read(__is);
        __is.endReadSlice();
    }

    public String firstName;

    public String lastName;

    public java.util.List<Examination> listOfExaminations;

    public PatientRecord
    clone()
    {
        return (PatientRecord)super.clone();
    }

    public static final long serialVersionUID = 1115649119L;
}
