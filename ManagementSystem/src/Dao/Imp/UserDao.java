package Dao.Imp;

import Dao.IUser;
import Entity.PageBean;
import Entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 分页查询所有用户
     */
    @Override
    public List<User> getAll(PageBean<User> pageBean) throws Exception{
       //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //查询总记录数，更新到pageBean对象中
        int totalCount = getAllCount();
        //更新pageBean总记录数
         pageBean.setTotalCount(totalCount);
         /*
		 * 问题： jsp页面，如果当前页为首页，再点击上一页报错！
		 *              如果当前页为末页，再点下一页显示有问题！
		 * 解决：
		 * 	   1. 如果当前页 <= 0;       当前页设置当前页为1;
		 * 	   2. 如果当前页 > 最大页数；  当前页设置为最大页数
		 */
         //判断当前页数
        if (pageBean.getCurrentPage() <= 0)
        {
            pageBean.setCurrentPage(1);  //把当前页数设置为1
        }else if (pageBean.getCurrentPage() > pageBean.getTotalPage())
        {
            pageBean.setCurrentPage(pageBean.getTotalPage()); //把当前页数设置为最大页数
        }
        //获取当前页
        int currentPage = pageBean.getCurrentPage();
        //设置查询的起始行
        int pstart = pageBean.getPageCount() * (currentPage - 1);
        //查询的行数
        int pindex= pageBean.getPageCount();
        //将起始行和行数防止到map中，进行mybatis分页查询
        Map<Object,Object> map = new HashMap<>();
        map.put("pstart",pstart);
        map.put("pindex",pindex);
        //执行查询操作
        List<User> userList = sqlSession.selectList("userNamespace.getAll",map);
        //设置查询结果到pageBean对象中
        pageBean.setPageData(userList);
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

    /**
     * 查找总记录数
     * @return
     * @throws Exception
     */
    @Override
    public int getAllCount() throws Exception {
        //创建sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行查询语句,获取总记录数
        int totalCount = sqlSession.selectOne("userNamespace.getAllCount");
        //关闭资源
        sqlSession.close();
        return totalCount;
    }
}
