<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>ユーザー情報新規登録画面</title>
<meta  charset="UTF-8">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap2.css" />
<link type="text/css" rel="new stylesheet"
	href="${pageContext.request.contextPath}/css/Site2.css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"
	type="text/javascript"></script>
<style>
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
}

.PARENTCONTAINER {
	width: 1000px; /* 白い背景の枠の幅：1000px */
	height: auto; /* 白い背景の枠の高さ：ウィンドウのサイズに合わせる */
	min-height: calc(100% - 58px); /* 白い背景の枠の高さ：ウィンドウのサイズに合わせる */
	margin: 0 auto; /* 白い背景の枠の位置：全画面の均等割付 */
	display: block; /* 白い背景の枠の位置：全画面の均等割付 */
	background-color: white; /* 背景色：ホワイト */
}

.required::after {
  content: " * ";
  color: red;
  vertical-align: middle;
}
</style>
</head>
<body>

    <div class="row">
        <div class="col-12 TOPBAR">
            <div class="TOPBAR">ユーザー情報新規登録</div>
        </div>
    </div>
    <div class="PARENTCONTAINER">
    <div class="container-fluid">
        <div class="row">
            <div class="col-12 TITLE">
                基本情報新規登録確認
                <div class="TITLELINE"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">ユーザーID</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="userId" required data-type="alphanumeric" minlength="5" maxlength="20">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">メールアドレス</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="email" required data-type="email" maxlength="50">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">パスワード</div>
            <div class="col-8">
                <input class="TEXTBOX" type="password" name="password" required minlength="8" maxlength="20">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">パスワード確認</div>
            <div class="col-8">
                <input class="TEXTBOX" type="password" name="confirmPassword" required minlength="8" maxlength="20">
            </div>
        </div>
        <div class="row">
            <div class="col-12 TITLE">
                プロファイル新規登録確認
                <div class="TITLELINE"></div>
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">ニックネーム</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="nickName" required maxlength="30">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">氏名</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="userName" required maxlength="30">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">性別</div>
            <div class="col-8">
                <input name="sex" type="radio" value="1" required> <span>男</span> <input name="sex" type="radio" value="2" required> <span>女</span>
            </div>
        </div>
        <!--生年月日-->
				<div class="row">
					<div class="col-1"></div>
					<div class="col-3">生年月日</div>
					<div class="col-8">
						<!-- 年 -->
						<select class="SELECT" name="birthdayYear" id="cbx生年" style="width:80px" required>
							<option selected=""></option>
                            <option value="1924">1924年</option>
                            <option value="1925">1925年</option>
                            <option value="1926">1926年</option>
                            <option value="1927">1927年</option>
                            <option value="1928">1928年</option>
                            <option value="1929">1929年</option>
                            <option value="1930">1930年</option>
                            <option value="1931">1931年</option>
                            <option value="1932">1932年</option>
                            <option value="1933">1933年</option>
                            <option value="1934">1934年</option>
                            <option value="1935">1935年</option>
                            <option value="1936">1936年</option>
                            <option value="1937">1937年</option>
                            <option value="1938">1938年</option>
                            <option value="1939">1939年</option>
                            <option value="1940">1940年</option>
                            <option value="1941">1941年</option>
                            <option value="1942">1942年</option>
                            <option value="1943">1943年</option>
                            <option value="1944">1944年</option>
                            <option value="1945">1945年</option>
                            <option value="1946">1946年</option>
                            <option value="1947">1947年</option>
                            <option value="1948">1948年</option>
                            <option value="1949">1949年</option>
                            <option value="1950">1950年</option>
                            <option value="1951">1951年</option>
                            <option value="1952">1952年</option>
                            <option value="1953">1953年</option>
                            <option value="1954">1954年</option>
                            <option value="1955">1955年</option>
                            <option value="1956">1956年</option>
                            <option value="1957">1957年</option>
                            <option value="1958">1958年</option>
                            <option value="1959">1959年</option>
                            <option value="1960">1960年</option>
                            <option value="1961">1961年</option>
                            <option value="1962">1962年</option>
                            <option value="1963">1963年</option>
                            <option value="1964">1964年</option>
                            <option value="1965">1965年</option>
                            <option value="1966">1966年</option>
                            <option value="1967">1967年</option>
                            <option value="1968">1968年</option>
                            <option value="1969">1969年</option>
                            <option value="1970">1970年</option>
                            <option value="1971">1971年</option>
                            <option value="1972">1972年</option>
                            <option value="1973">1973年</option>
                            <option value="1974">1974年</option>
                            <option value="1975">1975年</option>
                            <option value="1976">1976年</option>
                            <option value="1977">1977年</option>
                            <option value="1978">1978年</option>
                            <option value="1979">1979年</option>
                            <option value="1980">1980年</option>
                            <option value="1981">1981年</option>
                            <option value="1982">1982年</option>
                            <option value="1983">1983年</option>
                            <option value="1984">1984年</option>
                            <option value="1985">1985年</option>
                            <option value="1986">1986年</option>
                            <option value="1987">1987年</option>
                            <option value="1988">1988年</option>
                            <option value="1989">1989年</option>
                            <option value="1990">1990年</option>
                            <option value="1991">1991年</option>
                            <option value="1992">1992年</option>
                            <option value="1993">1993年</option>
                            <option value="1994">1994年</option>
                            <option value="1995">1995年</option>
                            <option value="1996">1996年</option>
                            <option value="1997">1997年</option>
                            <option value="1998">1998年</option>
                            <option value="1999">1999年</option>
                            <option value="2000">2000年</option>
                            <option value="2001">2001年</option>
                            <option value="2002">2002年</option>
                            <option value="2003">2003年</option>
                            <option value="2004">2004年</option>
                            <option value="2005">2005年</option>
                            <option value="2006">2006年</option>
                            <option value="2007">2007年</option>
                            <option value="2008">2008年</option>
                            <option value="2009">2009年</option>
                            <option value="2010">2010年</option>
                            <option value="2011">2011年</option>
                            <option value="2012">2012年</option>
                            <option value="2013">2013年</option>
                            <option value="2014">2014年</option>
                            <option value="2015">2015年</option>
                            <option value="2016">2016年</option>
                            <option value="2017">2017年</option>
                            <option value="2018">2018年</option>
                            <option value="2019">2019年</option>
                            <option value="2020">2020年</option>
                            <option value="2021">2021年</option>
                            <option value="2022">2022年</option>
                            <option value="2023">2023年</option>
                            <option value="2024">2024年</option>
						</select>
						<!-- 月 -->
						<select class="SELECT" name="birthdayMonth" id="cbx生月" style="width:80px" required>
							<option selected=""></option>
							<option value="01">1月</option>
							<option value="02">2月</option>
							<option value="03">3月</option>
							<option value="04">4月</option>
							<option value="05">5月</option>
							<option value="06">6月</option>
							<option value="07">7月</option>
							<option value="08">8月</option>
							<option value="09">9月</option>
							<option value="10">10月</option>
							<option value="11">11月</option>
							<option value="12">12月</option>
						</select>
						<!-- 日 -->
						<select class="SELECT" name="birthdayDay" id="cbx生日" style="width:80px" required>
							<option selected=""></option>
							<option value="01">1日</option>
							<option value="02">2日</option>
							<option value="03">3日</option>
							<option value="04">4日</option>
							<option value="05">5日</option>
							<option value="06">6日</option>
							<option value="07">7日</option>
							<option value="08">8日</option>
							<option value="09">9日</option>
							<option value="10">10日</option>
							<option value="11">11日</option>
							<option value="12">12日</option>
							<option value="13">13日</option>
							<option value="14">14日</option>
							<option value="15">15日</option>
							<option value="16">16日</option>
							<option value="17">17日</option>
							<option value="18">18日</option>
							<option value="19">19日</option>
							<option value="20">20日</option>
							<option value="21">21日</option>
							<option value="22">22日</option>
							<option value="23">23日</option>
							<option value="24">24日</option>
							<option value="25">25日</option>
							<option value="26">26日</option>
							<option value="27">27日</option>
							<option value="28">28日</option>
							<option value="29">29日</option>
							<option value="30">30日</option>
							<option value="31">31日</option>
						</select> <input type="hidden" name="birthday" id="txt生年月日">
					</div>
				</div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">電話番号</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="tel1" id="txt電話番号1" style="width: 60px" required data-type="numeric" minlength="2" maxlength="4"> -
                <input class="TEXTBOX" type="text" name="tel2" id="txt電話番号2" style="width: 120px" required data-type="numeric" minlength="3" maxlength="4"> -
                <input class="TEXTBOX" type="text" name="tel3" id="txt電話番号3" style="width: 120px" required data-type="numeric" minlength="4" maxlength="4">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">郵便番号</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="postcode1" id="txt郵便番号1" style="width: 70px" required data-type="numeric" minlength="3" maxlength="3"> -
                <input class="TEXTBOX" type="text" name="postcode2" id="txt郵便番号2" style="width: 120px" required data-type="numeric" minlength="4" maxlength="4">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">住所</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="address" required maxlength="100">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3"></div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="addressLine2" maxlength="100">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">入社日</div>
            <div class="col-8">
                <select class="SELECT" name="hireYear" id="cbx入社年" style="width: 80px" required>
                    <option selected=""></option>
                            <option value="1924">1924年</option>
                            <option value="1925">1925年</option>
                            <option value="1926">1926年</option>
                            <option value="1927">1927年</option>
                            <option value="1928">1928年</option>
                            <option value="1929">1929年</option>
                            <option value="1930">1930年</option>
                            <option value="1931">1931年</option>
                            <option value="1932">1932年</option>
                            <option value="1933">1933年</option>
                            <option value="1934">1934年</option>
                            <option value="1935">1935年</option>
                            <option value="1936">1936年</option>
                            <option value="1937">1937年</option>
                            <option value="1938">1938年</option>
                            <option value="1939">1939年</option>
                            <option value="1940">1940年</option>
                            <option value="1941">1941年</option>
                            <option value="1942">1942年</option>
                            <option value="1943">1943年</option>
                            <option value="1944">1944年</option>
                            <option value="1945">1945年</option>
                            <option value="1946">1946年</option>
                            <option value="1947">1947年</option>
                            <option value="1948">1948年</option>
                            <option value="1949">1949年</option>
                            <option value="1950">1950年</option>
                            <option value="1951">1951年</option>
                            <option value="1952">1952年</option>
                            <option value="1953">1953年</option>
                            <option value="1954">1954年</option>
                            <option value="1955">1955年</option>
                            <option value="1956">1956年</option>
                            <option value="1957">1957年</option>
                            <option value="1958">1958年</option>
                            <option value="1959">1959年</option>
                            <option value="1960">1960年</option>
                            <option value="1961">1961年</option>
                            <option value="1962">1962年</option>
                            <option value="1963">1963年</option>
                            <option value="1964">1964年</option>
                            <option value="1965">1965年</option>
                            <option value="1966">1966年</option>
                            <option value="1967">1967年</option>
                            <option value="1968">1968年</option>
                            <option value="1969">1969年</option>
                            <option value="1970">1970年</option>
                            <option value="1971">1971年</option>
                            <option value="1972">1972年</option>
                            <option value="1973">1973年</option>
                            <option value="1974">1974年</option>
                            <option value="1975">1975年</option>
                            <option value="1976">1976年</option>
                            <option value="1977">1977年</option>
                            <option value="1978">1978年</option>
                            <option value="1979">1979年</option>
                            <option value="1980">1980年</option>
                            <option value="1981">1981年</option>
                            <option value="1982">1982年</option>
                            <option value="1983">1983年</option>
                            <option value="1984">1984年</option>
                            <option value="1985">1985年</option>
                            <option value="1986">1986年</option>
                            <option value="1987">1987年</option>
                            <option value="1988">1988年</option>
                            <option value="1989">1989年</option>
                            <option value="1990">1990年</option>
                            <option value="1991">1991年</option>
                            <option value="1992">1992年</option>
                            <option value="1993">1993年</option>
                            <option value="1994">1994年</option>
                            <option value="1995">1995年</option>
                            <option value="1996">1996年</option>
                            <option value="1997">1997年</option>
                            <option value="1998">1998年</option>
                            <option value="1999">1999年</option>
                            <option value="2000">2000年</option>
                            <option value="2001">2001年</option>
                            <option value="2002">2002年</option>
                            <option value="2003">2003年</option>
                            <option value="2004">2004年</option>
                            <option value="2005">2005年</option>
                            <option value="2006">2006年</option>
                            <option value="2007">2007年</option>
                            <option value="2008">2008年</option>
                            <option value="2009">2009年</option>
                            <option value="2010">2010年</option>
                            <option value="2011">2011年</option>
                            <option value="2012">2012年</option>
                            <option value="2013">2013年</option>
                            <option value="2014">2014年</option>
                            <option value="2015">2015年</option>
                            <option value="2016">2016年</option>
                            <option value="2017">2017年</option>
                            <option value="2018">2018年</option>
                            <option value="2019">2019年</option>
                            <option value="2020">2020年</option>
                            <option value="2021">2021年</option>
                            <option value="2022">2022年</option>
                            <option value="2023">2023年</option>
                            <option value="2024">2024年</option>
                </select> 
                <select class="SELECT" name="hireMonth" id="cbx入社月" style="width: 50px" required>
                    <option value=""></option>
                    <option value="01">1月</option>
                    <option value="02">2月</option>
                    <option value="03">3月</option>
                    <option value="04">4月</option>
                    <option value="05">5月</option>
                    <option value="06">6月</option>
                    <option value="07">7月</option>
                    <option value="08">8月</option>
                    <option value="09">9月</option>
                    <option value="10">10月</option>
                    <option value="11">11月</option>
                    <option value="12">12月</option>
                </select> 
                <select class="SELECT" name="hireDay" id="cbx入社日" style="width: 50px" required>
                    <option value=""></option>
                    <option value="01">1日</option>
                    <option value="02">2日</option>
                    <option value="03">3日</option>
                    <option value="04">4日</option>
					<option value="05">5日</option>
					<option value="06">6日</option>
					<option value="07">7日</option>
					<option value="08">8日</option>
					<option value="09">9日</option>
					<option value="10">10日</option>
					<option value="11">11日</option>
					<option value="12">12日</option>
					<option value="13">13日</option>
					<option value="14">14日</option>
					<option value="15">15日</option>
					<option value="16">16日</option>
					<option value="17">17日</option>
					<option value="18">18日</option>
					<option value="19">19日</option>
					<option value="20">20日</option>
					<option value="21">21日</option>
					<option value="22">22日</option>
					<option value="23">23日</option>
					<option value="24">24日</option>
					<option value="25">25日</option>
					<option value="26">26日</option>
					<option value="27">27日</option>
					<option value="28">28日</option>
					<option value="29">29日</option>
					<option value="30">30日</option>
					<option value="31">31日</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">所属</div>
            <div class="col-8">
                <select class="SELECT" name="affiliation" style="width: 100px" required>
                    <option selected=""></option>
                    <option value="営業部">営業部</option>
                    <option value="技術部">技術部</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">役職</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="position" required maxlength="30">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">趣味</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="hobby" maxlength="50">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">特技</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="specialSkill" maxlength="50">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3">座右銘</div>
            <div class="col-8">
                <input class="TEXTBOX" type="text" name="comment" maxlength="100">
            </div>
        </div>
        <div class="row">
            <div class="col-1"></div>
            <div class="col-3" style="vertical-align :top; padding-top: 3px">座右銘</div>
            <div class="col-8">
                <textarea class="TEXTAREA" cols="20" id="txtComment" name="comment" rows="2" maxlength="100"></textarea>
            </div>
        </div>
        <div class="row">
            <div class="col-2"></div>
            <div class="col-4">
                <input type="button" class="BUTTON" value="登録" style="width: 180px" onclick="submitForm()">
            </div>
            <div class="col-4">
                <input type="button" class="BUTTON" value="キャンセル" style="width: 180px;">
            </div>
            <div class="col-2"></div>
        </div>
    </div>
