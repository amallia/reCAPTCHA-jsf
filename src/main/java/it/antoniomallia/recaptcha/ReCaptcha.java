package it.antoniomallia.recaptcha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;

public class ReCaptcha {

	private static final String SECRET_KEY = "6LfOJwITAAAAAB8usQzTamzYKGFdP67Tpt2BcxgJ";
	private static final String VERIFY_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s";

	public static boolean validate(FacesContext context) throws IOException {
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String remoteAddr = request.getRemoteAddr();
		String recap = request.getParameter("g-recaptcha-response");
		URL url;

		url = new URL(String.format(VERIFY_URL, SECRET_KEY, recap, remoteAddr));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String line = "";
		StringBuffer output = new StringBuffer();
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				conn.getInputStream()));
		while ((line = reader.readLine()) != null) {
			output.append(line);
		}
		CaptchaResponse capRes = new Gson().fromJson(output.toString(),
				CaptchaResponse.class);
		return capRes.isSuccess();

	}
}
