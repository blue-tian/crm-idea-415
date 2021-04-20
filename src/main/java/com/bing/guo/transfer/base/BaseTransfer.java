package com.bing.guo.transfer.base;

import java.util.List;

public interface BaseTransfer<T,Vo> {
    /**
     * T转Vo
     */
    Vo toVo(T t);

    /**
     * Vo转T
     */
    T toT(Vo vo);

    /**
     * T转Vo
     */
    List<Vo> toVos(List<T> ts);

    /**
     * Vo转T
     */
    List<T> toTs(List<Vo> vos);
}
