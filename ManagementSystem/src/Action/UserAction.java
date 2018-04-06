package Action;

import Entity.PageBean;
import Entity.User;
import Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户控制层
 */
@RequestMapping("/user")
@Controller
public class UserAction {
    private UserService service;

    @Resource(name = "userService")
    public void setService(UserService service) {
        this.service = service;
    }

    /**
     * 添加用户方法
     * @param user
     * @return
     */
    @RequestMapping("/add")
    public String add(User user)
    {
        try {
            service.add(user);
            return "redirect:/user/getAll.action";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
           // return "/error/error.jsp";
        }
    }

    /**
     * 查询所有用户,
     * @param currentPage:接收当前的页数
     */
    @RequestMapping("getAll")
    public String getAll(Model model,Integer currentPage)
    {
        try {
            if (currentPage == null)
                currentPage = 1;
            PageBean pageBean = new PageBean();
            //将当前页数封装到pageBean对象中
            pageBean.setCurrentPage(currentPage);
           service.getAll(pageBean);
           //将pageBean封装到域对象中
           model.addAttribute("pageBean",pageBean);
           return "/jsp/list.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据用户id删除
     * @param id
     * @return
     */
    @RequestMapping("deleteById")
    public String deleteById(int id)
    {
        try {
            System.out.println(id);
            service.deleteById(id);
            return "redirect:/user/getAll.action";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据用户id查找，封装数据，跳转到更新页面
     */
    @RequestMapping("update")
    public String update(int id,Model model)
    {
        try {
            //根据id查找
          User user = service.findById(id);
          //封装数据，数据回显
            model.addAttribute("userInfo",user);
            return "forward:/jsp/update.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 保存更新数据
     * @param user
     * @return
     */
    @RequestMapping("saveUpdate")
    public String saveUpdate(User user)
    {
        try {
            service.update(user);
            //重定向到用户列表页面
            return "redirect:/user/getAll.action";
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
