package edu.virginia.yl3ak.uvabucketlist;

import android.location.Criteria;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.UUID;

public class ListItemFragment extends Fragment{
    private Item listItem;
    private EditText titleField;
    private CheckBox completedCheckBox;
    private EditText itemDescription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID itemId = (UUID) getActivity().getIntent().getSerializableExtra(ListItemActivity.EXTRA_ITEM_ID);
        listItem = ListOfItems.get(getActivity()).getItem(itemId);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list_item, container, false);
        titleField = (EditText)v.findViewById(R.id.list_item_title);
        titleField.setText(listItem.getTitle());
        titleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //This is supposed to be blank
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listItem.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //This is supposed to be blank
            }
        });

        itemDescription = (EditText)v.findViewById(R.id.list_item_description);
        itemDescription.setText(listItem.getDescription());
        itemDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listItem.setDescription(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            });

        completedCheckBox = (CheckBox)v.findViewById(R.id.list_item_completed);
        completedCheckBox.setChecked(listItem.isCompleted());
        completedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                listItem.setCompleted(isChecked);
            }
        });

        return v;
    }

}
