package com.aplication.rest;

import com.aplication.rest.model.Book;
import com.aplication.rest.service.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
@ActiveProfiles("test")
public class RestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServiceImpl bookServiceImpl;

    @Test
    public void findAll() throws Exception {
        Book book = new Book();

        book.setId(1L);
        book.setAutor("test");
        book.setCategory("test");
        book.setIsbn("test");
        book.setDescription("test");
        book.setTitle("test");


        List<Book> stocks = Arrays.asList(book);
        given(bookServiceImpl.getAllBooks()).willReturn(stocks);

        this.mockMvc.perform(get("/books"))
                .andExpect(status().isOk());


    }
}
