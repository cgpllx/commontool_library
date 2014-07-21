package com.kubeiwu.commontool.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Base64;

/**
 * Tools
 * @author  cgpllx1@qq.com (www.kubeiwu.com)
 * @date    2014-7-21
 */

public class KUtil {
	/**
	 * ave Object To PreferenceFile
	 * @param context
	 * @param pojo   The object needs to be saved
	 * @param key  The only object identification and preservation
	 * @return
	 */
	public static boolean saveObjectToPreferenceFile(Context context, Object object, String key) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		String objectstring = objectToStringByBase64(object);
		return preferences.edit().putString(key, objectstring).commit();
	}

	/**
	 *  getObjectFromPreferenceFile
	 * @param context
	 * @param key
	 * @return
	 */
	public static Object getObjectFromPreferenceFile(Context context, String key) {
		SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
		String base64string = preferences.getString(key, "");
		return TextUtils.isEmpty(base64string) ? null : stringToObjectByBase64(base64string);
	}

	/**
	 * The object into a string using Base64
	 * @param object
	 * @return
	 */
	public static String objectToStringByBase64(Object object) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			String objectstring = Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);

			return objectstring;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(baos);
			close(oos);
		}
		return null;
	}

	/**
	 * String objects using Base6
	 * @param base64string
	 * @return
	 */
	public static Object stringToObjectByBase64(String base64string) {
		Object obj = null;
		ObjectInputStream bis = null;
		ByteArrayInputStream bais = null;
		try {
			byte[] base64 = Base64.decode(base64string, Base64.DEFAULT);
			bais = new ByteArrayInputStream(base64);
			bis = new ObjectInputStream(bais);
			obj = bis.readObject();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(bis);
			close(bais);
		}
		return null;
	}

	private static void close(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void close(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
