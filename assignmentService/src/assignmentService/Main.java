package assignmentService;

import java.io.File;
import java.util.Scanner;

import org.bson.BSONObject;
import org.bson.Document;
import org.json.JSONException;
import org.json.JSONObject;


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;




public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args)throws Exception {
		Scanner input = new Scanner(System.in);
		//File file=new File("C:/Users/Stas/Desktop/Assigment_Service_T/hilton1.html");

		File file=new File(input.next());
		JSONObject jason;
		//	MongoClient mongoClient =new MongoClient("mongodb://candidate:testing123@ds133166.mlab.com:33166/myinterview");


		if(file.exists()){
			Extractor hilton1=new HotelData(file);
			jason=hilton1.Extract();
			System.out.println(jason);
			try {
				MongoClientURI connectionString = new MongoClientURI("mongodb://candidate:testing123@ds133166.mlab.com:33166/myinterview");
				MongoClient mongoClient = new MongoClient(connectionString);

				MongoDatabase database = mongoClient.getDatabase("myinterview");
				MongoCollection<Document> collection = database.getCollection("myinterview");
				//Document doc=new Document();

				collection.insertOne( Document.parse(jason.toString())); //almost done unfortinatly creates an error.


			} catch (Exception e) {
				e.printStackTrace();
			}


		}
		else
		{
			System.out.println("missing file");
		}


	}

}
