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
 * Created by oriol on 11/22/16.
 */

public class HelpActivity extends Activity implements View.OnClickListener {
    WebView navegador;

    @Override
    public void onCreate(Bundle icicle) {

        super.onCreate(icicle);
        setContentView(R.layout.activity_help);
        navegador = (WebView) findViewById(R.id.WebKit);


        navegador.getSettings().setJavaScriptEnabled(true);

        //per geolocalització de HTML5
        navegador.getSettings().setAppCacheEnabled(true);
        navegador.getSettings().setDatabaseEnabled(true);
        navegador.getSettings().setDomStorageEnabled(true);
        navegador.setWebChromeClient(new WebChromeClient() {
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
            }
        });
        //per defecte ens obrirà Chrome, cal canviar-ho
        navegador.setWebViewClient(new WebViewClient());
        //navegador.loadUrl("http://www.fje.edu/");
        navegador.loadData("<html><body>hola, mon!</body></html>", "text/html", "UTF-8");
//        navegador.loadData("<html><body><input type=\"button\" value=\"Hola\" onClick=\"mostrarToast('Hola Android!')\" />\n" +
//                "<script type=\"text/javascript\">\n" +
//                "function mostrarToast(toast) {\n" +
//                "Android.mostrarToast(toast);\n" +
//                "}\n" +
//                "</script></body></html>", "text/html", "UTF-8");
//       navegador.addJavascriptInterface (new WebAppInterface (this), "Android");
        //navegador.loadUrl("file:///android_asset/html5_geolocalizacion4.html");

    }

    @Override
    public void onClick(View view) {

    }

}
