package com.ics.soapclient;

import localhost._7991.universities.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestClient implements CommandLineRunner {
    private final UniversityClient universityClient;

    public TestClient(UniversityClient universityClient) {
        this.universityClient = universityClient;
    }

    @Override
    public void run(String... args) throws Exception {
        University university = null;
        //        Get University by Name
        System.out.println(" --- Get University by Name --- ");
        GetUniversityResponse universityResponse = universityClient.getUniversity("Strathmore University");
        University universityWithName = universityResponse.getUniversity();
        System.out.println("University: " + universityWithName.getName() + ", " + universityWithName.getLocation() + ", " + universityWithName.getYearFounded());

//        Get University by ID
        System.out.println(" --- Get University by ID --- ");
        GetUniversityByIdResponse universityByIdResponse = universityClient.getUniversityById(2L);
        University universityWithId = universityByIdResponse.getUniversity();
        System.out.println("University: " + universityWithId.getName() + ", " + universityWithId.getLocation() + ", " + universityWithId.getYearFounded());

//        Get All Universities (Works) TODO: Confirm That forEach
        System.out.println(" --- Get All Universities --- ");
        GetAllUniversitiesResponse allUniversitiesResponse = universityClient.getAllUniversities();
        allUniversitiesResponse.getUniversity().forEach(
                e -> System.out.println(e.getName() + ", " + e.getLocation() + ", " + e.getYearFounded())
        );

//        Add a University
        System.out.println(" --- Add a University --- ");
        University addUniversity = new University();
        addUniversity.setName("University of Nairobi");
        addUniversity.setLocation("University Way");
        addUniversity.setYearFounded("1970");
        AddUniversityResponse addUniversityResponse = universityClient.addUniversityResponse(addUniversity);
//        University addUniResponse = addUniversityResponse.getUniversity();
//        System.out.println("University: " + addUniResponse.getName() + ", " + addUniResponse.getLocation() + ", " + addUniResponse.getYearFounded());
        ServiceStatus addServiceStatus = addUniversityResponse.getServiceStatus();
        System.out.println("Status Code: " + addServiceStatus.getStatusCode() + ", Message: " + addServiceStatus.getMessage());

//        Update a University
        System.out.println(" --- Update a University --- ");
        University updateUniversity = new University();
        updateUniversity.setName("Strathmore University");
        updateUniversity.setLocation("Madaraka, Ole Sangale");
        updateUniversity.setYearFounded("2002");
        UpdateUniversityResponse updateUniversityResponse = universityClient.updateUniversityResponse(1L, updateUniversity);
        ServiceStatus updateServiceStatus = updateUniversityResponse.getServiceStatus();
        System.out.println("Status Code: " + updateServiceStatus.getStatusCode() + ", Message: " + updateServiceStatus.getMessage());

//        Delete a  University (Works)
//        System.out.println(" --- Delete a  University --- ");
//        Long universityId = 3L;
//        DeleteUniversityResponse deleteUniversityResponse = universityClient.deleteUniversity(universityId);
//        ServiceStatus deleteServiceStatus = deleteUniversityResponse.getServiceStatus();
//        System.out.println("Status Code: " + deleteServiceStatus.getStatusCode() + ", Message: " + deleteServiceStatus.getMessage());
    }
}
