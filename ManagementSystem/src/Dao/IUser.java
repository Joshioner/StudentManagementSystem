package Dao;

import Entity.PageBean;
import Entity.User;

import java.util.List;

/**
 * 用户实体类接口
 */
public interface IUser {
    //添加用户
    void add(User user) throws Exception;
    //删除用户
    void deleteById(int id) throws Exception;
    //修改用户
    void update(User user) throws Exception;
    //查找所有用户
    List<User> getAll(PageBean<User> pageBean) throws Exception;
    //根据用户id查找
    User findById(int id)throws Exception;
    //查找总记录数
    int getAllCount() throws Exception;

}
