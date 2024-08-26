package org.example.usermanagebackend.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.example.usermanagebackend.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
public interface UserMapper extends BaseMapper<User>{
    @Select("SELECT * FROM user WHERE #{searchContent}='' OR userName REGEXP #{searchContent} ORDER BY userId DESC LIMIT #{pageNum}, #{pageSize}")
    List<User> getUserSearchResult(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize, @Param("searchContent") String searchContent);

    @Select("SELECT count(*) FROM user WHERE #{searchContent}='' OR userName REGEXP #{searchContent}")
    int getUserNum(String searchContent);

    @Delete("DELETE FROM user WHERE userId = #{id}")
    boolean deleteUser(Integer id);
    @Insert("INSERT INTO user (userName,password,createTime,updateTime) VALUES (#{userName}, #{password}, #{createTime}, #{updateTime})")
    void addUser(User user);
    @Update("UPDATE user SET userName=#{userName},password=#{password},updateTime=#{updateTime} WHERE userId=#{userId}")
    void updateUser(User user);
}
