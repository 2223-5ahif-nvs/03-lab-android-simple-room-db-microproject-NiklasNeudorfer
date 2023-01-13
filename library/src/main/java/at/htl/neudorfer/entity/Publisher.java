package at.htl.neudorfer.entity;

import lombok.Data;

@Data
public class Publisher {

    private String name;

    public Publisher(String name) {
        this.name = name;
    }
}
