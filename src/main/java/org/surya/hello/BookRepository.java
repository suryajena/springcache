package org.surya.hello;

public interface BookRepository {

    Book getByIsbn(String isbn);

}