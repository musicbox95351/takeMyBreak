package net.zcmusicbox.util.file;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class MyFileFilter extends FileFilter {

	String description;
	String extensions[];

	public static final String[] IMAGE_FILE = new String[]{"jpg","gif","png","bmp"}; 
	public static final String IMAGE_DESCRIPTION = "*.jpg,*.gif,*.png,*.bmp"; 
	
	public MyFileFilter(String description, String extension) {
		this(description, new String[] {extension} );
	}

	public MyFileFilter(String description, String extensions[]) {
		if(description == null) {
			// since no description, use first extension and # of extensions as description
			this.description = extensions[0]+"{ "+extensions.length+"} ";
		}
		else {
			this.description = description;
		}

		// convert array to lowercase
		// don't alter original entries
		this.extensions = (String[])extensions.clone();
		toLower(this.extensions);
	}

	private void toLower(String array[]) {
		for(int i=0, n=array.length; i<n; i++) {
			array[i] = array[i].toLowerCase();
		}
	}

	// ignore case, always accept directories
	// character before extension must be a period
	@Override
	public boolean accept(File file) {
		// TODO Auto-generated method stub
		if(file.isDirectory()) {
			return true;
		}
		else {
			String path = file.getAbsolutePath().toLowerCase();
			for(int i=0, n=extensions.length; i<n; i++) {
				String extension = extensions[i];
				if(path.endsWith(extension) && (path.charAt(path.length()-extension.length()-1)=='.')) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return description;
	}


}
