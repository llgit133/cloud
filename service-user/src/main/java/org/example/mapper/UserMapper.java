package org.example.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.pojo.User;

@Mapper
public interface UserMapper {
    @Select("select * from DB_USER where uid = #{uid}")
    User getUserById(int uid);
}
