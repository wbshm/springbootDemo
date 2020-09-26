<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: wangrq
  Date: 2020/9/19
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         pageEncoding="UTF-8" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%! private String name = "test";%>
<%! private static HashMap<String, Integer> map;

    static {
        map = new HashMap<>();
        map.put("k1", 1);
        map.put("k2", 2);
        map.put("k3", 3);
    }
%>
<%=map %>

</body>
</html>
