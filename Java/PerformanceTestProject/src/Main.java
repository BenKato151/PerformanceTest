import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public static void main(String[] args) {
		String text = "aaaaaaaaaa";
		MessageDigest digest;
		long start = System.nanoTime();
		for(int i = 0; i < 1000000; i++) {
			try {
				digest = MessageDigest.getInstance("SHA-256");
				byte[] hash = digest.digest(text .getBytes(StandardCharsets.UTF_8)); 
				//System.out.println(bytesToHex(hash));
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		long end = System.nanoTime();
		System.out.println("Duration: " + (end-start)/1000);
    }
}
