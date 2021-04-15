package com.bing.guo.service.impl;

import com.bing.guo.domain.entity.Brand;
import com.bing.guo.service.BrandService;
import com.bing.guo.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {
}
