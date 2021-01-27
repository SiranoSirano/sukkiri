<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import ="model.*,servlet.*,dao.*,java.util.List" %>
<%


//リクエストスコープに保存された社員リストを取得
@SuppressWarnings("unchecked")
List<Employee> employeeList = (List<Employee>)request.getAttribute("employeeList");

//リクエストスコープに保存されたエラーメッセージを取得
String errorMsg = (String) request.getAttribute("errorMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員情報管理システムメイン</title>
</head>
<body>
<h1>社員情報管理システムメイン</h1>
<p><c:out value="${userName}"/>さんはログイン中です
<a href ="/社員情報管理システムDB接続/Logout">ログアウト</a>
</p>

<p><a href="/社員情報管理システムDB接続/Main">更新</a></p>
<p></p>
<form action ="/社員情報管理システムDB接続/RegisterUser" method = "post">
<input type="submit" value="登録">
</form>
<p></p>
<form action ="/社員情報管理システムDB接続/DeleteUser" method = "post">
<input type="submit" value="削除">
</form>

<%--　エラーメッセージのerrorMsgがある場合はそこに遷移して表示する --%>
<%
if(errorMsg != null) {
%>
<p><%=errorMsg%>><p>
<%
}
%>

<%-- ArrayListに格納されたインスタンスを先頭から取得、名前と入力内容を紐づけて表示 --%>
<%-- 拡張for文を使って取り出していく --%>
<%
for(Employee Employee : employeeList){
%>
	<p><%= Employee.getUserName() %>:<%= Employee.getText() %></p>
<% } %>

</body>
</html>