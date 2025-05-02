package com.acme.basic;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private FibonacciCalculator fibonacciCalculator;

    @Test
    public void testFibonacci() throws Exception {
       given(fibonacciCalculator.fibonacci(5)).willReturn(5);
       mockMvc.perform(get("/fibonacci?n=5"))
               .andExpect(status().isOk())
               .andExpect(content().string(containsString("5")));

       verify(fibonacciCalculator, times(1)).fibonacci(anyInt());
    }


}
