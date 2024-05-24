%@page contentType="text/html" pageEncoding="UTF-8"%
<html>      
 <head>     
  <title>ログイン画面</title>    
  <style type="text/css">    
   .{ }   
      
   .LABEL   
   {   
    color:red;  
    margin:0 auto;  
    display:block;  
    text-align:center;  
   }   
   .CONTAINER   
   {   
    width:250px;  
    margin:0 auto;  
    margin-bottom:5px;  
   }   
   .TEXTBOX   
   {   
    width:250px;  
    height:30px;  
    margin-bottom:5px;  
   }   
   .LEFT   
   {   
    float:left;  
   }   
   .RIGHT   
   {   
    float:right;  
   }   
   .BUTTON   
   {   
    width:250px;  
   }   
   .TEXTAREA   
   {   
    width:500px;  
    height:200px;  
    margin:0 auto;  
    display:block;  
    resize:none;  
    clear:both;  
   }   
  </style>    
 </head>     
<body>      
 <label class="LABEL"></label>     
 <div class="CONTAINER">     
  <input type="text" class="TEXTBOX" placeholder="ユーザーID"/>    
  <input type="password" class="TEXTBOX" placeholder="パスワード"/>    
  <input type="submit" class="BUTTON" value="ログイン"/>    
  <a href="" class="LEFT" >パスワード忘れ</a>    
  <a href="" class="RIGHT" >新規登録</a>    
 </div>     
 <textarea class="TEXTAREA">お知らせ</textarea>     
</body>      
</html>      
