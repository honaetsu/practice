<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログインしました</title>
</head>
<body>
	<p>
		<!--セッションにアカウント情報が保管されている  -->
		<c:out value="${sessionScope.accountB.name}" />
		さんのページ
	</p>
	<ul>
		<li><a href="Search">商品表示</a></li>
		<li><a href="Logout">ログアウト</a></li>
		<li><a href="index.html">Topへもどる</a></li>
	</ul>
	<p>商品検索</p>
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

	<table>
		<c:forEach var="goods" items="${requestScope.glist}" >
			<tr>
				<td>商品<c:out value="${goods.gName}"/></td>
				<td>金額<c:out value="${goods.gName}"/></td>
				<td>商品内容<c:out value="${goods.gContents}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>