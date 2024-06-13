package G_T.OfficeSystem.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

// サービス層のクラスを定義するアノテーション
@Service
// セッションスコープの設定をするアノテーション
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserInfoModel_hi {

    // SessionFactoryのインスタンスを自動的に注入
    @Autowired
    private SessionFactory sessionFactory;

    // ユーザーをデータベースに保存するメソッド
    public void saveUser(HibUserMasterModel user) {
        // Hibernateセッションを開く
        Session session = sessionFactory.openSession();
        // トランザクションオブジェクトを初期化
        Transaction transaction = null;
        try {
            // トランザクションを開始
            transaction = session.beginTransaction();
            // ユーザーオブジェクトを保存
            session.save(user);
            // トランザクションをコミット
            transaction.commit();
        } catch (Exception e) {
            // エラーが発生した場合、トランザクションをロールバック
            if (transaction != null) {
                transaction.rollback();
            }
            // エラースタックトレースを出力
            e.printStackTrace();
        } finally {
            // セッションを閉じる
            session.close();
        }
    }

    // ユーザーIDが存在するかどうかを確認するメソッド
    public boolean isUserIdExists(String userId) {
        // Hibernateセッションを開く
        Session session = sessionFactory.openSession();
        try {
            // ユーザーIDを使ってユーザーオブジェクトを取得
            HibUserMasterModel user = (HibUserMasterModel) session.get(HibUserMasterModel.class, userId);
            // ユーザーオブジェクトがnullでない場合はtrueを返す
            return user != null;
        } finally {
            // セッションを閉じる
            session.close();
        }
    }
}
