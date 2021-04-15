package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.entity.Brand;
import com.bing.guo.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("brand")
public class BrandController extends BaseController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public AxiosResult<List<Brand>> findAll() {
        return AxiosResult.success(brandService.list());
    }
}
