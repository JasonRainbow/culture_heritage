package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.service.ForumService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yt
 */
@Tag(name="论坛",description = "论坛相关接口")
@RestController
public class ForumController {

    @Autowired
    ForumService forumService;

    @Operation(summary = "查询", description = "分页查询所有论坛")
    @GetMapping("/getAllForum")
    public Result getAllForum(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                              @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize){
        return forumService.getAllForum(pageSize, pageNum);
    }


}
