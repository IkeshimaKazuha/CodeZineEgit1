<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>




<!DOCTYPE html>
<html>
	<head>
		<title>書類申請</title>
	 	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css" />
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

/* 			.h1{
				border-bottom:3px solid #69A4D8;
			} */

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

			#h2{
				display:none;
			}


		</style>
	</head>
	<body>
		<div id="headerTitle" hidden>書類申請管理(管理者用)</div>
		<div class="background">
			<div class="container1">
				<div class="h1"><h1 id="h2">書類申請管理(管理者用)</h1></div>
				<div class="row div1">
					<div class="col-xs-offset-1 col-xs-5">
						氏名
						<c:if test="${applicationInfoModel.getProfileInfoModelList() != null}">
							${applicationInfoModel.getProfileInfoModelList()[0].getUserName()}
						</c:if>
					</div>
				</div>
				<div class="row div1">
					<div class="col-xs-offset-1 col-xs-2">
						所属
						<c:if test="${applicationInfoModel.getProfileInfoModelList() != null}">
							${applicationInfoModel.getProfileInfoModelList()[0].getAffiliation()}
						</c:if>
					</div>
					<div class="col-xs-offset-1 col-xs-2">
						役職
						<c:if test="${applicationInfoModel.getProfileInfoModelList() != null}">
							${applicationInfoModel.getProfileInfoModelList()[0].getPosition()}
						</c:if>
					</div>
				</div>
				<form method="post" action="ApplicationManage" id="Form1">
					<div class="row div1">
						<div class="col-xs-offset-1 col-xs-2 div状態">状態</div>
						<select class="col-xs-2 option select1" id="cbx状態" name="applyStatus">
							<option value="5">すべて</option>
							<option value="0" selected>未承認</option>
							<option value="1" >承認済み</option>
							<option value="2">自分差し戻し</option>
							<option value="3">差し戻し</option>
							<option value="4">削除済み</option>
						</select>
					</div>
				</form>
			</div>
			<div id="container"></div>
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

			$(document).on('change', "[id^='status']", function () {
				$.ajax({
					url: "${pageContext.request.contextPath}/ApplicationManage",
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


			$(document).on('click', "[id='nextPage']", function () {
				event.preventDefault();
				var selecting = $('#currentPage').val();
				var maxvalue = $('#currentPage option:last-child').val();

				if (selecting == maxvalue) {
					return;
				}

				$('#currentPage').val(Number(selecting) + 1);
				$('#previousPage').attr("src", "${pageContext.request.contextPath}/img/left_triangle.png");


				$.ajax({
					url: "${pageContext.request.contextPath}/GetPageApplication",
					type: "post",
					data: { showNumber:$("#showNumber").val(), currentPage: (Number(selecting) + 1) },
					success: function (data) {
						$("#container").html(data);
					},
					error: function () {
						alert("システムエラーが発生しました");
					}
				});
			});

			$(document).on('click', "[id='previousPage']", function () {
				event.preventDefault();
				var selecting = $('#currentPage').val();

				if (selecting == 1) {
					return;
				}

				$('#currentPage').val(Number(selecting) - 1);
				$('#nextPage').attr("src", "${pageContext.request.contextPath}/img/right_triangle.png");


				$.ajax({
					url: "${pageContext.request.contextPath}/GetPageApplication",
					type: "post",
					data: { showNumber:$("#showNumber").val(), currentPage: (Number(selecting) - 1) },
					success: function (data) {
						$("#container").html(data);
					},
					error: function () {
						alert("システムエラーが発生しました");
					}
				});
			});

			$(document).on('change', "[id='currentPage']", function () {
				if ($('#totalCount').text() == "0") {
					return;
				}
				$.ajax({
					url: "${pageContext.request.contextPath}/GetPageApplication",
					type: "post",
					data: { showNumber:$("#showNumber").val(), currentPage: $('#currentPage').val() },
					success: function (data) {
						$("#container").html(data);
					},
					error: function () {
						alert("システムエラーが発生しました");
					}
				});
			});

			$(document).on('change', "[id^='showNumber']", function () {
				if ($('#totalCount').text() == "0") {
					return;
				}
				$.ajax({
					url: "${pageContext.request.contextPath}/GetPageApplication",
					type: "post",
					data: { showNumber:$("#showNumber").val(), currentPage: 1 },
					success: function (data) {

						$("#container").html(data);
					},
					error: function (err) {
						alert(err.responseText);
						alert("システムエラーが発生しました");
					}
				});
			});

			function sort(obj) {
				if ($('#totalCount').text() == "0") {
					return;
				}
				var span = $(obj).find("span");//spanの要素
				var sortOrder = span.text().trim();//今の▲の状態
				var sortColumn = $(obj).text().replace("▲", "").replace("▼", "").trim();//今のユーザーIDとか

				//タイトルからソート順のマークを削除する　更新前に前を消しておく
				$("#searchList").find("tr:nth-child(1) td").each(function () {
					$(this).find("span").text("");
				});

				if (sortOrder == "" || sortOrder == "▼") {
					sortOrder = "▲";
				}
				else {
					sortOrder = "▼";
				}

				$('#previousPage').attr("src", "${pageContext.request.contextPath}/img/left_triangle_disable.png");
				$('#currentPage').val(1);
				$('#nextPage').attr("src", "${pageContext.request.contextPath}/img/right_triangle.png");


				$.ajax({
					url: "${pageContext.request.contextPath}/SortApplication",
					type: "post",
					data: {sortColumn:sortColumn,sortOrder:sortOrder},
					success: function (data) {
						$("#container").html(data);//containerの中身更新？
					},
					error: function (err) {
						console.error(err.responseText);
						//alert("システムエラーが発生しました");
					}
				});
			}
		</script>
	</body>

</html>
