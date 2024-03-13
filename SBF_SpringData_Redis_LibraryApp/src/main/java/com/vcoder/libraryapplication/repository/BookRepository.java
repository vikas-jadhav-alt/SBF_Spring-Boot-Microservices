package com.vcoder.libraryapplication.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vcoder.libraryapplication.dto.Book;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    int updateAddress(long id, String name);
}
