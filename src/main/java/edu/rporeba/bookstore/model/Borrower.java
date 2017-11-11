package edu.rporeba.bookstore.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "Borrower")
public class Borrower implements Serializable{

    private static final long serialVersionUID = -3723289802711977258L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrowerId", nullable = false, updatable = false)
    private Long borrowerId;

    @NotNull
    @Size(min = 3, max = 20)
    private String firstName;

    @NotNull
    @Size(min = 3, max = 20)
    private String lastName;

    @Valid
    private Boolean hasBookBorrowed = false;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "borrower")
//    private Set<Borrow> borrows;


}
