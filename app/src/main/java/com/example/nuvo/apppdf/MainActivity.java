package com.example.nuvo.apppdf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class MainActivity extends AppCompatActivity {

    public PDFView pdfView;
    public float zoomValue=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pdfView = (PDFView) findViewById(R.id.pdfView);
        pdfView.fromAsset("babtik.pdf").defaultPage(0)
                .spacing(10)
                .load();

//        scrollBar= (ScrollBar) findViewById(R.id.ScrollBar);
//        pdfView.setScrollBar(scrollBar);
//        //VERTICAL SCROLLING
//        scrollBar.setHorizontal(false);

    }

    public void  nextPage(View view){
        pdfView.jumpTo(pdfView.getCurrentPage()+1,true);
    }

    public void  prevPage(View view){
        pdfView.jumpTo(pdfView.getCurrentPage()-1,true);
    }

    public void zoomIn(View view){
        ++zoomValue;
        pdfView.zoomTo(zoomValue);
        pdfView.loadPages();
    }

    public void zoomOut(View view){

        if (zoomValue!=1){
            --zoomValue;
            pdfView.zoomTo(zoomValue);
            pdfView.loadPages();
        }

    }
}
