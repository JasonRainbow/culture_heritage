package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.service.ForumService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="论坛",description = "论坛相关接口")
@RestController
public class ForumController {

    @Autowired
    ForumService forumService;

    @Operation(summary = "查询", description = "分页查询所有论坛")
    @RequestMapping("/getAllForum/{pageSize}/{pageNumber}")
    public Result getAllForum(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNumber") Integer pageNumber){
        return forumService.getAllForum(pageSize, pageNumber);
    }


}
