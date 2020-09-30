package Listeners_Page;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

    Properties properties;

    public ReadConfig(){
        File src = new File("./Configuration/Config.properties");

        try {
            FileInputStream fis = new FileInputStream(src);
            properties = new Properties();
            properties.load(fis);
        } catch (Exception e) {
            System.out.println("Exception is " + e.getMessage());
        }

    }

    public String getUrl(){
        String Url=properties.getProperty("url");
        return Url;
    }

    public String getbrowserName(){
        String browsername=properties.getProperty("browserName");
        return browsername;
    }

    public String getUsername(){
        String Username=properties.getProperty("Username");
        return Username;
    }

    public String getPassword(){
        String Password=properties.getProperty("password");
        return Password;
    }

    public String getProductName(){
        String pdtname=properties.getProperty("Productname");
        return pdtname;
    }

    public String getInvalidUsrnme(){
        String invaliduname=properties.getProperty("invalidusername");
        return invaliduname;
    }

    public String getcountry(){
        String country=properties.getProperty("country");
        return country;
    }

    public String getfullName(){
        String fullName=properties.getProperty("fullName");
        return fullName;
    }

    public String getMobileNumber(){
        String MobileNumber=properties.getProperty("MobileNumber");
        return MobileNumber;
    }

    public String getHouseNumber(){
        String HouseNumber=properties.getProperty("HouseNumber");
        return HouseNumber;
    }

    public String getTown(){
        String Town=properties.getProperty("Town");
        return Town;
    }

    public String getState(){
        String State=properties.getProperty("State");
        return State;
    }

    public String getvalidpincode(){
        String validpincode=properties.getProperty("validpincode");
        return validpincode;
    }

    public String getinvalidpincode(){
        String invalidpincode=properties.getProperty("invalidpincode");
        return invalidpincode;
    }


}
