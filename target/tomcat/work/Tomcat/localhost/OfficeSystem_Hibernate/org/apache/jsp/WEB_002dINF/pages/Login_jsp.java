/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2024-05-02 00:21:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <title>ログイン画面</title>\r\n");
      out.write("    <script\r\n");
      out.write("      src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/js/jquery-1.10.2.min.js\"\r\n");
      out.write("      type=\"text/javascript\"\r\n");
      out.write("    ></script>\r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("      . {\r\n");
      out.write("      }\r\n");
      out.write("      .LABEL {\r\n");
      out.write("        color: red;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        display: block;\r\n");
      out.write("        text-align: center;\r\n");
      out.write("      }\r\n");
      out.write("      .CONTAINER {\r\n");
      out.write("        width: 250px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        margin-bottom: 5px;\r\n");
      out.write("      }\r\n");
      out.write("      .TEXTBOX {\r\n");
      out.write("        width: 250px;\r\n");
      out.write("        height: 30px;\r\n");
      out.write("        margin-bottom: 5px;\r\n");
      out.write("      }\r\n");
      out.write("      .LEFT {\r\n");
      out.write("        float: left;\r\n");
      out.write("      }\r\n");
      out.write("      .RIGHT {\r\n");
      out.write("        float: right;\r\n");
      out.write("      }\r\n");
      out.write("      .BUTTON {\r\n");
      out.write("        width: 250px;\r\n");
      out.write("      }\r\n");
      out.write("      .TEXTAREA {\r\n");
      out.write("        width: 500px;\r\n");
      out.write("        height: 200px;\r\n");
      out.write("        margin: 0 auto;\r\n");
      out.write("        display: block;\r\n");
      out.write("        resize: none;\r\n");
      out.write("        clear: both;\r\n");
      out.write("      }\r\n");
      out.write("    </style>\r\n");
      out.write("    <script type=\"text/ecmascript\">\r\n");
      out.write("      function CheckNull() {\r\n");
      out.write("       var userid = document.getElementById(\"userId\");\r\n");
      out.write("       var pass = document.getElementById(\"password\");\r\n");
      out.write("       var email = document.getElementById(\"email\");\r\n");
      out.write("       if (userid.value == \"\") {\r\n");
      out.write("        alert(\"ユーザーIDを入力してください\");\r\n");
      out.write("        return false;\r\n");
      out.write("       }\r\n");
      out.write("       if (pass.value == \"\") {\r\n");
      out.write("        alert(\"パスワードを入力してください\");\r\n");
      out.write("        return false;\r\n");
      out.write("       }\r\n");
      out.write("       if (email.value == \"\") {\r\n");
      out.write("        alert(\"メールアドレスを入力してください\");\r\n");
      out.write("        return false;\r\n");
      out.write("       }\r\n");
      out.write("      }\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("    <form method=\"post\" action=\"/OfficeSystem/Login\">\r\n");
      out.write("      <label class=\"LABEL\"> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${error}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write(" </label>\r\n");
      out.write("      <div class=\"CONTAINER\">\r\n");
      out.write("        <input\r\n");
      out.write("          type=\"text\"\r\n");
      out.write("          class=\"TEXTBOX\"\r\n");
      out.write("          id=\"userId\"\r\n");
      out.write("          name=\"userId\"\r\n");
      out.write("          placeholder=\"ユーザーID\"\r\n");
      out.write("        />\r\n");
      out.write("        <input\r\n");
      out.write("          type=\"password\"\r\n");
      out.write("          class=\"TEXTBOX\"\r\n");
      out.write("          id=\"password\"\r\n");
      out.write("          name=\"password\"\r\n");
      out.write("          placeholder=\"パスワード\"\r\n");
      out.write("        />\r\n");
      out.write("        <input\r\n");
      out.write("          type=\"text\"\r\n");
      out.write("          class=\"TEXTBOX\"\r\n");
      out.write("          id=\"email\"\r\n");
      out.write("          name=\"email\"\r\n");
      out.write("          placeholder=\"メールアドレス\"\r\n");
      out.write("        />\r\n");
      out.write("        <input type=\"button\" class=\"BUTTON\" value=\"ログイン\" />\r\n");
      out.write("        <a href=\"\" class=\"LEFT\">パスワード忘れ</a>\r\n");
      out.write("        <a href=\"\" class=\"RIGHT\">新規登録</a>\r\n");
      out.write("      </div>\r\n");
      out.write("    </form>\r\n");
      out.write("    <textarea class=\"TEXTAREA\">お知らせ</textarea>\r\n");
      out.write("    <script type=\"text/ecmascript\">\r\n");
      out.write("      $(\".BUTTON\").click(function () {\r\n");
      out.write("       if ($(\"#userId\").val() == \"\") {\r\n");
      out.write("        alert(\"ユーザーIDを入力してください\");\r\n");
      out.write("        return false;\r\n");
      out.write("       }\r\n");
      out.write("       if ($(\"#password\").val() == \"\") {\r\n");
      out.write("        alert(\"パスワードを入力してください\");\r\n");
      out.write("        return false;\r\n");
      out.write("       }\r\n");
      out.write("       if ($(\"#email\").val() == \"\") {\r\n");
      out.write("        alert(\"メールアドレスを入力してください\");\r\n");
      out.write("        return false;\r\n");
      out.write("       }\r\n");
      out.write("\r\n");
      out.write("       $.ajax({\r\n");
      out.write("        url: \"/OfficeSystem/Login\",\r\n");
      out.write("        type: \"post\",\r\n");
      out.write("        data:{userId:$(\"#userId\").val(), password: $(\"#password\").val(),email: $(\"#email\").val()},\r\n");
      out.write("        success: function (data) {\r\n");
      out.write("\r\n");
      out.write("            console.log(data);\r\n");
      out.write("\r\n");
      out.write("         if (data == \"\") {\r\n");
      out.write("          window.location.href = \"next\";\r\n");
      out.write("         }\r\n");
      out.write("         else {\r\n");
      out.write("          alert(data);\r\n");
      out.write("         }\r\n");
      out.write("        },\r\n");
      out.write("        error: function () {\r\n");
      out.write("         alert(\"システムエラーが発生しました\");\r\n");
      out.write("        }\r\n");
      out.write("       });\r\n");
      out.write("      });\r\n");
      out.write("    </script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
