package com.example.gumballfamily;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zulkarnaen.gumball.data.GumballFamily;
import com.zulkarnaen.gumball.data.GumballFamilyData;
import com.zulkarnaen.gumball.service.ItemClickSupport;
import com.zulkarnaen.gumball.view.CardViewGumballFamily;
import com.zulkarnaen.gumball.view.GridViewGumballFamily;
import com.zulkarnaen.gumball.view.RowViewGumballFamily;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private RecyclerView rvCategory;
    private RecyclerView rvCategory1;
    private ArrayList<GumballFamily> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

//        rvCategory1 = (RecyclerView)findViewById(R.id.rv_category1);
//        rvCategory1.setHasFixedSize(true);

//        list = new ArrayList<>();
        list.addAll(GumballFamilyData.getListData());
        showRecylerCardView();
//        showRowView();

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.action_list:
//                setActionBarTitle("Gumball Family");
//                setActionBarTitle("Mode List");
//                showRowView();
//                break;
//
//            case R.id.action_grid:
//                setActionBarTitle("Mode Grid");
//                showGridView();
//                break;
//
//            case R.id.action_cardview:
//                setActionBarTitle("Mode CardView");
//                showRecylerCardView();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    private void showRecylerCardView() {
        setContentView(R.layout.activity_main);


        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewGumballFamily cardViewPresidentAdapter= new CardViewGumballFamily(this);
        cardViewPresidentAdapter.setListGumball(list);
        rvCategory.setAdapter(cardViewPresidentAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedGumballFamily(list.get(position));
            }
        });

    }

//    private void showGridView() {
//        setContentView(R.layout.activity_main);
//
//
//        rvCategory = (RecyclerView)findViewById(R.id.rv_category);
//        rvCategory.setHasFixedSize(true);
//
//        rvCategory.setLayoutManager(new LinearLayoutManager(this));
//        GridViewGumballFamily gridViewGumballFamily= new GridViewGumballFamily(this);
//        gridViewGumballFamily.setListGumball(list);
//        rvCategory.setAdapter(gridViewGumballFamily);
//
//        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                showSelectedGumballFamily(list.get(position));
//            }
//        });
//
//    }
//
//    private void showRowView() {
//        setContentView(R.layout.activity_main2);
//
//        rvCategory1 = (RecyclerView)findViewById(R.id.rv_category1);
//        rvCategory1.setHasFixedSize(true);
//
//        rvCategory1.setLayoutManager(new LinearLayoutManager(this));
//        RowViewGumballFamily rowViewGumballFamily= new RowViewGumballFamily(this);
//        rowViewGumballFamily.setListGumball(list);
//        rvCategory1.setAdapter(rowViewGumballFamily);
//
//        ItemClickSupport.addTo(rvCategory1).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
//            @Override
//            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
//                showSelectedGumballFamily(list.get(position));
//            }
//        });
//
//    }

    private void showSelectedGumballFamily(GumballFamily gumballFamily){
        Toast.makeText(this, "Kamu memilih "+gumballFamily.getName(), Toast.LENGTH_SHORT).show();
    }
}
