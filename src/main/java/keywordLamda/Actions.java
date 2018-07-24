/*package keywordLamda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Actions {
    
    // to enter given value for an element
    private static BiConsumer<WebElement, String> SET_VALUE = (ele, param) -> {
        ele.sendKeys(param);
    };

    // to perform click operation
    private static BiConsumer<WebElement, String> CLICK = (ele, param) -> {
        ele.click();
    };

    // to select drop down values
    private static BiConsumer<WebElement, String> SELECT = (ele, param) -> {
        Select select = new Select(ele);
        select.selectByVisibleText(param);
    };

    // this map will hold all the lamdas / keyword operations
    private static Map<String, BiConsumer<WebElement, String>> map = null;
    
    static {
        map = new HashMap<String, BiConsumer<WebElement, String>>();
        map.put("SetValue", SET_VALUE);
        map.put("Click", CLICK);
        map.put("Select", SELECT);
    }
   
   // return the specific operation based on the key
    public static BiConsumer<WebElement, String> get(String action){
        return map.get(action);
    }
    
}*/