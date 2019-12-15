package app.eeui.framework.extend.module;


import android.app.Activity;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

import app.eeui.framework.activity.PageActivity;
import app.eeui.framework.ui.eeui;

public class eeuiUpdate {

    private static String url = "";

    private static String title = "";

    private static String content = "";

    private static boolean canCancel = true;


    public static String getTitle() {
        return title;
    }

    public static String getContent() {
        return content;
    }

    public static boolean isCanCancel() {
        return canCancel;
    }

    /****************************************************************************************/
    /****************************************************************************************/
    /****************************************************************************************/

    /**
     * 检查升级
     * @param object
     */
    public static void checkUpdate(JSONObject object) {
        url = eeuiJson.getString(object, "url");
        title = eeuiJson.getString(object, "title");
        content = eeuiJson.getString(object, "content");
        canCancel = eeuiJson.getBoolean(object, "canCancel");
        if (url.startsWith("http://") || url.startsWith("https://")) {
            showUpdate(eeuiJson.getString(object, "templateId", "1"));
        }
    }

    /**
     * 开始升级
     */
    public static void startUpdate() {
        if (url.startsWith("http://") || url.startsWith("https://")) {
            //未完成
        }else{
            Toast.makeText(eeui.getApplication(), "当前已是最新版本！", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 显示升级提示
     */
    public static void showUpdate(String templateId) {
        List<Activity> activityList = eeui.getActivityList();
        for (Activity activity : activityList) {
            if (activity instanceof PageActivity) {
                PageActivity mActivity = (PageActivity) activity;
                mActivity.showUpdate(templateId);
            }
        }
    }

    /**
     * 关闭升级提示
     */
    public static void closeUpdate() {
        List<Activity> activityList = eeui.getActivityList();
        for (Activity activity : activityList) {
            if (activity instanceof PageActivity) {
                PageActivity mActivity = (PageActivity) activity;
                mActivity.closeUpdate();
            }
        }
    }
}
