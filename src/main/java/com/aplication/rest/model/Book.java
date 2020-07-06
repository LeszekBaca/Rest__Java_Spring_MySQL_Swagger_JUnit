package com.aplication.rest.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity // This tells Hibernate to make a table out of this class
public class Book implements Serializable {

    private static final long serialVersionUID = 7696928629727395271L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String isbn;
    private String title;
    private String autor;
    private String category;
    private String description;

    public Book(Long id, String isbn, String title, String autor, String category, String description) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
        this.category = category;
        this.description = description;
    }

    public Book(String isbn, String title, String autor, String category, String description) {
        this.isbn = isbn;
        this.title = title;
        this.autor = autor;
        this.category = category;
        this.description = description;
    }

    public Book() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", autor='" + autor + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
