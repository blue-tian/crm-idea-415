package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.entity.Brand;
import com.bing.guo.service.BrandService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("brand")
@RequiredArgsConstructor
public class BrandController extends BaseController {
    //@RequiredArgsConstructor+final = @Autowired
    private final BrandService brandService;

    @GetMapping
    public AxiosResult<List<Brand>> findAll() {
        return AxiosResult.success(brandService.list());
    }

    @GetMapping("{id}")
    public AxiosResult<Brand> findById(@PathVariable Long id) {
        return AxiosResult.success(brandService.getById(id));
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Brand brand) {
        int row = brandService.insert(brand);
        return toCompare(row);
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Brand brand) {
        int row = brandService.update(brand);
        return toCompare(row);
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        int row = brandService.deleteById(id);
        return toCompare(row);
    }
}
