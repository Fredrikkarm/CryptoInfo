package application;

public class jsonObject {
	
	String btcValue;
	String ethValue;
	String dogeValue;
	
	public jsonObject(String btcValue, String ethValue, String dogeValue) {
		
		this.btcValue = btcValue;
		this.ethValue = ethValue;
		this.dogeValue = dogeValue;
	}
	
	public String getBtcValue() {
		return btcValue;
	}
	public String getEthValue() {
		return ethValue;
	}
	public String getDogeValue() {
		return dogeValue;
	}

}
