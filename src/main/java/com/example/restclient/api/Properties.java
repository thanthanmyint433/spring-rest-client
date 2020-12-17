package com.example.restclient.api;

import com.example.Bar;
import com.example.Baz;
import com.example.Foo;

import java.util.HashMap;
import java.util.Map;

public class Properties {

    private Foo foo;
    private Bar bar;
    private Baz baz;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Foo getFoo() {
        return foo;
    }

    public void setFoo(Foo foo) {
        this.foo = foo;
    }

    public Bar getBar() {
        return bar;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public Baz getBaz() {
        return baz;
    }

    public void setBaz(Baz baz) {
        this.baz = baz;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
