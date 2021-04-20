package com.bing.guo.service.base.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.bing.guo.common.reflect.ReflectionUtils;
import com.bing.guo.mapper.baseMapper.MyMapper;
import com.bing.guo.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private MyMapper<T> myMapper;


    protected MyMapper<T> getMapper() {
        return myMapper;
    }

    @Override
    public List<T> list() {
        return myMapper.selectList(null);
    }

    @Override
    public List<T> search(Wrapper<T> wrapper) {
        return myMapper.selectList(wrapper);
    }

    @Override
    public T getById(Long id) {
        return myMapper.selectById(id);
    }

    @Override
    public int insert(T t) {
        ReflectionUtils.invokeMethod(t, "setData", null, null);
        return myMapper.insert(t);
    }

    @Override
    public int update(T t) {
        ReflectionUtils.invokeMethod(t, "setData", null, null);
        return myMapper.updateById(t);
    }

    @Override
    public int deleteById(Long id) {
        return myMapper.deleteById(id);
    }

    @Transactional
    @Override
    public int batchDeleteByIds(List<Long> ids) {
        return myMapper.deleteBatchIds(ids);
    }
}
