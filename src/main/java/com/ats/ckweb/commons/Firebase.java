package com.ats.ckweb.commons;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;

public class Firebase {

	// Method to send Notifications from server to client end.
	//public final static String AUTH_KEY_FCM = "AAAAHZVWJIo:APA91bHv6s8hgUrH6t_erPCU7yweVjokN66Y3-zo5ZOyWtBerOayCaCAQrITf-DD8BOVEMQTv7N-hE_FHEdcwy7OdCMsedxDVGXqf0zzFKuSLmoKprNqaVyEUPo68yA_4Pmp_DoHaHzs";
	public final static String AUTH_KEY_FCM = "AAAAHZVWJIo:APA91bFIXx3RXZoQBvbnzj5uXjgcOqw7E7C2RhPx6LJ49NX8Ub1zx4W1fwIlGnVgXauxoEXqwH6qbjR0kbCH6GYhPdaKfsOZqfXQauOiw47oUGwXQkb6j3gJ7D4AYBP8ehuPdKN-K7HF";

	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";

	public static String sendPushNotification(String deviceToken, String title, String body, int tag)
			throws IOException {

		String result = "";
		URL url = new URL(API_URL_FCM);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setUseCaches(false);
		conn.setDoInput(true);
		conn.setDoOutput(true);

		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject json = new JSONObject();
		JSONObject info = new JSONObject();
		try {

			json.put("to", deviceToken.trim());
			info.put("title", title.trim());
			info.put("tag", tag);
			info.put("body", body.trim()); // Notification
			info.put("sound", "default");
			info.put("vibrate", "true");
			json.put("data", info);

		} catch (JSONException e1) {
			e1.printStackTrace();
		}

		try {
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			// System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				// System.out.println(output);
			}
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		}
		System.out.println("------------------------------------------------------------------------");
		System.out.println("FCM Notification is sent successfully");

