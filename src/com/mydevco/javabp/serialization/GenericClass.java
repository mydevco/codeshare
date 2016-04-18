package com.mydevco.javabp.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class GenericClass<T extends Serializable> {

	private String genericName;
	private T genericInstance;

	public GenericClass(T genericInstance) {
		super();
		this.genericInstance = genericInstance;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public T getGenericInstance() {
		return genericInstance;
	}

	public void setGenericInstance(T genericInstance) {
		this.genericInstance = genericInstance;
	}

	public static void main(String[] args) {
		SerializableClass sc = new SerializableClass(
				"MyDeveloperConnection.com");
		System.out.println("Serializable class is :" + sc.toString());

		// serialize
		try (FileOutputStream fos = new FileOutputStream("testSerial");
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(sc);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// deserialize
		try (FileInputStream fis = new FileInputStream("testSerial");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			SerializableClass deserialized = (SerializableClass) ois
					.readObject();
			System.out.println("Deserialized class is :"
					+ deserialized.toString());
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
