package application;
	
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			
			jsonReader jr = new jsonReader();
			BorderPane root = new BorderPane();
			
			//creating table
			TableView table = new TableView<jsonObject>();
			
			//creating column BTC
			TableColumn btcCol = new TableColumn<jsonObject, String>("BTC");
			btcCol.setCellValueFactory(new PropertyValueFactory<jsonObject, String>("btcValue"));
			
			//creating column ETH
			TableColumn ethCol = new TableColumn<jsonObject, String>("ETH");
			ethCol.setCellValueFactory(new PropertyValueFactory<jsonObject, String>("ethValue"));
			
			//creating column DOGE
			TableColumn dogeCol = new TableColumn<jsonObject, String>("DOGE");
			dogeCol.setCellValueFactory(new PropertyValueFactory<jsonObject, String>("dogeValue"));
			
			//adding columns to table
			table.getColumns().add(btcCol);
			table.getColumns().add(ethCol);
			table.getColumns().add(dogeCol);
			
			//making sizing fixed
			table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
			
			//adding get methods to rows
			table.getItems().add(new jsonObject("Price: " +jr.getBtcPrice(), "Price: " + jr.getEthPrice(), "Price: " + jr.getDogePrice()));
			table.getItems().add(new jsonObject("Circulating Supply: " + jr.getBtcCirculatingSupply(), "Circulating Supply: " + jr.getEthCirculatingSupply(), "Circulating Supply: " + jr.getDogeCirculatingSupply()));
			table.getItems().add(new jsonObject("Change 24H: " + jr.getBtcChange(), "Change 24H: " + jr.getEthChange(), "Change 24H: " + jr.getDogeChange()));
			table.getItems().add(new jsonObject("Market Cap: " + jr.getBtcMarketCap(), "Market Cap: " + jr.getEthMarketCap(), "Market Cap: " + jr.getDogeMarketCap()));
			
			//putting table to scene
			root.setCenter(table);
			
			Scene scene = new Scene(root, 800, 800);
			primaryStage.setTitle("Crypto price");
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		launch(args);
	}

}
