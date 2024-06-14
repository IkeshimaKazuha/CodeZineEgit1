<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>登録完了</title>
<meta charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap2.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/Site2.css" />
<style>
.container {
	max-width: 600px;
	margin: 0 auto;
	padding: 20px;
	text-align: center;
	background-color: #f9f9f9;
	border: 1px solid #ddd;
	border-radius: 10px;
}

.success-message {
	font-size: 18px;
	color: #4CAF50;
}

.button-container {
	margin-top: 20px;
}

.button-container input {
	width: 200px;
	padding: 10px;
	font-size: 16px;
}
</style>
</head>
<body>
	<div class="container">
		<h2>登録完了</h2>
		<p class="success-message">ユーザー情報の登録が完了しました。</p>
		<div class="button-container">
			<input type="button" class="BUTTON" value="ホームに戻る"
				onclick="window.location.href='${pageContext.request.contextPath}/UserInfoRegistration'" />
		</div>
	</div>
</body>
</html>
