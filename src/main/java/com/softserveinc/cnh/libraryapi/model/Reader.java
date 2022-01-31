package com.softserveinc.cnh.libraryapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reader")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long     readerId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "address")
    private String address;

    @Column(name = "age")
    private Integer age;

    @OneToMany(mappedBy = "book")
    private Set<BookReader> bookAssociation = new HashSet<>();
}
