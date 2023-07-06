package main.java.dao;

import main.java.entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;


public class PersonDAO {
    private EntityManager em;
    private EntityTransaction et;

    public PersonDAO(EntityManager em) {
        this.em = em;
        this.et = em.getTransaction();
    }

    public void insert(Person person) {
        et.begin();
        em.persist(person);
        et.commit();
    }

    public Person update(Person person) {
        et.begin();
        Person updatedPerson = em.merge(person);
        et.commit();
        return updatedPerson;
    }

    public void delete(Person person) {
        et.begin();
        em.remove(person);
        et.commit();
    }

    public Person get(String pass) {
        et.begin();
        Person person = em.find(Person.class, pass);
        et.commit();
        return person;
    }

    public List<Person> getItems() {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person AS p", Person.class);
        List<Person> persons = query.getResultList();
        return persons;
    }

    public List<Person> getItemsByValue(String columnName, String value) {
        TypedQuery<Person> query = em.createQuery("SELECT p FROM Person AS p "
                + "WHERE (p." + columnName + "=:val)", Person.class);
        query.setParameter("val", value);
        List<Person> persons = query.getResultList();
        return persons;
    }

    public List<Person> getAll() {
        return getItems();
    }

}
