package G_T.OfficeSystem.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import G_T.OfficeSystem.model.HibProfileInfoModel;
import G_T.OfficeSystem.model.HibUserMasterModel;
import G_T.OfficeSystem.model.UserInfoModel_hi_Service;
import G_T.OfficeSystem.model.UserinfoRegistrationConditionModel;

@Controller
public class UserInfoRegistration {

    @Autowired
    private UserInfoModel_hi_Service userService;

    // ユーザー情報登録画面の表示
    @RequestMapping(value = "/UserInfoRegistration", method = RequestMethod.GET)
    public String UserInfoRegister() {
        // UserInfoRegister.jspファイルを返して、ユーザー情報登録画面を表示
        return "UserInfoRegister";
    }

    // 登録成功画面の表示
    @RequestMapping(value = "/RegistrationSuccess", method = RequestMethod.GET)
    public String RegistrationSuccess() {
        // RegistrationSuccess.jspファイルを返して、登録成功画面を表示
        return "RegistrationSuccess";
    }

    // ユーザー情報の登録処理
    @ResponseBody
    @PostMapping(value = "/UserInfoRegistration", consumes = "application/json", produces = "application/json")
    public Map<String, String> UserInfoRegistrationIAdd(@RequestBody UserinfoRegistrationConditionModel form) {

        // HibUserMasterModelオブジェクトの作成
        HibUserMasterModel user = new HibUserMasterModel();
        user.setUserId(form.getUserId()); // ユーザーIDを設定

        // レスポンスマップの作成
        Map<String, String> response = new HashMap<>();

        // ユーザーIDの重複チェック
        if (userService.isUserIdExists(form.getUserId())) {
            // ユーザーIDがすでに存在する場合、メッセージを設定して返す
            response.put("message", "すでにユーザーIDが登録されています。");
            return response;
        }

        // ユーザー情報の設定
        user.setPassword(form.getPassword()); // パスワードを設定
        user.setEmail(form.getEmail()); // メールアドレスを設定
        user.setUpdatetime(new Timestamp(System.currentTimeMillis())); // 現在のタイムスタンプを設定
        user.setInserttime(new Timestamp(System.currentTimeMillis())); // 現在のタイムスタンプを設定

        // 最終ログイン日時の設定
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = sdf.format(currentTimestamp);
        user.setLastlogindate(formattedTimestamp); // フォーマットされたタイムスタンプを設定

        user.setRegisterLinkTime(new Timestamp(System.currentTimeMillis())); // 登録リンクタイムの設定
        user.setType(1); // ユーザータイプを設定

        // HibProfileInfoModelオブジェクトの作成
        HibProfileInfoModel profile = new HibProfileInfoModel();
        profile.setUserId(user.getUserId()); // ユーザーIDを設定
        profile.setNickName(form.getNickName()); // ニックネームを設定
        profile.setUserName(form.getUserName()); // 氏名を設定
        profile.setBirthday(form.getBirthday()); // 生年月日を設定
        profile.setSex(Integer.parseInt(form.getSex())); // 性別を文字列から整数に変換して設定
        profile.setPostcode(form.getPostcode()); // 郵便番号を設定
        profile.setAddress(form.getAddress()); // 住所を設定
        profile.setTel(form.getTel()); // 電話番号を設定
        profile.setHireDate(form.getHireDate()); // 入社日を設定
        profile.setAffiliation(form.getAffiliation()); // 所属を設定
        profile.setPosition(form.getPosition()); // 役職を設定
        profile.setHobby(form.getHobby()); // 趣味を設定
        profile.setSpecialSkill(form.getSpecialSkill()); // 特技を設定
        profile.setComment(form.getComment()); // 座右銘を設定
        profile.setImageLink("http://dummy.com/image.jpg"); // 画像リンクを設定（仮のリンク）
        profile.setUpdatetime(new Timestamp(System.currentTimeMillis())); // 更新日時を設定
        profile.setInserttime(new Timestamp(System.currentTimeMillis())); // 登録日時を設定

        // ユーザー情報とプロファイル情報を保存
        userService.saveUser(user, profile);

        // 成功した場合のリダイレクトURLを設定
        response.put("redirectUrl", "/OfficeSystem_Hibernate11/RegistrationSuccess");
        return response;
    }
    

    
}