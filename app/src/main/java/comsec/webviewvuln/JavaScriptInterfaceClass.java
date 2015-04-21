package comsec.webviewvuln;

import android.content.Context;
import android.widget.Toast;

public class JavaScriptInterfaceClass {

    Context mContext;

    JavaScriptInterfaceClass(Context c) {
        mContext = c;
    }

    //Only for 4.4 Versions -@JavascriptInterface
    public void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }
}
