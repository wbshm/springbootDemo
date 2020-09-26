package com.local.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName PrintHtml
 * @Description TODO
 * @Author wangrq
 * @Date 2020/9/19 15:27
 */
public class PrintHtml extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<html>\n");
        writer.write("  <head>\n");
        writer.write("    <title>nihao</title>\n");
        writer.write("  </head>\n");
        writer.write("  <body>\n");
        writer.write("  body\n");
        writer.write("  </body>\n");
        writer.write("</html>");

    }
}
