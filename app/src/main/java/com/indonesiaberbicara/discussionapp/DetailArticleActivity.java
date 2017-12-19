package com.indonesiaberbicara.discussionapp;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.indonesiaberbicara.discussionapp.model.Article;
import com.indonesiaberbicara.discussionapp.model.Message;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailArticleActivity extends AppCompatActivity {


    public static class MessageViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_chattext)
        TextView chatText;
        @BindView(R.id.tv_profilename)
        TextView displayName;
        @BindView(R.id.iv_profil)
        ImageView displayPhotos;

        public MessageViewHolder(View itemView) {
            super(itemView);
        }
    }

    @BindView(R.id.messageRecyclerView)
    RecyclerView messageRecyclerView;
    Article activeArticle;
    FirebaseRecyclerAdapter<Message, MessageViewHolder> adapter;
    DatabaseReference dbReference;
    public static final String CHILD = "message";


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_artcle);
        ButterKnife.bind(this);
        activeArticle = DataSource.getInstance().activeArticle;
        FirebaseApp.initializeApp(getApplicationContext());
        dbReference = FirebaseDatabase.getInstance().getReference();

        DatabaseReference  chatReference = dbReference.child(CHILD);
        final SnapshotParser<Message> parser = new SnapshotParser<Message>() {
            @Override
            public Message parseSnapshot(DataSnapshot snapshot) {
                Message message = snapshot.getValue(Message.class);
                System.out.println(message);
                return message;
            }
        };

        FirebaseRecyclerOptions<Message> options = new FirebaseRecyclerOptions.Builder<Message>()
                .setQuery(chatReference, parser)
                .build();


        adapter = new FirebaseRecyclerAdapter<Message, MessageViewHolder>(options) {
            @Override
            protected void onBindViewHolder(MessageViewHolder holder, int position, Message model) {

            }

            @Override
            public MessageViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                return new MessageViewHolder(inflater.inflate(R.layout.item_chat, viewGroup, false));
            }
        };
//
    }


}
