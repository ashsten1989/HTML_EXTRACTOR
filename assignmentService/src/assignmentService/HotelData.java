package assignmentService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.json.JSONException;
import org.json.JSONObject;
//import org.jsoup.nodes.Element;


public class HotelData extends Extractor {

	private String hotelname;
	private String totalPerRoom;
	private String arrivaldate;
	private String departuredata;
	private Date timestamp;


	HotelData(File htmlfile) {
		super(htmlfile);
		//this.htmlfile=getHtmlfile();
		// TODO Auto-generated constructor stub
	}

	@Override
	public JSONObject   Extract() {
		JSONObject json=new JSONObject();
		File htmlfile=getHtmlfile();
		try {
			Document doc = Jsoup.parse(htmlfile, "UTF-8", " ");
			Element link1 = doc.getElementById("hotelName");
			setHotelname(link1.text());



			Elements link2 = doc.select("font[style*=Helvetica,Arial,sans-serif;font-size:16px;line-height:22px;color:#464646;font-weight:bold]");
			String temp=link2.get(2).text();
			temp=temp.replace("USD","");
			//System.out.println(temp); debug print
			//cl.add(link2.text());

			String link3=doc.select("img[src*=mi_check_in]").attr("src");
			int indx=link3.indexOf("check_in");
			String arrive=link3.substring(indx+9, indx+19);
			int indx1=link3.indexOf("out");
			String depart=link3.substring(indx1+4, indx1+14);
			// System.out.println(arrive); debug 
			// System.out.println(depart);debug 
			Date date=new Date();
			//System.out.println(date); debug
			try {
				json.put("hotelName",link1.text());
				json.put("totalPerRoom",temp);
				json.put("arrivalDate",arrive);
				json.put("departureDate",depart);
				json.put("timestamp", date);
			} catch (JSONException e) {

				e.printStackTrace();
			}

			//System.out.println(json); for debug



		} catch (IOException e) {

			e.printStackTrace();
		}

		return json;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public String getTotalPerRoom() {
		return totalPerRoom;
	}

	public void setTotalPerRoom(String totalPerRoom) {
		this.totalPerRoom = totalPerRoom;
	}

	public String getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public String getDeparturedata() {
		return departuredata;
	}

	public void setDeparturedata(String departuredata) {
		this.departuredata = departuredata;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
