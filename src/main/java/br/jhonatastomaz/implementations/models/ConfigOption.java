package br.jhonatastomaz.implementations.models;

public class ConfigOption {

	private int id;
    private String option;
    private String type;
    private String value;

    public ConfigOption(int id, String option, String type, String value) {
        this.id = id;
        this.option = option;
        this.type = type;
        this.value = value;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	                ", option='" + option + '\'' +
	                ", type='" + type + '\'' +
	                ", value='" + value + '\'' +
	                '}';
	    }

}
