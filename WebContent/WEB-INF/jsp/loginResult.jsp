<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--ログイン結果を出力するビュー --%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システム</title>
</head>
<body>
<h1>社員情報管理システムログイン</h1>
<%--ログインが通ったら --%>

	<p>ログインに成功しました</p>
	<p>ようこそ<c:out value="${userName}"/>さん</p>
	<a href ="スッキリ/Main">社員情報管理画面へ</a>
	<a href="/スッキリ/Logout">TOP・ログイン画面へ戻る</a>

</body>
</html>