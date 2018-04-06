package Entity;

import java.util.List;

/**
 * 设置分页的一个javaBean，使用泛型
 * @param <T>
 */
public class PageBean<T> {
    private int currentPage = 1; //当前页数，默认显示第一页
    private int pageCount = 5 ;  //每页显示的行数，默认显示为5行
    private int totalPage;      //总页数 = 总记录数/每页显示的行数（+1）
    private int totalCount;    //总记录数
    private List<T> pageData;  //每页查询到的数据

    /**
     *   总页数 = 总记录数/每页显示的行数（+1）
     * @return
     */
    public int getTotalPage() {
        //总记录数刚好布满每页，没有剩余
        if (totalCount%pageCount == 0)
            totalPage = totalCount/pageCount;
        else
            totalPage = totalCount/pageCount + 1;
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }



    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }




    public List<T> getPageData() {
        return pageData;
    }

    public void setPageData(List<T> pageData) {
        this.pageData = pageData;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
