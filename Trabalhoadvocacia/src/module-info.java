module Trabalhoadvocacia {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.media;
	requires jdk.jdi;
	
	opens application to javafx.graphics, javafx.fxml;
	exports application;
}


