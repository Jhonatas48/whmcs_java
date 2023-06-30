package br.jhonatastomaz.implementations.models;

public class CustomField {

	private int id;
    private String name;
    private String translatedName;
    private String value;

    public CustomField(int id, String name, String translatedName, String value) {
        this.id = id;
        this.name = name;
        this.translatedName = translatedName;
        this.value = value;
    }

    

    public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getTranslatedName() {
		return translatedName;
	}



	public void setTranslatedName(String translatedName) {
		this.translatedName = translatedName;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	@Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", translatedName='" + translatedName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
