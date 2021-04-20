package com.bing.guo.domain.criteria;

import com.bing.guo.domain.criteria.base.BaseQueryCriteria;
import lombok.Data;

@Data
public class BrandCriteria extends BaseQueryCriteria {

    private String brandName;
}
