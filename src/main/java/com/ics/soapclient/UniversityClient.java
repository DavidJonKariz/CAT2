package com.ics.soapclient;

import localhost._7991.universities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UniversityClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(UniversityClient.class);

    //    TODO: Fix the UniversityByName
    public GetUniversityResponse getUniversity(String name) {
        GetUniversityRequest request = new GetUniversityRequest();
        request.setName(name);
        log.info(" --- Get University by Name --- ");
        return (GetUniversityResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7991/ws/universities", request,
                new SoapActionCallback("http://localhost:7991/ws/universities"));
    }

//    TODO: Fix the UniversityById
    public GetUniversityByIdResponse getUniversityById(Long universityId) {
        GetUniversityByIdRequest request = new GetUniversityByIdRequest();
        request.setUniversityId(universityId);
        log.info(" --- Get University by ID --- ");
        return (GetUniversityByIdResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7991/ws/universities", request,
                new SoapActionCallback("http://localhost:7991/ws/universities"));
    }

    public GetAllUniversitiesResponse getAllUniversities() {
        GetAllUniversitiesRequest request = new GetAllUniversitiesRequest();
        log.info(" --- Get All Universities --- ");
        return (GetAllUniversitiesResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7991/ws/universities", request,
                new SoapActionCallback("http://localhost:7991/ws/universities")
        );
    }
//    TODO: Ensure that it adds a University
    public AddUniversityResponse addUniversityResponse(University university) {
        AddUniversityRequest request = new AddUniversityRequest();
        request.setName(university.getName());
        request.setLocation(university.getLocation());
        request.setYearFounded(university.getYearFounded());
        return (AddUniversityResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7991/ws/universities", request,
                new SoapActionCallback("http://localhost:7991/ws/universities")
        );
    }

//    TODO: Ensure that it does not add a University
    public UpdateUniversityResponse updateUniversityResponse(Long universityId, University university) {
        UpdateUniversityRequest request = new UpdateUniversityRequest();
        request.setUniversityId(universityId);
        request.setName(university.getName());
        request.setLocation(university.getLocation());
        request.setYearFounded(university.getYearFounded());
        return (UpdateUniversityResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7991/ws/universities", request,
                new SoapActionCallback("http://localhost:7991/ws/universities")
        );
    }

//    TODO: Ensure that it finds the University ID
    public DeleteUniversityResponse deleteUniversity(Long universityId) {
        DeleteUniversityRequest request = new DeleteUniversityRequest();
        request.setUniversityId(universityId);
//        DeleteUniversityResponse response = (DeleteUniversityResponse) getWebServiceTemplate().marshalSendAndReceive(
//                "http://localhost:7991/ws/universities", request,
//                new SoapActionCallback("http://localhost:7991/ws/universities")
//        );
        return (DeleteUniversityResponse) getWebServiceTemplate().marshalSendAndReceive(
                "http://localhost:7991/ws/universities", request,
                new SoapActionCallback("http://localhost:7991/ws/universities")
        );
    }
}
