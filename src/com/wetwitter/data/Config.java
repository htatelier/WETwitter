package com.wetwitter.data;

import org.json.JSONException;
import org.json.JSONObject;

public class Config {

	private static Config instance;
	private JSONObject json;
	private JSONObject curJson = null;
	private String curWeibo;

	public static synchronized Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public Config() {

	}

	public void setJson(JSONObject jobt) {
		json = jobt;
	}

	public JSONObject getJson() {
		return json;
	}

	public String get(String key) {
		String str = null;
		try {
			str = curJson.getString(key);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return str;
	}

	public void setCurWeibo(String weibo) {
		curWeibo = weibo;
		try {
			curJson = json.getJSONObject(curWeibo);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
