package zp.dv.KOM.Chat;

import java.util.Date;
import com.example.kozin_test.R;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ChatActivity extends Activity {
	Button btnMarkerSendMessage;
	EditText etChatText;
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		lv = (ListView) findViewById(R.id.listView1);
		btnMarkerSendMessage = (Button) findViewById(R.id.btnSendMessage);
		etChatText = (EditText) findViewById(R.id.etChatText);

		etChatText.addTextChangedListener(new TextWatcher() {

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
				if (s.length() > 0)
					btnMarkerSendMessage.setEnabled(true);
				else
					btnMarkerSendMessage.setEnabled(false);

			}
		});

		btnMarkerSendMessage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				message.ListMessage.add(new message(LoginActivity.loginName,
						etChatText.getText().toString(), new Date()));
				message.ListMessage.add(message.genMessage());

				if (message.ListMessage.size() > 0) {

					lv.setAdapter(new TemplateAdapter(ChatActivity.this,
							message.ListMessage));
					
					 etChatText.setText("");
				}
			}
		});

	}
}
