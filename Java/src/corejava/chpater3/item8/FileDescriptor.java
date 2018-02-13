package corejava.chpater3.item8;

import java.time.LocalDate;
import java.util.Arrays;

//Part of a program that search for duplicated files in a given directory
//This object can'nt be allowed to change after creation
//AN IMMUTABLE OBJECT
public class FileDescriptor implements Comparable<FileDescriptor> {

	private final String fileName;
	private final LocalDate createdON;
	private final LocalDate lastModifiedON;
	private final byte[] checksum;

	private FileDescriptor(String fileName, LocalDate createdON, LocalDate lastModifiedON) {
		this.fileName = fileName;
		this.createdON = createdON;
		this.lastModifiedON = lastModifiedON;
		this.checksum = hecksumHash();
	}

	public static FileDescriptor describe(String fileURL) {
		return new FileDescriptor("book.pdf", LocalDate.now(), LocalDate.now());
	}

	// Generate SHA file checksum hash
	// uniquely generated according to the file content
	private final byte[] hecksumHash() {
		// For testing
		return "e2a9798888b4fad19848134537fe1f9e".getBytes();
	}

	public String getFileName() {
		return fileName;
	}

	public LocalDate getCreatedON() {
		return createdON;
	}

	public LocalDate getLastModifiedON() {
		return lastModifiedON;
	}

	public byte[] getChecksum() {
		return checksum;
	}

	// Overriding object methods

	// In the context of our program tow files are equal if they
	// contain the same data
	// checksum a hash that depend on the file content
	@Override
	public boolean equals(Object obj) {
		return obj instanceof FileDescriptor
				&& (Arrays.equals(((FileDescriptor) obj).getChecksum(), this.getChecksum()));
	}

	// calculating the hash
	// according to the file name & the checksum byte area
	@Override
	public int hashCode() {
		int result = 21;
		result = 31 * result + fileName.hashCode();
		for (byte b : checksum)
			result = 31 * result + (int) b;
		return result;
	}

	// Enable us to order files according to there name
	// High probability that that duplicated files have similar name or related
	// names
	// Ex : final-project.docx & final-project2.docx
	@Override
	public int compareTo(FileDescriptor o) {
		return this.fileName.compareTo(o.getFileName());
	}

	// Nice printing
	@Override
	public String toString() {
		return "File Name :" + fileName + " Cheksum : " + Arrays.toString(checksum);
	}
}
