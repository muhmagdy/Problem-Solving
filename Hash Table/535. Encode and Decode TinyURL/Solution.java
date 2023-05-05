public class Codec {
    
    HashMap<String, String> directory = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String code = Integer.toHexString(longUrl.hashCode());
        directory.put(code, longUrl);
        return "http://tinyurl.com/" + code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return directory.get(shortUrl.substring(19));
    }
}