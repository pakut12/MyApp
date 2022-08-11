/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author 110680
 */


import com.sap.mw.jco.IRepository;
import com.sap.mw.jco.JCO;

public class ConnectSap {
    // The MySAP.com system we gonna be using

    static final String SID = "R3";
    // The repository we will be using

    public ConnectSap() {
        super();
    // TODO Auto-generated constructor stub
    }

    public static JCO.Client createClientDEVOld() throws JCO.Exception {

        //	JCO.Pool pool = JCO.getClientPoolManager().getPool(SID);

        //	if (pool == null){
        // OrderedProperties logonProperties = OrderedProperties.load("/logon.properties");
        // Add a connection pool to the specified system
	/*JCO.addClientPool(SID, 		 // Alias for this pool
        10, 		 // Max. number of connections
        "500",		 // SAP client
        "mis01",  // userid
        "compit21",	 // password
        "EN",   	 // language
        "10.0.62.8",// host name
        "00");
                         */
        JCO.Client client = JCO.createClient("500", // SAP client
                "mis01", // userid
                "pgit01", // password
                "EN", // language
                "10.0.62.139",// host name
                "00");
      /*      JCO.Client client = JCO.createClient("500", // SAP client
                "zcpic", // userid
                "pgcpic12", // password
                "EN", // language
                "10.0.62.8",// host name
                "00");*/
        //	}
        //			 Get a client from the pool
        client.connect();
        //		JCO.Client client = JCO.getClient(SID);
        return client;
    }

   public static JCO.Client createClientZcpic() throws JCO.Exception {

        //	JCO.Pool pool = JCO.getClientPoolManager().getPool(SID);

        //	if (pool == null){
        // OrderedProperties logonProperties = OrderedProperties.load("/logon.properties");
        // Add a connection pool to the specified system
	/*JCO.addClientPool(SID, 		 // Alias for this pool
        10, 		 // Max. number of connections
        "500",		 // SAP client
        "mis01",  // userid
        "compit21",	 // password
        "EN",   	 // language
        "10.0.62.8",// host name
        "00");
                         */
//       userName :zcpic2
//       Password :8v,@1702
            JCO.Client client = JCO.createClient("500", // SAP client
                "zcpic", // userid
                "pgcpic12", // password
                "EN", // language
                "10.0.62.8",// host name
                "00");
        //	}
        //			 Get a client from the pool
        client.connect();
        //		JCO.Client client = JCO.getClient(SID);
        return client;
    }

    public static JCO.Client createClient() throws JCO.Exception {
            JCO.Client client = JCO.createClient("500", // SAP client
                "zcpic2", // userid
                "8v,@1702", // password
                "EN", // language
                "10.0.62.8",// host name
                "00");
//            JCO.Client client = JCO.createClient("500", // SAP client
//                "zcpic", // userid
//                "pgcpic12", // password
//                "EN", // language
//                "10.0.62.8",// host name
//                "00");
            
//         JCO.Client client = JCO.createClient("500", // SAP client
//                "MIS01", // userid
//                "COMPIT21", // password
//                "EN", // language
//                "10.0.62.8",// host name
//                "00");
        //	}
        //			 Get a client from the pool
        client.connect();
        //		JCO.Client client = JCO.getClient(SID);
        return client;
    }


    public static JCO.Client createClientDevl() throws JCO.Exception {
//        JCO.Client client = JCO.createClient("200", // SAP client
//                "itsupport2", // userid
//                "prog6519", // password
//                "EN", // language
//                "10.0.62.139",// host name
//                "00");

//        JCO.Client client = JCO.createClient("200", // SAP client
//                "mis01", // userid
//                "pgit01", // password
//                "EN", // language
//                "10.0.62.139",// host name
//                "00");

        JCO.Client client = JCO.createClient("200", // SAP client
                "mis01", // userid
                "pgit01", // password
                "EN", // language
                "10.0.62.139",// host name
                "00");
        //	}
        //			 Get a client from the pool
        client.connect();
        //		JCO.Client client = JCO.getClient(SID);
        return client;
    }

    public static IRepository createRepository(String nameRep) {
        // Create a new repository
        IRepository repository = JCO.createRepository(nameRep, SID);
        return repository;

    }

    public static String getNamePool() {
        return SID;
    }
}

