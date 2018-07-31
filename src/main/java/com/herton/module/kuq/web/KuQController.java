package com.herton.module.kuq.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kuq")
public class KuQController {
    @RequestMapping(value = "/msg", method = RequestMethod.POST)
    public ResponseEntity<Reply> reciveMsg(@RequestBody Msg msg) {
        System.out.println(msg.getMessage());
        return new ResponseEntity<>(new Reply(), HttpStatus.OK);
    }
}
