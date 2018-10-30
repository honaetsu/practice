<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインしました</title>
</head>
<body>
      <p><c:out value="${sessionScope.accountB.name}"/>さん</p>
      <p><a href="Logout">ログアウト</a></p>
      <p><a href="index.html">Topへもどる</a></p>

<p>ログインできました</p>
<p><a href="/Search">商品検索</a></p>
<p>商品一覧</p>
<form action="post">
<p><imput type="text">検索キーワード</p>
</form>

<table>
<tr><td>商品</td><td>商品名</td><td>金額</td></tr>
<tr><td></td><td>商品名</td><td>金額</td></tr>

</table>
</body>
</html>