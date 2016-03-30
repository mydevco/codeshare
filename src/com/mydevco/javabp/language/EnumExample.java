package com.mydevco.javabp.language;

public class EnumExample {
	
	public enum MobilePhone{
		IPHONE6SPLUS("apple","iOS","9.3", 6.1f), IPHONE6S("apple","iOS","9.3", 5.4f), NEXUS6P("google","android","6.0", 5.5f), GALAXYS7("samsung","andoid","6.0", 5.6f);
		
		private String vendor;
		private String os;
		private String osVersion;
		private float screenSize;
		
		public String getVendor() {
			return vendor;
		}
		public void setVendor(String vendor) {
			this.vendor = vendor;
		}
		public String getOs() {
			return os;
		}
		public void setOs(String os) {
			this.os = os;
		}
		public String getOsVersion() {
			return osVersion;
		}
		public void setOsVersion(String osVersion) {
			this.osVersion = osVersion;
		}

		public float getScreenSize() {
			return screenSize;
		}
		public void setScreenSize(float screenSize) {
			this.screenSize = screenSize;
		}
		
		private MobilePhone(String vendor, String os, String osVersion,
				float screenSize) {
			this.vendor = vendor;
			this.os = os;
			this.osVersion = osVersion;
			this.screenSize = screenSize;
		}
		
		
	}
	
	public static void main(String[] args) {
		
		MobilePhone myPhone = MobilePhone.IPHONE6S;
		
		MobilePhone yourPhone = MobilePhone.GALAXYS7;
		
		if(myPhone.getVendor().equals(yourPhone.getVendor())) {
			System.out.println("We both have phones from same vendor.");
		}
	}

}
