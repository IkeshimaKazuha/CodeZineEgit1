<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>ログイン画面</title>
    <script
      src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"
      type="text/javascript"
    ></script>
    <style type="text/css">
      . {
      }
      .LABEL {
        color: red;
        margin: 0 auto;
        display: block;
        text-align: center;
      }
      .CONTAINER {
        width: 250px;
        margin: 0 auto;
        margin-bottom: 5px;
      }
      .TEXTBOX {
        width: 250px;
        height: 30px;
        margin-bottom: 5px;
      }
      .LEFT {
        float: left;
      }
      .RIGHT {
        float: right;
      }
      .BUTTON {
        width: 250px;
      }
      .TEXTAREA {
        width: 500px;
        height: 200px;
        margin: 0 auto;
        display: block;
        resize: none;
        clear: both;
      }
    </style>
    <script type="text/ecmascript">
function validateUserId(userId) {
                var regex = /^[a-zA-Z0-9]{1,10}$/;　//[a-zA-Z0-9]{1,10}で範囲を指定
                return regex.test(userId);
            }

      function CheckNull() {
       var userid = document.getElementById("userId");
       var pass = document.getElementById("password");
       var email = document.getElementById("email");
       if (userid.value == "") {
        alert("ユーザーIDを入力してください");
        return false;
       }
       if (pass.value == "") {
        alert("パスワードを入力してください");
        return false;
       }
       if (email.value == "") {
        alert("メールアドレスを入力してください");
        return false;
       }
      }
    </script>
  </head>
  <body>
    <form method="post" action="/OfficeSystem/Login">
      <label class="LABEL"> ${error} </label>
      <div class="CONTAINER">
        <input
          type="text"
          class="TEXTBOX"
          id="userId"
          name="userId"
          placeholder="ユーザーID"
        />
        <input
          type="password"
          class="TEXTBOX"
          id="password"
          name="password"
          placeholder="パスワード"
        />
        <input
          type="text"
          class="TEXTBOX"
          id="email"
          name="email"
          placeholder="メールアドレス"
        />
        <input type="button" class="BUTTON" value="ログイン" />
        <a href="" class="LEFT">パスワード忘れ</a>
        <a href="" class="RIGHT">新規登録</a>
      </div>
    </form>
    <textarea class="TEXTAREA">お知らせ</textarea>
    <script type="text/ecmascript">
      $(".BUTTON").click(function () {
       if ($("#userId").val() == "") {
        alert("ユーザーIDを入力してください");
        return false;
       }
       if (!validateUserId($("#userId").val())) {　//validateUserId(userId)の引数(userId)がここに飛ぶ
//!で否定
                 alert("ユーザーIDは1～10文字の英数字で入力してください");
                    return false;
                }
//範囲外の場合は、alertが表示される
//これまでは全角や範囲以上の桁数でも通っていたが、このコードでチェックが可能になる
       
       if ($("#password").val() == "") {
        alert("パスワードを入力してください");
        return false;
       }
       if ($("#email").val() == "") {
        alert("メールアドレスを入力してください");
        return false;
       }

       $.ajax({
        url: "/OfficeSystem/Login",
        type: "post",
        data:{userId:$("#userId").val(), password: $("#password").val(),email: $("#email").val()},
        success: function (data) {

            console.log(data);

         if (data == "") {
          window.location.href = "next";
         }
         else {
          alert(data);
         }
        },
        error: function () {
         alert("システムエラーが発生しました");
        }
       });
      });
    </script>
  </body>
</html>
