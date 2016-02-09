package edu.virginia.yl3ak.uvabucketlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ListFragment extends Fragment{
    private RecyclerView itemRecyclerView;
    private ItemAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        itemRecyclerView = (RecyclerView) view.findViewById(R.id.item_recycler_view);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        ListOfItems listOfItems = ListOfItems.get(getActivity());
        List<Item> items = listOfItems.getList();

        mAdapter = new ItemAdapter(items);
        itemRecyclerView.setAdapter(mAdapter);
    }

    private class ItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView titleTextView;
        private CheckBox completedCheckBox;
        private Item mItem;

        public ItemHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            titleTextView = (TextView)itemView.findViewById(R.id.list_item_title_text_view);
            completedCheckBox = (CheckBox)itemView.findViewById(R.id.list_item_completed_checkbox);
            completedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mItem.setCompleted(isChecked);
                }
            });
        }

        public void bindItem(Item item) {
            mItem = item;
            titleTextView.setText(mItem.getTitle());
            completedCheckBox.setChecked(mItem.isCompleted());
        }

        @Override
        public void onClick(View v) {
            Intent intent = ListItemActivity.newIntent(getActivity(), mItem.getId());
            startActivity(intent);

            if (v instanceof CheckBox) {

            }
        }

    }

    private class ItemAdapter extends RecyclerView.Adapter<ItemHolder> {
        private List<Item> mItems;

        public ItemAdapter(List<Item> items){
            mItems = items;
        }

        @Override
        public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(R.layout.list_item, parent, false);
            return new ItemHolder(view);
        }

        @Override
        public void onBindViewHolder(ItemHolder holder, int position) {
            Item item = mItems.get(position);
            holder.bindItem(item);
        }

        @Override
        public int getItemCount() {
            return mItems.size();
        }
    }
}
