package com.yy.hellotoday.model.weather;

import java.io.Serializable;

/**
 * 描述: 天气提醒
 *
 * @author 2yLoo
 * @create 2019-05-11 13:19
 */
public class WeatherIndex implements Serializable {

    /**
     * 时间
     */
    private String time;
    /**
     * 化妆提醒
     */
    private WeatherTip makeup;
    /**
     * 太阳镜提醒
     */
    private WeatherTip sunglasses;
    /**
     * 天气扩散提醒
     */
    private WeatherTip diffusion;
    /**
     * 日光提醒
     */
    private WeatherTip sunscreen;
    /**
     * 心情提醒
     */
    private WeatherTip mood;
    /**
     * 运动提醒
     */
    private WeatherTip sports;
    /**
     * 雨伞提醒
     */
    private WeatherTip umbrella;
    /**
     * 风寒提醒
     */
    private WeatherTip chill;
    /**
     * 过敏提醒
     */
    private WeatherTip allergy;
    /**
     * 旅游提醒
     */
    private WeatherTip tourism;
    /**
     * 冷天提醒
     */
    private WeatherTip cold;
    /**
     * 干燥提醒
     */
    private WeatherTip dry;
    /**
     * 穿衣提醒
     */
    private WeatherTip clothes;
    /**
     * 适宜度提醒
     */
    private WeatherTip comfort;
    /**
     * 早晨提醒
     */
    private WeatherTip morning;
    /**
     * 晾晒提醒
     */
    private WeatherTip drying;
    /**
     * 紫外线提醒
     */
    private WeatherTip ultraviolet;
    /**
     * 垂钓提醒
     */
    private WeatherTip fish;
    /**
     * 中暑提醒
     */
    private WeatherTip heatstroke;
    /**
     * 空调提醒
     */
    private WeatherTip airconditioner;
    /**
     * 洗车提醒
     */
    private WeatherTip carwash;
    /**
     * 交通提醒
     */
    private WeatherTip traffic;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public WeatherTip getMakeup() {
        return makeup;
    }

    public void setMakeup(WeatherTip makeup) {
        this.makeup = makeup;
    }

    public WeatherTip getSunglasses() {
        return sunglasses;
    }

    public void setSunglasses(WeatherTip sunglasses) {
        this.sunglasses = sunglasses;
    }

    public WeatherTip getDiffusion() {
        return diffusion;
    }

    public void setDiffusion(WeatherTip diffusion) {
        this.diffusion = diffusion;
    }

    public WeatherTip getSunscreen() {
        return sunscreen;
    }

    public void setSunscreen(WeatherTip sunscreen) {
        this.sunscreen = sunscreen;
    }

    public WeatherTip getMood() {
        return mood;
    }

    public void setMood(WeatherTip mood) {
        this.mood = mood;
    }

    public WeatherTip getSports() {
        return sports;
    }

    public void setSports(WeatherTip sports) {
        this.sports = sports;
    }

    public WeatherTip getUmbrella() {
        return umbrella;
    }

    public void setUmbrella(WeatherTip umbrella) {
        this.umbrella = umbrella;
    }

    public WeatherTip getChill() {
        return chill;
    }

    public void setChill(WeatherTip chill) {
        this.chill = chill;
    }

    public WeatherTip getAllergy() {
        return allergy;
    }

    public void setAllergy(WeatherTip allergy) {
        this.allergy = allergy;
    }

    public WeatherTip getTourism() {
        return tourism;
    }

    public void setTourism(WeatherTip tourism) {
        this.tourism = tourism;
    }

    public WeatherTip getCold() {
        return cold;
    }

    public void setCold(WeatherTip cold) {
        this.cold = cold;
    }

    public WeatherTip getDry() {
        return dry;
    }

    public void setDry(WeatherTip dry) {
        this.dry = dry;
    }

    public WeatherTip getClothes() {
        return clothes;
    }

    public void setClothes(WeatherTip clothes) {
        this.clothes = clothes;
    }

    public WeatherTip getComfort() {
        return comfort;
    }

    public void setComfort(WeatherTip comfort) {
        this.comfort = comfort;
    }

    public WeatherTip getMorning() {
        return morning;
    }

    public void setMorning(WeatherTip morning) {
        this.morning = morning;
    }

    public WeatherTip getDrying() {
        return drying;
    }

    public void setDrying(WeatherTip drying) {
        this.drying = drying;
    }

    public WeatherTip getUltraviolet() {
        return ultraviolet;
    }

    public void setUltraviolet(WeatherTip ultraviolet) {
        this.ultraviolet = ultraviolet;
    }

    public WeatherTip getFish() {
        return fish;
    }

    public void setFish(WeatherTip fish) {
        this.fish = fish;
    }

    public WeatherTip getHeatstroke() {
        return heatstroke;
    }

    public void setHeatstroke(WeatherTip heatstroke) {
        this.heatstroke = heatstroke;
    }

    public WeatherTip getAirconditioner() {
        return airconditioner;
    }

    public void setAirconditioner(WeatherTip airconditioner) {
        this.airconditioner = airconditioner;
    }

    public WeatherTip getCarwash() {
        return carwash;
    }

    public void setCarwash(WeatherTip carwash) {
        this.carwash = carwash;
    }

    public WeatherTip getTraffic() {
        return traffic;
    }

    public void setTraffic(WeatherTip traffic) {
        this.traffic = traffic;
    }

    @Override
    public String toString() {
        return "WeatherIndex{" +
                "time='" + time + '\'' +
                ", makeup=" + makeup +
                ", sunglasses=" + sunglasses +
                ", diffusion=" + diffusion +
                ", sunscreen=" + sunscreen +
                ", mood=" + mood +
                ", sports=" + sports +
                ", umbrella=" + umbrella +
                ", chill=" + chill +
                ", allergy=" + allergy +
                ", tourism=" + tourism +
                ", cold=" + cold +
                ", dry=" + dry +
                ", clothes=" + clothes +
                ", comfort=" + comfort +
                ", morning=" + morning +
                ", drying=" + drying +
                ", ultraviolet=" + ultraviolet +
                ", fish=" + fish +
                ", heatstroke=" + heatstroke +
                ", airconditioner=" + airconditioner +
                ", carwash=" + carwash +
                ", traffic=" + traffic +
                '}';
    }
}