package com.example.td_jee.models;

public class Book {
    private String title;
    private String author;
    private String publicationType;
    private String publicationDate;
    private String editor;
    private Long isbn;

    public Book(){
    }

    public Book(String title, String author, String publicationType, String publicationDate, String editor, Long isbn) {
        this.title = title;
        this.author = author;
        this.publicationType = publicationType;
        this.publicationDate = publicationDate;
        this.editor = editor;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublicationType() {
        return publicationType;
    }

    public void setPublicationType(String publicationType) {
        this.publicationType = publicationType;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }
}
