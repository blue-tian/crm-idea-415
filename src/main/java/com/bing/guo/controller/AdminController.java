package com.bing.guo.controller;

import com.bing.guo.common.http.AxiosResult;
import com.bing.guo.controller.base.BaseController;
import com.bing.guo.domain.entity.Admin;
import com.bing.guo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController extends BaseController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public AxiosResult<List<Admin>> findAll() {
        return AxiosResult.success(adminService.list());
    }

    @GetMapping("{id}")
    public AxiosResult<Admin> findById(@PathVariable Long id) {
        return AxiosResult.success(adminService.getById(id));
    }

    @PostMapping
    public AxiosResult<Void> add(@RequestBody Admin admin) {
        int row = adminService.insert(admin);
        return toCompare(row);
    }

    @PutMapping
    public AxiosResult<Void> update(@RequestBody Admin admin) {
        int row = adminService.update(admin);
        return toCompare(row);
    }

    @DeleteMapping("{id}")
    public AxiosResult<Void> delete(@PathVariable Long id) {
        int row = adminService.deleteById(id);
        return toCompare(row);
    }
}
