package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello") //makes all controller routes start at /hello
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")//whatevers in parens shows path where this lives
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles post request from helloForm at path /hello
    //this will be a dynamic handler (it can accept data)
    //URL parameter and method parameter must match
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //action tells form to submit a request to the path /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
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
//this is to work on controller exercises