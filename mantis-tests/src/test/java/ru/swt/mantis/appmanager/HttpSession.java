package ru.swt.mantis.appmanager;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class HttpSession {

	private CloseableHttpClient httpclient;
	private ApplicationManager app;

	public HttpSession (ApplicationManager app) throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		this.app = app;
		httpclient = HttpClients.custom().setSSLSocketFactory(new SSLConnectionSocketFactory(SSLContexts.custom()
						.loadTrustMaterial(null, new TrustSelfSignedStrategy()).build())).setRedirectStrategy(new LaxRedirectStrategy()).build();
	}

	public boolean login(String username, String password) throws IOException {
		HttpPost post = new HttpPost (app.getProperty("web.Url") + "login.php");
		List<NameValuePair> params = new ArrayList<>();
		params.add(new BasicNameValuePair("username", username));
		params.add(new BasicNameValuePair ("password", password));
		params.add(new BasicNameValuePair ("secure_session", "on"));
		params.add(new BasicNameValuePair ("return", "index.php"));
		post.setEntity(new UrlEncodedFormEntity(params));
		CloseableHttpResponse response = httpclient.execute(post);
		String body = getTextFrom(response);
		return body.contains(String.format("<span class=\"italic\">%s</span>", username));
	}

	private String getTextFrom(CloseableHttpResponse response) throws IOException {
		try {
			return EntityUtils.toString(response.getEntity());
		} finally {
			response.close();
		}
	}

	public boolean isLoggedInAs (String username) throws IOException {
		HttpGet get = new HttpGet(app.getProperty("web.Url") + "/index.php");
		CloseableHttpResponse response = httpclient.execute(get);
		String body = getTextFrom(response);
		return body.contains(String.format("<span class=\"italic\">%s</span>", username));
	}

}