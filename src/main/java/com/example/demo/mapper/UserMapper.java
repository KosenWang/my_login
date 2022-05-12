package com.example.demo.mapper;


import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;


@Mapper
public interface UserMapper {
    //查询，可以实现登录功能
  @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password}")
  public User getInfo(@Param("username") String username, @Param("password") String password);

  //多个参数要加@Param修饰
  //增加，可以实现注册功能
  @Insert("insert into user(username,password) values(#{username},#{password})")
  public void saveInfo(@Param("username") String username, @Param("password") String password);
}
