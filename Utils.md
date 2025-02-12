**Action Class, JavaScriptExecutor, and Robot Class in Selenium**

## 1. **Action Class in Selenium**
Action Class is used for handling mouse and keyboard interactions.

### **Import:**
```java
import org.openqa.selenium.interactions.Actions;
```

### **Common Methods & Usage:**
```java
Actions actions = new Actions(driver);

// Hover over an element
WebElement element = driver.findElement(By.id("elementId"));
actions.moveToElement(element).perform();

// Right-click (Context Click)
actions.contextClick(element).perform();

// Double Click
actions.doubleClick(element).perform();

// Drag and Drop
WebElement source = driver.findElement(By.id("source"));
WebElement target = driver.findElement(By.id("target"));
actions.dragAndDrop(source, target).perform();

// Click and Hold
actions.clickAndHold(element).release().perform();
```

---
## 2. **JavaScriptExecutor in Selenium**
JavaScriptExecutor is used for executing JavaScript commands in Selenium.

### **Import:**
```java
import org.openqa.selenium.JavascriptExecutor;
```

### **Common Methods & Usage:**
```java
JavascriptExecutor js = (JavascriptExecutor) driver;

// Scroll Down
js.executeScript("window.scrollBy(0,500)");

// Scroll to an Element
js.executeScript("arguments[0].scrollIntoView();", element);

// Click an Element
js.executeScript("arguments[0].click();", element);

// Enter Text in a Disabled Field
js.executeScript("document.getElementById('textFieldId').value='Test Value'");
```

---
## 3. **Robot Class in Selenium**
Robot Class is used for simulating keyboard and mouse events.

### **Import:**
```java
import java.awt.Robot;
import java.awt.event.KeyEvent;
```

### **Common Methods & Usage:**
```java
Robot robot = new Robot();

// Press & Release Enter Key
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);

// Press Control + S (Save Shortcut)
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_S);
robot.keyRelease(KeyEvent.VK_S);
robot.keyRelease(KeyEvent.VK_CONTROL);

// Move Mouse Cursor
robot.mouseMove(300, 500);
```

---
## **Conclusion**
- **Action Class** is best for mouse and keyboard interactions.
- **JavaScriptExecutor** is useful for handling elements that Selenium can't interact with normally.
- **Robot Class** is ideal for automating OS-level interactions.
