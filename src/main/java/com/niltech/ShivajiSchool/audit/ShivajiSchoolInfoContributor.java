package com.niltech.ShivajiSchool.audit;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ShivajiSchoolInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, String> Map = new HashMap<String, String>();
        Map.put("App Name", "ShivajiSchool");
        Map.put("App Description", "Shivaji School Web Application for Students and Admin");
        Map.put("App Version", "1.0.0");
        Map.put("Contact Email", "info@shivajischool.com");
        Map.put("Contact Mobile", "+917057368444");
        builder.withDetail("shivajischool-info", Map);
    }

}