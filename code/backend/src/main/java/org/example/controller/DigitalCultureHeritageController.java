package org.example.controller;

import org.example.service.DigitalCultureHeritageService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzx
 * 数字非遗访问控制器
 */
@RestController
@RequestMapping("/digital_culture_heritage")
public class DigitalCultureHeritageController {

    @Autowired
    private DigitalCultureHeritageService digitalCultureHeritageService;

    @GetMapping("/paging_query")
    public Result findByPage(@RequestParam(name = "pageNum", defaultValue = "1", required = false) Integer pageNum,
                             @RequestParam(name = "pageSize", defaultValue = "10", required = false) Integer pageSize) {
        return Result.success(digitalCultureHeritageService.findAllByPage(pageNum, pageSize));
    }
}
