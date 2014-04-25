package zp.dv.KOM.Chat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class message {
	public static List<message> ListMessage = new ArrayList<message>();

	private String name;
	private String text;
	private Date date;

	public String getName() {
		return name;
	}

	public message(String name, String text, Date date) {
		super();
		this.name = name;
		this.text = text;
		this.date = date;
	}

	public message() {

	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "message [name=" + name + ", text=" + text + ", date=" + date
				+ "]";
	}

	public static message genMessage() {
		String[] lib = { "Да", "Я думаю хорошо", "Это возможно",
				"Думаю, не стоит", "Слишком рано", "Кто знает?",
				"Не надейся на это", "Быть может", "Ни в коем случае",
				"Ты шутишь ?", "Не делай этого" };
		Random rn = new Random();

		message tempMsg = new message("Бот", lib[rn.nextInt(lib.length)],
				new Date());

		return tempMsg;
	}

}
