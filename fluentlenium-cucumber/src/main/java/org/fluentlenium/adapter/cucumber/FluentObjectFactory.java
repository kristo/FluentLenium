package org.fluentlenium.adapter.cucumber;

import cucumber.api.java.ObjectFactory;
import cucumber.runtime.CucumberException;

import java.util.*;

import static org.fluentlenium.adapter.cucumber.FluentCucumberTestContainer.FLUENT_TEST;

public class FluentObjectFactory implements ObjectFactory {

    private FluentCucumberTest fluentTest;

    private final Map<Class<?>, Object> instances = new HashMap<>();

    public FluentObjectFactory() {
        this.fluentTest = FLUENT_TEST.instance();
    }

    @Override
    public void start() {
        fluentTest.before();
    }

    @Override
    public void stop() {
        fluentTest.after();
        this.instances.clear();
    }

    @Override
    public boolean addClass(Class<?> aClass) {
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getInstance(Class<T> type) {
        try {
            T instance = type.cast(instances.get(type));
            if (instance == null) {
                instance = cacheNewInstance(type);
            }
            return instance;

        } catch (Exception e) {
            throw new CucumberException(String.format("Failed to instantiate %s", type), e);
        }
    }

    private <T> T cacheNewInstance(Class<T> type) {
        try {
            T instance = fluentTest.newInstance(type);
            instances.put(type, instance);
            return instance;
        } catch (Exception e) {
            throw new CucumberException(String.format("Failed to instantiate %s", type), e);
        }
    }
}