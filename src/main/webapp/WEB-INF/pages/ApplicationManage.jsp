<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>




<!DOCTYPE html>
<html>
	<head>
		<title>書類申請</title>
	 	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
		 <link type="text/css" rel="new stylesheet" href="${pageContext.request.contextPath}/css/Site.css" />
	 	<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js" type="text/javascript"></script>
		<style>

			html{
				height:100%;
			}

			body
			{
				/* background-color:#C0C0C0; */
				font-size:large;
				height:100%;
				/* padding:20px 0px; */
			}

			.background{
				background-color:WHITE;
				width:90%;
				margin:0 auto;
				min-height:100%;
				padding-bottom:20px;
				margin-bottom:10px;
			}

			.container1
			{
				width:95%;
				margin:0 auto;
				padding-top:10px;
			}

			.h1{
				border-bottom:3px solid #69A4D8;
			}

			.select1{
				border:2px #69A4D8 solid;
				border-radius:5px;
				width:200px;
				height:40px;
			}

			.select2{
				border:2px #69A4D8 solid;
				border-radius:5px;
				width:150px;
				height:40px;
			}

			input[type=button]{
				border-radius:10px;
				color:#fff;
				height:40px;
				border:2px #69A4D8 solid;
				background-color:#69A4D8;
			}

			.div1{
				width:100%;
				display: flex;
				align-items: center;
			}

			.div状態{
			/* 	//margin-left:20px; */
			}

			.option{
			}

			.button{
			}
















			.row{
				margin-bottom:10px;
			}

			.table{
				width:95%;
				border:2px solid #69A4D8;
				margin:0 auto;
			}

			.table th,td{
				border:2px solid #69A4D8;
			 }

			.tr1{
				border-bottom:4px solid #69A4D8;
			}

			.tablebox1{
			 	display:table;
				width:100%;
			}

			.SOUKENSU{
				display:table-cell;
			}

			.tablebox2{
				display:table-cell;
				text-align:right;
			}

			.HYOJI{
				display:inline-block;
			}

			.HYOJIOPTION{
			}


		</style>
	</head>
	<body>
		<div class="background">
			<div class="container1">
				<div class="h1"><h1 id="h2">申請一覧</h1></div>
				<form method="post" action="ApplicationManage" id="Form1">
					<div class="row div1">
						<div class="col-xs-offset-1 col-xs-2 div状態">状態</div>
						<select class="col-xs-2 option select1" id="cbx状態" name="applyStatus">
							<option value="_">すべて</option>
							<option value="0" selected>未承認</option>
							<option value="1" >承認済み</option>
							<option value="2">自分差し戻し</option>
							<option value="3">差し戻し</option>
							<option value="4">削除済み</option>
						</select>
						<input type="button" class="col-xs-offset-3 col-xs-3 button" value="新規申請" id="btn新規申請" />
					</div>
				</form>
			</div>
			<div id="container">
				<tiles:insertAttribute name="_ApplicationList" />
			</div>
		</div>
		<script type="text/ecmascript">

			window.onload=function(){
 				$.ajax({
					url: "${pageContext.request.contextPath}/ApplicationManage",
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

		</script>
	</body>

</html>
