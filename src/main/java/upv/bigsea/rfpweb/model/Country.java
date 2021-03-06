package upv.bigsea.rfpweb.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Country {
  
  protected int id;
  protected String name;
  protected String code;
  protected String osmDlURL;
  protected List<City> cities;
  @JsonIgnore
  protected Map<String, City> citiesByCode;
  
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
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public List<City> getCities() {
    return cities;
  }
  public void setCities(List<City> cities) {
    this.cities = cities;
    genCitiesByCode();
  }  
  
  public String getOsmDlURL() {
    return osmDlURL;
  }
  public void setOsmDlURL(String osmDlURL) {
    this.osmDlURL = osmDlURL;
  }
  @JsonIgnore
  public City getCity(String cityCode)
  {
    if (citiesByCode != null)
      return citiesByCode.get(cityCode);
    else 
      return null;
  }
  
  @JsonIgnore
  public void genCitiesByCode()
  {
    citiesByCode = new HashMap<String, City>();
    for (City c : cities)
    {
      citiesByCode.put(c.getCode(), c);
    }
  }
  
  

}
