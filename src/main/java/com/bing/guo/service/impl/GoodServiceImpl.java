package com.bing.guo.service.impl;

import com.bing.guo.domain.entity.Good;
import com.bing.guo.service.GoodService;
import com.bing.guo.service.base.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodServiceImpl extends BaseServiceImpl<Good> implements GoodService {
}
