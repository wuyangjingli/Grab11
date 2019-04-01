package Grab;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class apitest {
    public static void main(String[] args) throws URISyntaxException, IOException {
        getlatLng();
    }

    private static void getlatLng() throws URISyntaxException, IOException {
//        1.打开http客户端
        CloseableHttpClient client = HttpClients.createDefault();
//        2.构建网址
// http://www.mapquestapi.com/geocoding/v1/address?key=KEY&location=Washington,DC
        URI uri = new URIBuilder()
                .setScheme("http")
                .setHost("www.mapquestapi.com")
              //  .setPort(8080)      // 如果网址中没有端口号，可以省略不屑
                .setPath("geocoding/v1/address")
                .setParameter("key","KEY")  //写双引号，逗号 会自动生成
                .setParameter("location","Washington,DC")
                .build();
        System.out.println(uri);
        //        3.创建请求：网址和请求方法
        HttpGet get = new HttpGet(uri);
//        4.执行请求，并获取响应
        CloseableHttpResponse response = client.execute(get);
//        5.打印响应结果
        System.out.println(response);
        response.getStatusLine();
        System.out.println(response.getStatusLine().getStatusCode());
//        每次发送请求，应该首先，校验状态码返回值是否正确
        if (200 == response.getStatusLine().getStatusCode()) {
//            如果等于200，我们再继续解析响应结果
//            如果不等于200，直接报错返回
            response.getEntity();
            System.out.println(response.getEntity());
            String response_txt = EntityUtils.toString(response.getEntity());
            System.out.println(response_txt);

        }


    }

}
