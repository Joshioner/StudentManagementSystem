package Service;

import Dao.IAdmin;
import Dao.Imp.AdminDao;
import Entity.Admin;

/**
 * 管理员业务处理方法
 */

public class AdminService {
    private IAdmin adminDao;

    public void setAdminDao(IAdmin adminDao) {
        this.adminDao = adminDao;
    }

    /**
     * 登录页面
     * @param admin
     */
    public Admin login(Admin admin) throws Exception {
      return   adminDao.login(admin);
    }
}
