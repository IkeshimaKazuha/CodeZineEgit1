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

			.TopMenuContainer {
            width: 100%;
            height: 50px;
            display: block;
            position: fixed;
            top: 0;
            left: 0;
            background-color: #5B9BD5;
            z-index:100;
        }
        .TopMenu {
            width: 1012px;
            height: 50px;
            display: block;
            position: fixed;
            top: 0;
            background-color: #5B9BD5;
            z-index:101;
        }

        .TopMenuTitle {
            float:left;
            padding-top:5px;
        }

        .TopMenuSettingImgContainer {
            float:right;
            width:40px;
            height:100%;
            right:0px;
        }

        .TopMenuDropDownComandContainer {
            float:right;
            height:100%;
        }

        .TopMenuDropDownComandContainer:hover .TopMenuComandContent {
            display:block !important;
        }

        .TopMenuComandContent{
            position:absolute;
            top:45px;
            right:0px;
            width:100px;
            font-size:12px;
            padding:3px;
            border:1px solid #0094ff;
            display:none !important;
            background-color:white;
            z-index:90;
        }

        .TopMenuSettingImg {
            position:absolute;
            width:40px;
            height:40px;
            right:0px;
        }

        .TopMenuNick {
            float:right;
            font-size:18px;
            padding-top:15px;
        }

        .LeftMenu {
            width: 200px;
            height: 100vh;
            background-color: #ffffff;
            color: white;
            position: fixed;
            top: 60px;
            padding: 10px;
            z-index:90;
        }

        .RightMenu {
            width: 0px;
            height: 100vh;
            background-color: #ffffff;
            color: white;
            position: fixed;
            right: 0;
            top: 60px;
            padding: 10px;
            z-index:90;
        }

        .TopContainer {
            width: 1012px;
            height:50xp;
            position: relative;
            left: calc(50% - 506px);  /* 回答3・追加：画面を中央に寄せる */
        }

        .MidContainer {
            width: 802px;
            height: auto;
            min-height: 100%;
            display: inline-block;
            margin-top: 60px;
            margin-left: 210px;
            margin-right: 0px;
            margin-bottom: 0;
            background-color: #ffffff;
            padding: 10px;
            /* overflow-y:scroll; */ /* 回答1・削除：白部分の縦スクロールバーを無くす */
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
		<div class="TopContainer">
			<div class="TopMenuContainer PageHeader">
			</div>
			<div id="top" class="TopMenu PageHeader">
				<div class="TopMenuTitle">
					書類申請
				</div>
	
	<div class="TopMenuSettingImgContainer">
		<div class="TopMenuDropDownComandContainer">
			<!-- 回答5・変更・開始：トップバーの画像を設定 -->
			<input type="image" class="TopMenuSettingImg v_middle_a" src="./img/setting.png">
			<!-- 回答5・変更・完了：トップバーの画像を設定 -->
			<div class="TopMenuComandContent">
				<a href="/BaseInformation/Index" style="font-size:12px">基本情報</a><br>
				<a href="/ProfileInformation/Index" style="font-size:12px">プロファイル</a><br>
				<div class="TitleLine"> </div>
				<a href="/Authentication/Logout" style="font-size:12px">ログアウト</a>
			</div>
		</div>
	
	</div>
	<div class="TopMenuNick">
		ニックネーム
		権限
	</div>
			</div>
	
	<div class="TitleLine" style="width:100%;margin-top:10px"></div>
	

			</div>
		<div class="background">
			<div class="container1">
				<div class="h1"><h1 id="h2">申請一覧</h1></div>
				<form method="post" action="ApplicationManage" id="Form1">
					<div class="row div1">
						<div class="col-xs-offset-1 col-xs-2 div状態">状態</div>
						<select class="col-xs-2 option select1" id="cbx状態" name="applyStatus">
							<option value="">すべて</option>
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

			$(document).on('change', "[id^='cbx状態']", function () {
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

			$(document).on('change', "[id^='showNumber']", function () {      
 if ($('#totalCount').text() == "0") {     
  return;    
 }     
 $.ajax({     
  url: "${pageContext.request.contextPath}/GetPage2",    
  type: "post",    
  data: { showNumber:$("#showNumber").val(), currentPage: 1 },    
  success: function (data) {    
   $("#container").html(data);   
  },    
  error: function () {    
   alert("システムエラーが発生しました");   
  }    
 });     
});      

		</script>
	</body>

</html>
