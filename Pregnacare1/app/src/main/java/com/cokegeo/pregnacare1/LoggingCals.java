package com.cokegeo.pregnacare1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoggingCals extends AppCompatActivity {
    EditText foodTxt, calsTxt, vitsTxt;
    Button logBtn, cancelBtn, resetBtn;
    DatabaseReference reff;
    Member member;
    long maxid=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logging_cals);
        foodTxt=(EditText)findViewById(R.id.foodTxt);
        calsTxt=(EditText)findViewById(R.id.calsTxt);
        vitsTxt=(EditText)findViewById(R.id.vitsTxt);
        logBtn=(Button)findViewById(R.id.logBtn);
        cancelBtn=(Button)findViewById(R.id.cancelBtn);
        resetBtn=(Button)findViewById(R.id.resetBtn);
        member=new Member();
        reff= FirebaseDatabase.getInstance().getReference().child("Member");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=(dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cals=Integer.parseInt(calsTxt.getText().toString().trim());
                Float vits=Float.parseFloat((vitsTxt.getText().toString().trim()));

                member.setFoodName(foodTxt.getText().toString().trim());
                member.setCalories(cals);
                member.setVitamins(vits);

                //reff.push().setValue(member);

                reff.child(String.valueOf(maxid+1)).setValue(member);

                Toast.makeText(LoggingCals.this, "data inserted successfully", Toast.LENGTH_LONG).show();
                //Testing reset button
                resetBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        foodTxt.setText("");
                        calsTxt.setText("");
                        vitsTxt.setText("");
                    }
                });
                //End testing button
            }
        });
    }

    public void CancelLog(View view)
    {
        Intent intent = new Intent(LoggingCals.this, HomeActivity.class);
        startActivity(intent);
    }
}
