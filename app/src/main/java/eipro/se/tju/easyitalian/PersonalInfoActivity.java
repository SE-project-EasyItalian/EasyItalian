package eipro.se.tju.easyitalian;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class PersonalInfoActivity extends Activity {
    private String[] data={"头像", "昵称", "词书"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_info);

        ArrayAdapter adapter=new ArrayAdapter<String>(PersonalInfoActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView=findViewById(R.id.list_view1);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String showText;
                switch (position+1){

                    case 1:
                        showText = "执行第" +1+ "个函数";
                        Toast.makeText(PersonalInfoActivity.this,showText, Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        showText = "执行第" +2+ "个函数";
                        Toast.makeText(PersonalInfoActivity.this,showText, Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        showText = "执行第" +3+ "个函数";
                        Toast.makeText(PersonalInfoActivity.this,showText, Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }

            }
        });


        Button button_back=findViewById(R.id.back_);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(PersonalInfoActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
