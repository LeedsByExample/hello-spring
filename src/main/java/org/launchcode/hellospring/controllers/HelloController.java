package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")//whatevers in parens shows path where this lives
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles post request from helloForm at path /hello
    //this will be a dynamic handler (it can accept data)
    //URL parameter and method parameter must match
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

}
//default method for forms is GET
//<label for="cars">Choose a car:</label>
//    <select id="cars" name="cars">
//        <option value="volvo">Volvo</option>
//        <option value="saab">Saab</option>
//        <option value="fiat">Fiat</option>
//        <option value="audi">Audi</option>
//    </select>