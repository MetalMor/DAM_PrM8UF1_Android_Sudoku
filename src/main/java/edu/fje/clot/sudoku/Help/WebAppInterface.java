package edu.fje.clot.sudoku.Help;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Created by oriol on 11/25/16.
 */

public class WebAppInterface {

    Context mContext;

    /**
     * instancia la interfície i l'associa el context
     */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /**
     * mostra una torrada
     */
    @JavascriptInterface
    public void mostrarToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}