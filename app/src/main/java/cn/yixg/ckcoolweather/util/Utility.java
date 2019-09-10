package cn.yixg.ckcoolweather.util;

import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import cn.yixg.ckcoolweather.db.City;
import cn.yixg.ckcoolweather.db.County;
import cn.yixg.ckcoolweather.db.Province;

/**
 * 处理请求网路返回的json
 * Created by Anry on 2019/9/9.
 */
public class Utility {

    /**
     * 处理返回的省级数据
     */
    public static boolean handleProvinceResponse(String json) {
        if (!TextUtils.isEmpty(json)) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject element = jsonArray.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(element.getString("name"));//得到省名，并设置给实体类
                    province.setProvinceCode(element.getInt("id"));//得到省代码，并设置给实体类
                    province.save();//保存到数据库
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 处理返回的市级数据
     */
    public static boolean handleCityResponse(String json,int provinceId) {
        if (!TextUtils.isEmpty(json)) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject element = jsonArray.getJSONObject(i);
                    City city = new City();
                    city.setCityName(element.getString("name"));
                    city.setCityCode(element.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     * 处理返回的县级数据
     */
    public static boolean handleCountyResponse(String json, int cityId) {
        if (!TextUtils.isEmpty(json)) {
            try {
                JSONArray jsonArray = new JSONArray(json);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject element = jsonArray.getJSONObject(i);
                    County county= new County();
                    county.setCityId(cityId);
                    county.setCountyName(element.getString("name"));
                    county.setWeatherId(element.getString("weather_id"));
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return false;
        }
    }

}
