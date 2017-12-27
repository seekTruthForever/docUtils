package com.whv.doc.utils.convert;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

import org.artofsolving.jodconverter.OfficeDocumentConverter;
import org.artofsolving.jodconverter.office.DefaultOfficeManagerConfiguration;
import org.artofsolving.jodconverter.office.OfficeManager;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * doc docx��ʽת��
 */
public class DocConverter {
	public static int environment = 1;// ���� 1��windows 2:linux
	private String fileString;// (ֻ�漰pdf2swf·������)
	private String outputPath = "";// ����·�� ����������þ������Ĭ�ϵ�λ��
	private String fileName;
	private File pdfFile;
	private File swfFile;
	private File docFile;
	private static String officeHome;
	private static String swfToolHome;
	static {
		 String osName = System.getProperty("os.name");  
			if (Pattern.matches("Linux.*", osName)) {  
					officeHome = PropOptUtil.getProperties("global.properties", "Linux_officeHome");  
					swfToolHome = "";
					environment = 2;
			    } else if (Pattern.matches("Windows.*", osName)) {  
			    	officeHome = PropOptUtil.getProperties("global.properties", "Window_officeHome");  
			    	swfToolHome = PropOptUtil.getProperties("global.properties", "Window_swfToolHome");
			    	environment = 1;
			    } 
	}
	public DocConverter(String fileString) {
		ini(fileString);
	}

	/**
	 * ��������file
	 * 
	 * @param fileString
	 */
	public void setFile(String fileString) {
		ini(fileString);
	}

	/**
	 * ��ʼ��
	 * 
	 * @param fileString
	 */
	private void ini(String fileString) {
		this.fileString = fileString;
		fileName = fileString.substring(0, fileString.lastIndexOf("."));
		docFile = new File(fileString);
		pdfFile = new File(fileName + ".pdf");
		swfFile = new File(getPinYin(fileName) + ".swf");
	}

	/**
	 * תΪPDF
	 * 
	 * @param file
	 */
	private void doc2pdf() throws Exception {
		if (docFile.exists()) {
			if (!pdfFile.exists()) {
				OpenOfficeConnection connection = new SocketOpenOfficeConnection(
						8100);
				try {
					connection.connect();
					DocumentConverter converter = new OpenOfficeDocumentConverter(
							connection);
					converter.convert(docFile, pdfFile);
					// close the connection
					connection.disconnect();
					System.out.println("****pdfת���ɹ���PDF�����" + pdfFile.getPath()
							+ "****");
				} catch (java.net.ConnectException e) {
					e.printStackTrace();
					System.out.println("****swfת�����쳣��openoffice����δ������****");
					throw e;
				} catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
					e.printStackTrace();
					System.out.println("****swfת�����쳣����ȡת���ļ�ʧ��****");
					throw e;
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			} else {
				System.out.println("****�Ѿ�ת��Ϊpdf������Ҫ�ٽ���ת��****");
			}
		} else {
			System.out.println("****swfת�����쳣����Ҫת�����ĵ������ڣ��޷�ת��****");
		}
	}

	/**
	 * ת���� swf
	 */
	@SuppressWarnings("unused")
	public void pdf2swf() {
		Runtime r = Runtime.getRuntime();
		if (!swfFile.exists()) {
			if (pdfFile.exists()) {
				if (environment == 1) {// windows��������
					try {

						Process p = r
								.exec(swfToolHome+"/pdf2swf.exe"
										+ " -t "
										+ pdfFile.getPath()
										+ " -s flashversion=9 -o "
										+ swfFile.getPath());
						System.out.print(loadStream(p.getInputStream()));
						System.err.print(loadStream(p.getErrorStream()));
						System.out.print(loadStream(p.getInputStream()));
						System.err.println("****swfת���ɹ����ļ������"
								+ swfFile.getPath() + "****");
						if (pdfFile.exists()) {
							pdfFile.delete();
						}

					} catch (IOException e) {
						e.printStackTrace();
						
					}
				} else if (environment == 2) {// linux��������
					try {
						Process p = r.exec("pdf2swf " + pdfFile.getPath()
								+ " -o " + swfFile.getPath() + " -T 9");
						System.out.print(loadStream(p.getInputStream()));
						System.err.print(loadStream(p.getErrorStream()));
						System.err.println("****swfת���ɹ����ļ������"
								+ swfFile.getPath() + "****");
						if (pdfFile.exists()) {
							pdfFile.delete();
						}
					} catch (Exception e) {
						e.printStackTrace();
						
					}
				}
			} else {
				System.out.println("****pdf������,�޷�ת��****");
			}
		} else {
			System.out.println("****swf�Ѿ����ڲ���Ҫת��****");
		}
	}

