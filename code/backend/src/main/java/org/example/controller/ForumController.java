package org.example.controller;

import org.example.service.ForumService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ForumController {

    @Autowired
    ForumService forumService;

    @RequestMapping("/getAllForum/{pageSize}/{pageNumber}")
    public Result getAllForum(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNumber") Integer pageNumber){
        return forumService.getAllForum(pageSize, pageNumber);
    }


}
