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
@RequestMapping("/admin")
@Api(value = "admin", description = "Rest API for administrative operations", tags = "Admin API")
public class AdminController {

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET, produces = "application/json")
    @ApiOperation(value = "Display greeting message to admin user", response = Greeting.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "You are not authorized access the resource"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public Greeting message(@PathVariable String name) {
        Greeting msg = new Greeting(name, "Hello admin " + name);
        return msg;
    }

}
