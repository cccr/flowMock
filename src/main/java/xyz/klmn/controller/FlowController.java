package xyz.klmn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.klmn.model.Step;
import xyz.klmn.service.MockRegistrator;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class FlowController {

    final
    MockRegistrator mockRegistrator;

    @Autowired
    public FlowController(MockRegistrator mockRegistrator) {
        this.mockRegistrator = mockRegistrator;
    }

    @RequestMapping(value = "/dss/{path}/**", method = RequestMethod.GET)
    public Step get(@PathVariable("path") String path1,
                    HttpServletRequest request) throws Exception {
        final Map<String, String[]> parameterMap = request.getParameterMap();

        Step step = mockRegistrator.getMocks().get(path1);

        while (step != null) {
            if (parameterMap.containsKey(step.getParamName())) {
                if (step.getNextStep() != null)
                    step = step.getNextStep();
                else break;
            } else {
                break;
            }
        }

        return step;
    }

}
