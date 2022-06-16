import java.net.*;
import java.io.*;
import java.util.*;
class UDPClient{

	/**Unreliable communication between two applications
	 * Sends independent packets of data call datagram
	 * The order of delivery is not important and is not
	 * guaranteed, and each message is independent of any other.
	 * Look how there aren't any connection establishment
	 * the port number on the data packet is meant for the
	 * port number of the specified host
	 * UDP (and TCP) protocols use ports to map incoming data to a
	 * particular process running on a computer.
	 * */
	public static void main(String[] args) throws Exception
	{
		
		DatagramSocket ds=new DatagramSocket();
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter your message:");
			String str=scan.nextLine();
			InetAddress ip=InetAddress.getByName("localhost");
			DatagramPacket dp=new DatagramPacket(str.getBytes(),str.length(),ip,2334);
			ds.send(dp);
			if(str.equals("bye"))
			{
				ds.close();
				break;
			}
			
		}
	}
}