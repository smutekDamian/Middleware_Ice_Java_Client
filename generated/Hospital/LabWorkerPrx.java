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

public interface LabWorkerPrx extends Ice.ObjectPrx
{
    public void addExamination(Examination examination, String patientFirstName, String patientLastName);

    public void addExamination(Examination examination, String patientFirstName, String patientLastName, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_addExamination(Examination examination, String patientFirstName, String patientLastName);

    public Ice.AsyncResult begin_addExamination(Examination examination, String patientFirstName, String patientLastName, java.util.Map<String, String> __ctx);

    public Ice.AsyncResult begin_addExamination(Examination examination, String patientFirstName, String patientLastName, Ice.Callback __cb);

    public Ice.AsyncResult begin_addExamination(Examination examination, String patientFirstName, String patientLastName, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    public Ice.AsyncResult begin_addExamination(Examination examination, String patientFirstName, String patientLastName, Callback_LabWorker_addExamination __cb);

    public Ice.AsyncResult begin_addExamination(Examination examination, String patientFirstName, String patientLastName, java.util.Map<String, String> __ctx, Callback_LabWorker_addExamination __cb);

    public Ice.AsyncResult begin_addExamination(Examination examination, 
                                                String patientFirstName, 
                                                String patientLastName, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_addExamination(Examination examination, 
                                                String patientFirstName, 
                                                String patientLastName, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                IceInternal.Functional_BoolCallback __sentCb);

    public Ice.AsyncResult begin_addExamination(Examination examination, 
                                                String patientFirstName, 
                                                String patientLastName, 
                                                java.util.Map<String, String> __ctx, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    public Ice.AsyncResult begin_addExamination(Examination examination, 
                                                String patientFirstName, 
                                                String patientLastName, 
                                                java.util.Map<String, String> __ctx, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                IceInternal.Functional_BoolCallback __sentCb);

    public void end_addExamination(Ice.AsyncResult __result);
}
