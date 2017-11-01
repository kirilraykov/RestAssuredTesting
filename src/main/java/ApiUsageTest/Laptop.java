package ApiUsageTest;

public class Laptop {

	private String brand;
	private String model;
	private int price;
	private Feature feature;
	
	public Laptop() {
		// TODO Auto-generated constructor stub
	}

	
	public Laptop(String brand, String model, int price, Feature feature) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.feature = feature;
		
		
	}

	public Laptop(String brand, String model, int price, String hdd, int ram) {
		this.brand = brand;
		this.model = model;
		this.price = price;
		this.feature = new Feature(hdd, ram);
		
		
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}


	public Feature getFeature() {
		return feature;
	}


	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	@Override
	public String toString() {
		 return "{" + 
				 "\"brand\":\"" + this.getBrand() + "\"," +
				"\"model\":\"" + this.getModel() + "\"," +
				"\"price\":" + this.getPrice() + "," + "\"feature\":" + feature.toString() +
			"}";
	}
	
	
	public class Feature {

		private String HDD;
		private int RAM;
		
		public Feature() {
			// TODO Auto-generated constructor stub
		}
		
		public Feature(String HDD, int RAM) {
			this.HDD = HDD;
			this.RAM = RAM;
			
		}

		public String getHDD() {
			return HDD;
		}

		public void setHDD(String hDD) {
			HDD = hDD;
		}

		public int getRAM() {
			return RAM;
		}

		public void setRAM(int rAM) {
			RAM = rAM;
		}
		
		public String toString() {
			
			return "{" + 
						"\"ram\":" + this.getRAM() + "," +
						"\"hdd\":\"" + this.getHDD() + "\"" +
					"}";
		}
	}
	
	
}
