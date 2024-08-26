package org.example.usermanagebackend.service;

import org.example.usermanagebackend.entity.User;
import org.example.usermanagebackend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public Map<String, Object> getUserSearchResult(Integer pageNum, Integer pageSize, String searchContent) {
        Map<String, Object> result = new HashMap<>();
        pageNum = pageSize * (pageNum - 1);
        List<User> users = userMapper.getUserSearchResult(pageNum, pageSize, searchContent);
        int sum = userMapper.getUserNum(searchContent);
        result.put("users", users);
        result.put("sum", sum);
        return result;
    }
    @Override
    public boolean deleteUser(List<Integer> idList) {
        System.out.println(idList);
        if(idList == null || idList.size() == 0) {
            return true;
        } else {
            try{
                for(int i = 0; i < idList.size(); i++){
                    userMapper.deleteUser(idList.get(i));
                }
                return true;
            }catch(Exception e){
                System.out.println(e);
                return false;
            }
        }
    }

    @Override
    public boolean addUser(User user) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        user.setCreateTime(time);
        try {
            System.out.println(user);
            userMapper.addUser(user);
            return true;
        } catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }


    @Override
    public boolean updateUser(User user) {
        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        user.setUpdateTime(time);
        try {
            System.out.println(user);
            userMapper.updateUser(user);
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
