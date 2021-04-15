package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.entity.Category;
import com.bing.guo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController extends BaseController {
    @Autowired
    private CategoryService CategoryService;

    @GetMapping
    public AxiosResult<List<Category>> findAll() {
        return AxiosResult.success(CategoryService.list());
    }

    @GetMapping("{id}")
    public AxiosResult<Category> findById(@PathVariable Long id) {
        return AxiosResult.success(CategoryService.getById(id));
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Category Category) {
        int row = CategoryService.insert(Category);
        return toCompare(row);
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Category Category) {
        int row = CategoryService.update(Category);
        return toCompare(row);
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        int row = CategoryService.deleteById(id);
        return toCompare(row);
    }
}