	static String loadStream(InputStream in) throws IOException {

		int ptr = 0;
		in = new BufferedInputStream(in);
		StringBuffer buffer = new StringBuffer();

		while ((ptr = in.read()) != -1) {
			buffer.append((char) ptr);
		}

		return buffer.toString();
	}

	/**
	 * ת��������
	 */
	@SuppressWarnings("unused")
	public boolean conver() {

		if (swfFile.exists()) {
			System.out.println("****swfת������ʼ���������ļ��Ѿ�ת��Ϊswf****");
			return true;
		}

		if (environment == 1) {
			System.out.println("****swfת������ʼ��������ǰ�������л���windows****");
		} else {
			System.out.println("****swfת������ʼ��������ǰ�������л���linux****");
		}
		try {
			word2pdf();
			pdf2swf();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

		if (swfFile.exists()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * �����ļ�·��
	 * 
	 * @param s
	 */
	public String getswfPath() {
		if (swfFile != null) {
			String tempString = swfFile.getPath();
			// tempString = getPinYin(tempString);
			tempString = tempString.replaceAll("\\\\", "/");
			return tempString;
		} else {
			return "";
		}

	}

	/**
	 * �������·��
	 */
	public void setOutputPath(String outputPath) {
		this.outputPath = outputPath;
		if (!outputPath.equals("")) {
			String realName = fileName.substring(fileName.lastIndexOf("/"),
					fileName.lastIndexOf("."));
			// realName = getPinYin(realName);
			if (outputPath.charAt(outputPath.length()) == '/') {
				swfFile = new File(outputPath + realName + ".swf");
			} else {
				swfFile = new File(outputPath + realName + ".swf");
			}
		}
	}

	public static String getPinYin(String src) {
		char[] t1 = null;
		t1 = src.toCharArray();
		// System.out.println(t1.length);
		String[] t2 = new String[t1.length];
		// System.out.println(t2.length);
		// ���ú���ƴ������ĸ�ʽ
		HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
		t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
		t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		t3.setVCharType(HanyuPinyinVCharType.WITH_V);
		String t4 = "";
		int t0 = t1.length;
		try {
			for (int i = 0; i < t0; i++) {
				// �ж��ܷ�Ϊ�����ַ�
				// System.out.println(t1[i]);
				if (Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
					t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);// �����ֵļ���ȫƴ���浽t2������
					t4 += t2[0];// ȡ���ú���ȫƴ�ĵ�һ�ֶ��������ӵ��ַ���t4��
				} else {
					// ������Ǻ����ַ������ȡ���ַ������ӵ��ַ���t4��
					t4 += Character.toString(t1[i]);
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			e.printStackTrace();
		}
		return t4;
	}
	/**
	 * ��Office�ĵ�ת��ΪPDF. ���иú�����Ҫ�õ�OpenOffice, OpenOffice
	 * 
	 * @param sourceFile
	 *            Դ�ļ�,����·��. ������Office2003-2007ȫ����ʽ���ĵ�, Office2010��û����. ����.doc, .docx, .xls, .xlsx, .ppt, .pptx��.
	 * 
	 * @param destFile
	 *            Ŀ���ļ�.����·��.
	 */
	public void word2pdf() {
		if (docFile.exists()) {
			if (!pdfFile.exists()) {
			    DefaultOfficeManagerConfiguration config = new DefaultOfficeManagerConfiguration();  
			    config.setOfficeHome(officeHome);  
			    OfficeManager officeManager = config.buildOfficeManager();  
			    officeManager.start();  
			    OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);  
			    converter.convert(docFile, pdfFile);  
			    officeManager.stop();  
			    System.out.println("****pdfת���ɹ���PDF�����" + pdfFile.getPath()+ "****");
		} else {
			System.out.println("****�Ѿ�ת��Ϊpdf������Ҫ�ٽ���ת��****");
		}
	} else {
		System.out.println("****swfת�����쳣����Ҫת�����ĵ������ڣ��޷�ת��****");
	}
}  
public static void main(String[] args) {
	System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
}
}
