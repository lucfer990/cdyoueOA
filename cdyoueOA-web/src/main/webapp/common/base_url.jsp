<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = "";
    if (request.getServerPort() == 80) {
        basePath = request.getScheme() + "://" + request.getServerName() + path;
    } else {
        basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    }
    request.setAttribute("basePath", basePath);
    if (!"/WEB-INF/page/login.jsp".equals(request.getServletPath()) && session.getAttribute("user") == null) {
        response.sendRedirect(basePath + "/loginPage.do");
    }
%>
<script type="text/javascript">
    var basePath = "${basePath}";
</script>
