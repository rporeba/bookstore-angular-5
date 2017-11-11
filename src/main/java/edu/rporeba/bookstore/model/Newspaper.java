package edu.rporeba.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "Newspaper")
public class Newspaper extends Item {

    @NotNull
    @Size(min = 3, max = 30)
    private String newspaperTitle;


}
