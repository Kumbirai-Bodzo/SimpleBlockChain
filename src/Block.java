import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;

public class Block {
	private String version;
	private String hash;
	private String prevHash;
	private Date timestamp;
	private String data;

	public Block(String version, Date timestamp, String data) {
		this.version = version;
		this.timestamp = timestamp;
		this.data = data;
		hash = computeHash();
	}

	private String computeHash() {
		String toHash = this.version + this.data + this.timestamp;
		String encoded = null;

		MessageDigest digest;

		try {
			digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(toHash.getBytes(StandardCharsets.UTF_8));
			encoded = Base64.getEncoder().encodeToString(hash);

		} catch (NoSuchAlgorithmException e) {
			// FUNCTION: Auto-generated catch block
			e.printStackTrace();
		}

		this.hash = encoded;
		return encoded;

	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPrevHash() {
		return prevHash;
	}

	public void setPrevHash(String prevHash) {
		this.prevHash = prevHash;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

}
