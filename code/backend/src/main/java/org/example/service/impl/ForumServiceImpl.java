package org.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.ForumMapper;
import org.example.pojo.Forum;
import org.example.service.ForumService;
import org.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ForumServiceImpl implements ForumService {
    @Autowired
    ForumMapper forumMapper;

    @Override
    public Result getAllForum(Integer pageSize, Integer pageNumber) {
        Page<Forum> page = new Page<>(pageNumber,pageSize);
        forumMapper.selectPage(page,null);
        Map map = new HashMap();
        map.put("current",page.getCurrent());
        map.put("total", page.getTotal());
        map.put("size",page.getSize());
        map.put("records", page.getRecords());
        return Result.success(map);

    }
}
