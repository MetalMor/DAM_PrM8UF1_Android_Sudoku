package edu.fje.clot.sudoku.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import edu.fje.clot.sudoku.R;
/**
 * Activitat per mostrar una pantalla d'ajuda.
 * Created by oriol on 11/22/16.
 */

public class HelpActivity extends Activity {
    WebView navegador;

    /**
     * Inicialitza el component.
     * @param icicle Bundle
     */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_help);
        navegador = (WebView) findViewById(R.id.WebKit);

        navegador.getSettings().setJavaScriptEnabled(true);

        navegador.getSettings().setAppCacheEnabled(true);
        navegador.getSettings().setDatabaseEnabled(true);
        navegador.getSettings().setDomStorageEnabled(true);
        navegador.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        navegador.setWebViewClient(new WebViewClient());
        navegador.loadUrl("file:///android_asset/WebHelp/index.html");
    }

}