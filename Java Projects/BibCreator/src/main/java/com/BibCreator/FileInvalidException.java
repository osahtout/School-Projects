package com.BibCreator;


public class FileInvalidException extends Exception{

	private static final long serialVersionUID = -2615492444465068089L;
	
		public FileInvalidException() {
			super("Error: Input file cannot be parsed due to missing information(i.e. month={}, title={}, etc.)");
		}
	
		public FileInvalidException(String s) {
			
			super(s);
		}
	

}
