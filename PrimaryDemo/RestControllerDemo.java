package com.Primary.PrimaryDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {
	Game g;
    public RestControllerDemo(Game ge)
    {
    	g=ge;
    }
    @GetMapping("/")
    public String play()
    {
    	return g.play();
    }

}
