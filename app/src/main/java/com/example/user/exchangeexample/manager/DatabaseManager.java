package com.example.user.exchangeexample.manager;

import android.content.Context;

import com.example.user.exchangeexample.model.DaoMaster;
import com.example.user.exchangeexample.model.DaoSession;
import com.example.user.exchangeexample.model.History;
import com.example.user.exchangeexample.model.HistoryDao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.rx.RxDao;
import org.greenrobot.greendao.rx.RxQuery;

import java.util.List;

/**
 * Created by user on 25.07.17.
 */

public class DatabaseManager {
    private DaoSession daoSession;
    private HistoryDao historyDao;
    //private Query<History> historiesQuery;

    public DatabaseManager(Context context) {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "history-db");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
        historyDao = daoSession.getHistoryDao();

    }

    public List<History> getHistory() {
        return historyDao.loadAll();
    }

    public void insertHistory(History history) {
        historyDao.insert(history);
    }
}
