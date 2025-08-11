package com.springboootacademy.point_of_sale.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/test")
public class TestController {

    @GetMapping(path="/text1")
    public String getMyText(){
        String myText = "This is my project";
        System.out.println(myText);
        return (myText);
    }
    @GetMapping(path="/text2")
    public String getMyText2(){
        String myText = "This is my second project";
        System.out.println(myText);
        return (myText);
    }

}
