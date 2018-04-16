package com.example.student.myfragment;

import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainFragment mainFragment;
    LoginFragment loginFragment;
    RegisterFragment registerFragment;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.cntn, new MainFragment()).commit();
        }
    }

    public void initUI() {
        mainFragment = new MainFragment();
        loginFragment = new LoginFragment();
        registerFragment = new RegisterFragment();

        fragmentManager = getSupportFragmentManager();
    }

    public void onClickBtn(View v) {
        switch (v.getId()) {
            case R.id.btn :
                fragmentManager.beginTransaction().replace(R.id.cntn, mainFragment).commit();
                break;
            case R.id.main_btn_login :
                fragmentManager.beginTransaction().replace(R.id.cntn, loginFragment).commit();
                break;
            case R.id.main_btn_register :
                registerFragment.setType(1);
                fragmentManager.beginTransaction().replace(R.id.cntn, registerFragment).commit();
                break;
            case R.id.login_btn_register :
                registerFragment.setType(2);
                fragmentManager.beginTransaction().replace(R.id.cntn, registerFragment).commit();
                break;
        }
    }
    public static class MainFragment extends android.support.v4.app.Fragment{
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.mainlayout, container, false);
            return v;
        }
    }

    public static class LoginFragment extends android.support.v4.app.Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.loginlayout, container, false);
            return v;
        }
    }

    public static class RegisterFragment extends android.support.v4.app.Fragment {

        private int type;
        private TextView rgstr_txtv;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
            View v = inflater.inflate(R.layout.registerlayout, container, false);
            rgstr_txtv = v.findViewById(R.id.rgstr_txtv);
            rgstr_txtv.setText(String.valueOf(getType()));
            return v;
        }
    }

}
