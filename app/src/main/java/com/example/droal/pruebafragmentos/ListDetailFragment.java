package com.example.droal.pruebafragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by droal_ara on 6/03/18.
 */

public class ListDetailFragment extends Fragment {



    static ListDetailFragment getInsance (String url){
        ListDetailFragment listDetailFragment = new ListDetailFragment();

        Bundle bundle = new Bundle();
        bundle.putString("wiki_url",url);

        listDetailFragment.setArguments(bundle);
        return listDetailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        showDeatil(view);

        return view;
    }


    private void showDeatil(View view) {

        String wikiUrl = getArguments().getString("wiki_url");

        WebView webView = (WebView) view.findViewById(R.id.list_detail_wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient(){

        });

        webView.setWebViewClient(new WebViewClient(){

        });
        webView.loadUrl(wikiUrl);
    }

}
