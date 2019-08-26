package test;


import org.junit.Test;

import com.whv.scanFolders.scan.ScanUtils;

public class TestScan {

	@Test
	public void testScan() {
		ScanUtils.getFiles("F:\\PDF电子书\\notes");
	}
	@Test
	public void testScan2() {
		ScanUtils.getFiles("F:\\PDF电子书\\notes","java.txt","2");
	}
}
