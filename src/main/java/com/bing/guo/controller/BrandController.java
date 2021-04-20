package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.common.page.PageResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.criteria.BrandCriteria;
import com.bing.guo.domain.entity.Brand;
import com.bing.guo.domain.vo.BrandVo;
import com.bing.guo.service.BrandService;
import com.bing.guo.transfer.BrandTransfer;
import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("brand")
@RequiredArgsConstructor
public class BrandController extends BaseController {
    //@RequiredArgsConstructor+final = @Autowired
    private final BrandService brandService;
    private final BrandTransfer brandTransfer;

    /*@GetMapping
    public AxiosResult<PageResult<Brand>> findAll(int currentPage,int pageSize) {
        //分页
        PageHelper.startPage(currentPage, pageSize);
        List<Brand> list = brandService.list();
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        return AxiosResult.success(new PageResult<Brand>(pageInfo.getTotal(),list));
    }*/

    @GetMapping
    public AxiosResult<PageResult<BrandVo>> findAll(BrandCriteria brandCriteria) {
        List<Brand> list = brandService.searchPage(brandCriteria);
        PageInfo<Brand> pageInfo = new PageInfo<>(list);
        List<BrandVo> brandVos = brandTransfer.toVos(list);
        return AxiosResult.success(new PageResult<>(pageInfo.getTotal(),brandVos));
    }

    @GetMapping("{id}")
    public AxiosResult<Brand> findById(@PathVariable Long id) {
        return AxiosResult.success(brandService.getById(id));
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Brand brand) {
        System.out.println(brand);
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
    @DeleteMapping("batch/{ids}")
    public AxiosResult<Void> batchDelete(@PathVariable List<Long> ids) {
       int row = brandService.batchDeleteByIds(ids);
       return toCompare(row);
    }
}
