package com.vcoder.libraryapplication.api;

import com.vcoder.libraryapplication.dto.Book;


public interface BookService  {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);

	String deleteCacheBook(long id);
}
