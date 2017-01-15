package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Vishwajeet
 * starting from 11/1/17.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView englishTranslation = (TextView) listItemView.findViewById(R.id.text_view_english);
        TextView miwokTranslation = (TextView) listItemView.findViewById(R.id.text_view_miwok);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwok_image);

        englishTranslation.setText(currentWord.getEnglishTranslation());
        miwokTranslation.setText(currentWord.getMiwokTranslation());
        imageView.setImageResource(currentWord.getImageResourceId());

        if(currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }

}
