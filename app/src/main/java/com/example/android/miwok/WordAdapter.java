package com.example.android.miwok;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.annotation.NonNull;

import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    //private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    int ba;
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param al A List of AndroidFlavor objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> al,int i) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, al);
        ba=i;
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentword = getItem(position);


        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView nameTextView = (TextView) convertView.findViewById(R.id.miwokWord);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        assert currentword != null;
        nameTextView.setText(currentword.getmiwok());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView numberTextView = (TextView) convertView.findViewById(R.id.engWord);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        numberTextView.setText(currentword.geteng());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) convertView.findViewById(R.id.pic);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        if(currentword.hasimage()) {
            iconView.setImageResource(currentword.getImID());
        }
        else{iconView.setVisibility(View.GONE);}
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        View textContainer = convertView.findViewById(R.id.ver);
        int color = ContextCompat.getColor(getContext(), ba);
        convertView.setBackgroundColor(color);



        return convertView;
    }

}


