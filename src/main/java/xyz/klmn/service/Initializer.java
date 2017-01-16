package xyz.klmn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import xyz.klmn.model.Mock;
import xyz.klmn.model.Step;

import java.util.Arrays;

@Component
public class Initializer implements ApplicationListener<ContextRefreshedEvent> {

    private final
    MockRegistrator mockRegistrator;

    @Autowired
    public Initializer(MockRegistrator mockRegistrator) {
        this.mockRegistrator = mockRegistrator;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Started");

        Mock autoPartsMock = new Mock("autoParts");

        final Step make = new Step("Make", "make", Arrays.asList("Toyota", "BMW", "Ford"));
        autoPartsMock.setStep(make);
        final Step model = new Step("Model", "model", Arrays.asList("Corolla", "X6", "Escape"));
        make.setNextStep(model);
        final Step engine = new Step("Engine", "engine", Arrays.asList("4-DOHC", "E6", "V8"));
        model.setNextStep(engine);

        mockRegistrator.putMock(autoPartsMock);

    }
}
