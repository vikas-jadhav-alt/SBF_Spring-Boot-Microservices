package com.vcoder.libraryapplication.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.vcoder.libraryapplication.dto.Book;
import com.vcoder.libraryapplication.repository.BookRepository;



@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book addBook(Book book) {
		Book b = bookRepository.save(book);
		logger.info("adding book with id - {}", b.getId());
		return b;

	}

	@Override
	@CachePut(cacheNames = "books", key = "#book.id")
	public Book updateBook(Book book) {
		bookRepository.updateAddress(book.getId(), book.getName());
		logger.info("book updated with new name");
		return book;
	}

	@Override
//	@Caching(cacheable = { @Cacheable(cacheNames = "books", key = "#id"),
//			@Cacheable(cacheNames = "shelf", key = "#id") })
	@Cacheable(cacheNames = "books", key = "#id")
	public Book getBook(long id) {
		logger.info("fetching book from db : {}", id);
		Optional<Book> book = bookRepository.findById(id);
		if (book.isPresent()) {
			return book.get();
		} else {
			return new Book();
		}
	}

	@Override
	@CacheEvict(cacheNames = "books", key = "#id")
	public String deleteBook(long id) {
		bookRepository.deleteById(id);
		logger.info("Deleted Book wit ID - {}", id);
		return "Book deleted";
	}

	@Override
	@CacheEvict(cacheNames = "books", key = "#id")
	public String deleteCacheBook(long id) {
		logger.info("Cache Deleted Book wit ID - {}", id);

		// To test what happens in case of Exception..
//		String h = null;
//		h.length();

		return "cache with book.id : " + id + " deleted";
	}

}
