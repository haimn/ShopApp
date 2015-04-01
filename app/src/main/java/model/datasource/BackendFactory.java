package model.datasource;

import android.content.Context;

import model.backend.Backend;

/**
 * Created by haim on 3/23/15.
 */
public class BackendFactory {
    static Backend instance = null;

    public static String mode = "lists";

    public final static Backend getInstance(Context context)
    {
        if (mode == "lists")
        {
            if (instance == null)
                instance = new model.datasource.DatabaseList(context);
            return instance;
        }
        else return null;
    }
}
