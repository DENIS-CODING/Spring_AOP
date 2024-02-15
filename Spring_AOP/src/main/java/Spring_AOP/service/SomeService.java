package Spring_AOP.service;

import org.springframework.stereotype.Service;
import Spring_AOP.Interface.TrackUserAction;

@Service
public class SomeService {

    @TrackUserAction(value = "doSomething")
    public void doSomething(String param) {
    }

    @TrackUserAction(value = "doAnotherThing")
    public void doAnotherThing(int number) {
    }
}
