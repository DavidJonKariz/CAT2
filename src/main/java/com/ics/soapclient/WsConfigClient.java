package com.ics.soapclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WsConfigClient {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("localhost._7991.universities");
        return marshaller;
    }

    @Bean
    public UniversityClient universityClient(Jaxb2Marshaller marshaller) {
        UniversityClient universityClient = new UniversityClient();
        universityClient.setDefaultUri("http://localhost:7991/universities");
//        universityClient.setDefaultUri("http://localhost:7991/ws/universities.wsdl");
        universityClient.setMarshaller(marshaller);
        universityClient.setUnmarshaller(marshaller);
        return universityClient;
    }
}
