package com.example.td_jee.controllers;

import com.example.td_jee.data.FakeDB;
import com.example.td_jee.models.Book;
import com.example.td_jee.models.BookDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@WebServlet(name = "BookFormServlet", value = "/session/addBook")
public class BookFormServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookDTO bookDTO = new BookDTO();
        ArrayList<String> errors = new ArrayList<>();

        req.setAttribute("book", bookDTO);
        req.setAttribute("errors", errors);
        req.setAttribute("mode", "addBook");

        req.getRequestDispatcher("/WEB-INF/session/bookManagement.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<String> errors = new ArrayList<>();
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publicationType = req.getParameter("publicationType");
        String publicationDate = req.getParameter("publicationDate");
        String editor = req.getParameter("editor");
        String isbn = req.getParameter("isbn");


        Optional<Book> foundBook = FakeDB.bookList.stream().filter(b -> b.getIsbn().equals(isbn)).findFirst();

        if (!foundBook.isPresent()){
            Book book = new Book(title, author, publicationType, publicationDate, editor, isbn);
            FakeDB.bookList.add(book);

            req.getSession().setAttribute("book", book);
            resp.sendRedirect(req.getContextPath() + "/session/bookManagement.jsp");

        } else {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setTitle(title);
            bookDTO.setAuthor(author);
            bookDTO.setPublicationType(publicationType);
            bookDTO.setPublicationDate(publicationDate);
            bookDTO.setEditor(editor);
            bookDTO.setIsbn(isbn);

            req.setAttribute("errors", errors);
            req.setAttribute("book", bookDTO);
            req.setAttribute("mode", "addBook");
            req.getRequestDispatcher("/WEB-INF/session/bookManagement.jsp");
        }
    }
}
