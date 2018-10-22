<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メニュー画面ですよ</title>
<link href="CSS/account.css" rel="stylesheet" type="text/css">
<style type="text/css">
section {
	background-color: #FFFBDA;
	overflow: hidden;
}

#formD {
	padding-top: 8px;
	padding-left: 24px;
	padding-bottom: 8px;
	width: 70％;
	float: left;
}

dl {
	padding-bottom: 1em;
}

.formDright {
	width: 80%;
	text-align: center;
	padding-right: 18px;
}
</style>
</head>
<body>
	<div id="contener">
		<header>
			<h1>Accountテストシステム</h1>
			<p>ログイン画面</p>
		</header>
		<nav>
			<ul>
				<li><a href="index.html">ホーム</a></li>
				<li><a href="#">ユーザー登録</a></li>
			</ul>
		</nav>
		<section>
			<form method="post" action="Login">
				<h2>ログイン画面</h2>
				<div id="formD">
					<dl>
						<dt>ログインＩＤを入力</dt>
						<dd>
							<input type="text" name="pId">
						</dd>
						<dt>ログインパスワードを入力</dt>
						<dd>
							<input type="text" name="pPass">
						</dd>
					</dl>
					<p>
						<input type="reset" value="リセット"> <input type="submit"
							value="ログインする">
					</p>
				</div>
				<!--エラーメッセージをここで表示予定 -->
				<p>
					<c:out value="${requestScope.error}" />
				</p>
				<p>
					<c:out value="${requestScope.logoutmes}" />
				</p>

			</form>
		</section>
		<footer>
			<small>Copyright(c)2018 honaetsu,All rights reserved.lol</small>
		</footer>
	</div>
</body>
</html>