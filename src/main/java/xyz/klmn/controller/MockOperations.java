package xyz.klmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.klmn.model.Mock;
import xyz.klmn.model.Step;
import xyz.klmn.service.MockRegistrator;

import java.util.Map;

@RestController
public class MockOperations {

    final
    MockRegistrator mockRegistrator;

    @Autowired
    public MockOperations(MockRegistrator mockRegistrator) {
        this.mockRegistrator = mockRegistrator;
    }

    @RequestMapping(value = "/mocks", method = RequestMethod.POST)
    public Map<String, Step> addMock(@RequestBody Mock mock) {
        mockRegistrator.putMock(mock);
        return mockRegistrator.getMocks();
    }

    @RequestMapping(value = "/mocks", method = RequestMethod.GET)
    public Map<String, Step> getMocks() {
        return mockRegistrator.getMocks();
    }
}
