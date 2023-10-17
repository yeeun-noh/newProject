package com.example.board.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class SampleController {

    @GetMapping("/test")
    public void test() {
        log.info("test...");
    }

}
