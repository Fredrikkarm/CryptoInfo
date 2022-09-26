
module Cryptoinfo {
	
	requires javafx.controls;
	requires javafx.base;
	requires javafx.graphics;
	requires java.net.http;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
	
}