</div>
    

  <script>

    function submitForm() {
        // エラーメッセージを格納する配列
        var errors = [];

        // フォームの各入力要素をチェック
        $('input, select').each(function() {
            var element = $(this);
            var value = element.val().trim();  // 値の前後の空白を削除
            var dataType = element.data('type');  // 要素のデータタイプ属性を取得
            var name = element.attr('name');  // 要素の名前属性を取得

            // 必須フィールドのチェック
            if (element.prop('required') && value === '') {
                errors.push(name + 'は必須です。');
            }

            // 半角数字のチェック
            if (dataType === 'numeric' && !/^\d+$/.test(value)) {
                errors.push(name + 'は半角数字で入力してください。');
            }

            // 半角英数字のチェック
            if (dataType === 'alphanumeric' && !/^[a-zA-Z0-9]+$/.test(value)) {
                errors.push(name + 'は半角英数で入力してください。');
            }

            // メールアドレスの形式チェック
            if (dataType === 'email' && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(value)) {
                errors.push(name + 'は有効なメールアドレスを入力してください。');
            }

            // 最小文字数のチェック
            if (element.attr('minlength') && value.length < element.attr('minlength')) {
                errors.push(name + 'は' + element.attr('minlength') + '文字以上で入力してください。');
            }

            // 最大文字数のチェック
            if (element.attr('maxlength') && value.length > element.attr('maxlength')) {
                errors.push(name + 'は' + element.attr('maxlength') + '文字以内で入力してください。');
            }
        });

        // エラーがあれば、アラートで表示し、フォームの送信を中止
        if (errors.length > 0) {
            alert(errors.join('\n'));
            return;
        }

        // フォームデータの収集
        var formData = {
            userId: $('input[name="userId"]').val(),
            email: $('input[name="email"]').val(),
            password: $('input[name="password"]').val(),
            nickName: $('input[name="nickName"]').val(),
            userName: $('input[name="userName"]').val(),
            sex: $('input[name="sex"]:checked').val(),
            birthday: ('0' + $('select[name="birthdayYear"]').val()).slice(-4) + ('0' + $('select[name="birthdayMonth"]').val()).slice(-2) + ('0' + $('select[name="birthdayDay"]').val()).slice(-2),  // 生年月日を8桁の数字形式に変換
            tel: $('input[name="tel1"]').val() + $('input[name="tel2"]').val() + $('input[name="tel3"]').val(),  // 電話番号を連結
            postcode: $('input[name="postcode1"]').val() + $('input[name="postcode2"]').val(),  // 郵便番号を連結
            address: $('input[name="address"]').val() + ' ' + $('input[name="addressLine2"]').val(),  // 住所を連結
            hireDate: ('0' + $('select[name="hireYear"]').val()).slice(-4) + ('0' + $('select[name="hireMonth"]').val()).slice(-2) + ('0' + $('select[name="hireDay"]').val()).slice(-2),  // 入社日を8桁の数字形式に変換
            affiliation: $('select[name="affiliation"]').val(),
            position: $('input[name="position"]').val(),
            hobby: $('input[name="hobby"]').val(),
            specialSkill: $('input[name="specialSkill"]').val(),
            comment: $('textarea[name="comment"]').val()
        };

        // AJAXリクエストの送信
        $.ajax({
            type: 'POST',
            url: '/OfficeSystem/UserInfoRegistration',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                // 成功時の処理：リダイレクトまたはメッセージ表示
                if (response.redirectUrl) {
                    window.location.href = response.redirectUrl;
                } else {
                    alert(response.message);
                }
            },
            error: function(jqXHR, textStatus, errorThrown) {
                // エラー時の処理
                alert('エラーが発生しました: ' + textStatus);
            }
        });
    }

</script>


</body>
</html>

