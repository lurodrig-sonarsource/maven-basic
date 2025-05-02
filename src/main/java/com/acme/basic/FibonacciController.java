package com.acme.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FibonacciController {

    private final FibonacciCalculator fibonacciCalculator;

    public FibonacciController(FibonacciCalculator fibonacciCalculator) {
        this.fibonacciCalculator = fibonacciCalculator;
    }

    @GetMapping("/fibonacci")
    public @ResponseBody String fibonacci(@RequestParam("n") int n) {
        return String.valueOf(fibonacciCalculator.fibonacci(n));
    }
}
