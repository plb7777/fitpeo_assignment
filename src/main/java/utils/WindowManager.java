package utils;

public class WindowManager {
	
	static WindowManager _this;
	
	public static WindowManager getInstance() {
		if (_this == null) {
			_this = new WindowManager();
		}
		return _this;
	}
	
	private String mainId;

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId = mainId;
	}	
	
}
