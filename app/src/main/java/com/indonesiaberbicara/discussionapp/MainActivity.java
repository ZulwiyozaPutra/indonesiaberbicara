package com.indonesiaberbicara.discussionapp;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.indonesiaberbicara.discussionapp.model.Article;
import com.indonesiaberbicara.discussionapp.model.Content;
import com.indonesiaberbicara.discussionapp.model.Message;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    Article activeArticle;

    TextView articleTextView;
    @BindView(R.id.tv_artice_title)
    TextView tvArticeTitle;
    @BindView(R.id.tv_article_date)
    TextView tvArticleDate;
    @BindView(R.id.cv_article)
    CardView cvArticle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activeArticle = DataSource.getInstance().activeArticle;
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setArticleOnView();
        setUpCardOnClickListener();

    }

    void setArticleTitleOnTextView() {
        articleTextView =  findViewById(R.id.tv_artice_title);
        String title = activeArticle.getTitle();
        articleTextView.setText(title);
    }

    void setArticleDateOnTextView() {
        Date date = activeArticle.getCreated();
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        String stringDate = dateFormat.format(date);
        tvArticleDate.setText(stringDate);
        System.out.println(stringDate);
    }

    void setArticleOnView() {
        setArticleDateOnTextView();
        setArticleTitleOnTextView();
    }

    void presentDetailView() {
        MainActivity context = MainActivity.this;
        Intent intent = new Intent(context, DetailArticleActivity.class);
        startActivity(intent);
    }

    void setUpCardOnClickListener() {
        cvArticle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentDetailView();
                DataSource source = new DataSource();
                System.out.println(source.getMessages());
            }
        });
    }
}
