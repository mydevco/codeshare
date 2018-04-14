module codeshare {
	exports com.mydevco.lambda.util;
	exports com.mydevco.lambda.common;
	exports com.mydevco.lambda.model;
	exports com.mydevco.javabp.io;
	exports com.mydevco.javabp.datetime;
	exports com.mydevco.lambda.commandpattern;
	exports com.mydevco.lambda.strategypattern;
	exports com.mydevco.lambda.unittesting;
	exports com.mydevco.javabp.language;
	exports com.mydevco.javabp.serialization;

	requires commons.csv;
	requires commons.io;
	requires commons.lang3;
	requires commons.logging;
	requires commons.math3;
	requires java.desktop;
	requires java.logging;
	requires json.simple;
	requires junit;
	requires poi;
}