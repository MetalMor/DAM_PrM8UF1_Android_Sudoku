package edu.fje.clot.sudoku.help;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

/**
 * Classe que carrega la interficie d'ajuda.
 * Created by oriol on 11/25/16.
 */

public class WebAppInterface {

    Context mContext;

    /**
     * Constructor amb 1 parametre.
     * Assigna un context.
     */
    WebAppInterface(Context c) {
        mContext = c;
    }

    /**
     * Mostra un pop-up.
     */
    @JavascriptInterface
    public void mostrarToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}