package zp.dv.KOM.Chat;

import com.example.kozin_test.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	Button btnLogin;
	EditText etLogin, etPass;
	public static String loginName = "userDefault";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		btnLogin = (Button) findViewById(R.id.btnLogin);
		etLogin = (EditText) findViewById(R.id.etlogin);
		etPass = (EditText) findViewById(R.id.etPass);

		etLogin.addTextChangedListener(myTextWatcher);
		etPass.addTextChangedListener(myTextWatcher);

		btnLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				boolean marker = true;

				if (etLogin.getText().toString() == null
						|| etPass.getText().toString() == null) {
					marker = false;
				} else {

					if (!new LoginValidator().validate(etLogin.getText()
							.toString())) {
						Toast.makeText(LoginActivity.this,
								"Логин не в формате электронного адреса!",
								Toast.LENGTH_LONG).show();
						marker = false;
					}

					if (!new PasswordValidator().validate(etPass.getText()
							.toString())) {
						Toast.makeText(
								LoginActivity.this,
								"Пароль должен быть не меньше 6 символов,\n"
										+ " содержать буквы цыфры,\n"
										+ " и уникальные символы '-','_'",
								Toast.LENGTH_LONG).show();
						marker = false;
					}
				}

				if (marker) {
					loginName = etLogin.getText().toString();
					startActivity(new Intent(LoginActivity.this,
							ChatActivity.class));
				}
			}
		});

	}

	TextWatcher myTextWatcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {
		}

		@Override
		public void afterTextChanged(Editable s) {
			if (etLogin.length() > 0 && etPass.length() > 0)
				btnLogin.setEnabled(true);
			else
				btnLogin.setEnabled(false);

		}
	};

}
