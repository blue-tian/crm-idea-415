package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.entity.Good;
import com.bing.guo.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("good")
public class GoodController extends BaseController {
    @Autowired
    private GoodService goodService;

    @GetMapping
    public AxiosResult<List<Good>> findAll() {
        return AxiosResult.success(goodService.list());
    }

    @GetMapping("{id}")
    public AxiosResult<Good> findById(@PathVariable Long id) {
        return AxiosResult.success(goodService.getById(id));
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Good Good) {
        int row = goodService.insert(Good);
        return toCompare(row);
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Good Good) {
        int row = goodService.update(Good);
        return toCompare(row);
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        int row = goodService.deleteById(id);
        return toCompare(row);
    }
}
