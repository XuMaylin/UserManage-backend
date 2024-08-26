package org.example.usermanagebackend.service;

import org.example.usermanagebackend.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, Object> getUserSearchResult(Integer pageNum, Integer pageSize, String searchContent);

    boolean deleteUser(List<Integer> idList);
    boolean addUser(User user);

    boolean updateUser(User user);
}
