<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システム</title>
</head>
<body>
<h1>社員情報管理システムへようこそ</h1>
<h2>トップページ</h2>
<div align="center">

<form action ="/スッキリ/LoginServlet" method = "post">
ユーザー名:<input type ="text" name = "userName"><br>
パスワード:<input type ="password" name="pass"><br>

<p></p>
<input type="submit" value="ログイン">
</form>


</div>
</body>
</html>