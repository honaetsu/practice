<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインしました</title>
<link href="CSS/account.css" rel="stylesheet" type="text/css">
<style type="text/css">
header {
	background-image: none;
	height: 80px;
}
th, td {
	padding: 8px;
	border: solid 1px;
}
table {
	border-collapse: collapse;
	table-layout: auto;
	margin-left: auto;
	margin-right: auto;
	width: 80%;
}
</style>
</head>
<body>
    <header>
  <h1>商品検索ページ</h1>
  <p>
    <!--セッションにアカウント情報が保管されている  -->
    <c:out value="${sessionScope.accountB.name}" />
    さんのページ
    </p>
    </header>
	<nav><ul>
		<li><a href="Search">商品表示</a></li>
		<li><a href="Logout">ログアウト</a></li>
		<li><a href="index.html">Topへもどる</a></li>
	</ul></nav>
    <section>
      <h2>商品検索</h2>
      <form method="post" action="Search">
        <dl>
          <dt>検索キーワード</dt>
          <dd>
            <input type="text" name="kyeword">
            </dd>
          
          </dl>
        <p>
          <input type="reset" value="リセット"> <input type="submit"
				value="検索">
          </p>
        </form>
      <span><c:out value="${requestScope.msg}"></c:out></span>
      <table>
        
        <c:forEach var="goods" items="${requestScope.glist}" >
          <tr>
            <td><td><img src="img/<c:out value="${goods.gId}"/>.jpg"></td>
            <td>商品<c:out value="${goods.gName}"/></td>
            <td>金額<c:out value="${goods.gPraice}"/></td>
            <td>商品内容<c:out value="${goods.gContents}"/></td>
            </tr>
          </c:forEach>
        </table>
    </section>
	<footer>
			<small>Copyright(c)2018 honaetsu,All rights reserved.lol</small>
		</footer>
</body>
</html>