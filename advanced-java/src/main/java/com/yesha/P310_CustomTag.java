/*
Objective:
Custom JSP Tag : Develop a simple custom JSP tag to display formatted information
on a JSP page.
 */

package com.yesha;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class P310_CustomTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        // retrieves the jsp output writer
        JspWriter out = getJspContext().getOut();

        // generates custom html formatted text
        out.println("<div style='border:2px solid blue; padding:10px;'>");
        out.println("<h3>custom tag generates this formatted box!</h3>");
        out.println("</div>");
    }
}

// output at http://localhost:8080/P310_TestTag.jsp after running P310_TestTag.jsp