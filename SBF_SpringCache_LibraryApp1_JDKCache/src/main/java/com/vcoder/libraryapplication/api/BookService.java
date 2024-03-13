package com.vcoder.libraryapplication.api;

import com.vcoder.libraryapplication.dto.Book;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */
public interface BookService  {
    Book addBook(Book book);

    Book updateBook(Book book);

    Book getBook(long id);

    String deleteBook(long id);

	String deleteCacheBook(long id);
}
