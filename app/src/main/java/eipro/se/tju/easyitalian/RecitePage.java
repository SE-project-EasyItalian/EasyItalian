package eipro.se.tju.easyitalian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class RecitePage extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resite_page);



        Button button_remember=findViewById(R.id.remenbered);
        button_remember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        Button button_incognizance=findViewById(R.id.incognizance);
        button_incognizance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(RecitePage.this,WordImformation.class);
                startActivity(intent);
            }
        });
        Button button_back=findViewById(R.id.back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RecitePage.this,MainActivity.class);
                startActivity(intent);
            }
        });

        Button button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RecitePage.this,"nothing", Toast.LENGTH_LONG).show();
            }
        });
        Button button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RecitePage.this,"nothing", Toast.LENGTH_LONG).show();
            }
        });

        Button button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RecitePage.this,"nothing", Toast.LENGTH_LONG).show();
            }
        });
        Button button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(RecitePage.this,"nothing", Toast.LENGTH_LONG).show();
            }
        });
    }

}
