package kr.hs.emirim.ycy6685.simpledialog;

import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button but;
    String[] items={"매콤","상콤","달콤","고소","바삭"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //이 문장 호출 후에 리니어레이아웃, 버튼 이런거 다 메모리에 올라감
        but=(Button)findViewById(R.id.but_dialog);
        but.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        //원래는 쓰이는 액티비티의 객체명.this인데 이건 여기서 쓸거니까 this OK
        dialog.setTitle("First Dialog");
        dialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) { //which가 배열의 인덱스를 알아
                but.setText(items[which]);
            }
        });
        dialog.setIcon(R.drawable.first_icon);
        //dialog.setPositiveButton("확인",null); //우리는 창만 닫히고 처리 안할 거니까 널!
        dialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,"대화상자의 확인 버튼을 클릭했어요~", Toast.LENGTH_LONG).show();
                //여기는 이름을 쓰는 이유는 이 안에 객체가 또 있으니까 구분해주려고
            }
        }); //익명 클래스? 익명 객체?? 뭐 씀
        dialog.show();
    }
}
