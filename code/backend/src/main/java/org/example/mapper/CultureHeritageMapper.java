package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.pojo.CultureHeritage;

import java.util.List;

public interface CultureHeritageMapper extends BaseMapper<CultureHeritage> {

    public List searchAllPostTime();

    public List searchAllArea();
}
