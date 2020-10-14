package controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Value("${version}")
    private String version;

    @Value("${profile}")
    private String profile;

    @GetMapping(value = "/gateway")
    public String gateway() throws Exception {
        return "version:" + version + ",profile:" + profile;
    }
}
