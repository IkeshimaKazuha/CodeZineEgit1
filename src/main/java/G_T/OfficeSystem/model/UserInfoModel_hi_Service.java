package G_T.OfficeSystem.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// サービス層のクラスを定義するアノテーション
@Service
public class UserInfoModel_hi_Service {

    // UserInfoModel_hi（DAO層）のインスタンスを自動的に注入
    @Autowired
    private UserInfoModel_hi userDao;

    // トランザクション管理を行うためのアノテーション
    @Transactional
    public void saveUser(HibUserMasterModel user, HibProfileInfoModel profile) {
        // HibUserMasterModelオブジェクトにHibProfileInfoModelオブジェクトを設定
        user.setHibProfileInfoModel(profile);

        // HibProfileInfoModelオブジェクトにHibUserMasterModelオブジェクトを設定
        profile.setHibUserMasterModel(user);

        // UserDaoを使ってユーザー情報をデータベースに保存
        userDao.saveUser(user);
    }

    // ユーザーIDが存在するかどうかを確認するメソッド
    public boolean isUserIdExists(String userId) {
        // UserDaoを使ってユーザーIDの存在をチェック
        return userDao.isUserIdExists(userId);
    }
}
