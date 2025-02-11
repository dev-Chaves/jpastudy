package com.bookshore.demo.BookModels;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "TBL_BOOK")
public class BookModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_ID")
    private PublisherModel publisher;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_ID")
    private AutorModel autor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tb_book_autor",
            joinColumns = @JoinColumn(name = "book_ID"),
            inverseJoinColumns = @JoinColumn(name="autor_ID"))

    private Set<BookModel> authors= new HashSet<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public PublisherModel getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherModel publisher) {
        this.publisher = publisher;
    }

    public Set<BookModel> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<BookModel> authors) {
        this.authors = authors;
    }
}
