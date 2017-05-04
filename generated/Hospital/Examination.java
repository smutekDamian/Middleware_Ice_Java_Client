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

public class Examination extends Ice.ObjectImpl
{
    public Examination()
    {
        patientName = "";
        date = "";
        doctorName = "";
    }

    public Examination(String patientName, String date, String doctorName, java.util.List<Group> listOfGroups)
    {
        this.patientName = patientName;
        this.date = date;
        this.doctorName = doctorName;
        this.listOfGroups = listOfGroups;
    }

    private static class __F implements Ice.ObjectFactory
    {
        public Ice.Object create(String type)
        {
            assert(type.equals(ice_staticId()));
            return new Examination();
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
        "::Hospital::Examination",
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
        __os.writeString(patientName);
        __os.writeString(date);
        __os.writeString(doctorName);
        ListOfGroupsHelper.write(__os, listOfGroups);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        patientName = __is.readString();
        date = __is.readString();
        doctorName = __is.readString();
        listOfGroups = ListOfGroupsHelper.read(__is);
        __is.endReadSlice();
    }

    public String patientName;

    public String date;

    public String doctorName;

    public java.util.List<Group> listOfGroups;

    public Examination
    clone()
    {
        return (Examination)super.clone();
    }

    public static final long serialVersionUID = 295403535L;
}
