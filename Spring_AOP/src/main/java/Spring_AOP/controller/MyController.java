package Spring_AOP.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import Spring_AOP.service.SomeService;

@RestController
public class MyController {

    private final SomeService someService;

    @Autowired
    public MyController(SomeService someService) {
        this.someService = someService;
    }

    @RequestMapping("/doSomething")
    public String doSomething() {
        someService.doSomething("exampleParam");
        return "Something done";
    }

    @RequestMapping("/doAnotherThing")
    public String doAnotherThing() {
        someService.doAnotherThing(123);
        return "Another thing done";
    }
}
