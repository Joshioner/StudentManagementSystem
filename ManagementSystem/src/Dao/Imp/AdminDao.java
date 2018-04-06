package Dao.Imp;

import Dao.IAdmin;
import Entity.Admin;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


/**
 *管理员接口实现类
 */
public class AdminDao implements IAdmin {


    private SqlSessionFactory sqlSessionFactory ;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 管理员登录
     * @param admin
     */
    @Override
    public Admin login(Admin admin) throws Exception{
//        Reader reader = Resources.getResourceAsReader("MyBatis.xml");
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询步骤
        Admin admin1 =  sqlSession.selectOne("adminNamespace.login",admin);
        //关闭资源
        sqlSession.close();
        return admin1;
    }

//    public static void main(String[] args) throws Exception {
//        AdminDao adminDao = new AdminDao();
//        Admin admin = new Admin();
//        admin.setName("aa");
//        admin.setPwd("aa");
//        adminDao.login(admin);
//    }
}
