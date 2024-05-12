package com.lee.springbootworkspaceblogger.util.tag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Map;


public class ListCategoryTag extends SimpleTagSupport {
    private String id ;
    private Map<String, String> kind;
    public void setId(String id){this.id = id;}
    public void setKind(Map<String, String> kind){this.kind = kind;}

    @Override
    public void doTag() throws JspException, IOException {

        System.out.println("id: " +this.id + " map size:" +this.kind.size());

        for (int i = 0; i < 10; i++) {
            getJspContext().setAttribute("msg", "第一列"+i + "   ");
            getJspContext().setAttribute("counts", "第二列:"+i);
            getJspBody().invoke(null);
        }
    }
}
