package org.example.usermanagebackend.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.usermanagebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.example.usermanagebackend.entity.User;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ApiOperation(value = "测试接口", notes = "测试接口")
    @GetMapping(value = "/test")
    public String getUserSearchResult() {
        return "hello";
    }

    @ApiOperation(value = "获取用户名搜索结果", notes = "获取用户名搜索结果")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数目", paramType = "query", required = true, dataType = "int"),
            @ApiImplicitParam(name = "searchContent", value = "搜索内容", paramType = "query", dataType = "string"),
    })
    @GetMapping(value = "/getUserSearchResult")
    public Map<String, Object> getUserSearchResult(
            @RequestParam(value = "pageNum", required = true) Integer pageNum,
            @RequestParam(value = "pageSize", required = true) Integer pageSize,
            @RequestParam(value = "searchContent", defaultValue = "") String searchContent) {
        return userService.getUserSearchResult(pageNum, pageSize, searchContent);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @DeleteMapping(value = "/deleteUser")
    public boolean deleteUser(@ApiParam(value = "用户id列表", required = true) @RequestBody List<Integer> idList){
        return userService.deleteUser(idList);
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @PostMapping(value = "/addUser")
    public boolean addUser(@ApiParam(value = "用户", required = true) @RequestBody User user){
        return userService.addUser(user);
    }
    @ApiOperation(value = "编辑用户", notes = "编辑用户")
    @PostMapping(value = "/updateUser")
    public boolean updateUser(@ApiParam(value = "用户", required = true) @RequestBody User user){
        return userService.updateUser(user);
    }

}
