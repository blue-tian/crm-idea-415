package com.bing.guo.transfer.base.impl;

import com.bing.guo.transfer.base.BaseTransfer;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class BaseTransferImpl<T, Vo> implements BaseTransfer<T, Vo> {

    private Class<T> classT;

    private Class<Vo> classVo;

    public BaseTransferImpl() {
        Type types = this.getClass().getGenericSuperclass();
        Type[] genericType = ((ParameterizedType) types).getActualTypeArguments();
        classT = (Class<T>) genericType[0];
        classVo = (Class<Vo>) genericType[1];

    }

    @Override
    public Vo toVo(T t) {
        try {
            Vo vo = classVo.newInstance();
            BeanUtils.copyProperties(t, vo);
            return vo;
        } catch (Exception e) {
            log.error("toVo转换错误", t);
        }
        return null;
    }

    @Override
    public T toT(Vo vo) {
        try {
            T t = classT.newInstance();
            BeanUtils.copyProperties(vo, t);
            return t;
        } catch (Exception e) {
            log.error("toT转换错误", vo);
        }
        return null;
    }

    @Override
    public List<Vo> toVos(List<T> ts) {
        List<Vo> vos = new ArrayList<>();
        ts.forEach(t -> {
            vos.add(toVo(t));
        });
        return vos;
    }

    @Override
    public List<T> toTs(List<Vo> vos) {
        List<T> ts = new ArrayList<>();
        vos.forEach(vo -> {
            ts.add(toT(vo));
        });
        return ts;
    }
}
