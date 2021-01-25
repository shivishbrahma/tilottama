package com.shivishbrahma.tilottama.main.par;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class Wiki {
	final String BASE_URL = "https://en.wikipedia.org/api/rest_v1/page/summary/";
	String subject = null;
	String displayTitle = "";
	String imageURL = "";
	String extractText = "";

	public Wiki(String subject) {
		this.subject = subject;
		getData();
	}

	@SuppressWarnings("deprecation")
	private void getData() {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(BASE_URL + subject).get().build();
		try {
			Response response = client.newCall(request).execute();
			String data = response.body().string();
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(data).getAsJsonObject();

			// get title from JSON response
			displayTitle = jsonObject.get("displaytitle").getAsString();

			// first create a image object and then get image URL
			JsonObject jsonObjectOriginalImage = jsonObject.get("originalimage").getAsJsonObject();
			imageURL = jsonObjectOriginalImage.get("source").getAsString();

			// get text
			extractText = jsonObject.get("extract").getAsString();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the displayTitle
	 */
	public String getDisplayTitle() {
		return displayTitle;
	}

	/**
	 * @param displayTitle the displayTitle to set
	 */
	public void setDisplayTitle(String displayTitle) {
		this.displayTitle = displayTitle;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the extractText
	 */
	public String getExtractText() {
		return extractText;
	}

	/**
	 * @param extractText the extractText to set
	 */
	public void setExtractText(String extractText) {
		this.extractText = extractText;
	}

	public void details() {
		System.out.println(StringHandler.centerAligned("Wikipedia Summary", 64, "="));
		System.out.println(StringHandler.centerAligned("Powered by Wikipedia Api", 64, "-"));
		System.out.println(this.displayTitle);
		System.out.println(this.imageURL);
		System.out.println(this.extractText);
	}
}
