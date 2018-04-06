package Dao.Imp;

import Dao.IUser;
import Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * 用户数据访问层接口实现类
 */
public class UserDao implements IUser {
    //利用spring进行对象注入
    private SqlSessionFactory sqlSessionFactory;

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 添加用户
     * @param user
     */
    @Override
    public void add(User user) throws Exception{
       //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        sqlSession.insert("userNamespace.add", user);
        //关闭资源
        sqlSession.close();
    }

    /**
     * 根据用户id进行删除
     * @param id
     */
    @Override
    public void deleteById(int id)throws Exception {
        //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行删除操作
        sqlSession.delete("userNamespace.deleteById",id);
        //关闭资源
        sqlSession.close();
    }

    /**
     * 更新用户数据
     * @param user
     */
    @Override
    public void update(User user) throws Exception{
      //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行更新操作
        sqlSession.update("userNamespace.update",user);
        //关闭资源
        sqlSession.close();

    }

    /**
     * 查询所有用户
     */
    @Override
    public List<User> getAll() throws Exception{
       //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询操作
        List<User> userList = sqlSession.selectList("userNamespace.getAll");
        return userList;
    }

    /**
     * 根据用户id查找
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public User findById(int id) throws Exception {
        //创建sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
       User  user =  sqlSession.selectOne("userNamespace.findById",id);
        //关闭资源
        sqlSession.close();
        //返回数据
        return user;
    }
}
