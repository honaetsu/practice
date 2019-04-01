<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
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

body {

}
</style>
</head>
<body>
	<div id="contener">
		<header>
			<h1>ユーザー登録</h1>
			<p>ユーザーID確認画面</p>
		</header>
		<nav>
			<ul>
				<li><a href="index.html">Topへもどる</a></li>

			</ul>
		</nav>
		<section>
			<form method="post" action="SignUp">
				<h2>新規登録画面</h2>
				<div id="formD">
					<dl>
						<dt>新規作成ＩＤを入力して利用可能か確認してください。</dt>
						<dd>
							<input type="text" name="pId">
						</dd>
					</dl>
					<!--エラーメッセージをここで表示 -->
					<p>
						<c:out value="${requestScope.pId}"/>
						<c:out value="${requestScope.emsg}" />
					</p>
					<p>
						<input type="reset" value="リセット"> <input type="submit"
							value="確認">
					</p>
				</div>

				<p>
					<c:out value="${requestScope.errormes}" />
				</p>

			</form>
		</section>
		<footer>
			<small>Copyright(c)2018 honaetsu,All rights reserved.lol</small>
		</footer>
	</div>
</body>
</html>