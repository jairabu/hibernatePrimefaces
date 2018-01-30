package model;

import lombok.Data;

@Data
public class Theme {	 
    private int id; 
    private String displayName; 
    private String name;
  
    public Theme() {}
 
    public Theme(int id, String displayName, String name) {
        this.id = id;
        this.displayName = displayName;
        this.name = name;
    }
 
    @Override
    public String toString() {
        return name;
    }
}
