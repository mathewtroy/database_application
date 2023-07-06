package main.java.dao;

import main.java.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void addBook(Book book) {
        entityManager.persist(book);
    }

    public Book getBook(String bookId) {
        return entityManager.find(Book.class, bookId);
    }

    public void updateBook(Book book) {
        entityManager.merge(book);
    }

    public void deleteBook(Book book) {
        entityManager.remove(book);
    }
}

