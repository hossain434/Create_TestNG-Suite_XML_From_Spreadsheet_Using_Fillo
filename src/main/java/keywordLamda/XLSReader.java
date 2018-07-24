package keywordLamda;
import java.io.File;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XLSReader {

	private final Fillo fillo;
	private String filePath;

	private Connection connection;

	public XLSReader(String filePath) {
		fillo = new Fillo();
		this.filePath = filePath;
	}

	public void getTests(String query) {
		try {
			connection = fillo.getConnection(this.filePath);

			Recordset recordset = connection.executeQuery(query);
			this.createSuite(recordset);
		} catch (FilloException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	private void createSuite(Recordset recordset) {
		XmlMapper xmlMapper = new XmlMapper();
		Suite suite = new Suite("TesTautomationGuru");
		try {
			while (recordset.next()) {

				String testName = recordset.getField("TestCaseDescription");
				String className = recordset.getField("ClassName");
				String param = "Data";
				String paramValue = recordset.getField("Data");

				suite.addTest(testName, param, paramValue, className);
			}
			xmlMapper.writeValue(new File("C:\\Users\\ahoss1\\Desktop\\Workspace_new\\Keyword_Lamda\\testng-suite.xml"),
					suite);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			recordset.close();
		}
	}

	@Test
	public static void execute() {
		XLSReader suite = new XLSReader("\\Users\\ahoss1\\Desktop\\Workspace_new\\Keyword_Lamda\\TestCases.xls");
		suite.getTests("select * from testcaseslist where module='Order'");
	}
}