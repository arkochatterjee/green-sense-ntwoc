package ml.rushabh.greensense;

public class DeviceData{
    public String airHumidity;
    public String gps;
    public String pH;
    public String rtc;
    public String soilMoisture;
    public String temperature;
    public String timeUnderSunlight;
    public DeviceData(){}
    public DeviceData(String airHumidity,
            String gps,
            String pH,
            String rtc,
            String soilMoisture,
            String temperature,
            String timeUnderSunlight){
        this.airHumidity = airHumidity;
        this.gps = gps;
        this.pH = pH;
        this.rtc = rtc;
        this.soilMoisture = soilMoisture;
        this.temperature = temperature;
        this.timeUnderSunlight = timeUnderSunlight;
    }

}
