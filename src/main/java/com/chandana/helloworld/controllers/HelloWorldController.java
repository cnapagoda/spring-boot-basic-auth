package com.chandana.helloworld.controllers;

import com.chandana.helloworld.bean.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(value = "user", description = "Rest API for user operations", tags = "User API")
public class HelloWorldController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Display greeting message to non-admin user", response = Greeting.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public Greeting message(@PathVariable String name) {
        Greeting msg = new Greeting(name, "Hello " + name);
        return msg;
    }

}
