package com.yy.hellotoday.service;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.yy.hellotoday.dto.WeatherInfoDTO;
import com.yy.hellotoday.dto.Sunrise15Day;
import com.yy.hellotoday.dto.Weather7Day;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 描述: 天气服务测试类
 *
 * @author 2yLoo
 * @create 2019-05-09 15:31
 */
public class WeatherServiceTest {

    @Test
    public void testGetTodayWeather() {
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://www.weather.com.cn/data/sk/101250101.html");
            CloseableHttpResponse response = httpclient.execute(httpGet);
            System.out.println(response.getStatusLine());
            HttpEntity entity = response.getEntity();
            System.out.println("toString");
            String result = EntityUtils.toString(entity, StandardCharsets.ISO_8859_1);
            EntityUtils.consume(entity);

            String jsonStr = new String(result.getBytes(StandardCharsets.ISO_8859_1));
            JSONObject jsonObject = JSONObject.parseObject(jsonStr);

            WeatherInfoDTO info = JSONObject.toJavaObject(jsonObject.getJSONObject("weatherinfo"), WeatherInfoDTO.class);
            System.out.println(info);


        }catch (IOException e){
            System.out.println(e);
        }
    }

    @Test
    public void testTencentSunrise() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://wis.qq.com/weather/common?source=pc&weather_type=air%7Crise&province=%E6%B9%96%E5%8D%97&city=%E9%95%BF%E6%B2%99&callback=jQuery111306106531699233368_1557506505523&_=1557506505532")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        Headers responseHeaders = response.headers();
        for (int i = 0; i < responseHeaders.size(); i++) {
            System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        String result = response.body().string();
        System.out.println(result);
        String data = result.substring(result.indexOf("{"), result.indexOf(")"));
        JSONObject dataJson = JSONObject.parseObject(data).getJSONObject("data");
        Sunrise15Day sunRise15Day = JSONObject.toJavaObject(dataJson, Sunrise15Day.class);
        System.out.println(sunRise15Day);
    }

    @Test
    public void testTencentWeather() throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://wis.qq.com/weather/common?source=pc&weather_type=observe%7Cforecast_1h%7Cforecast_24h%7Cindex%7Calarm%7Climit%7Ctips%7Crise&province=%E6%B9%96%E5%8D%97&city=%E9%95%BF%E6%B2%99&county=%E5%A4%A9%E5%BF%83&callback=jQuery111306106531699233368_1557506505523&_=1557506505531")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        String result = response.body().string();
        String data = result.substring(result.indexOf("{"), result.lastIndexOf(")"));
        System.out.println(data);
        JSONObject dataJson = JSONObject.parseObject(data).getJSONObject("data");
        Weather7Day weather7Day = JSONObject.toJavaObject(dataJson, Weather7Day.class);
        System.out.println(weather7Day);
    }

    @Test
    public void testJsonParse() throws Exception{
        String json = "{\n" +
                "\t\"data\": {\n" +
                "\t\t\"index\": {\n" +
                "\t\t\t\"airconditioner\": {\n" +
                "\t\t\t\t\"detail\": \"天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。\",\n" +
                "\t\t\t\t\"info\": \"部分时间开启\",\n" +
                "\t\t\t\t\"name\": \"空调开启\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"allergy\": {\n" +
                "\t\t\t\t\"detail\": \"天气条件不易诱发过敏，可放心外出，除特殊体质外，无需担心过敏问题。\",\n" +
                "\t\t\t\t\"info\": \"不易发\",\n" +
                "\t\t\t\t\"name\": \"过敏\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"carwash\": {\n" +
                "\t\t\t\t\"detail\": \"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。\",\n" +
                "\t\t\t\t\"info\": \"较适宜\",\n" +
                "\t\t\t\t\"name\": \"洗车\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"chill\": {\n" +
                "\t\t\t\t\"detail\": \"温度未达到风寒所需的低温，稍作防寒准备即可。\",\n" +
                "\t\t\t\t\"info\": \"无\",\n" +
                "\t\t\t\t\"name\": \"风寒\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"clothes\": {\n" +
                "\t\t\t\t\"detail\": \"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。\",\n" +
                "\t\t\t\t\"info\": \"热\",\n" +
                "\t\t\t\t\"name\": \"穿衣\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"cold\": {\n" +
                "\t\t\t\t\"detail\": \"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\n" +
                "\t\t\t\t\"info\": \"少发\",\n" +
                "\t\t\t\t\"name\": \"感冒\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"comfort\": {\n" +
                "\t\t\t\t\"detail\": \"白天天气晴好，明媚的阳光在给您带来好心情的同时，也会使您感到有些热，不很舒适。\",\n" +
                "\t\t\t\t\"info\": \"较不舒适\",\n" +
                "\t\t\t\t\"name\": \"舒适度\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"diffusion\": {\n" +
                "\t\t\t\t\"detail\": \"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。\",\n" +
                "\t\t\t\t\"info\": \"中\",\n" +
                "\t\t\t\t\"name\": \"空气污染扩散条件\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"dry\": {\n" +
                "\t\t\t\t\"detail\": \"天气较好，路面比较干燥，路况较好。\",\n" +
                "\t\t\t\t\"info\": \"干燥\",\n" +
                "\t\t\t\t\"name\": \"路况\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"drying\": {\n" +
                "\t\t\t\t\"detail\": \"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！\",\n" +
                "\t\t\t\t\"info\": \"适宜\",\n" +
                "\t\t\t\t\"name\": \"晾晒\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"fish\": {\n" +
                "\t\t\t\t\"detail\": \"较适合垂钓，但天气稍热，会对垂钓产生一定的影响。\",\n" +
                "\t\t\t\t\"info\": \"较适宜\",\n" +
                "\t\t\t\t\"name\": \"钓鱼\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"heatstroke\": {\n" +
                "\t\t\t\t\"detail\": \"气温偏高，有可能中暑，体质较弱的朋友请注意防暑降温，避免长时间在日光下暴晒或在高温环境中工作。\",\n" +
                "\t\t\t\t\"info\": \"少发\",\n" +
                "\t\t\t\t\"name\": \"中暑\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"makeup\": {\n" +
                "\t\t\t\t\"detail\": \"建议用蜜质SPF15以上面霜打底，水质无油粉底霜。\",\n" +
                "\t\t\t\t\"info\": \"去油防晒\",\n" +
                "\t\t\t\t\"name\": \"化妆\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"mood\": {\n" +
                "\t\t\t\t\"detail\": \"天气较好，气温较高，会让人觉得有些烦躁，注意室内通风降温，保持心态平和，给自己的情绪“降降温”。\",\n" +
                "\t\t\t\t\"info\": \"较差\",\n" +
                "\t\t\t\t\"name\": \"心情\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"morning\": {\n" +
                "\t\t\t\t\"detail\": \"天气不错，空气清新，是您晨练的大好时机，建议不同年龄段的人们积极参加户外健身活动。\",\n" +
                "\t\t\t\t\"info\": \"适宜\",\n" +
                "\t\t\t\t\"name\": \"晨练\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"sports\": {\n" +
                "\t\t\t\t\"detail\": \"天气较好，较适宜进行各种运动，但因天气热，请适当减少运动时间，降低运动强度。\",\n" +
                "\t\t\t\t\"info\": \"较适宜\",\n" +
                "\t\t\t\t\"name\": \"运动\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"sunglasses\": {\n" +
                "\t\t\t\t\"detail\": \"白天太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜\",\n" +
                "\t\t\t\t\"info\": \"必要\",\n" +
                "\t\t\t\t\"name\": \"太阳镜\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"sunscreen\": {\n" +
                "\t\t\t\t\"detail\": \"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。\",\n" +
                "\t\t\t\t\"info\": \"中等\",\n" +
                "\t\t\t\t\"name\": \"防晒\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"time\": \"20190511\",\n" +
                "\t\t\t\"tourism\": {\n" +
                "\t\t\t\t\"detail\": \"天气较好，但丝毫不会影响您的心情。微风，虽天气稍热，却仍适宜旅游，不要错过机会呦！\",\n" +
                "\t\t\t\t\"info\": \"适宜\",\n" +
                "\t\t\t\t\"name\": \"旅游\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"traffic\": {\n" +
                "\t\t\t\t\"detail\": \"天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。\",\n" +
                "\t\t\t\t\"info\": \"良好\",\n" +
                "\t\t\t\t\"name\": \"交通\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"ultraviolet\": {\n" +
                "\t\t\t\t\"detail\": \"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\",\n" +
                "\t\t\t\t\"info\": \"中等\",\n" +
                "\t\t\t\t\"name\": \"紫外线强度\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"umbrella\": {\n" +
                "\t\t\t\t\"detail\": \"天气较好，不会降水，因此您可放心出门，无须带雨伞。\",\n" +
                "\t\t\t\t\"info\": \"不带伞\",\n" +
                "\t\t\t\t\"name\": \"雨伞\"\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t},\n" +
                "\t\"message\": \"OK\",\n" +
                "\t\"status\": 200\n" +
                "}";


        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://wis.qq.com/weather/common?source=pc&weather_type=observe%7Cforecast_1h%7Cforecast_24h%7Cindex%7Calarm%7Climit%7Ctips%7Crise&province=%E6%B9%96%E5%8D%97&city=%E9%95%BF%E6%B2%99&county=%E5%A4%A9%E5%BF%83&callback=jQuery111306106531699233368_1557506505523&_=1557506505531")
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful()) {
            throw new IOException("服务器端错误: " + response);
        }

        String result = response.body().string();
        String data = result.substring(result.indexOf("{"), result.lastIndexOf(")"));


        JSONObject dataJson = JSONObject.parseObject(json).getJSONObject("data");
        // JSONObject dataJson = JSONObject.parseObject("{\"data\":{\"alarm\":{},\"forecast_1h\":{\"0\":{\"degree\":\"28\",\"update_time\":\"20190511120000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"4\"},\"1\":{\"degree\":\"30\",\"update_time\":\"20190511130000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"10\":{\"degree\":\"24\",\"update_time\":\"20190511220000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"11\":{\"degree\":\"24\",\"update_time\":\"20190511230000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东风\",\"wind_power\":\"3\"},\"12\":{\"degree\":\"23\",\"update_time\":\"20190512000000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东风\",\"wind_power\":\"3\"},\"13\":{\"degree\":\"22\",\"update_time\":\"20190512010000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"14\":{\"degree\":\"22\",\"update_time\":\"20190512020000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东风\",\"wind_power\":\"3\"},\"15\":{\"degree\":\"21\",\"update_time\":\"20190512030000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"16\":{\"degree\":\"21\",\"update_time\":\"20190512040000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"17\":{\"degree\":\"21\",\"update_time\":\"20190512050000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东风\",\"wind_power\":\"3\"},\"18\":{\"degree\":\"21\",\"update_time\":\"20190512060000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"19\":{\"degree\":\"22\",\"update_time\":\"20190512070000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"2\":{\"degree\":\"30\",\"update_time\":\"20190511140000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"20\":{\"degree\":\"23\",\"update_time\":\"20190512080000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东风\",\"wind_power\":\"3\"},\"21\":{\"degree\":\"24\",\"update_time\":\"20190512090000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"},\"22\":{\"degree\":\"25\",\"update_time\":\"20190512100000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"23\":{\"degree\":\"26\",\"update_time\":\"20190512110000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"24\":{\"degree\":\"27\",\"update_time\":\"20190512120000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"25\":{\"degree\":\"27\",\"update_time\":\"20190512130000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"26\":{\"degree\":\"27\",\"update_time\":\"20190512140000\",\"weather\":\"中雨\",\"weather_code\":\"08\",\"weather_short\":\"中雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"27\":{\"degree\":\"27\",\"update_time\":\"20190512150000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"28\":{\"degree\":\"26\",\"update_time\":\"20190512160000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"29\":{\"degree\":\"26\",\"update_time\":\"20190512170000\",\"weather\":\"中雨\",\"weather_code\":\"08\",\"weather_short\":\"中雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"3\":{\"degree\":\"30\",\"update_time\":\"20190511150000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"30\":{\"degree\":\"25\",\"update_time\":\"20190512180000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"31\":{\"degree\":\"24\",\"update_time\":\"20190512190000\",\"weather\":\"中雨\",\"weather_code\":\"08\",\"weather_short\":\"中雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"32\":{\"degree\":\"23\",\"update_time\":\"20190512200000\",\"weather\":\"中雨\",\"weather_code\":\"08\",\"weather_short\":\"中雨\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"33\":{\"degree\":\"23\",\"update_time\":\"20190512210000\",\"weather\":\"中雨\",\"weather_code\":\"08\",\"weather_short\":\"中雨\",\"wind_direction\":\"西风\",\"wind_power\":\"3\"},\"34\":{\"degree\":\"22\",\"update_time\":\"20190512220000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"西北风\",\"wind_power\":\"3\"},\"35\":{\"degree\":\"22\",\"update_time\":\"20190512230000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"36\":{\"degree\":\"21\",\"update_time\":\"20190513000000\",\"weather\":\"中雨\",\"weather_code\":\"08\",\"weather_short\":\"中雨\",\"wind_direction\":\"西风\",\"wind_power\":\"3\"},\"37\":{\"degree\":\"21\",\"update_time\":\"20190513010000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"西南风\",\"wind_power\":\"3\"},\"38\":{\"degree\":\"21\",\"update_time\":\"20190513020000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"39\":{\"degree\":\"20\",\"update_time\":\"20190513030000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"西南风\",\"wind_power\":\"3\"},\"4\":{\"degree\":\"30\",\"update_time\":\"20190511160000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"40\":{\"degree\":\"20\",\"update_time\":\"20190513040000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"西风\",\"wind_power\":\"3\"},\"41\":{\"degree\":\"20\",\"update_time\":\"20190513050000\",\"weather\":\"阴\",\"weather_code\":\"02\",\"weather_short\":\"阴\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"42\":{\"degree\":\"20\",\"update_time\":\"20190513060000\",\"weather\":\"小雨\",\"weather_code\":\"07\",\"weather_short\":\"小雨\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"43\":{\"degree\":\"20\",\"update_time\":\"20190513070000\",\"weather\":\"阴\",\"weather_code\":\"02\",\"weather_short\":\"阴\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"44\":{\"degree\":\"20\",\"update_time\":\"20190513080000\",\"weather\":\"阴\",\"weather_code\":\"02\",\"weather_short\":\"阴\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"45\":{\"degree\":\"20\",\"update_time\":\"20190513090000\",\"weather\":\"阴\",\"weather_code\":\"02\",\"weather_short\":\"阴\",\"wind_direction\":\"西风\",\"wind_power\":\"3\"},\"46\":{\"degree\":\"20\",\"update_time\":\"20190513100000\",\"weather\":\"阴\",\"weather_code\":\"02\",\"weather_short\":\"阴\",\"wind_direction\":\"西南风\",\"wind_power\":\"3\"},\"47\":{\"degree\":\"21\",\"update_time\":\"20190513110000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"北风\",\"wind_power\":\"3\"},\"5\":{\"degree\":\"30\",\"update_time\":\"20190511170000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"6\":{\"degree\":\"29\",\"update_time\":\"20190511180000\",\"weather\":\"晴\",\"weather_code\":\"00\",\"weather_short\":\"晴\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"7\":{\"degree\":\"26\",\"update_time\":\"20190511190000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"8\":{\"degree\":\"25\",\"update_time\":\"20190511200000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"南风\",\"wind_power\":\"3\"},\"9\":{\"degree\":\"25\",\"update_time\":\"20190511210000\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"东南风\",\"wind_power\":\"3\"}},\"forecast_24h\":{\"0\":{\"day_weather\":\"多云\",\"day_weather_code\":\"01\",\"day_weather_short\":\"多云\",\"day_wind_direction\":\"北风\",\"day_wind_direction_code\":\"8\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"28\",\"min_degree\":\"18\",\"night_weather\":\"多云\",\"night_weather_code\":\"01\",\"night_weather_short\":\"多云\",\"night_wind_direction\":\"西南风\",\"night_wind_direction_code\":\"5\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-10\"},\"1\":{\"day_weather\":\"多云\",\"day_weather_code\":\"01\",\"day_weather_short\":\"多云\",\"day_wind_direction\":\"南风\",\"day_wind_direction_code\":\"4\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"31\",\"min_degree\":\"21\",\"night_weather\":\"多云\",\"night_weather_code\":\"01\",\"night_weather_short\":\"多云\",\"night_wind_direction\":\"东风\",\"night_wind_direction_code\":\"2\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-11\"},\"2\":{\"day_weather\":\"大雨\",\"day_weather_code\":\"09\",\"day_weather_short\":\"大雨\",\"day_wind_direction\":\"南风\",\"day_wind_direction_code\":\"4\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"28\",\"min_degree\":\"20\",\"night_weather\":\"中雨\",\"night_weather_code\":\"08\",\"night_weather_short\":\"中雨\",\"night_wind_direction\":\"北风\",\"night_wind_direction_code\":\"8\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-12\"},\"3\":{\"day_weather\":\"多云\",\"day_weather_code\":\"01\",\"day_weather_short\":\"多云\",\"day_wind_direction\":\"北风\",\"day_wind_direction_code\":\"8\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"24\",\"min_degree\":\"20\",\"night_weather\":\"多云\",\"night_weather_code\":\"01\",\"night_weather_short\":\"多云\",\"night_wind_direction\":\"北风\",\"night_wind_direction_code\":\"8\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-13\"},\"4\":{\"day_weather\":\"多云\",\"day_weather_code\":\"01\",\"day_weather_short\":\"多云\",\"day_wind_direction\":\"东风\",\"day_wind_direction_code\":\"2\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"30\",\"min_degree\":\"21\",\"night_weather\":\"多云\",\"night_weather_code\":\"01\",\"night_weather_short\":\"多云\",\"night_wind_direction\":\"南风\",\"night_wind_direction_code\":\"4\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-14\"},\"5\":{\"day_weather\":\"雷阵雨\",\"day_weather_code\":\"04\",\"day_weather_short\":\"雷阵雨\",\"day_wind_direction\":\"东南风\",\"day_wind_direction_code\":\"3\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"29\",\"min_degree\":\"23\",\"night_weather\":\"雷阵雨\",\"night_weather_code\":\"04\",\"night_weather_short\":\"雷阵雨\",\"night_wind_direction\":\"西南风\",\"night_wind_direction_code\":\"5\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-15\"},\"6\":{\"day_weather\":\"阵雨\",\"day_weather_code\":\"03\",\"day_weather_short\":\"阵雨\",\"day_wind_direction\":\"南风\",\"day_wind_direction_code\":\"4\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"29\",\"min_degree\":\"23\",\"night_weather\":\"中雨\",\"night_weather_code\":\"08\",\"night_weather_short\":\"中雨\",\"night_wind_direction\":\"南风\",\"night_wind_direction_code\":\"4\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-16\"},\"7\":{\"day_weather\":\"阵雨\",\"day_weather_code\":\"03\",\"day_weather_short\":\"阵雨\",\"day_wind_direction\":\"南风\",\"day_wind_direction_code\":\"4\",\"day_wind_power\":\"3\",\"day_wind_power_code\":\"0\",\"max_degree\":\"28\",\"min_degree\":\"23\",\"night_weather\":\"阵雨\",\"night_weather_code\":\"03\",\"night_weather_short\":\"阵雨\",\"night_wind_direction\":\"南风\",\"night_wind_direction_code\":\"4\",\"night_wind_power\":\"3\",\"night_wind_power_code\":\"0\",\"time\":\"2019-05-17\"}},\"index\":{\"airconditioner\":{\"detail\":\"天气热，到中午的时候您将会感到有点热，因此建议在午后较热时开启制冷空调。\",\"info\":\"部分时间开启\",\"name\":\"空调开启\"},\"allergy\":{\"detail\":\"天气条件不易诱发过敏，可放心外出，除特殊体质外，无需担心过敏问题。\",\"info\":\"不易发\",\"name\":\"过敏\"},\"carwash\":{\"detail\":\"较适宜洗车，未来一天无雨，风力较小，擦洗一新的汽车至少能保持一天。\",\"info\":\"较适宜\",\"name\":\"洗车\"},\"chill\":{\"detail\":\"温度未达到风寒所需的低温，稍作防寒准备即可。\",\"info\":\"无\",\"name\":\"风寒\"},\"clothes\":{\"detail\":\"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。\",\"info\":\"热\",\"name\":\"穿衣\"},\"cold\":{\"detail\":\"各项气象条件适宜，发生感冒机率较低。但请避免长期处于空调房间中，以防感冒。\",\"info\":\"少发\",\"name\":\"感冒\"},\"comfort\":{\"detail\":\"白天天气晴好，明媚的阳光在给您带来好心情的同时，也会使您感到有些热，不很舒适。\",\"info\":\"较不舒适\",\"name\":\"舒适度\"},\"diffusion\":{\"detail\":\"气象条件对空气污染物稀释、扩散和清除无明显影响，易感人群应适当减少室外活动时间。\",\"info\":\"中\",\"name\":\"空气污染扩散条件\"},\"dry\":{\"detail\":\"天气较好，路面比较干燥，路况较好。\",\"info\":\"干燥\",\"name\":\"路况\"},\"drying\":{\"detail\":\"天气不错，适宜晾晒。赶紧把久未见阳光的衣物搬出来吸收一下太阳的味道吧！\",\"info\":\"适宜\",\"name\":\"晾晒\"},\"fish\":{\"detail\":\"较适合垂钓，但天气稍热，会对垂钓产生一定的影响。\",\"info\":\"较适宜\",\"name\":\"钓鱼\"},\"heatstroke\":{\"detail\":\"气温偏高，有可能中暑，体质较弱的朋友请注意防暑降温，避免长时间在日光下暴晒或在高温环境中工作。\",\"info\":\"少发\",\"name\":\"中暑\"},\"makeup\":{\"detail\":\"建议用蜜质SPF15以上面霜打底，水质无油粉底霜。\",\"info\":\"去油防晒\",\"name\":\"化妆\"},\"mood\":{\"detail\":\"天气较好，气温较高，会让人觉得有些烦躁，注意室内通风降温，保持心态平和，给自己的情绪“降降温”。\",\"info\":\"较差\",\"name\":\"心情\"},\"morning\":{\"detail\":\"天气不错，空气清新，是您晨练的大好时机，建议不同年龄段的人们积极参加户外健身活动。\",\"info\":\"适宜\",\"name\":\"晨练\"},\"sports\":{\"detail\":\"天气较好，较适宜进行各种运动，但因天气热，请适当减少运动时间，降低运动强度。\",\"info\":\"较适宜\",\"name\":\"运动\"},\"sunglasses\":{\"detail\":\"白天太阳辐射较强，建议佩戴透射比1级且标注UV380-UV400的浅色太阳镜\",\"info\":\"必要\",\"name\":\"太阳镜\"},\"sunscreen\":{\"detail\":\"属中等强度紫外辐射天气，外出时应注意防护，建议涂擦SPF指数高于15，PA+的防晒护肤品。\",\"info\":\"中等\",\"name\":\"防晒\"},\"time\":\"20190511\",\"tourism\":{\"detail\":\"天气较好，但丝毫不会影响您的心情。微风，虽天气稍热，却仍适宜旅游，不要错过机会呦！\",\"info\":\"适宜\",\"name\":\"旅游\"},\"traffic\":{\"detail\":\"天气较好，路面干燥，交通气象条件良好，车辆可以正常行驶。\",\"info\":\"良好\",\"name\":\"交通\"},\"ultraviolet\":{\"detail\":\"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。\",\"info\":\"中等\",\"name\":\"紫外线强度\"},\"umbrella\":{\"detail\":\"天气较好，不会降水，因此您可放心出门，无须带雨伞。\",\"info\":\"不带伞\",\"name\":\"雨伞\"}},\"limit\":{\"tail_number\":\"\",\"time\":\"\"},\"observe\":{\"degree\":\"28\",\"humidity\":\"47\",\"precipitation\":\"0.0\",\"pressure\":\"1000\",\"update_time\":\"201905111145\",\"weather\":\"多云\",\"weather_code\":\"01\",\"weather_short\":\"多云\",\"wind_direction\":\"5\",\"wind_power\":\"2\"},\"rise\":{\"0\":{\"sunrise\":\"05:40\",\"sunset\":\"19:08\",\"time\":\"20190511\"},\"1\":{\"sunrise\":\"05:40\",\"sunset\":\"19:08\",\"time\":\"20190512\"},\"10\":{\"sunrise\":\"05:35\",\"sunset\":\"19:14\",\"time\":\"20190521\"},\"11\":{\"sunrise\":\"05:34\",\"sunset\":\"19:14\",\"time\":\"20190522\"},\"12\":{\"sunrise\":\"05:34\",\"sunset\":\"19:15\",\"time\":\"20190523\"},\"13\":{\"sunrise\":\"05:33\",\"sunset\":\"19:15\",\"time\":\"20190524\"},\"14\":{\"sunrise\":\"05:33\",\"sunset\":\"19:16\",\"time\":\"20190525\"},\"2\":{\"sunrise\":\"05:39\",\"sunset\":\"19:09\",\"time\":\"20190513\"},\"3\":{\"sunrise\":\"05:38\",\"sunset\":\"19:09\",\"time\":\"20190514\"},\"4\":{\"sunrise\":\"05:38\",\"sunset\":\"19:10\",\"time\":\"20190515\"},\"5\":{\"sunrise\":\"05:37\",\"sunset\":\"19:11\",\"time\":\"20190516\"},\"6\":{\"sunrise\":\"05:37\",\"sunset\":\"19:11\",\"time\":\"20190517\"},\"7\":{\"sunrise\":\"05:36\",\"sunset\":\"19:12\",\"time\":\"20190518\"},\"8\":{\"sunrise\":\"05:36\",\"sunset\":\"19:12\",\"time\":\"20190519\"},\"9\":{\"sunrise\":\"05:35\",\"sunset\":\"19:13\",\"time\":\"20190520\"}},\"tips\":{\"observe\":{\"0\":\"光芒透过云缝，洒向大地~\",\"1\":\"现在的温度比较舒适~\"}}},\"message\":\"OK\",\"status\":200}").getJSONObject("data");
        Weather7Day sunRise15Day = JSONObject.toJavaObject(dataJson, Weather7Day.class);
        // JSONObject jsonObject = dataJson.getJSONObject("observe");
        // WeatherObserve observe = JSONObject.toJavaObject(jsonObject, WeatherObserve.class);
        System.out.println(sunRise15Day);
    }

    @Test
    public void testDate(){
        Date dt = new Date();
        //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date =sdf.format(dt);
        System.out.println(date);
    }

}