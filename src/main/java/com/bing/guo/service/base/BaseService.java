package com.bing.guo.service.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;

import java.util.List;

public interface BaseService<T> {

    /**
     * 查询所有
     * @return
     */
    List<T> list();

    /**
     * 通过条件查询
     * @param wrapper
     * @return
     */
    List<T> search(Wrapper<T> wrapper);

    /**
     * 通过id查询
     * @param id
     * @return
     */
    T getById(Long id);

    /**
     * 添加
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 修改
     * @param t
     * @return
     */
    int update(T t);

    /**
     * id删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    int batchDeleteByIds(List<Long> ids);
}
