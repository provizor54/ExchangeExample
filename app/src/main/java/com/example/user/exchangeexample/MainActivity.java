package com.example.user.exchangeexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RequiredViewOps {
    @BindView(R.id.num1)
    Button btnNum1;
    @BindView(R.id.num2)
    Button btnNum2;
    @BindView(R.id.num3)
    Button btnNum3;
    @BindView(R.id.num4)
    Button btnNum4;
    @BindView(R.id.num5)
    Button btnNum5;
    @BindView(R.id.num6)
    Button btnNum6;
    @BindView(R.id.num7)
    Button btnNum7;
    @BindView(R.id.num8)
    Button btnNum8;
    @BindView(R.id.num9)
    Button btnNum9;
    @BindView(R.id.num0)
    Button btnNum0;
    @BindView(R.id.clear)
    Button btnClear;
    @BindView(R.id.currentRate)
    Button btnCurrentRate;
    @BindView(R.id.calculate)
    Button btnCalculate;
    @BindView(R.id.value)
    TextView tvValue;
    @BindView(R.id.result)
    TextView tvResult;
    @BindView(R.id.tvCurrentRate)
    TextView tvCurrentRate;
    private MainPresenter mainPresenter;
    @BindView(R.id.containerCurrentRate)
    LinearLayout containerCurrentRate;
    @BindView(R.id.containerResult)
    LinearLayout containerResult;
    @BindView(R.id.history)
    Button btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getComponentInstance().inject(this);
        ButterKnife.bind(this);

        init();
    }

    public void init() {
        mainPresenter = new MainPresenter(this, this);

        RxView.clicks(btnNum1).subscribe(o -> {
            tvValue.append(btnNum1.getText());
        });

        RxView.clicks(btnNum1).subscribe(o -> {
            tvValue.append(btnNum1.getText());
        });

        RxView.clicks(btnNum2).subscribe(o -> {
            tvValue.append(btnNum2.getText());
        });

        RxView.clicks(btnNum3).subscribe(o -> {
            tvValue.append(btnNum3.getText());
        });

        RxView.clicks(btnNum4).subscribe(o -> {
            tvValue.append(btnNum4.getText());
        });

        RxView.clicks(btnNum5).subscribe(o -> {
            tvValue.append(btnNum5.getText());
        });

        RxView.clicks(btnNum6).subscribe(o -> {
            tvValue.append(btnNum6.getText());
        });

        RxView.clicks(btnNum7).subscribe(o -> {
            tvValue.append(btnNum7.getText());
        });

        RxView.clicks(btnNum8).subscribe(o -> {
            tvValue.append(btnNum8.getText());
        });

        RxView.clicks(btnNum9).subscribe(o -> {
            tvValue.append(btnNum9.getText());
        });

        RxView.clicks(btnNum0).subscribe(o -> {
            tvValue.append(btnNum0.getText());
        });

        RxView.clicks(btnHistory).subscribe(o -> {
            startActivity(new Intent(MainActivity.this, HistoryActivity.class));
        });

        RxView.clicks(btnCalculate).subscribe(o -> {
            double value = 0.0;
            double currentRate = 0.0;

            if (getCurrentRate().isEmpty()) {
                showToast(getString(R.string.alert_message_current_rate));
            } else if (getValue().isEmpty()) {
                showToast(getString(R.string.alert_message_value));
            } else {
                value = Double.parseDouble(tvValue.getText().toString());
                currentRate = Double.parseDouble(tvCurrentRate.getText().toString());
                mainPresenter.calculate(value, currentRate);
            }
        });

        RxView.clicks(btnCurrentRate).subscribe(o -> {
            mainPresenter.getCurrentRate();
        });

        RxView.clicks(btnClear).

                subscribe(o ->

                {
                    containerCurrentRate.setVisibility(View.INVISIBLE);
                    containerResult.setVisibility(View.INVISIBLE);
                    tvValue.setText("");
                });
    }

    @Override
    public void showCurrentRate(String currency) {
        containerCurrentRate.setVisibility(View.VISIBLE);
        tvCurrentRate.setText(currency);
    }

    @Override
    public void showResult(String result) {
        containerResult.setVisibility(View.VISIBLE);
        tvResult.setText(result);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public String getCurrentRate() {
        return tvCurrentRate.getText().toString();
    }

    @Override
    public String getValue() {
        return tvValue.getText().toString();
    }

    @Override
    public String getResult() {
        return tvResult.getText().toString();
    }
}
