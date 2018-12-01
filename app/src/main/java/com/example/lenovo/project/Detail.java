package com.example.lenovo.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Detail extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    ArrayList<Shirts> ShirtList=new ArrayList<>();

    ImageView image;
    TextView Name;
    TextView  Price;
    TextView Quantity;
    Button Cart;
    Button wishlist;
    String Size;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i=getIntent();

        String name=i.getStringExtra(ProductFragment.EXTRA_MESSAGE);
        Shirts temp3=new Shirts("POLO REPUBLICA HIDAKA",1000,10,10,10);
        ShirtList.add(temp3);
        Shirts temp=getShirt(name);

        image=findViewById(R.id.detailImage);
        Name=findViewById(R.id.detailNAME);
        Price=findViewById(R.id.detailPrice);
        Quantity=findViewById(R.id.detailQuantity);
        Cart=findViewById(R.id.detailCart);
        wishlist=findViewById(R.id.detailwishlist);

        Spinner spinner = (Spinner) findViewById(R.id.size_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.size_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);





        Name.setText(temp.name);
        Price.setText(Integer.toString(temp.price));
        Quantity.setText(Integer.toString(temp.quantity));
        image.setImageResource(R.drawable.shirt_pic);

         Cart.setOnClickListener(new View.OnClickListener() {
           @Override
        public void onClick(View v) {
           AddToCart();
        }
        });

        wishlist.setOnClickListener(new View.OnClickListener() {
          @Override
        public void onClick(View v) {
              AddToWishlist();
          }
        });
    }
    public Shirts getShirt(String name)
    {
        for (int i=0;i<ShirtList.size();i++)
        {
            if(ShirtList.get(i).name.equals(name))
            {
                return ShirtList.get(i);
            }
        }
        return  null;
    }
    public void AddToCart()
    {
        Toast.makeText(this,"Adding to Cart",Toast.LENGTH_LONG).show();
    }
    public void AddToWishlist()
    {
        Toast.makeText(this,"Adding to WishList",Toast.LENGTH_LONG).show();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Size=parent.getItemAtPosition(position).toString();
        Toast.makeText(this,Size,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
