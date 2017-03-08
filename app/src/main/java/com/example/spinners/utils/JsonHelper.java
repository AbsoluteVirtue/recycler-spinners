package com.example.spinners.utils;

import android.content.Context;
import android.content.res.Resources;

import com.example.spinners.R;
import com.example.spinners.model.QaItem;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class JsonHelper {

    public static String exportJson(Context context, List<QaItem> data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    public static List<QaItem> importJson(Context context, String json) {
        Type listType = new TypeToken<List<QaItem>>(){}.getType();
        Gson gson = new Gson();
        return gson.fromJson(json, listType);

//        DataItems dataItems = gson.fromJson(json, DataItems.class);
//        return dataItems.getDataItems();
    }

    private static class DataItems {
        List<QaItem> dataItems;

        List<QaItem> getDataItems() {
            return dataItems;
        }

        void setDataItems(List<QaItem> dataItems) {
            this.dataItems = dataItems;
        }
    }
}
