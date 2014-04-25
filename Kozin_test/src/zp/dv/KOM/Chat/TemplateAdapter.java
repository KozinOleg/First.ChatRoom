package zp.dv.KOM.Chat;

import java.util.ArrayList;
import java.util.List;
import com.example.kozin_test.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class TemplateAdapter extends BaseAdapter {

	List<message> template = new ArrayList<message>();

	private LayoutInflater mInflater;

	public TemplateAdapter(Context context, List<message> res) {
		template = res;

		mInflater = LayoutInflater.from(context);
	}

	public int getCount() {
		return template.size();
	}

	public Object getItem(int position) {
		return template.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.chat_item, null);
			holder = new ViewHolder();
			holder.lUserName = (TextView) convertView
					.findViewById(R.id.tvUserName);
			holder.lMessage = (TextView) convertView
					.findViewById(R.id.tvMessage);
			holder.lDate = (TextView) convertView.findViewById(R.id.tvDate);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		holder.lUserName.setText(template.get(position).getName());
		holder.lMessage.setText(template.get(position).getText());
		holder.lDate.setText(String.valueOf(template.get(position).getDate()
				.toString()));

		// convertView.setTag(holder);

		return convertView;
	}

	static class ViewHolder {
		TextView lUserName;
		TextView lMessage;
		TextView lDate;

	}
}
