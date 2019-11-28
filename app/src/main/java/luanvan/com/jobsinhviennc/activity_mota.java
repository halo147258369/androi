package luanvan.com.jobsinhviennc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class activity_mota extends Activity {
    //TextView id, ntd, dchi;
    TextView id, diemdi, diemden,gia,socho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mota);
        id = (TextView)findViewById(R.id.idmota);
        diemdi = (TextView)findViewById(R.id.ntdmota);
        diemden = (TextView)findViewById(R.id.diachimota);
        gia=(TextView)findViewById(R.id.giamota);
        socho=(TextView)findViewById(R.id.sochomota) ;

        Intent intent = getIntent();
//        String  iddata = intent.getStringExtra("id");
//        String ntddata = intent.getStringExtra("ntd");
//        String dchidata = intent.getStringExtra("dchi");
//

       String  iddata = intent.getStringExtra("id");
       String ntddata = intent.getStringExtra("namefrom");
       String dchidata = intent.getStringExtra("nameto");
       //String giadata = intent.getStringExtra("price");

        id.setText(iddata);
        diemdi.setText(ntddata);
        diemden.setText(dchidata);

    }
}
