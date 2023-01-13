package at.htl.neudorfer.entity;

import lombok.Data;

@Data
public class Author {

    private String fullName;
//    private String firstName;
//    private String lastName;

    public Author(String fullName) {
        this.fullName = fullName;
        //this.firstName = fullName.split(" ")[0];
        //this.lastName = fullName.split(" ")[1];
    }
}
