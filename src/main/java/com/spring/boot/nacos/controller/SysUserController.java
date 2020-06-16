package com.spring.boot.nacos.controller;
import com.spring.boot.nacos.common.core.Result;
import com.spring.boot.nacos.common.core.ResultGenerator;
import com.spring.boot.nacos.model.SysUser;
import com.spring.boot.nacos.service.SysUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: YUEXIN
 * @Date: 2020-06-12 17:06:54
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {
    @Resource
    private SysUserService sysUserService;

    @PostMapping("/add")
    public Result add(@RequestBody SysUser sysUser) {
        sysUserService.insert(sysUser);
        return ResultGenerator.success();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        sysUserService.deleteById(id);
        return ResultGenerator.success();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SysUser sysUser) {
        sysUserService.update(sysUser);
        return ResultGenerator.success();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SysUser sysUser = sysUserService.findById(id);
        return ResultGenerator.success(sysUser);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<SysUser> list = sysUserService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.success(pageInfo);
    }

    @PostMapping("/select")
    public Result list(@RequestBody SysUser sysUser) {
        List<SysUser> list = sysUserService.find(sysUser);
        return ResultGenerator.success(list);
    }
}
