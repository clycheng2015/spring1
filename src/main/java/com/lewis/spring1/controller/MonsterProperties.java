package com.lewis.spring1.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component //org.springframework.stereotype.Component;
@ConfigurationProperties(prefix = "monster")
public class MonsterProperties {
    private String name;
    private int atk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    @Override
    public String toString() {
        return "MonsterProperties{" +
                "name='" + name + '\'' +
                ", atk=" + atk +
                '}';
    }
}
