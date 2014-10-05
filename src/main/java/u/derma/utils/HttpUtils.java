package u.derma.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

/**
 * http工具
 * @author wqgs2004214
 *
 */
public class HttpUtils {
	private static final Logger log = Logger.getLogger(HttpUtils.class); 
	/**
	 * get
	 * @param url
	 * @return
	 */
	public static String request(String url) {
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			BufferedHttpEntity bufferedHttpEntity = new BufferedHttpEntity(response.getEntity());
	        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	        bufferedHttpEntity.writeTo(byteArrayOutputStream);
	        byte[] responseBytes = byteArrayOutputStream.toByteArray();
	        return new String(responseBytes, 0, responseBytes.length);
		} catch (ClientProtocolException e) {
		} catch (IOException e) {
		}
		return "";
	}
}
