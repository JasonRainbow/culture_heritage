package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.mapper.DigitalCultureHeritageMapper;
import org.example.pojo.DigitalCultureHeritage;
import org.example.service.DigitalCultureHeritageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hzx
 */
@Service
public class DigitalCultureHeritageServiceImpl implements DigitalCultureHeritageService {

    @Autowired
    private DigitalCultureHeritageMapper digitalCultureHeritageMapper;

    @Override
    public Page<DigitalCultureHeritage> findAllByPage(int pageNum, int pageSize) {
        Page<DigitalCultureHeritage> result = digitalCultureHeritageMapper.selectPage(new Page<>(pageNum, pageSize),
                new QueryWrapper<>());

        return result;
    }
}
