from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time

# Setup Chrome driver
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

# Open the desired URL
driver.get("https://jqueryui.com/droppable/")  # Example page with drag-and-drop feature

# Wait for the page to load
WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.ID, "draggable")))

# Switch to the iframe if required (for pages like JQuery UI with embedded frames)
driver.switch_to.frame(driver.find_element(By.CLASS_NAME, "demo-frame"))

# Locate the element to hover over and drag from
hover_element = driver.find_element(By.ID, "draggable")  # The element to hover over
target_element = driver.find_element(By.ID, "droppable")  # The target element for the drop

# Ensure the target element is in the viewport by scrolling it into view
driver.execute_script("arguments[0].scrollIntoView(true);", target_element)

# Create an ActionChains object
actions = ActionChains(driver)

# Perform mouse hover and drag-and-drop
actions.move_to_element(hover_element)  # Hover over the element
actions.click_and_hold(hover_element)  # Click and hold the element
actions.move_to_element(target_element)  # Move to the target element
actions.release(target_element)  # Release the element (drop it)
actions.perform()  # Execute the actions

# Wait for a while to observe the result (optional)
time.sleep(3)

# Close the browser
driver.quit()