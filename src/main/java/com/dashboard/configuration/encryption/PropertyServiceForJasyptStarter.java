package com.dashboard.configuration.encryption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceForJasyptStarter {

    @Value("${encrypted.portaldb.pwd}")
    private String portalDbPassword;

    
    public String getPortalDbPassword() {
        return portalDbPassword;
    }

    public String getPasswordUsingEnvironment(Environment environment) {
    	System.setProperty("jasypt.encryptor.password", "chspd@20450801");
        return environment.getProperty("encrypted.property");
    }
}