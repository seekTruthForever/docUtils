package test;


import org.junit.Test;

import com.whv.scanFolders.scan.ScanUtils;

public class TestScan {

	@Test
	public void testScan() {
		ScanUtils.getFiles("F:\\PDF������\\notes");
	}
	@Test
	public void testScan2() {
		ScanUtils.getFiles("F:\\PDF������\\notes","java.txt","2");
	}
}
