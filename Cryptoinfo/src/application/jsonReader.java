package application;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class jsonReader {

	//appending API & key
	String apiKey = "97011da7-fa20-474d-8630-d77b2fadf1aa";
	HttpRequest request = HttpRequest.newBuilder()
			.uri(URI.create("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest"))
			.header("X-CMC_PRO_API_KEY", apiKey).method("GET", HttpRequest.BodyPublishers.noBody()).build();

	//method returning API JSON formatted String
	public String printJson() throws IOException, InterruptedException {
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		String json = response.body();
		return json;
	}
	
	//getting value btc price
	public String getBtcPrice() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String btc = jsonObj[0].substring(1) + "}";
		String btcPrice = "not found";
		int target = btc.indexOf("\"USD\":{\"");
		int deci = btc.indexOf(".", target);
		int start = deci;
		while(btc.charAt(start) != '\"') {
			start--;
		}
		btcPrice = btc.substring(start +2, deci +4);
		
		return btcPrice + "$";
	}
	
	//getting value eth price
	public String getEthPrice() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String eth = jsonObj[1] + "}";
		String ethPrice = "not found";
		int target = eth.indexOf("\"USD\":{\"");
		int deci = eth.indexOf(".", target);
		int start = deci;
		while(eth.charAt(start) != '\"') {
			start--;
		}
		ethPrice = eth.substring(start +2, deci +4);
		
		return ethPrice + "$";
	}
	
	//getting value doge price
	public String getDogePrice() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String doge = jsonObj[12] + "}";
		String dogePrice = "not found";
		int target = doge.indexOf("\"USD\":{\"");
		int deci = doge.indexOf(".", target);
		int start = deci;
		while(doge.charAt(start) != '\"') {
			start--;
		}
		dogePrice = doge.substring(start +2, deci +7);
		
		return dogePrice + "$";
	}
	
	//getting value btc circulating supply
	public String getBtcCirculatingSupply() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String btc = jsonObj[0].substring(1) + "}";
		String cs = "not found";
		int target = btc.indexOf("\"circulating_supply\":");
		int deci = btc.indexOf(",", target);
		int start = deci;
		while(btc.charAt(start) != ':') {
			start--;
		}
		cs = btc.substring(start+1,deci);
		return cs;
	}
	
	//getting value eth circulating supply
	public String getEthCirculatingSupply() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String eth = jsonObj[1] + "}";
		String cs = "not found";
		int target = eth.indexOf("\"circulating_supply\":");
		int deci = eth.indexOf(",", target);
		int start = deci;
		while(eth.charAt(start) != ':') {
			start--;
		}
		cs = eth.substring(start+1,deci);
		return cs;
	}
	
	//getting value doge circulating supply
	public String getDogeCirculatingSupply() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String doge = jsonObj[12] + "}";
		String cs = "not found";
		int target = doge.indexOf("\"circulating_supply\":");
		int deci = doge.indexOf(",", target);
		int start = deci;
		while(doge.charAt(start) != ':') {
			start--;
		}
		cs = doge.substring(start+1,deci);
		return cs;
	}
	
	//getting value btc fluctuation (24H)
	public String getBtcChange() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String btc = jsonObj[0].substring(1) + "}";
		String change = "not found";
		int target = btc.indexOf("\"percent_change_24h\":");
		int deci = btc.indexOf(",", target);
		int start = deci;
		while(btc.charAt(start) != ':') {
			start--;
		}
		change = btc.substring(start+1,deci-6);
		return change + "%";
		
	}
	
	//getting value eth fluctuation (24H)
	public String getEthChange() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String eth = jsonObj[1] + "}";
		String change = "not found";
		int target = eth.indexOf("\"percent_change_24h\":");
		int deci = eth.indexOf(",", target);
		int start = deci;
		while(eth.charAt(start) != ':') {
			start--;
		}
		change = eth.substring(start+1,deci-6);
		return change + "%";
		
	}
	
	//getting value doge fluctuation (24H)
	public String getDogeChange() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String doge = jsonObj[12] + "}";
		String change = "not found";
		int target = doge.indexOf("\"percent_change_24h\":");
		int deci = doge.indexOf(",", target);
		int start = deci;
		while(doge.charAt(start) != ':') {
			start--;
		}
		change = doge.substring(start+1,deci-6);
		return change + "%";
		
	}
	
	//getting value btc market cap
	public String getBtcMarketCap() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String btc = jsonObj[0].substring(1) + "}";
		String MC = "not found";
		int target = btc.indexOf("\"market_cap\":");
		int deci = btc.indexOf(",", target);
		int start = deci;
		while(btc.charAt(start) != ':') {
			start--;
		}
		MC = btc.substring(start+1,deci);
		return MC + "$";
		
	}
	
	//getting value eth market cap
	public String getEthMarketCap() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String eth = jsonObj[1] + "}";
		String MC = "not found";
		int target = eth.indexOf("\"market_cap\":");
		int deci = eth.indexOf(",", target);
		int start = deci;
		while(eth.charAt(start) != ':') {
			start--;
		}
		MC = eth.substring(start+1,deci);
		return MC + "$";
		
	}
	
	//getting value doge market cap
	public String getDogeMarketCap() throws IOException, InterruptedException {
		String[] jsonSplit = printJson().split("\"data\":");
		String[] jsonObj = jsonSplit[1].split("},");
		String doge = jsonObj[12] + "}";
		String MC = "not found";
		int target = doge.indexOf("\"market_cap\":");
		int deci = doge.indexOf(",", target);
		int start = deci;
		while(doge.charAt(start) != ':') {
			start--;
		}
		MC = doge.substring(start+1,deci);
		return MC + "$";
		
	}
}
