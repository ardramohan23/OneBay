package testpkg;

import org.testng.annotations.Test;

import basepkg.BaseClass;
import pagepkg.Search;
import utilitypkg.ExcelUtils;

public class SearchTest extends BaseClass {
	
	
	@Test
	public void searchFieldTest() throws Exception {
		Search sc=new Search(driver);
		String x1="C:\\Users\\ARDRA MOHAN\\OneDrive\\Documents\\JavaNotepadcodes\\onebay.xlsx";
		String sheet="Sheet1";
		
		int rowCount=ExcelUtils.getRowCount(x1, sheet);
		System.out.println(rowCount);
		for(int i=1;i<=rowCount;i++) {
			String searchItem=ExcelUtils.getCellValue(x1, sheet, i, 0);
			System.out.println("Search item is "+searchItem);
			sc.searchProducts(searchItem);
			
		}
		
		
		
	}

}
