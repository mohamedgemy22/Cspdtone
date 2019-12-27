package com.enggemy22.cap.splash;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.enggemy22.cap.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class fianlSpalsh extends AppCompatActivity {

    @BindView(R.id.finalActivity)
    ImageView finalActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fianl_spalsh);
        ButterKnife.bind(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finalSplash();
    }

    private void finalSplash() {
        AlertDialog.Builder builder = new AlertDialog.Builder(fianlSpalsh.this);
        builder.setTitle("Exit")
                .setMessage(" Are you sure..?")
                .setPositiveButton("Ok", (dialogInterface, i) -> {
                    finish();

                });
        builder.show();
    }

    @OnClick(R.id.finalActivity)
    public void onViewClicked() {
       finalSplash();
    }
}
