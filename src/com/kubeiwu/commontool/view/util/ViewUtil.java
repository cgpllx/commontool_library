package com.kubeiwu.commontool.view.util;

import android.app.Fragment;
import android.content.Context;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

public class ViewUtil {
	public static void creatView(Context mContext) {
		LinearLayout mLinearLayout = new LinearLayout(mContext);
		mLinearLayout.setOrientation(LinearLayout.VERTICAL);
		mLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
	}
}
