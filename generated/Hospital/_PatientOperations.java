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

public interface _PatientOperations
{
    PatientRecord getRecord(String patientFirstName, String patientLastName, Ice.Current __current);
}
