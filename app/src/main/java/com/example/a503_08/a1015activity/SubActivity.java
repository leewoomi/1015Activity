package com.example.a503_08.a1015activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class SubActivity extends AppCompatActivity {

    TextView SubLabel;
    Button moveMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        SubLabel=(TextView)findViewById(R.id.SubLabel);
        moveMain = (Button)findViewById(R.id.moveMain);

        final Intent intent = getIntent();

        HashMap<String,Object> map = (HashMap<String, Object>)intent.getSerializableExtra("data");

        SubLabel.setText(map.toString());
        moveMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //상위 Activity에게 전달할 데이터 생성
                Intent intent1 = new Intent();
                intent1.putExtra("subdata","하위 Activity에서 넘겨주는 데이터");
                //응답 코드 생성 한 후 데이터 전달
                setResult(100, intent1);

               finish();
            }
        });


        Log.e("SubActivity","Sub의 onCreate 호출");

    }

    public void onResume(){
        super.onResume();
        Log.e("SubActibity","Sub의 onResume호출");
    }
}
