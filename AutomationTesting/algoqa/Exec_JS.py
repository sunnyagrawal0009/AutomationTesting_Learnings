from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from webdriver_manager.chrome import ChromeDriverManager

# Setup Chrome driver
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()))

# Open the desired URL
driver.get("https://www.example.com")  # Replace with your target URL

# Execute JavaScript to get the title of the web page
page_title = driver.execute_script("return document.title;")

# Print the title of the page
print("Page Title:", page_title)

# Close the browser
driver.quit()