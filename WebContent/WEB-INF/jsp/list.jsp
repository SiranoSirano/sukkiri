<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList,modeltest.Employee"%>

<%
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");

	String error = (String) request.getAttribute("error");
%>

<html>

<head>

<title>全てのデータを表示する</title>

</head>

<body>

	<div style="text-align: center">

		<h2 style="text-align: center">全てのデータを表示するプログラム</h2>

		<hr style="height: 3; background-color: #0000FF" />

		<br>

		<%=error%>

		<table style="margin: 0 auto">

			<tr>

				<th style="background-color: #6666FF; width: 100">ユーザーID</th>
				<th style="background-color: #6666FF; width: 100">ユーザー名</th>
				<th style="background-color: #6666FF; width: 100">名前</th>
				<th style="background-color: #6666FF; width: 100">読み方</th>
				<th style="background-color: #6666FF; width: 100">誕生日</th>
				<th style="background-color: #6666FF; width: 100">年齢</th>
				<th style="background-color: #6666FF; width: 100">性別</th>
				<th style="background-color: #6666FF; width: 100">国籍</th>
				<th style="background-color: #6666FF; width: 100">郵便番号</th>
				<th style="background-color: #6666FF; width: 100">住所</th>
				<th style="background-color: #6666FF; width: 100">雇入の年月日</th>
				<th style="background-color: #6666FF; width: 100">退職の年月日</th>
				<th style="background-color: #6666FF; width: 100">退職事由</th>
				<th style="background-color: #6666FF; width: 100">電話番号</th>
				<th style="background-color: #6666FF; width: 250">メールアドレス</th>
				<th style="background-color: #6666FF; width: 100">個人ナンバー</th>
				<th style="background-color: #6666FF; width: 100">備考</th>
				<th style="background-color: #6666FF; width: 100">パスワード</th>
			</tr>

			<%
				if (list != null) {

					for (int i = 0; i < list.size(); i++) {
			%>

			<tr>
				<td style="text-align: center; width: 100"><%=list.get(i).getId()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getUserName()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getName()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getCall()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getBirth()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getAge()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getGender()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getCountry()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getPostal()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getAddress()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getEntry()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getLeave()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getReason()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getPhone()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getMail()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getMynumber()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getText()%></td>
				<td style="text-align: center; width: 100"><%=list.get(i).getPass()%></td>
			</tr>

			<%
				}

				}
			%>

		</table>

		<br>

	</div>

</body>
</html>
