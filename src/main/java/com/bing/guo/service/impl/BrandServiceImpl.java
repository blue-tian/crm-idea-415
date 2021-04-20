package com.bing.guo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bing.guo.domain.criteria.BrandCriteria;
import com.bing.guo.domain.entity.Brand;
import com.bing.guo.domain.vo.BrandVo;
import com.bing.guo.mapper.BrandMapper;
import com.bing.guo.service.BrandService;
import com.bing.guo.service.base.impl.BaseServiceImpl;
import com.bing.guo.transfer.BrandTransfer;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BrandServiceImpl extends BaseServiceImpl<Brand> implements BrandService {

    private final BrandMapper brandMapper;

    /**
     * 分页条件查询
     *
     * @param brandCriteria
     * @return
     */
    @Override
    public List<Brand> searchPage(BrandCriteria brandCriteria) {
        PageHelper.startPage(brandCriteria.getCurrentPage(), brandCriteria.getPageSize());
        LambdaQueryWrapper<Brand> lambda = new QueryWrapper<Brand>().lambda();
        if (!StringUtils.isEmpty(brandCriteria.getBrandName())) {
            lambda.like(Brand::getBrandName, brandCriteria.getBrandName());
        }
        LocalDateTime startTime = brandCriteria.getStartTime();
        LocalDateTime endTime = brandCriteria.getEndTime();
        if (startTime != null && endTime != null) {
            lambda.between(Brand::getCreateTime, startTime, endTime);
        }
        List<Brand> brands = brandMapper.selectList(lambda);

        return brands;
    }


}
