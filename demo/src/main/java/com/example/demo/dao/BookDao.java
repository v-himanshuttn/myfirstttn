package com.example.demo.dao;

import com.example.demo.entitiy.Book;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {

    //public static int id;
    List<Book> li=new ArrayList<>();

    public BookDao() {
    }

    public void save(Book book)
    {
        li.add(book);
    }

    public List<Book> getAll()
    {
        return li;
    }
}
