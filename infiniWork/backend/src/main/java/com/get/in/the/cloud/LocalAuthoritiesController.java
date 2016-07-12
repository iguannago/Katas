package com.get.in.the.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by davicres on 13/04/2016.
 */
@RestController
public class LocalAuthoritiesController {
    @RequestMapping("/getLocalAuthorities")
    public String getLocalAuthorities() {
        return "Authorities List";
    }
}
