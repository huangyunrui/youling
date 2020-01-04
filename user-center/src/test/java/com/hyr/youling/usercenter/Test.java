package com.hyr.youling.usercenter;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * @author hyr
 * @date 20-1-3-下午8:47
 * @description
 * */
public class Test {
    private static Integer count = 0;
    public static void get() throws InterruptedException {


        List<String> list1 = getList("TEst.txt");

        List<String> list = new ArrayList<>();
        list.add("safari 5.1 – MAC");
        list.add("Mozilla/5.0 (Macintosh; U; Intel Mac OS X 10_6_8; en-us) AppleWebKit/534.50 (KHTML, like Gecko)");
        list.add("Version/5.1 Safari/534.50");
        list.add("safari 5.1 – Windows");
        list.add("Safari/534.50");
        list.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0");
        list.add("Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.0; Trident/4.0)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.0)");
        list.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.6; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        list.add("Mozilla/5.0 (Windows NT 6.1; rv:2.0.1) Gecko/20100101 Firefox/4.0.1");
        list.add("Opera/9.80 (Macintosh; Intel Mac OS X 10.6.8; U; en) Presto/2.8.131 Version/11.11");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Maxthon 2.0)");
        list.add("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_7_0) AppleWebKit/535.11 (KHTML, like Gecko)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; TencentTraveler 4.0)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Trident/4.0; SE 2.X MetaSr 1.0; SE 2.X MetaSr 1.0; .NET CLR 2.0.50727; SE 2.X MetaSr 1.0)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; 360SE)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; Avant Browser)");
        list.add("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
        list.add("Mozilla/5.0 (iPhone; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
        list.add("Mozilla/5.0 (iPod; U; CPU iPhone OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
        list.add("Mozilla/5.0 (iPad; U; CPU OS 4_3_3 like Mac OS X; en-us) AppleWebKit/533.17.9 (KHTML, like Gecko) Version/5.0.2 Mobile/8J2 Safari/6533.18.5");
        list.add("Mozilla/5.0 (Linux; U; Android 2.3.7; en-us; Nexus One Build/FRF91) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        list.add("MQQBrowser/26 Mozilla/5.0 (Linux; U; Android 2.3.7; zh-cn; MB200 Build/GRJ22; CyanogenMod-7) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        list.add("Opera/9.80 (Android 2.3.4; Linux; Opera Mobi/build-1107180945; U; en-GB) Presto/2.8.149 Version/11.10");
        list.add("Mozilla/5.0 (Linux; U; Android 3.0; en-us; Xoom Build/HRI39) AppleWebKit/534.13 (KHTML, like Gecko) Version/4.0 Safari/534.13");
        list.add("Mozilla/5.0 (BlackBerry; U; BlackBerry 9800; en) AppleWebKit/534.1+ (KHTML, like Gecko) Version/6.0.0.337 Mobile Safari/534.1+");
        list.add("Mozilla/5.0 (hp-tablet; Linux; hpwOS/3.0.0; U; en-US) AppleWebKit/534.6 (KHTML, like Gecko) wOSBrowser/233.70 Safari/534.6 TouchPad/1.0");
        list.add("Mozilla/5.0 (SymbianOS/9.4; Series60/5.0 NokiaN97-1/20.0.019; Profile/MIDP-2.1 Configuration/CLDC-1.1) AppleWebKit/525 (KHTML, like Gecko) BrowserNG/7.1.18124");
        list.add("Mozilla/5.0 (compatible; MSIE 9.0; Windows Phone OS 7.5; Trident/5.0; IEMobile/9.0; HTC; Titan)");
        list.add("UCWEB7.0.2.37/28/999");
        list.add("NOKIA5700/ UCWEB7.0.2.37/28/999");
        list.add("Mozilla/4.0 (compatible; MSIE 6.0; ) Opera/UCWEB7.0.2.37/28/999");
        Random random = new Random();
        while (count < 1200){
            for (int i=0;i<list1.size();i++){
                get(list,random.nextInt(list.size()),list1,i,random);
            }
        }

    }
    public static void get(List<String> list,int index,List<String> list2,int index2,Random random) throws InterruptedException {
        for (int i=0;i<10;i++){
            Thread.sleep(random.nextInt(3)*1000);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                // 创建httpget.
                HttpGet httpget = new HttpGet("http://tougao.12371.cn/gaojian.php?tid=3025528");
                // 执行get请求.
                httpget.addHeader("User-Agent", list.get(index));
                // 传输的类型
                httpget.addHeader("Content-Type", "application/x-www-form-urlencoded");
//            httpget.addHeader("x-forwarded-for",list2.get(index2));  //韩国ip
                String[] items=list2.get(index2).split(":");
                if (items.length == 1){
                    return;
                }
                HttpHost proxy = new HttpHost(items[0],Integer.valueOf(items[1]));
                RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(3000).setSocketTimeout(3000).build();
                httpget.setConfig(config);
                CloseableHttpResponse response = httpclient.execute(httpget);
                try {
                    // 获取响应实体
                    HttpEntity entity = response.getEntity();
                    // 打印响应状态
                    System.out.println(response.getStatusLine());
                    if (entity != null) {
                        System.out.println("***************************************");
                        System.out.println("请求完成");
                        count ++;
                        System.out.println("***************************************");
                    }

                } finally {
                    response.close();
                }
            } catch (SocketTimeoutException e){
                break;
            }catch (ClientProtocolException e) {
                e.printStackTrace();
                break;
            } catch (ParseException e) {
                e.printStackTrace();
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            } finally {
                // 关闭连接,释放资源
                try {
                    httpclient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static List<String> getList(String filename){
        File file = new File("/home/rui/java_project/youling/user-center/src/test/java/com/hyr/youling/usercenter/TEst.txt");
        BufferedReader reader = null;
        List<String> list = new ArrayList<>();
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {                // 显示行号
                list.add(tempString);
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
