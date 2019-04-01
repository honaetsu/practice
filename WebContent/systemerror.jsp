<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>システムエラーページ</title>
</head>
<body>
  <!--エラーメッセージをここで表示予定 -->
     <p> <c:out value="${requestScope.error}"/></p>
      <p><a href="index.html">Topへもどる</a></p>
</body>
</html>