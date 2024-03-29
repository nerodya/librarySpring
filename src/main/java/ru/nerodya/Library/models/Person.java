package ru.nerodya.Library.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @Column(name = "id_person")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_person;

    @Min(value = 1900, message = "Некорректный год рождения")
    @Column(name = "year_birth")
    private int yearBirth;

    @Pattern(regexp = "^([А-Я][а-я]+) ([А-Я][а-я]+) ([А-Я][а-я]+)$", message = "РеГуЛяРоЧкА")
    @NotEmpty(message = "Имя не может быть пустым")
    @Size(min = 2, max = 50, message = "Слишком короткое или длинное ФИО")
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(int yearBirth, String name) {
        this.yearBirth = yearBirth;
        this.name = name;
    }

    public Person() {}

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}