		return result;
	}


	public static void sendPushNotification1(List<String> deviceTokenList) {
		Sender sender = new Sender(AUTH_KEY_FCM);
		Message msg = new Message.Builder().addData("New Bill Generated", "Approval Pending").build();
		try {
			MulticastResult result = sender.send(msg, deviceTokenList, 5);
			for (Result r : result.getResults()) {
				if (r.getMessageId() != null)
					System.out.println("Push Notification Sent Successfully");
				else
					System.out.println("ErrorCode " + r.getErrorCodeName());
			}
		} catch (IOException e) {
			// System.out.println("Error " + e.getLocalizedMessage());
		}
	}

	public String getDeviceToken(int empId) {
		String result = null;

		return result;

	}

	public ArrayList<Integer> getFireBaseEmpId() {
		ArrayList<Integer> arrEmpId = new ArrayList<>();

		return arrEmpId;
	}

	//AUTH_KEY_FCM
	//public final static String ENQUIRY_FCM_KEY = "AAAA2RWgVfE:APA91bGe10FrLoZQSPVTGnHM3M9uYeiyVFPzzfep3mBIIao7O8NRKSHY641Z-dBVS8VdetQdn0NnpOko2Gd37x9jb6mT_HvyWHMRe8VcWcei8HpzFtgtZki5V7SM2Ti1EX3pzqOhv14R";

	public static void send_FCM_NotificationList(List<String> putIds2, String title, String message, int tag) {
		try {
			// Create URL instance.
			URL url = new URL(API_URL_FCM);
			// create connection.
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// set method as POST or GET
			conn.setRequestMethod("POST");
			// pass FCM server key
			conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
			// Specify Message Format
			conn.setRequestProperty("Content-Type", "application/json");
			// Create JSON Object & pass value

			JSONArray regId = null;
			JSONObject objData = null;
			JSONObject data = null;
			JSONObject notif = null;

			regId = new JSONArray();
			for (int i = 0; i < putIds2.size(); i++) {
				regId.put(putIds2.get(i));
			}
			data = new JSONObject();
			data.put("message", message);
			data.put("title", title);
			data.put("body", message);
			data.put("tag", tag);
			data.put("sound", "default");
			data.put("vibrate", "true");

			objData = new JSONObject();
			objData.put("registration_ids", regId);
			//objData.put("data", data);
			objData.put("notification", data);
			//System.out.println("!_@rj@_group_PASS:>" + objData.toString());

			System.out.println("json :" + objData.toString());
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

			wr.write(objData.toString());
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			if (status != 0) {

				if (status == 200) {
					// SUCCESS message
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					System.out.println("Android Notification Response : " + reader.readLine());
				} else if (status == 401) {
					// client side error
					System.out.println("Notification Response : 401 ");
				} else if (status == 501) {
					// server side error
					System.out.println("Notification Response : 501 ");
				} else if (status == 503) {
					// server side error
					System.out.println("Notification Response : 503 ");
				}
			}
		} catch (MalformedURLException mlfexception) {
			System.out.println("Error occurred while sending push Notification!.." + mlfexception.getMessage());
		} catch (IOException mlfexception) {
			// URL problem
			System.out.println(
					"Reading URL, Error occurred while sending push Notification!.." + mlfexception.getMessage());
			mlfexception.printStackTrace();
		} catch (Exception exception) {
			// General Error or exception.
			System.out.println("Error occurred while sending push Notification!.." + exception.getMessage());
		}
	}


	
	public static void send_FCM_NotificationList(List<String> putIds2, String title, String message, int tag,String image) {
		try {
			// Create URL instance.
			URL url = new URL(API_URL_FCM);
			// create connection.
			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			// set method as POST or GET
			conn.setRequestMethod("POST");
			// pass FCM server key
			conn.setRequestProperty("Authorization", "key=" + AUTH_KEY_FCM);
			// Specify Message Format
			conn.setRequestProperty("Content-Type", "application/json");
			// Create JSON Object & pass value

			JSONArray regId = null;
			JSONObject objData = null;
			JSONObject data = null;
			JSONObject notif = null;

			regId = new JSONArray();
			for (int i = 0; i < putIds2.size(); i++) {
				regId.put(putIds2.get(i));
			}
			data = new JSONObject();
			data.put("message", message);
			data.put("title", title);
			data.put("body", message);
			data.put("tag", tag);
			data.put("sound", "default");
			data.put("vibrate", "true");
			data.put("imageUrl", image);
			
			notif = new JSONObject();
			notif.put("title", title);
			notif.put("body", message);
			notif.put("tag", tag);
			notif.put("image", image);

			objData = new JSONObject();
			objData.put("registration_ids", regId);
			objData.put("data", data);
			objData.put("notification", notif);
			//System.out.println("!_@rj@_group_PASS:>" + objData.toString());

			System.out.println("json :" + objData.toString());
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

			wr.write(objData.toString());
			wr.flush();
			int status = 0;
			if (null != conn) {
				status = conn.getResponseCode();
			}
			if (status != 0) {

				if (status == 200) {
					// SUCCESS message
					BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					System.out.println("Android Notification Response : " + reader.readLine());
				} else if (status == 401) {
					// client side error
					System.out.println("Notification Response : 401 ");
				} else if (status == 501) {
					// server side error
					System.out.println("Notification Response : 501 ");
				} else if (status == 503) {
					// server side error
					System.out.println("Notification Response : 503 ");
				}
			}
		} catch (MalformedURLException mlfexception) {
			System.out.println("Error occurred while sending push Notification!.." + mlfexception.getMessage());
		} catch (IOException mlfexception) {
			// URL problem
			System.out.println(
					"Reading URL, Error occurred while sending push Notification!.." + mlfexception.getMessage());
			mlfexception.printStackTrace();
		} catch (Exception exception) {
			// General Error or exception.
			System.out.println("Error occurred while sending push Notification!.." + exception.getMessage());
		}
	}

	
	

}
