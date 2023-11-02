package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.pojo.SearchHeritage;
import org.example.service.CultureHeritageService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="文化遗产",description = "文化遗产相关接口")
@RestController
public class CultureHeritageController {
    @Autowired
    CultureHeritageService cultureHeritageService;

    @Operation(summary = "查询", description = "分页查询所有文化遗产")
    @GetMapping("getAllHeritageByPage/{pageSize}/{pageNumber}")
    public Result getAllHeritageByPage(@PathVariable("pageSize") Integer pageSize, @PathVariable("pageNumber") Integer pageNumber){
        return cultureHeritageService.getAllHeritageByPage(pageSize, pageNumber);
    }

    @Operation(summary = "搜索", description = "分页搜索所有文化遗产")
    @PostMapping("/searchHeritage")
    public Result searchHeritage(@RequestBody SearchHeritage searchHeritage){

        return cultureHeritageService.searchHeritage(searchHeritage);
    }

    @Operation(summary = "搜索", description = "查询非物质文化遗产的分布情况")
    @GetMapping("/searchDistribute")
    public Result searchDistribute(){
        return Result.success(cultureHeritageService.getCultureHeritageDistribute());
    }
}
