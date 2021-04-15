package com.bing.guo.service.impl;

import com.bing.guo.domain.entity.Admin;
import com.bing.guo.domain.entity.Brand;
import com.bing.guo.service.AdminService;
import com.bing.guo.service.BrandService;
import com.bing.guo.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
}
