<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
<head>
<title>検索画面</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.css" />
<link type="text/css" rel="new stylesheet"
	href="${pageContext.request.contextPath}/css/Site.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>

<style>
* {
	font-family: 'MS Mincho', 'MS PMincho', 'MS Gothic', 'MS PGothic', Arial,
		Helvetica, sans-serif;
}

body, html {
	height: 100%;
	background-color: #e9ebee;
}

body {
	height: auto;
	margin: 8px;
}

.TOPBAR {
	width: 100%; /* 幅：全画面 */
	min-width: 1000px;
	height: 50px; /* 高さ：50px */
	background-color: #5B9BD5; /* 背景色：#5B9BD5 */
	color: white; /* テキスト色：ホワイト */
	font-size: 24px; /* フォントサイズ：24px */
	font-weight: bold; /* フォントの太さ：太 */
	text-align: center; /* テキストの位置：トップバーの中央 */
	display: flex; /* テキストの位置：トップバーの中央 */
	justify-content: center; /* テキストの位置：トップバーの中央 */
	align-items: center; /* テキストの位置：トップバーの中央 */
	margin-bottom: 8px; /* 白色背景枠との間の幅：8px */
}

.TITLE {
	font-size: 24px;
	font-weight: bold;
}

.TEXTBOX {
	color: #494949;
	border: 1px solid #69A4D8;
	border-radius: 5px;
	height: 30px;
	font-size: 18px;
	padding-left: 5px;
	padding-right: 5px;
}

.TEXTAREA {
	color: #494949;
	border: 1px solid #69A4D8;
	border-radius: 5px;
	font-size: 18px;
	padding-left: 5px;
	padding-right: 5px;
	resize: none;
}

.BUTTON {
	background-color: #5B9BD5;
	color: white;
	border: 1px solid #43729D;
	border-radius: 5px;
	height: 36px;
	font-size: 18px;
	font-weight: bold;
}

.BUTTONDISABLE {
	background-color: #dddddd;
	color: white;
	border: 1px solid #cccccc;
	border-radius: 5px;
	height: 36px;
	font-size: 18px;
	font-weight: bold;
}

.BUTTONDISABLE:hover {
	cursor: pointer;
}

.LABEL {
	color: #494949;
	font-size: 18px;
	text-align: left;
}

.SELECT {
	color: #494949;
	border: 1px solid #69A4D8;
	border-radius: 5px;
	height: 30px;
	font-size: 18px;
}

.TITLELINE {
	border-bottom: 3px solid #5B9BD5;
	width: 100%;
	margin-top: 5px;
	margin-bottom: 5px;
}

.TEXTBOX:focus, .TEXTAREA:focus, .SELECT:focus {
	outline: none !important;
	border-color: red;
	box-shadow: 0 0 5px #ce7171;
}

.BUTTON:hover {
	cursor: pointer;
}

.BUTTON:focus {
	outline: none !important;
	border-color: #43729D;
	box-shadow: 0 0 5px #608db8;
}

tr {
	height: 35px;
	font-size: 18px;
}

td {
	text-align: left;
	width: auto;
}

a {
	font-size: 18px;
}

.row {
	min-height: 35px;
	padding-bottom: 3px;
}

td {
	border: 1px solid #69A4D8;
}

.TEXTBOX {
	width: 300px;
}

.TEXTAREA {
	width: 300px;
	height: 100px;
	resize: none;
}

.PARENTCONTAINER {
	width: 1000px; /* 白い背景の枠の幅：1000px */
	height: auto; /* 白い背景の枠の高さ：ウィンドウのサイズに合わせる */
	min-height: calc(100% - 58px); /* 白い背景の枠の高さ：ウィンドウのサイズに合わせる */
	margin: 0 auto; /* 白い背景の枠の位置：全画面の均等割付 */
	display: block; /* 白い背景の枠の位置：全画面の均等割付 */
	background-color: white; /* 背景色：ホワイト */
}

.container {
	width: 950px;
	margin: 0 auto;
}
</style>
</head>

<body>
	<div class="TOPBAR">ユーザー管理画面</div>
	<div class="PARENTCONTAINER">
		<div class="container-fluid">
			<form id="Form1" method="post" action="UserManage">
				<div class="row div1">
					<div class="col-xs-offset-1 col-xs-2 div表示区分">表示区分</div>
					<select class="col-xs-2 option select1" id="cbx表示区分"
						name="type">
						<option value="0" selected>新規申請中</option>
						<option value="1">登録リンク発行中</option>
						<option value="2">登録済み</option>
						<option value="3">削除済</option>
					</select> 
				</div>
			</form>
			<div id="container">
				<tiles:insertAttribute name="_UserManageList" />
			</div>
		</div>
</body>

<script type="text/ecmascript">
		

    window.onload=function(){
         $.ajax({
            url: "${pageContext.request.contextPath}/UserManage",
            type: "post",
            data: $("#Form1").serialize(),
            success: function (data) {
                //alert(data);
                $("#container").html(data);
            },
            error: function(err){
                alert(err.responseText);
                alert("システムエラーが発生しました..");
            }
        });
    };

    $(document).on('change', "[id^='cbx表示区分']", function () {
        $.ajax({
            url: "${pageContext.request.contextPath}/UserManage",
            type: "post",
            data: $("#Form1").serialize(),
            success: function (data) {
                $("#container").html(data);
            },
            error: function(err){
                alert(err.responseText);
                alert("システムエラーが発生しました..");
            }
        });
    });
	
</script>
</html>
