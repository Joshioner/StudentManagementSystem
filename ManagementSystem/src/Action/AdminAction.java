package Action;

import Entity.Admin;
import Service.AdminService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    private AdminService service;

    @Resource(name = "adminService")
    public void setService(AdminService service) {
        this.service = service;
    }

    @RequestMapping("/login")
    public String login(Admin admin, Model model, HttpSession session)
    {
        try {
              Admin adminInfo = service.login(admin);
            session.setAttribute("adminInfo",adminInfo);
            return "redirect:/user/getAll.action";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //创建sqlsession对象
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //执行查询步骤
//        sqlSession.selectOne("adminNamespace.login",admin);
//        //关闭资源
//        sqlSession.close();
//        model.addAttribute("message","成功");
//            return "/jsp/success.jsp";
    }
}
