package Service;

import Dao.IUser;
import Entity.PageBean;
import Entity.User;

import java.util.List;

/**
 * 用户业务处理方法
 */
public class UserService {
    //利用spring的ioc创建对象
    private IUser userDao;

    public void setUserDao(IUser userDao) {
        this.userDao = userDao;
    }

    /**
     * 添加用户
     * @param user
     * @throws Exception
     */
    public void add(User user) throws Exception {
        userDao.add(user);
    }

    /**
     * 查询所有用户
     * @return
     */
    public List<User> getAll(PageBean<User> pageBean) throws Exception {
       return userDao.getAll(pageBean);
    }

    /**
     * 根据用户id删除
     * @param id
     */
    public void deleteById(int id) throws Exception {
        userDao.deleteById(id);
    }

    /**
     * 根据用户id查找
     * @param id
     * @return
     * @throws Exception
     */
    public User findById(int id) throws Exception {
        return userDao.findById(id);
    }
    /**
     * 更新用户数据
     */
    public void update(User user) throws Exception {
        userDao.update(user);
    }
}
