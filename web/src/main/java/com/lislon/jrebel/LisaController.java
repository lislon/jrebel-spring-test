package com.lislon.jrebel;

import com.lislon.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class LisaController {

    private App app;

    @Autowired
    public LisaController(App app) {
        this.app = app;
    }

    @GetMapping("/lisa")
    public String lisa()
    {
        app.foo();
        return "index";
    }
}
