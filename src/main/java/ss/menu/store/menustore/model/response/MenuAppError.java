package ss.menu.store.menustore.model.response;

import java.util.Date;

public class MenuAppError {

	private Date dateTime;
	private String message;

	public MenuAppError(Date dateTime, String message) {
		super();
		this.dateTime = dateTime;
		this.message = message;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
