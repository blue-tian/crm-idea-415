package com.bing.guo.service;

import com.bing.guo.domain.criteria.BrandCriteria;
import com.bing.guo.domain.entity.Brand;
import com.bing.guo.domain.vo.BrandVo;
import com.bing.guo.service.base.BaseService;

import java.util.List;


public interface BrandService extends BaseService<Brand> {
    List<Brand> searchPage(BrandCriteria brandCriteria);
}


