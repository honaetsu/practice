<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	width: auto;
	float: right;
	text-align: center;
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
    <form>
      <h2>ログイン画面</h2>
      <div id="formD">
        <dl>
          <dt>ログインＩＤを入力</dt>
          <dd>
            <input type="text">
          </dd>
          <dt>ログインパスワードを入力</dt>
          <dd>
            <input type="text">
          </dd>
        </dl>
        <p>
          <input type="reset">
          <input type="submit">
        </p>
      </div>
      <!--エラーメッセージをここで表示予定 -->
      <p class="formDright">
        <c:out value="${reqestScope.error}">
        </c:out>
        test</p>
    </form>
  </section>
  <footer> <small>Copyright(c)2018 honaetsu,All rights reserved.lol</small> </footer>
</div>
<p>&nbsp;</p>
</body>
</html>