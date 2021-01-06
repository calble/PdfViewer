package com.gsnathan.pdfviewer;

import android.content.Context;
import android.content.SharedPreferences;

public class DocumentPageStorage {
    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;

    private static final String PREF_FILE = "DOCUMENT_PAGE_STORAGE";

    public DocumentPageStorage(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public void update(String filename, int page){
        editor.putInt(filename, page);
    }

    public int getLastPage(String filename){
        return preferences.getInt(filename, 0);
    }

    public void save(){
        editor.commit();
    }

}
