package org.example.controller;

import org.example.pojo.OfflineActivity;
import org.example.service.OfflineActivityService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OfflineActivityController {

    @Autowired
    OfflineActivityService offlineActivityService;

    @GetMapping("/getAllOfflineActivity")
    public Result getAllOfflineActivity(){

        return offlineActivityService.getAllOfflineActivity();
    }

    @GetMapping("getAllOfflineActivityByPage")
    public Result getAllOfflineActivityByPage(@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNumber") Integer pageNumber){
        return offlineActivityService.getAllOfflineActivityByPage(pageSize,pageNumber);
    }

    @PostMapping("/activityPromotionApply")
    public Result activityPromotionApply(@RequestBody OfflineActivity offlineActivity){
        return offlineActivityService.activityPromotionApply(offlineActivity);
    }
}
