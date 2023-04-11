package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */


import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {

		BigInteger hashint =null;

		try{
			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] hash = md.digest(entity.getBytes("UTF-8"));

			String hex = toHex(hash);

			hashint = new BigInteger(hex,16);

		}catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
			e.printStackTrace();
		}


		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		
		return hashint;
	}
	
	public static BigInteger addressSize() {

		int numbits = bitSize();


		BigInteger addressSize = BigInteger.valueOf(2).pow(numbits);

		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return addressSize;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;


		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			digestlen = md.getDigestLength();
		}catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
