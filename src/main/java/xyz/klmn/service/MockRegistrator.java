package xyz.klmn.service;

import org.springframework.stereotype.Service;
import xyz.klmn.model.Mock;
import xyz.klmn.model.Step;

import java.util.HashMap;
import java.util.Map;

@Service
public class MockRegistrator {
    Map<String, Step> mocks = new HashMap<>();

    public MockRegistrator() {
    }

    public Map<String, Step> getMocks() {
        return mocks;
    }

    public void putMock(Mock mock) {
        mocks.put(mock.getInitial(), mock.getStep());
    }
}
