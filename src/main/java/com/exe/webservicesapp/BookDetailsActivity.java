package com.exe.webservicesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class BookDetailsActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK_DETAILS_TITLE = "com.exe.webservicesapp.BOOK_DETAILS_TITLE";
    public static final String EXTRA_BOOK_DETAILS_AUTHOR = "com.exe.webservicesapp.BOOK_DETAILS_AUTHOR";
    public static final String EXTRA_BOOK_DETAILS_COVER_ID = "com.exe.webservicesapp.BOOK_DETAILS_COVER_ID";
    private TextView titleTextView;
    private TextView authorTextView;
    private ImageView cover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);

        titleTextView = findViewById(R.id.book_detail_title);
        authorTextView = findViewById(R.id.book_detail_author);
        cover = findViewById(R.id.img_detail_cover);

        Intent starter = getIntent();
        titleTextView.setText(starter.getStringExtra(EXTRA_BOOK_DETAILS_TITLE));
        authorTextView.setText(starter.getStringExtra(EXTRA_BOOK_DETAILS_AUTHOR));
        String coverId = starter.getStringExtra(EXTRA_BOOK_DETAILS_COVER_ID);
        if (coverId != null)
            Picasso.with(this)
                    .load(MainActivity.IMAGE_URL_BASE + coverId + "-L.jpg")
                    .placeholder(R.drawable.ic_book)
                    .into(cover);
        else
            cover.setImageResource(R.drawable.ic_book);
    }
}