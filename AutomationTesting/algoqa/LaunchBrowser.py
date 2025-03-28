from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.action_chains import ActionChains
import time

# Setup Chrome driver
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

# Open the desired URLdriver.get("https://algoshack.com/algoqa/")

# Wait for the page to load
time.sleep(2)  # Adjust the time to ensure the page is loaded

# Locate the algoQA menu link and click on it
menu_link = driver.find_element(By.LINK_TEXT, "algoQA")
menu_link.click()

# Wait for some time to see the result (optional)
time.sleep(3)

# Close the browser
driver.quit()