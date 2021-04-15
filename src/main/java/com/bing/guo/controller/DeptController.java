package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.entity.Dept;
import com.bing.guo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dept")
public class DeptController extends BaseController {
    @Autowired
    private DeptService deptService;

    @GetMapping
    public AxiosResult<List<Dept>> findAll() {
        return AxiosResult.success(deptService.list());
    }

    @GetMapping("{id}")
    public AxiosResult<Dept> findById(@PathVariable Long id) {
        return AxiosResult.success(deptService.getById(id));
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Dept dept) {
        int row = deptService.insert(dept);
        return toCompare(row);
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Dept dept) {
        int row = deptService.update(dept);
        return toCompare(row);
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        int row = deptService.deleteById(id);
        return toCompare(row);
    }
}
