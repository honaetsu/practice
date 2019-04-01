<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー詳細登録画面</title>
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
		<h1>ユーザー詳細登録画面</h1>
	</header>
	<nav>
		<ul>
			<li><a href="index.html">Topへもどる</a></li>
		</ul>
	</nav>
	<section>
		<h2>ユーザー登録</h2>
		<form method="post" action="">
			<table>
				<!--reqから名前表示  -->
				<tr>
					<td>ID</td>
					<td><input type="text" name="pId"  value="<c:out
							value="${requestScope.pId}" />"> </td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><input type="text" name="pass"></td>
				</tr>
				<tr>
					<td>氏名</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>メールアドレス</td>
					<td><input type="text" name="mail"></td>
				</tr>
				<tr>
					<td>年齢</td>
					<td><input type="text" name="age"></td>
				</tr>

			</table>
			<p>
				<input type="reset" value="リセット"> <input type="submit"
					value="登録">
			</p>

		</form>
		<p>
			<c:out value="${sessionScope.accountB.name}" />
		</p>
	</section>
	<footer>
		<small>Copyright(c)2018 honaetsu,All rights reserved.lol</small>
	</footer>
</body>
</html>