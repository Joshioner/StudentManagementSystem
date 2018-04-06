package Dao;

import Entity.Admin;

/**
 * 管理员实体类接口
 */
public interface IAdmin {
    //登录
    Admin login(Admin admin) throws Exception;
}
