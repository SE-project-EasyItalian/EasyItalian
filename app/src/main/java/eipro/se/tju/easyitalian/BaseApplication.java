package eipro.se.tju.easyitalian;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import eipro.se.tju.easyitalian.gen.DaoSession;
import eipro.se.tju.easyitalian.gen.DaoMaster;

public class BaseApplication extends Application {
    private DaoSession daoSession = null;
    @Override
    public void onCreate(){
        super.onCreate();
        //配置数据库

        setupDatabase();
        GreenDaoManager.Companion.getInstance();
    }

    private void setupDatabase(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "wordList.db", null);
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    public DaoSession getDaoInstant() {
        return daoSession;
    }

}
