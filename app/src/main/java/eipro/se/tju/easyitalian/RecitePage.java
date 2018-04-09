package eipro.se.tju.easyitalian;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


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

                // the following two lines show the usage of getting info from database
                // my.queryAll
                // my.queryForId   根据 id 排序
                // my.queryForAppearTime   根据出现次数排序
                // my.queryForCorrectTime  根据正确次数排序
                // my.queryForIncorrectTime  根据错误次数排序
                DaoOpt my =DaoOpt.Companion.getInstance();
                // Warning!!  java需要处理空指针
                String testword = my.queryAll(getApplicationContext()).get(2).getExample();
                //end

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

    private Word getWordFromXml (Integer num ){
        DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
        try{
            DocumentBuilder dombuilder=dbf.newDocumentBuilder();
            try {
                Document doc = dombuilder.parse(getAssets().open("wordlist.xml"));
                NodeList  wordList = doc.getElementsByTagName("items");
                Word thisWord = new Word();
                thisWord.setId(num.longValue());
                thisWord.setAppearTime(0);
                thisWord.setCorrectTime(0);
                thisWord.setIncorrectTime(0);
                if(num<wordList.getLength()){
                    Node elem = wordList.item(num);
                    thisWord.setWord(elem.getChildNodes().item(1).getTextContent());
                    thisWord.setTransform(elem.getChildNodes().item(3).getTextContent());
                    thisWord.setTranslation(elem.getChildNodes().item(5).getTextContent());
                    thisWord.setExample(elem.getChildNodes().item(7).getTextContent());
                }else {
                    thisWord.setWord("None");
                    thisWord.setTransform("None");
                    thisWord.setTranslation("None");
                    thisWord.setExample("None");
                }
                return thisWord;
            }catch (IOException e){
                Log.e("Error:",e.getMessage());
            }catch (SAXException e) {
                Log.e("Error: ", e.getMessage());
                return null;
            }
            }catch (ParserConfigurationException e){
            Log.e("Error: ", e.getMessage());
            return null;
        }


    return null;

    }

    // call createDatabase() to create wordlist.db
    private void createDatabase(){
        DaoOpt my = DaoOpt.Companion.getInstance();
        my.deleteAllData(this);
        for(Integer i=0;i<20;i++){
            Word insertWord = getWordFromXml(i);
            if(insertWord==null) break;
            my.insertData(this,insertWord);
        }
    }
}
